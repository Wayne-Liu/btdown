package org.wayne.spring.javase.leetcode;

//数值位数反转
public class IntegerReverse {

    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int a = x % 10;
            x = x / 10;
            if (result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE/10 && a==7)) return 0;
            if (result < -Integer.MAX_VALUE/10 || (result == -Integer.MAX_VALUE/10 && a==-8)) return 0;
            result = result*10 + a;
        }
        return result;

    }

    public static void main(String[] args) {
        IntegerReverse ir = new IntegerReverse();
        int a = -1234;
        System.out.println(ir.reverse(a));
    }
}
