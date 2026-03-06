package DP.Questions;

import static DP.Questions.LongestCommonSubsequence.longestCommonSubsequence;

public class MinInsertionSteps {
    public int minInsertions(String s) {
        return s.length() - longestPalindromeSubseq(s);
    }
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
