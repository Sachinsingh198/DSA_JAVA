package STRINGS;

import java.util.Arrays;

public class MostFrequentCharacter {
    public static char mostFrequentCharacter(String s){
//
//        int n = s.length();
//        int maxFreq = -1;
//        char ans = s.charAt(0);
//        char[] arr = s.toCharArray();
//        Arrays.sort(arr);
//        int i =0, j = 0;
//
//        while(j < n){
//            if(arr[i] == arr[j]) j++;
//            else{
//                int freq = j - i;
//                if(freq > maxFreq){
//                    maxFreq = freq;
//                    ans = arr[i];
//                }
//                i = j;
//            }
//        }
//        int freq = j - i;
//        if(freq > maxFreq){
//            maxFreq = freq;
//            ans = arr[i];
//        }
//        return ans;

        int n = s.length();
        int[] freq = new int[26];
        for(int i = 0; i< n;i++){
            freq[s.charAt(i) - 97]++;
        }
        int maxfreq = 0;
        char ans = s.charAt(0);
        for(int i = 0; i< n; i++){
            if(freq[i] > maxfreq) {
                maxfreq = freq[i];
                ans = (char)(i + 97);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        String s = "character";
        char c = mostFrequentCharacter(s);
        System.out.println(c);
    }
}
