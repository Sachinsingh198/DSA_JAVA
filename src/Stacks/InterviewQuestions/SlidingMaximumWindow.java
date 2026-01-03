package Stacks.InterviewQuestions;

import java.util.Stack;

public class SlidingMaximumWindow {
    private static int[] maxSlidingWindowBruteForce(int[] nums, int k) {
        int[] maximum = new int[nums.length - k + 1];
        for(int i = 0; i < nums.length - k + 1; i++){
            int max = nums[i];
            for(int j = i; j < i + k; j++){
                if(nums[j] > max) max = nums[j];
            }
            maximum[i] = max;
        }
        return maximum;
    }

    private static int[] maxSlidingWindowOptimized(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();

        nge[n - 1] = n;
        st.push(n - 1);

        // Build NGE array
        for (int i = n - 2; i >= 0; i--) {
            while (!st.isEmpty() && nums[i] >= nums[st.peek()]) {
                st.pop();
            }
            nge[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        // Sliding window using NGE jump logic
        int z = 0;
        for (int i = 0; i <= n - k; i++) {
            int j = i;
            while (j < i + k) {
                if (nge[j] >= i + k) {
                    ans[z++] = nums[j];
                    break;
                }
                j = nge[j];
            }
        }

        return ans;
    }


    public static void main(String[] args) {

    }
}
