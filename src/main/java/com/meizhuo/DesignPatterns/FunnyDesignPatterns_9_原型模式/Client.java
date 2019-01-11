package com.meizhuo.DesignPatterns.FunnyDesignPatterns_9_原型模式;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_9_原型模式
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/1/11 22:43
 * @UpdateUser:
 * @UpdateDate: 2019/1/11 22:43
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class Client {
    public static void main(String[] args) {
        Resume gangan = new Resume("Gangan");
        gangan.setPersonalInfo("男", "22");
        gangan.setWorkExperience("1998-2000", "XX公司");

        Resume clone1 = (Resume) gangan.clone();
        clone1.setWorkExperience("2000-2002", "YY公司");

        Resume clone2 = (Resume) gangan.clone();
        clone2.setWorkExperience("2002-2004", "ZZ公司");

        System.out.println(gangan);
        System.out.println("----------------------------------");
        System.out.println(clone1);
        System.out.println("----------------------------------");
        System.out.println(clone2);

    }
}
