package com.meizhuo.JVM._4;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.JVM._4
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2018/6/19 17:05
 * @UpdateUser:
 * @UpdateDate: 2018/6/19 17:05
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class Commend {
    public static void main(String[] args) {
        int i=0;
        while (true){
            System.out.println("执行"+i+"次");
            try {
                Thread.sleep(1000);
                i++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
