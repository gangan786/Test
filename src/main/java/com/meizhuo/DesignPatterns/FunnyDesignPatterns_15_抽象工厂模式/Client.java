package com.meizhuo.DesignPatterns.FunnyDesignPatterns_15_抽象工厂模式;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_15_抽象工厂模式
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/1/30 22:56
 * @UpdateUser:
 * @UpdateDate: 2019/1/30 22:56
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class Client {

    public static void main(String[] args) {
        IUser user = DataAccess.createUser();
        User id = user.getUserById(1);
        user.insert(new User());

        IDepartment iDepartment = DataAccess.createDepartment();
        iDepartment.getDepartmentById(1);
        iDepartment.insert(new Department());
    }

}
