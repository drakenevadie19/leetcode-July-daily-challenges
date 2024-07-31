package day10;

import java.util.Stack;

public class leetcode1598 {
    // The Leetcode file system keeps a log each time some user performs a change folder operation.

    // The operations are described below:

    //     "../" : Move to the parent folder of the current folder. (If you are already in the main folder, remain in the same folder).
    //     "./" : Remain in the same folder.
    //     "x/" : Move to the child folder named x (This folder is guaranteed to always exist).
    // You are given a list of strings logs where logs[i] is the operation performed by the user at the ith step.

    // The file system starts in the main folder, then the operations in logs are performed.

    // Return the minimum number of operations needed to go back to the main folder after the change folder operations.

    public int minOperations(String[] logs) {
        if (logs.length == 1) return 1;

        Stack<String> stack = new Stack<>();
        for (int i=0;i<logs.length;i++) {
            // if it is ../ => move to parent folder
            if (logs[i].equals("../")) {
                // System.out.println(i + " previous " + logs[i]);
                if (stack.isEmpty()) {
                    continue;
                } else {
                    stack.pop();
                }
            // if it is ./ => move to current folder => do nothing => continue
            } else if (logs[i].equals("./")) {
                // System.out.println(i + " remains " + logs[i]);
                continue;
            // else push to stack (store as current, next top on stack is child folder of current folder)
            } else {
                // System.out.println(i + " " + logs[i]);
                stack.push(logs[i]);
            }
        }

        return stack.size();
    }
}
