package day13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class leetcode2751 {
    // There are n 1-indexed robots, each having a position on a line, health, and movement direction.

    // You are given 0-indexed integer arrays positions, healths, and a string directions (directions[i] is either 'L' for left or 'R' for right). All integers in positions are unique.

    // All robots start moving on the line simultaneously at the same speed in their given directions. If two robots ever share the same position while moving, they will collide.

    // If two robots collide, the robot with lower health is removed from the line, and the health of the other robot decreases by one. The surviving robot continues in the same direction it was going. If both robots have the same health, they are both removed from the line.

    // Your task is to determine the health of the robots that survive the collisions, in the same order that the robots were given, i.e. final heath of robot 1 (if survived), final health of robot 2 (if survived), and so on. If there are no survivors, return an empty array.

    // Return an array containing the health of the remaining robots (in the order they were given in the input), after no further collisions can occur.

    // Note: The positions may be unsorted.

    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        List<int[]> robots = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            robots.add(new int[]{positions[i], healths[i], directions.charAt(i), i});
        }

        Collections.sort(robots, (a, b) -> Integer.compare(a[0], b[0]));

        Stack<int[]> stack = new Stack<>();

        for (int[] robot : robots) {
            if (robot[2] == 'R' || stack.isEmpty() || stack.peek()[2] == 'L') {
                stack.push(robot);
                continue;
            }

            if (robot[2] == 'L') {
                boolean add = true;
                while (!stack.isEmpty() && stack.peek()[2] == 'R' && add) {
                    int last_health = stack.peek()[1];
                    if (robot[1] > last_health) {
                        stack.pop();
                        robot[1] -= 1;
                    } else if (robot[1] < last_health) {
                        stack.peek()[1] -= 1;
                        add = false;
                    } else {
                        stack.pop();
                        add = false;
                    }
                }

                if (add) {
                    stack.push(robot);
                }
            }
        }

        List<int[]> resultList = new ArrayList<>(stack);
        resultList.sort(Comparator.comparingInt(a -> a[3]));

        List<Integer> result = new ArrayList<>();
        for (int[] robot : resultList) {
            result.add(robot[1]);
        }

        return result;
    }
}
