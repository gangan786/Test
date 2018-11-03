package com.meizhuo.os.page_exchange;

import java.util.ArrayList;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.os.page_exchange
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2018/11/3 14:16
 * @UpdateUser:
 * @UpdateDate: 2018/11/3 14:16
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
     * 模拟物理块
     */
    private ArrayList<Page> pageFrameList = new ArrayList<>();

    /**
     * 记录叶框的个数，默认3个
     */
    private int pageFrameListSize = 3;

    /**
     * 模拟虚拟内存
     */
    private ArrayList<Page> virtualMemory = new ArrayList<>();

    /**
     * 添加页面，模拟作业的页面走向
     *
     * @param page
     * @return
     */
    public boolean addPage(Page page) {
        return virtualMemory.add(page);
    }

    /**
     * 模拟FIFO页面置换算法
     */
    public void pageExchangeToFIFO() throws InterruptedException {
        int cut = 0;
        for (Page page : virtualMemory) {
            Thread.sleep(1000);
            System.out.println("当前要执行的页面为：" + page.getName());
            if (!pageFrameList.contains(page)) {
                //pageFrameList中不存在所需页面，发生中断
                //记录中断数
                cut++;
                System.out.println("页面发生中断");
                if (pageFrameList.size() < pageFrameListSize) {
                    pageFrameList.add(page);
                } else {
                    //否则移除List的最后一个并往第一个添加
                    System.out.println("移除页面：" + pageFrameList.get(0).getName());
                    pageFrameList.remove(0);
                    pageFrameList.add(page);
                    System.out.println("添加的页面为：" + page.getName());
                }
            } else {
                //此处没有发生中断
                System.out.println(page.getName() + " 页面存在，不需要发生中断");
            }

            System.out.println("--------------------------------");

        }

        System.out.println("缺页次数为：" + cut);
        System.out.println("缺页率为：" + cut / (float) virtualMemory.size());

    }

    /**
     * 模拟LRU页面置换算法
     */
    public void pageExchangeToLRU() throws InterruptedException {
        int cut = 0;
        for (Page page : virtualMemory) {
            Thread.sleep(1000);
            //记录此叶面被调用
            page.addCount();
            System.out.println("当前要执行的页面为：" + page.getName());
            if (!pageFrameList.contains(page)) {
                //pageFrameList中不存在所需页面，发生中断
                //记录中断数
                cut++;
                System.out.println("页面发生中断");
                if (pageFrameList.size() < pageFrameListSize) {
                    pageFrameList.add(page);
                } else {
                    Page uselessPage = getUselessPage();
                    //重置调用次数
                    uselessPage.reSetCount();
                    pageFrameList.remove(uselessPage);
                    pageFrameList.add(page);
                    System.out.println("移除页面" + uselessPage.getName() + "  调用次数为：" + uselessPage.getCount());
                    System.out.println("添加的页面为：" + page.getName());
                }
            } else {
                //此处没有发生中断
                System.out.println(page.getName() + " 页面存在，不需要发生中断");
            }

            System.out.println("--------------------------------");

        }

        System.out.println("最后的的页面为：");
        for (Page page : pageFrameList) {
            System.out.println("最后页面名称为："+page.getName()+"  该页面被调用的次数为："+page.getCount());
        }
        System.out.println("缺页次数为：" + cut);
        System.out.println("缺页率为：" + cut / (float) virtualMemory.size());

    }

    /**
     * 遍历查找出最少使用的页面
     *
     * @return
     */
    private Page getUselessPage() {
        Page uselessPage = pageFrameList.get(0);
        for (Page page : pageFrameList) {
            if (uselessPage.getCount() > page.getCount()) {
                uselessPage = page;
            }
        }
        return uselessPage;
    }

}
