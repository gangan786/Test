package com.meizhuo.DesignPatterns.FunnyDesignPatterns_19_组合模式;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_19_组合模式
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/2/23 11:22
 * @UpdateUser:
 * @UpdateDate: 2019/2/23 11:22
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class ConcreteCompany extends Company {
    private List<Company> childNode = new LinkedList<>();

    public ConcreteCompany(String name) {
        super(name);
    }

    @Override
    public void add(Company company) {
        childNode.add(company);
    }

    @Override
    public void remove(Company company) {
        childNode.remove(company);
    }

    @Override
    public void display(int depth) {
        System.out.println(StringUtils.fixedLength('-', depth) + name);
        for (Company company : childNode) {
            company.display(depth + 2);
        }
    }

    @Override
    public void lineOfDuty() {
        for (Company company : childNode) {
            company.lineOfDuty();
        }
    }
}
