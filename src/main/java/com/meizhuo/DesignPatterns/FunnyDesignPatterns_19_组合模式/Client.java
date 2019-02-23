package com.meizhuo.DesignPatterns.FunnyDesignPatterns_19_组合模式;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_19_组合模式
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/2/23 12:12
 * @UpdateUser:
 * @UpdateDate: 2019/2/23 12:12
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class Client {

    public static void main(String[] args) {
        ConcreteCompany root = new ConcreteCompany("北京总公司");
        root.add(new HRDepartment("总公司人力资源部"));
        root.add(new FinanceDepartment("总公司财务部"));

        ConcreteCompany company = new ConcreteCompany("上海华东分公司");
        company.add(new HRDepartment("华东分公司人力资源部"));
        company.add(new FinanceDepartment("华东分公司财务部"));

        root.add(company);

        ConcreteCompany company1 = new ConcreteCompany("南京办事处");
        company1.add(new HRDepartment("南京办事处人力资源部"));
        company1.add(new FinanceDepartment("南京办事处财务部"));

        company.add(company1);

        ConcreteCompany company2 = new ConcreteCompany("杭州办事处");
        company2.add(new HRDepartment("杭州办事处人力资源部"));
        company2.add(new FinanceDepartment("杭州办事处财务部"));

        company.add(company2);

        System.out.println("结构图");
        root.display(1);

        System.out.println("职责");
        root.lineOfDuty();


    }

}
