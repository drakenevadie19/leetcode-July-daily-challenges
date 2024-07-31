package day25;

public class leetcode912 {
    // Given an array of integers nums, sort the array in ascending order and return it.

    // You must solve the problem without using any built-in functions in O(nlog(n)) time complexity and with the smallest space complexity possible.

    // Use Dictionary
    public int[] sortArray(int[] nums) {
        int max = nums[0];
        int min = nums[0];

        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        int n = max - min;
        int[] arr = new int[n + 1];

        for (int num : nums) {
            arr[num - min]++;
        }

        int index = 0;

        for (int i = 0; i <= n; i++) {
            while (arr[i] > 0) {
                nums[index] = min;
                index++;
                arr[i]--;
            }

            min++;
        }

        return nums;
    }
}
