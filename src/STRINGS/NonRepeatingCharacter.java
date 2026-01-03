package STRINGS;

public class NonRepeatingCharacter {
    static char nonRepeatingChar(String s){
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
        String s = "racecar";
        
    }
}
