package day1;

public class leetcode1550 {
    // Given an integer array arr, return true if there are three consecutive odd numbers in the array. Otherwise, return false.
    public boolean threeConsecutiveOdds(int[] arr) {
        if (arr.length < 3) return false;
        for (int i=1;i<arr.length-1;i++) {
            if (arr[i] % 2 == 1) {
                if (arr[i-1] % 2 == 1 && arr[i+1] % 2 == 1) {
                    return true;
                }
            }
        }

        return false;
    }
}
