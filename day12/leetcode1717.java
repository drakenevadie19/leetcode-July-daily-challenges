package day12;

public class leetcode1717 {
    // You are given a string s and two integers x and y. You can perform two types of operations any number of times.

    //     Remove substring "ab" and gain x points.
    //         For example, when removing "ab" from "cabxbae" it becomes "cxbae".
    //     Remove substring "ba" and gain y points.
    //         For example, when removing "ba" from "cabxbae" it becomes "cabxe".
    // Return the maximum points you can gain after applying the above operations on s.

    public int maximumGain(String s, int x, int y) {
        int res = 0;
        String top, bot;
        int top_score, bot_score;

        if (y > x) {
            top = "ba";
            top_score = y;
            bot = "ab";
            bot_score = x;
        } else {
            top = "ab";
            top_score = x;
            bot = "ba";
            bot_score = y;
        }

        // Removing first top substrings cause they give more points
        StringBuilder stack = new StringBuilder();
        for (char ch : s.toCharArray()) { // Changed 'char' to 'ch'
            if (ch == top.charAt(1) && stack.length() > 0 && stack.charAt(stack.length() - 1) == top.charAt(0)) {
                res += top_score;
                stack.setLength(stack.length() - 1);
            } else {
                stack.append(ch);
            }
        }

        // Removing bot substrings cause they give less or equal amount of scores
        StringBuilder new_stack = new StringBuilder();
        for (char ch : stack.toString().toCharArray()) { // Changed 'char' to 'ch'
            if (ch == bot.charAt(1) && new_stack.length() > 0 && new_stack.charAt(new_stack.length() - 1) == bot.charAt(0)) {
                res += bot_score;
                new_stack.setLength(new_stack.length() - 1);
            } else {
                new_stack.append(ch);
            }
        }

        return res;
    }
}
