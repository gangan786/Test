package com.meizhuo.DesignPatterns.FunnyDesignPatterns_15_抽象工厂模式;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_15_抽象工厂模式
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/1/30 22:27
 * @UpdateUser:
 * @UpdateDate: 2019/1/30 22:27
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public interface IUser {

    void insert(User user);

    User getUserById(int id);
}
