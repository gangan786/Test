package com.meizhuo.os.ProcessController;

import java.util.Comparator;
import java.util.LinkedList;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.os.ProcessController
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2018/10/27 10:48
 * @UpdateUser:
 * @UpdateDate: 2018/10/27 10:48
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class ProcessPriority {

    public static void main(String[] args) throws InterruptedException {

        //构建五个进程块
        ProcessControllerBlock PCB1 = ProcessControllerBlock.instance("process1", null, 2, 1, "R");
        ProcessControllerBlock PCB2 = ProcessControllerBlock.instance("process2", null, 3, 5, "R");
        ProcessControllerBlock PCB3 = ProcessControllerBlock.instance("process3", null, 1, 3, "R");
        ProcessControllerBlock PCB4 = ProcessControllerBlock.instance("process4", null, 2, 4, "R");
        ProcessControllerBlock PCB5 = ProcessControllerBlock.instance("process5", null, 4, 2, "R");

        LinkedList<ProcessControllerBlock> PCBLink = new LinkedList<>();
        PCBLink.add(PCB1);
        PCBLink.add(PCB2);
        PCBLink.add(PCB3);
        PCBLink.add(PCB4);
        PCBLink.add(PCB5);

        PCBLink = arrangeBCBLink(PCBLink);
        System.out.println("开始执行");
        int count = 1;


        //这是优先级调度的核心算法
        while (PCBLink.size() != 0) {
            ProcessControllerBlock first = PCBLink.getFirst();
            System.out.println("第" + count + "次执行之前的PCB信息：" + first);
            first.reducePriority();
            if (first.reduceRunningTime() == 0) {
                //如果运行时间为零就把该PCB移出队列
                PCBLink.removeFirst();
            }
            Thread.sleep(1000);
            System.out.println("第" + count + "次执行之后的PCB信息：" + first);
            count++;
            arrangeBCBLink(PCBLink);
        }
        System.out.println("执行完毕");

    }

    /**
     * 按优先级进行降序排序
     *
     * @param pcbLink
     * @return
     */
    private static LinkedList<ProcessControllerBlock> arrangeBCBLink(LinkedList<ProcessControllerBlock> pcbLink) {
        pcbLink.sort((o1, o2) -> o2.getPriority() - o1.getPriority());
        return pcbLink;
    }

}
