package day22;

import java.util.Arrays;
import java.util.HashMap;

public class leetcode2418 {
    // You are given an array of strings names, and an array heights that consists of distinct positive integers. Both arrays are of length n.

    // For each index i, names[i] and heights[i] denote the name and height of the ith person.

    // Return names sorted in descending order by the people's heights.

    public String[] sortPeople(String[] names, int[] heights) {
        if (names.length == 1) return names;

        HashMap<Integer, String> map = new HashMap<>();
        for (int i=0;i<heights.length;i++) {
            map.put(heights[i], names[i]);
        } 

        Arrays.sort(heights);
        for (int i=heights.length-1;i>=0;i--) {
            names[Math.abs(i-heights.length+1)] = map.get(heights[i]);
        }

        return names;
    }
}
