package day5;

import java.util.ArrayList;
import java.util.List;

public class leetcode2058 {
    // A critical point in a linked list is defined as either a local maxima or a local minima.

    // A node is a local maxima if the current node has a value strictly greater than the previous node and the next node.

    // A node is a local minima if the current node has a value strictly smaller than the previous node and the next node.

    // Note that a node can only be a local maxima/minima if there exists both a previous node and a next node.

    // Given a linked list head, return an array of length 2 containing [minDistance, maxDistance] where minDistance is the minimum distance between any two distinct critical points and maxDistance is the maximum distance between any two distinct critical points. If there are fewer than two critical points, return [-1, -1].

    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return new int[]{-1, -1};
        }

        List<Integer> criticalPoints = new ArrayList<>();
        ListNode prev = head;
        ListNode curr = head.next;
        int position = 1;

        while (curr.next != null) {
            if ((curr.val > prev.val && curr.val > curr.next.val) ||
                (curr.val < prev.val && curr.val < curr.next.val)) {
                criticalPoints.add(position);
            }
            prev = curr;
            curr = curr.next;
            position++;
        }

        if (criticalPoints.size() < 2) {
            return new int[]{-1, -1};
        }

        int minDistance = Integer.MAX_VALUE;
        int maxDistance = criticalPoints.get(criticalPoints.size() - 1) - criticalPoints.get(0);

        for (int i = 1; i < criticalPoints.size(); i++) {
            minDistance = Math.min(minDistance, criticalPoints.get(i) - criticalPoints.get(i - 1));
        }

        return new int[]{minDistance, maxDistance};
    }
}
