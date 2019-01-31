package com.meizhuo.DesignPatterns.FunnyDesignPatterns_15_抽象工厂模式;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.DesignPatterns.FunnyDesignPatterns_15_抽象工厂模式
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2019/1/30 22:45
 * @UpdateUser:
 * @UpdateDate: 2019/1/30 22:45
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class DataAccess {

    private static final String db = "SqlServer";

    public static IUser createUser() {
        String className="com.meizhuo.DesignPatterns.FunnyDesignPatterns_15_抽象工厂模式.Impl."+db+"User";
        try {
            return (IUser) Class.forName(className).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static IDepartment createDepartment(){
        String className = "com.meizhuo.DesignPatterns.FunnyDesignPatterns_15_抽象工厂模式.Impl." + db + "Department";
        try {
            return (IDepartment) Class.forName(className).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
