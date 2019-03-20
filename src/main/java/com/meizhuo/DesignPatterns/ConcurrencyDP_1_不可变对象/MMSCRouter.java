package com.meizhuo.DesignPatterns.ConcurrencyDP_1_不可变对象;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.ConcurrencyDP_1_不可变对象
 * @ClassName: ${TYPE_NAME}
 * @Description: 彩信中心路由规则管理器
 * @Author: Gangan
 * @CreateDate: 2019/3/20 21:47
 * @UpdateUser:
 * @UpdateDate: 2019/3/20 21:47
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public final class MMSCRouter {

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
