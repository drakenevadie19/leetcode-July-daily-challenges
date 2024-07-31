package day2;

import java.util.ArrayList;
import java.util.Arrays;

public class leetcode350 {
    // Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order. 
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0,j=0;

        ArrayList<Integer> list = new ArrayList<>();
        while (i<nums1.length && j<nums2.length) {
            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        int[] result = new int[list.size()];
        if (result.length == 0) return result;
        for (i=0;i<list.size();i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}
