package com.meizhuo.os.page_exchange;

import org.junit.Test;

import java.util.UUID;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.os.page_exchange
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2018/11/3 14:54
 * @UpdateUser:
 * @UpdateDate: 2018/11/3 14:54
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class Main {

    private Controller controller = Controller.getInstance();

    @Test
    public void test() throws InterruptedException {
        Page p1 = new Page("P1", UUID.randomUUID().toString());
        Page p2 = new Page("P2", UUID.randomUUID().toString());
        Page p3 = new Page("P3", UUID.randomUUID().toString());
        Page p4 = new Page("P4", UUID.randomUUID().toString());
        Page p5 = new Page("P5", UUID.randomUUID().toString());

        //添加一个页面走向为：
        //5-->1-->2-->3-->4-->5-->3-->4-->1-->2-->3-->4
        controller.addPage(p5);
        controller.addPage(p1);
        controller.addPage(p2);
        controller.addPage(p3);
        controller.addPage(p4);
        controller.addPage(p5);
        controller.addPage(p3);
        controller.addPage(p4);
        controller.addPage(p1);
        controller.addPage(p2);
        controller.addPage(p3);
        controller.addPage(p4);

        //开始执行FIFO置换算法
        //controller.pageExchangeToFIFO();
        //开始执行LRU置换算法
        controller.pageExchangeToLRU();


    }
}
