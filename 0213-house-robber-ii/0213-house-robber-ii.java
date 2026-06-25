public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        
        return Math.max(robHelper(nums, 0, nums.length - 2), 
                        robHelper(nums, 1, nums.length - 1));
    }
    
    private int robHelper(int[] nums, int start, int end) {
        int[] dp = new int[end - start + 2];
        dp[0] = 0;
        dp[1] = nums[start];
        
        for (int i = start + 1; i <= end; i++) {
            dp[i - start + 1] = Math.max(dp[i - start], 
                                         dp[i - start - 1] + nums[i]);
        }
        
        return dp[end - start + 1];
    }
}