package com.meizhuo.DesignPatterns.FunnyDesignPatterns_19_组合模式;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_19_组合模式
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/2/23 12:05
 * @UpdateUser:
 * @UpdateDate: 2019/2/23 12:05
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class HRDepartment extends Company {

    public HRDepartment(String name) {
        super(name);
    }

    @Override
    public void add(Company company) {

    }

    @Override
    public void remove(Company company) {

    }

    @Override
    public void display(int depth) {
        System.out.println(StringUtils.fixedLength('-', depth) + name);
    }

    @Override
    public void lineOfDuty() {
        System.out.println(name + " 员工招聘培训管理");
    }
}
