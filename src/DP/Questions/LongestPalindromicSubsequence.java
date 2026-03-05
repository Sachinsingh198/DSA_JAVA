package DP.Questions;

import java.util.Arrays;

import static DP.Questions.LongestCommonSubsequence.lcs;
import static DP.Questions.LongestCommonSubsequence.longestCommonSubsequence;

public class LongestPalindromicSubsequence {
    public String reverse(String s){
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        s = sb.toString();
        return s;
    }
    public int longestPalindromeSubseq(String s) {
        return longestCommonSubsequence(s, reverse(s));
    }
    public static void main(String[] args) {

    }
}
