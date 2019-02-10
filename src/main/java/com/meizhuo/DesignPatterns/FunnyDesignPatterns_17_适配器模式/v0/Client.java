package com.meizhuo.DesignPatterns.FunnyDesignPatterns_17_适配器模式.v0;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_17_适配器模式
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/2/10 10:41
 * @UpdateUser:
 * @UpdateDate: 2019/2/10 10:41
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class Client {

    public static void main(String[] args) {
        Player gangan = new Forwards("Gangan");

        Player dDong = new Guards("DDong");

        Player center = new Center("热夜");

        gangan.Attack();
        dDong.Defense();


        center.Defense();
        center.Attack();
    }

}
