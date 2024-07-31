package day8;

import java.util.ArrayList;

public class leetcode1823 {
    // There are n friends that are playing a game. The friends are sitting in a circle and are numbered from 1 to n in clockwise order. More formally, moving clockwise from the ith friend brings you to the (i+1)th friend for 1 <= i < n, and moving clockwise from the nth friend brings you to the 1st friend.

    // The rules of the game are as follows:

    // 1. Start at the 1st friend.
    // 2. Count the next k friends in the clockwise direction including the friend you started at. The counting wraps around the circle and may count some friends more than once.
    // 3. The last friend you counted leaves the circle and loses the game.
    // 4. If there is still more than one friend in the circle, go back to step 2 starting from the friend immediately clockwise of the friend who just lost and repeat.
    // 5. Else, the last friend in the circle wins the game.
    // Given the number of friends, n, and an integer k, return the winner of the game.

    public int findTheWinner(int n, int k) {
        ArrayList<Integer> circle = new ArrayList<>();
        for (int i = 1; i <= n; ++i) {
            circle.add(i);
        }
        int cur_ind = 0;

        while (circle.size() > 1) {
            int next_to_remove = (cur_ind + k - 1) % circle.size();
            circle.remove(next_to_remove);
            cur_ind = next_to_remove;
        }

        return circle.get(0);
    }
}
