package com.meizhuo.DesignPatterns.FunnyDesignPatterns_15_抽象工厂模式;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_15_抽象工厂模式
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/1/30 22:29
 * @UpdateUser:
 * @UpdateDate: 2019/1/30 22:29
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public interface IDepartment {

    void insert(Department department);

    Department getDepartmentById(int id);

}
