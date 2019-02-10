package com.meizhuo.DesignPatterns.FunnyDesignPatterns_17_适配器模式.v1;

import com.meizhuo.DesignPatterns.FunnyDesignPatterns_17_适配器模式.v0.Center;
import com.meizhuo.DesignPatterns.FunnyDesignPatterns_17_适配器模式.v0.Forwards;
import com.meizhuo.DesignPatterns.FunnyDesignPatterns_17_适配器模式.v0.Guards;
import com.meizhuo.DesignPatterns.FunnyDesignPatterns_17_适配器模式.v0.Player;

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

        //可以看到 没有让ForeignCenter实现Player接口，通过Adapter模式依然可以保证接口规范
        Player center = new TranslatorAdapter("热夜");

        gangan.Attack();
        dDong.Defense();


        center.Defense();
        center.Attack();
    }

}
