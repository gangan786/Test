package com.meizhuo.DesignPatterns.FunnyDesignPatterns_26_享元模式;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_26_享元模式
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/3/9 14:42
 * @UpdateUser:
 * @UpdateDate: 2019/3/9 14:42
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class Client {

    public static void main(String[] args) {
        WebSiteFactory webSiteFactory = new WebSiteFactory();

        BaseWebSite webSite1 = webSiteFactory.getWebSite("展示");
        webSite1.use(new User("热夜"));

        BaseWebSite website2 = webSiteFactory.getWebSite("展示");
        website2.use(new User("冻朝"));

        BaseWebSite webSite3 = webSiteFactory.getWebSite("博客");
        webSite3.use(new User("淦尼"));

        BaseWebSite webSite4 = webSiteFactory.getWebSite("博客");
        webSite4.use(new User("冬妮"));

        System.out.println("共享对象的数量为：" + webSiteFactory.getWebSiteCount());
    }

}
