package com.wdm.example.algorithm;

public class LongestPalindrome {

    public static String longestPalindrome(String s) {
        int length = s.length();
        int maxlength = 0;
        int  start = 0;
        int tag = 0;
        boolean P[][] = new boolean[length][length];
        for(int i = 0;i<length;i++)
        {
            for(int j = 0;j< length;j++)
                P[i][j] = false;
        }   
        for(int i = 0; i < length; i++)
        {
            P[i][i] = true;
            if(i<length-1&& s.charAt(i) == s.charAt(i+1))
            {
                P[i][i+1] = true;
                maxlength = 2;
                start = i;
            }
        }   
        for(int len = 3; len <=length;len++)
        {
            tag = 0;
            for(int i = 0 ; i<= length-len ; i++)
            {
                int j = i+len-1;
                if(P[i+1][j-1] && s.charAt(i)==s.charAt(j))
                {
                    P[i][j] = true;
                    maxlength = len;
                    if(tag == 0)
                    start = i;
                    tag = 1;
                }
            }
        }
        if(maxlength>=2)
            return s.substring(start, maxlength+start);
        return s.substring(0,1);
    }

    public static void main(String args[]) {
        String s = "aaa";
        String S1 = longestPalindrome(s);
        System.out.println(S1);
    }
}
