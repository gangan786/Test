package com.meizhuo.DesignPatterns.FunnyDesignPatterns_13_建造者模式;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_13_建造者模式
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/1/24 13:07
 * @UpdateUser:
 * @UpdateDate: 2019/1/24 13:07
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class Product {

    private List<String> list = new ArrayList<>();

    public void add(String string) {
        list.add(string);
    }

    public void show() {
        for (String s : list) {
            System.out.println(s);
        }
    }

}
