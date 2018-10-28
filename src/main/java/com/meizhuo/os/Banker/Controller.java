package com.meizhuo.os.Banker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.os.Banker
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2018/10/27 14:22
 * @UpdateUser:
 * @UpdateDate: 2018/10/27 14:22
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class Controller {

    private static Controller INSTANCE = null;

    private Controller() {

    }

    /**
     * 构建单例
     *
     * @return
     */
    public static Controller getInstance() {
        if (INSTANCE == null) {
            synchronized (Controller.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Controller();
                }
            }
        }
        return INSTANCE;
    }

    /**
     * 用于保存系统最大资源
     */
    private static final HashMap<String, Resource> MAX_RESOURCE_MAP = new HashMap<>();

    /**
     * 用于保存进程
     */
    private ArrayList<Process> processList = new ArrayList<>();

    /**
     * 记录待完成的进程数
     */
    private int doneProcessCount = 0;

    /**
     * 用于保存可用资源
     */
    private static final HashMap<String, Resource> AVAIL_RESOURCE_MAP = new HashMap<>();


    /**
     * 添加一个进程
     *
     * @param process
     */
    public void addProcess(Process process) {

        //这里还应该对process的合法性进行检测
        processList.add(process);

        doneProcessCount++;

        addResource(process.resourceList);

    }


    /**
     * 安全性检测算法
     *
     * @return
     */
    public ArrayList<Process> isSafe() {
        //深拷贝构建副本
        HashMap<String, Integer> tempAvailMap = new HashMap<>();
        for (Map.Entry<String, Resource> entry : AVAIL_RESOURCE_MAP.entrySet()) {
            tempAvailMap.put(entry.getKey(), entry.getValue().getAvail());
        }

        //这里是浅拷贝
        ArrayList<Process> tempProcessList = new ArrayList<>();
        tempProcessList.addAll(processList);

        HashMap<Integer, Integer> scanningRecover = new HashMap<>(12);
        ArrayList<Process> safeProcess = new ArrayList<>();

        int scanningCount = 0;
        while (doneProcessCount != 0) {

            for (Process process : tempProcessList) {
                //这个循环是寻找合适进程进行资源发放
                if (!process.isDone) {
                    //计算未完成的进程
                    int canCount = 0;
                    for (Resource resource : process.resourceList) {
                        Integer availCount = tempAvailMap.get(resource.resourceName);
                        if (resource.need <= availCount) {
                            //如果所需要的小于等于所拥有的，记录下来
                            canCount++;
                        } else {
                            //否则直接结束此段循环
                            break;
                        }
                    }

                    if (canCount == AVAIL_RESOURCE_MAP.size()) {
                        //如果所有资源申请都符合则说明此进程可被执行，进行试分配
                        for (Resource resource : process.resourceList) {
                            //释放资源并调整可用资源
                            //获取持有资源
                            int alloc = resource.alloc;
                            //获取原有资源
                            Integer availed = tempAvailMap.get(resource.resourceName);
                            //回收资源
                            tempAvailMap.put(resource.resourceName, alloc + availed);
                            canCount--;
                            if (canCount == 0) {
                                //将该临时进程添加进安全序列
                                safeProcess.add(process);
                                //将该进程所有资源回收后标记该进程
                                process.isDone = true;
                                //代完成数目减一
                                --doneProcessCount;
                            }
                        }
                    }
                }
            }
            //记录扫描数
            scanningCount++;
            scanningRecover.put(scanningCount, doneProcessCount);

            //取出上一次扫描记录
            if (scanningCount != 1) {
                Integer lastDoneProcessCount = scanningRecover.get(scanningCount - 1);
                if (lastDoneProcessCount == doneProcessCount && doneProcessCount != 0) {
                    //说明没有安全序列
                    safeProcess.clear();
                    break;
                }
            }
        }
        return safeProcess;
    }

    /**
     * 检查进程队列里面所有进程是否都完成
     *
     * @param tempProcessList
     * @return
     */
    private boolean checkDone(ArrayList<Process> tempProcessList) {
        for (Process process : tempProcessList) {
            if (!process.isDone) {
                return false;
            }
        }
        return true;
    }

    /**
     * 添加系统资源
     *
     * @param resourceName
     * @param maxCount
     */
    public void addSystemResource(String resourceName, int maxCount) {
        Resource systemResource = new Resource(resourceName, maxCount, 0);
        systemResource.setAvail(maxCount);
        MAX_RESOURCE_MAP.put(resourceName, systemResource);
        //初始化系统资源的时候可用资源就是全部系统资源
        AVAIL_RESOURCE_MAP.put(resourceName, systemResource);
    }

    /**
     * 添加资源请求
     *
     * @param processName
     * @param resources
     * @return
     */
    public boolean addRequest(String processName, Resource... resources) {
        //获取对应名称的进程
        Process process = getProcessByName(processName);
        if (process == null) {
            throw new RuntimeException("该进程不存在");
        } else {
            if (checkResIsLegal(process, resources)) {
                //调整资源进行试分配
                for (Resource resource : process.resourceList) {
                    //维护进程中的资源数量
                    for (Resource requestRes : resources) {
                        if (resource.resourceName.equals(requestRes.resourceName)){
                            resource.addAlloc(requestRes.request);

                            Resource ed = AVAIL_RESOURCE_MAP.get(resource.resourceName);
                            int now = ed.getAvail() - requestRes.request;
                            ed.setAvail(now);
                        }
                    }
                }
                ArrayList<Process> safe = isSafe();
            }
        }
        return true;
    }

    /**
     * 检查资源请求是否合法
     *
     * @param process
     * @param rqsResources
     * @return
     */
    private boolean checkResIsLegal(Process process, Resource[] rqsResources) {

        //判断系统是否有这个资源
        for (Resource rqsResource : rqsResources) {
            if (!MAX_RESOURCE_MAP.containsKey(rqsResource.resourceName)) {
                throw new RuntimeException("资源名为：" + rqsResource.resourceName + " 的资源不存在");
            }
        }

        //对资源数量进行检测
        for (Resource resource : process.resourceList) {
            for (Resource rqsResource : rqsResources) {
                if (rqsResource.resourceName.equals(resource.resourceName)){
                    if (resource.need<rqsResource.request){
                        throw new RuntimeException("资源名为：" + rqsResource.resourceName + " 的资源数量要求不合理");
                    }
                }
            }
        }

        return true;
    }


    /**
     * 添加资源后维护AVAIL_RESOURCE_MAP的值
     *
     * @param resourceList
     */
    private void addResource(ArrayList<Resource> resourceList) {
        //维护可用资源的值
        for (Resource resource : resourceList) {
            //从map中取出与resource对应的系统资源详情
            Resource sys = AVAIL_RESOURCE_MAP.get(resource.resourceName);
            if (sys == null) {
                throw new RuntimeException("系统不存在资源名称为：" + resource.resourceName + "的资源");
            }
            //得出剩余资源数量
            int avail = sys.getAvail() - resource.alloc;
            Resource availResource = new Resource(sys.resourceName, -1, -1);
            availResource.setAvail(avail);
            //将更新后的资源重新放回覆盖
            AVAIL_RESOURCE_MAP.put(sys.resourceName, availResource);
        }
    }

    /**
     * 根据进程名获取具体的进程
     *
     * @param processName
     * @return
     */
    private Process getProcessByName(String processName) {
        for (Process process : processList) {
            if (process.getProcessName().equals(processName)) {
                return process;
            }
        }
        return null;
    }


}
