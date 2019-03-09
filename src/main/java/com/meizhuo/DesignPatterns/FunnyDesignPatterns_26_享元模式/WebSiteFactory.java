package com.meizhuo.DesignPatterns.FunnyDesignPatterns_26_享元模式;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_26_享元模式
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/3/9 14:36
 * @UpdateUser:
 * @UpdateDate: 2019/3/9 14:36
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class WebSiteFactory {

    private ConcurrentHashMap<String, BaseWebSite> webSiteList = new ConcurrentHashMap<>();

    public WebSiteFactory() {
        webSiteList.put("展示", new ConstantWebSite("展示"));
        webSiteList.put("博客", new ConstantWebSite("博客"));

    }

    /**
     * 获得共享网站对象
     * @param type
     * @return
     */
    public BaseWebSite getWebSite(String type) {
        return webSiteList.get(type);
    }

    public int getWebSiteCount() {
        return webSiteList.size();
    }


}
