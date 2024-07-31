package day3;

import java.util.Arrays;

public class leetcode1509 {
    //You are given an integer array nums.
    // In one move, you can choose one element of nums and change it to any value.
    // Return the minimum difference between the largest and smallest value of nums after performing at most three moves.
    
    public int minDifference(int[] nums) {
        if(nums.length <= 4) {
            return 0;
        }
        Arrays.sort(nums);
        int ans = nums[nums.length - 1] - nums[0];
        for(int i = 0; i <= 3; i++) {
            ans = Math.min(ans, nums[nums.length - (3 - i) - 1] - nums[i]);
        }
        return ans;
    }
}
