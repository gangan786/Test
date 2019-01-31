package com.meizhuo.DesignPatterns.FunnyDesignPatterns_15_抽象工厂模式.Impl;

import com.meizhuo.DesignPatterns.FunnyDesignPatterns_15_抽象工厂模式.IUser;
import com.meizhuo.DesignPatterns.FunnyDesignPatterns_15_抽象工厂模式.User;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_15_抽象工厂模式.Impl
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/1/30 22:35
 * @UpdateUser:
 * @UpdateDate: 2019/1/30 22:35
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class MySQLUser implements IUser {
    @Override
    public void insert(User user) {
        System.out.println(this.getClass().getName() + " 插入MySQL");
    }

    @Override
    public User getUserById(int id) {
        System.out.println(this.getClass().getName() + " 查询MySQL");
        return null;
    }
}
