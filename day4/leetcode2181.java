package day4;

public class leetcode2181 {
    // You are given the head of a linked list, which contains a series of integers separated by 0's. The beginning and end of the linked list will have Node.val == 0.

    // For every two consecutive 0's, merge all the nodes lying in between them into a single node whose value is the sum of all the merged nodes. The modified list should not contain any 0's.

    // Return the head of the modified linked list.

    public ListNode mergeNodes(ListNode head) {
        ListNode traversal = head;

        ListNode result = null;
        ListNode traversalResult = result;

        int totalBetweenZeros = 0;

        while (traversal != null) {
            if (traversal.val == 0) {
                if (traversal.next != null) {
                    traversal = traversal.next;
                    // Keep going from 0 to the closest 0 -> get total value of non-value integers between them
                    while (traversal.val != 0) {
                        totalBetweenZeros += traversal.val;
                        traversal = traversal.next;
                    }

                    // After getting total value of non-value integers between 2 zeros, create a new node, contain the total value
                    ListNode nodeContainsTotalBetweenZeros = new ListNode(totalBetweenZeros);
                    // System.out.println(nodeContainsTotalBetweenZeros.val + " " + traversal.val);

                    // This is when the result list is null => the just created node is the head of result linked list
                    if (traversalResult == null) {
                        result = nodeContainsTotalBetweenZeros;
                        traversalResult = result;
                    } else { // This is when the result list is not null => traversalResult is the varying node containing last node of result linked list 
                        // Assign the just created node to the result linkedlist by adding to the next of traversalResult node 
                        traversalResult.next = nodeContainsTotalBetweenZeros;
                        traversalResult = traversalResult.next;
                    }
                    totalBetweenZeros = 0;
                } else {
                    // This is when the 0 is the last 0 of the list.
                    traversal = traversal.next;
                }
            } 
        }

        return result;
    }
}
