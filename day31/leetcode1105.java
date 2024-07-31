package day31;

import java.util.Arrays;

public class leetcode1105 {
    // You are given an array books where books[i] = [thicknessi, heighti] indicates the thickness and height of the ith book. You are also given an integer shelfWidth.

    // We want to place these books in order onto bookcase shelves that have a total width shelfWidth.

    // We choose some of the books to place on this shelf such that the sum of their thickness is less than or equal to shelfWidth, then build another level of the shelf of the bookcase so that the total height of the bookcase has increased by the maximum height of the books we just put down. We repeat this process until there are no more books to place.

    // Note that at each step of the above process, the order of the books we place is the same order as the given sequence of books.

    //     For example, if we have an ordered list of 5 books, we might place the first and second book onto the first shelf, the third book on the second shelf, and the fourth and fifth book on the last shelf.
    // Return the minimum possible height that the total bookshelf can be after placing shelves in this manner.

    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;  // Base case: no books require 0 height
        
        for (int i = 1; i <= n; ++i) {
            int total_width = 0;
            int max_height = 0;
            for (int j = i; j > 0; --j) {
                total_width += books[j-1][0];
                if (total_width > shelfWidth) {
                    break;
                }
                max_height = Math.max(max_height, books[j-1][1]);
                dp[i] = Math.min(dp[i], dp[j-1] + max_height);
            }
        }
        
        return dp[n];
    }
}
