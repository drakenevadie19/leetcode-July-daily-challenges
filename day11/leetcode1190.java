package day11;

public class leetcode1190 {
    // You are given a string s that consists of lower case English letters and brackets.

    // Reverse the strings in each pair of matching parentheses, starting from the innermost one.

    // Your result should not contain any brackets.

    int i = 0;
    public String reverseParentheses(String s) {
        char[] ar = s.toCharArray();
        return helper(ar);
    }

    public String helper(char[] s){
        StringBuilder sb = new StringBuilder();

        while(i < s.length){
            if(s[i] == ')'){
                i++;
                return sb.reverse().toString();
            }else if(s[i] == '('){
                i++;
                String st  = helper(s);
                sb.append(st);
            }else{
                sb.append(s[i]);
                i++;
            }
        }
        return sb.toString();

    }
}
