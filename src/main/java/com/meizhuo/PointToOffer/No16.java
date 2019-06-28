package com.meizhuo.PointToOffer;

import org.junit.Test;

/**
 * @Classname No16
 * @Description 幂运算
 * @Date 2019/6/28 16:32
 * @Created by Gangan
 */
public class No16 {

    public double pow(double base, int exponent) {
        if (base == 0.0 && exponent < 0) {
            throw new IllegalStateException("非法输入");
        }
        int absExponent = Math.abs(exponent);
        double result = powerWithAbsExponent(base, absExponent);
        if (exponent < 0) {
            result = 1.0 / result;
        }
        return result;

    }

    private double powerWithAbsExponent(double base, int absExponent) {
        if (absExponent == 0) {
            return 1;
        } else if (absExponent == 1) {
            return base;
        }
        double result = powerWithAbsExponent(base, absExponent >> 1);
        result = result * result;
        if ((absExponent & 0x1) == 1) {
            result = result * base;
        }
        return result;
    }

    @Test
    public void test() {
        System.out.println(pow(2, 4));
    }

}
