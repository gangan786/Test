package com.meizhuo.JVM._10;

import org.junit.Test;

/**
 * @ProjectName: Test
 * @Package: com.meizhuo.JVM._4
 * @ClassName: ${TYPE_NAME}
 * @Description:
 * @Author: Gangan
 * @CreateDate: 2018/9/28 22:05
 * @UpdateUser:
 * @UpdateDate: 2018/9/28 22:05
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class AutoPackage {
    @Test
    public void test0() {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        System.out.println(c == d);
        System.out.println(e == f);
        System.out.println(c == (a + b));
        System.out.println(c.equals(a + b));
        System.out.println(g == (a + b));
        System.out.println(g.equals(a + b));

        /*
        这是编译后的代码
        对于Integer，在在-128至127之间的赋值，Integer对象是在IntegerCache.cache中产生，会复用已有对象
        这个区间内的Integer值可以使用==直接判断，但这个区间之外的所有数据都会在堆中产生，并不会复用已有对象
        public class AutoPackage
{

	public AutoPackage()
	{
	}

	public void test0()
	{
		Integer a = Integer.valueOf(1);
		Integer b = Integer.valueOf(2);
		Integer c = Integer.valueOf(3);
		Integer d = Integer.valueOf(3);
		Integer e = Integer.valueOf(321);
		Integer f = Integer.valueOf(321);
		Long g = Long.valueOf(3L);
		System.out.println(c == d);
		System.out.println(e == f);
		System.out.println(c.intValue() == a.intValue() + b.intValue());
		System.out.println(c.equals(Integer.valueOf(a.intValue() + b.intValue())));
		System.out.println(g.longValue() == (long)(a.intValue() + b.intValue()));
		System.out.println(g.equals(Integer.valueOf(a.intValue() + b.intValue())));
	}
}
        */

    }
}
