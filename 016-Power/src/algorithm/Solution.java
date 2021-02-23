package algorithm;

import java.math.BigDecimal;
import java.util.Map;

class Power {

    public double power(double base, int exponent) {
        if (compareDouble(base, 0.0) == 0 && exponent == 0) {
            return 0;
        }
        int absExponent = Math.abs(exponent);
        double result = powerWithPositiveExponent(base, absExponent);
        if (exponent < 0) {
            result = 1.0 / result;
        }
        return result;
    }

    public double powerWithPositiveExponent(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        double result = powerWithPositiveExponent(base, exponent >> 1);
        result = result * result;
        if ((exponent & 0x1) == 1) {
            result = result * base;
        }
        return result;
    }

    public int compareDouble(double a, double b) {
        BigDecimal data1 = new BigDecimal(a);
        BigDecimal data2 = new BigDecimal(b);
        return data1.compareTo(data2);
    }

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double res = 1;
        for (int i = 0; i < Math.abs(n); i++) {
            res = res * x;
        }
        return n > 0 ? res : 1 / res;
    }

    public double myPow1(double x, int n) {
        if (x == 0) {
            return 0;
        }
        double res = 1.0;
        long num = n;
        num = Math.abs(num);
        while (num > 0) {
            if ((num & 1) == 1) {
                res = res * x;
            }
            x = x * x;
            num = num >>> 1;
        }
        return n > 0 ? res : 1.0 / res;
    }
}

public class Solution {

    public static void main(String[] args) {
        Power power = new Power();
        double res = power.power(2.0, -3);
        System.out.println("结果:" + res);
        double res1 = power.myPow(2.0, -3);
        System.out.println("结果:" + res1);
        double res2 = power.myPow1(-2.00000, -2147483648);
        System.out.println("结果:" + res2);
    }
}
