package org.wayne.spring.javase.leetcode;

//回文数，是指从左到右和从右到左读是一样的整数
public class Palindrome {

    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        if (x>0&& x%10==0) {
            return false;
        }

        int temp=0;
        while (true) {
            int a = x % 10;
            x /=10;
            temp = temp * 10 + a;
            if (temp >= x) break;
        }

        if (temp == x) return true;
        else if (temp /10 == x) return true;
        else return false;
    }

    public static void main(String[] args) {
        int x = 10001;
        Palindrome palindrome = new Palindrome();
        boolean res = palindrome.isPalindrome(x);
        System.out.println(res);
    }
}
