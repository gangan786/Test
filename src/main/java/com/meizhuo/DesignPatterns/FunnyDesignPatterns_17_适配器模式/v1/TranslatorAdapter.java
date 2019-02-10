package com.meizhuo.DesignPatterns.FunnyDesignPatterns_17_适配器模式.v1;

import com.meizhuo.DesignPatterns.FunnyDesignPatterns_17_适配器模式.v0.Player;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_17_适配器模式.v1
 * @ClassName: ${TYPE_NAME}
 * @Description: 既然要求按照Player接口的规范来适配ForeignCenter 那么适配器就必须实现Player接口，
 * 并在适配器里面引用ForeignCenter
 * @Author: Gangan
 * @CreateDate: 2019/2/10 10:55
 * @UpdateUser:
 * @UpdateDate: 2019/2/10 10:55
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class TranslatorAdapter extends Player {

    private ForeignCenter foreignCenter;

    public TranslatorAdapter(String name) {
        super(name);
        foreignCenter = new ForeignCenter();
        foreignCenter.setName(name);
    }

    @Override
    public void Attack() {
        foreignCenter.进攻();
    }

    @Override
    public void Defense() {
        foreignCenter.防守();
    }
}
