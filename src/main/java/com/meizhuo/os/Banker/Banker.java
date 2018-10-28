package com.meizhuo.os.Banker;

import org.junit.Test;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.os.Banker
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2018/10/27 20:09
 * @UpdateUser:
 * @UpdateDate: 2018/10/27 20:09
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class Banker {

    private Controller controller = Controller.getInstance();

    @Test
    public void main() {
        buildSysResource();
        createProcess();
        //controller.isSafe();
        Resource resourceA = new Resource("A",1);
        Resource resourceB = new Resource("B",0);
        Resource resourceC = new Resource("C",2);

        controller.addRequest("P1", resourceA, resourceB, resourceC);
    }


    /**
     * 构建系统资源
     */
    @Test
    public void buildSysResource() {

        controller.addSystemResource("A", 10);
        controller.addSystemResource("B", 5);
        controller.addSystemResource("C", 7);
    }

    /**
     * 模拟进程模型
     */
    public void createProcess() {
        //构建进程模型
        Resource p0A = new Resource("A", 7, 0);
        Resource p0B = new Resource("B", 5, 1);
        Resource p0C = new Resource("C", 3, 0);
        Process p0 = new Process("P0");
        p0.addResource(p0A);
        p0.addResource(p0B);
        p0.addResource(p0C);
        controller.addProcess(p0);

        Resource p1A = new Resource("A", 3, 2);
        Resource p1B = new Resource("B", 2, 0);
        Resource p1C = new Resource("C", 2, 0);
        Process p1 = new Process("P1");
        p1.addResource(p1A);
        p1.addResource(p1B);
        p1.addResource(p1C);
        controller.addProcess(p1);

        Resource p2A = new Resource("A", 9, 3);
        Resource p2B = new Resource("B", 0, 0);
        Resource p2C = new Resource("C", 2, 2);
        Process p2 = new Process("P2");
        p2.addResource(p2A);
        p2.addResource(p2B);
        p2.addResource(p2C);
        controller.addProcess(p2);

        Resource p3A = new Resource("A", 2, 2);
        Resource p3B = new Resource("B", 2, 1);
        Resource p3C = new Resource("C", 2, 1);
        Process p3 = new Process("P3");
        p3.addResource(p3A);
        p3.addResource(p3B);
        p3.addResource(p3C);
        controller.addProcess(p3);

        Resource p4A = new Resource("A", 4, 0);
        Resource p4B = new Resource("B", 3, 0);
        Resource p4C = new Resource("C", 3, 2);
        Process p4 = new Process("P4");
        p4.addResource(p4A);
        p4.addResource(p4B);
        p4.addResource(p4C);
        controller.addProcess(p4);

    }

}
