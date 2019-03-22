# Immutable Object （不可变对象）模式

多线程共享变量的情况下,为了保证数据一致性,往往需要对这些变量的访问进行加锁。而锁本身又会带来一些问题和开销。 Immutable Object模式使得我们可以在不使用锁的情况下,既保证共享变量访问的线程安全,又能避免引入锁可能带来的问题和开销。

+ 这里的代码是基于这样的一个情景:

  某彩信网关系统在处理由增值业务提供商(VASP, Value-Added Service Provider)下发给手机终端用户的彩信消息时,需要根据彩信接收方号码的前缀(如1381234)选择对应的彩信中心(MMSC, Multimedia Messaging Service Center),然后转发消息给选中的彩信中心,由其负责对接电信网络将彩信消息下发给手机终端用户。彩信中心相对于彩信网关系统而言,它是一个独立的部件,二者通过网络进行交互。这个选择彩信中心的过程,我们称之为路由 (Routing),而手机号前缀和彩信中心的这种对应关系,被称为路由表。路由表在软件运维过程中可能发生变化。例如,业务扩容带来的新增彩信中心、为某个号码前缀指定新的彩信中心等。虽然路由表在该系统中是由多线程共享的数据,但是这些数据的变化频率并不高。因此,即使是为了保证线程安全,我们也不希望对这些数据的访问进行加锁等并发访问控制,以免产生不必要的开销和问题。这时, Immutable Object模式就派上用场了。

+ 不可变对象具有天生的线程安全性

+ 模式适用场景

  + **被建模对象的状态变化不频繁**
  + **同时对一组相关的数据进行写操作,因此需要保证原子性**:此场景为了保证操作的原子性,通常的做法是使用显式锁。但若采用Immutable Object模式,将这一组相关的数据 ““组合”成一个不可变对象,则对这一组数据的操作就可以无须加显式锁也能保证原子性,这既简化了编程,又提高了代码运行效率。
  + **使用某个对象作为安全的HashMap的Key**:我们知道,一个对象作为HashMap的Ke被“放入” HashMap之后,若该对象状态变化导致了其Hash Code的变化,则会导至后面在用同样的对象作为Key去get的时候无法获取关联的值,尽管该HashMap中自确存在以该对象为Key的条目。相反,由于不可变对象的状态不变,因此其Hash Cod也不变。这使得不可变对象非常适于用作HashMap的Key.

+ 如果不可变对象的状态不得不对外进行暴露，那么进行**防御性的复制**就显得很重要了



彩信中心（MMSC）抽象

~~~java
public class MMSCInfo {

    private final String deviceID;

    private final String url;

    private final int maxAttachmentSizeInBytes;

    public MMSCInfo(String deviceID, String url, int maxAttachmentSizeInBytes) {
        this.deviceID = deviceID;
        this.url = url;
        this.maxAttachmentSizeInBytes = maxAttachmentSizeInBytes;
    }

    public MMSCInfo(MMSCInfo mmscInfo) {

        deviceID = mmscInfo.deviceID;
        url = mmscInfo.url;
        maxAttachmentSizeInBytes = mmscInfo.maxAttachmentSizeInBytes;

    }

    public String getDeviceID() {
        return deviceID;
    }

    public String getUrl() {
        return url;
    }

    public int getMaxAttachmentSizeInBytes() {
        return maxAttachmentSizeInBytes;
    }

    @Override
    public String toString() {
        return "MMSCInfo{" +
                "deviceID='" + deviceID + '\'' +
                ", url='" + url + '\'' +
                ", maxAttachmentSizeInBytes=" + maxAttachmentSizeInBytes +
                '}';
    }
}
~~~

路由中心

~~~java
public final class MMSCRouter {

    //volatile 保证了多线程之间的可见性 又避免了使用显式锁
    private static volatile MMSCRouter instance = new MMSCRouter();

    /**
     * 这里面的数据就是并发访问的
     */
    private final Map<String, MMSCInfo> routeMap;

    public MMSCRouter() {
        this.routeMap = MMSCRouter.retrieveRouteMapFromDB();
    }

    public static MMSCRouter getInstance() {
        return instance;
    }

    /**
     * 根据手机号码获取对应的彩信中心信息
     *
     * @param msisdnPrefix
     * @return
     */
    public MMSCInfo getMMSCInfo(String msisdnPrefix) {
        return routeMap.get(msisdnPrefix);
    }

    /**
     * 模拟从数据库加载号码与彩信中心的路由信息
     *
     * @return
     */
    private static Map<String, MMSCInfo> retrieveRouteMapFromDB() {
        HashMap<String, MMSCInfo> map = new HashMap<>(16);
        map.put("1500", new MMSCInfo("0000", "agagag:jjj/ytyyrr", 12 * 1024 * 1024));
        map.put("1501", new MMSCInfo("0001", "agagag:jjj/ytyysw", 8 * 1024 * 1024));
        map.put("1503", new MMSCInfo("0003", "agagag:jjj/ytyyjj", 9 * 1024 * 1024));
        return map;
    }

    /**
     * 更新当前实例
     *
     * @param instance
     */
    public static void setInstance(MMSCRouter instance) {
        MMSCRouter.instance = instance;
    }

    /**
     * 做防御性复制
     *
     * @return
     */
    public Map<String, MMSCInfo> getRouteMap() {
        return Collections.unmodifiableMap(deepCopy(routeMap));
    }

    private static Map<String, MMSCInfo> deepCopy(Map<String, MMSCInfo> mmscInfoMap) {
        Map<String, MMSCInfo> stringMMSCInfoMap = new HashMap<>(16);
        for (String s : mmscInfoMap.keySet()) {
            stringMMSCInfoMap.put(s, new MMSCInfo(mmscInfoMap.get(s)));
        }

        return stringMMSCInfoMap;

    }

}
~~~

更新路由表

仅指定该线程创建不可变对象

~~~java
public class OMCAgent implements Runnable {
    @Override
    public void run() {
        //当对获得最新路由表时，更新数据库，并且重新加载彩信中心路由规则管理器的内容
        MMSCRouter.setInstance(new MMSCRouter());
        //省略其他代码
    }
}
~~~

