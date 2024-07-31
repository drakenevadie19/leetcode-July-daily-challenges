package day24;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.lang.model.util.Elements;

public class leetcode2191 {
    // You are given a 0-indexed integer array mapping which represents the mapping rule of a shuffled decimal system. mapping[i] = j means digit i should be mapped to digit j in this system.

    // The mapped value of an integer is the new integer obtained by replacing each occurrence of digit i in the integer with mapping[i] for all 0 <= i <= 9.

    // You are also given another integer array nums. Return the array nums sorted in non-decreasing order based on the mapped values of its elements.

    // Notes:

    //     Elements with the same mapped values should appear in the same relative order as in the input.
    //     The elements of nums should only be sorted based on their mapped values and not be replaced by them.

    public int[] sortJumbled(int[] mapping, int[] nums) {
        Map<Integer, Integer> numberMapping = new HashMap<>();

        for (int num : nums) {
            if (!numberMapping.containsKey(num)) {
                numberMapping.put(num, translateInteger(num, mapping));
            }
        }

        Integer[] numsBoxed = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(numsBoxed, (a, b) -> Integer.compare(numberMapping.get(a), numberMapping.get(b)));

        for (int i = 0; i < nums.length; i++) {
            nums[i] = numsBoxed[i];
        }

        return nums;
    }

    private int translateInteger(int num, int[] mapping) {
        char[] digits = Integer.toString(num).toCharArray();
        for (int i = 0; i < digits.length; i++) {
            digits[i] = (char) ('0' + mapping[digits[i] - '0']);
        }
        return Integer.parseInt(new String(digits));
    }
}
