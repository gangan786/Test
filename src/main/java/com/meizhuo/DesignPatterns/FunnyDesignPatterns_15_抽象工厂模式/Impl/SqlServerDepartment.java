package com.meizhuo.DesignPatterns.FunnyDesignPatterns_15_抽象工厂模式.Impl;

import com.meizhuo.DesignPatterns.FunnyDesignPatterns_15_抽象工厂模式.Department;
import com.meizhuo.DesignPatterns.FunnyDesignPatterns_15_抽象工厂模式.IDepartment;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_15_抽象工厂模式.Impl
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/1/30 22:41
 * @UpdateUser:
 * @UpdateDate: 2019/1/30 22:41
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class SqlServerDepartment implements IDepartment {
    @Override
    public void insert(Department department) {
        System.out.println(this.getClass().getName() + " 插入SQLServer");
    }

    @Override
    public Department getDepartmentById(int id) {
        System.out.println(this.getClass().getName() + " 查询SQLServer");
        return null;
    }
}
