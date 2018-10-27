package com.meizhuo.os.ProcessController;

import lombok.Data;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.os.ProcessController
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2018/10/27 10:42
 * @UpdateUser:
 * @UpdateDate: 2018/10/27 10:42
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
@Data
public class ProcessControllerBlock {

    private static final String RUN = "R";

    private static final String QUIT = "E";

    private String processName;

    private ProcessControllerBlock nextBlock;

    private int runningTime;

    private int priority;

    private String state = RUN;

    private ProcessControllerBlock(String processName, ProcessControllerBlock nextBlock, int runningTime, int priority, String state) {
        this.processName = processName;
        this.nextBlock = nextBlock;
        this.runningTime = runningTime;
        this.priority = priority;
        this.state = state;
    }

    /**
     * 将运行时间自减并返回
     *
     * @return
     */
    public int reduceRunningTime() {
        if (runningTime != 0) {
            return --runningTime;
        } else {
            state = QUIT;
            return runningTime;
        }
    }

    /**
     * 将优先级自减并返回
     *
     * @return
     */
    public int reducePriority() {
        if (priority != 0) {
            return --priority;
        } else {
            return priority;
        }
    }

    /**
     * 新建一个PCB实例
     *
     * @param processName
     * @param nextBlock
     * @param runningTime
     * @param priority
     * @param state
     * @return
     */
    public static ProcessControllerBlock instance(String processName, ProcessControllerBlock nextBlock, int runningTime, int priority, String state) {
        return new ProcessControllerBlock(processName, nextBlock, runningTime, priority, state);
    }

}
