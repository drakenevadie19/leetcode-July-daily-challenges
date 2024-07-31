package day9;

public class leetcode1701 {
    // There is a restaurant with a single chef. You are given an array customers, where customers[i] = [arrivali, timei]:

    // arrival[i] is the arrival time of the ith customer. The arrival times are sorted in non-decreasing order.
    // time[i] is the time needed to prepare the order of the ith customer.
    // When a customer arrives, he gives the chef his order, and the chef starts preparing it once he is idle. The customer waits till the chef finishes preparing his order. The chef does not prepare food for more than one customer at a time. The chef prepares food for customers in the order they were given in the input.

    // Return the average waiting time of all customers. Solutions within 10-5 from the actual answer are considered accepted.

    public double averageWaitingTime(int[][] customers) {
        int n = customers.length;
        double time_waiting = customers[0][1];
        int finished_prev = customers[0][0] + customers[0][1];

        for (int customer_ind = 1; customer_ind < n; ++customer_ind) {
            int[] times = customers[customer_ind];
            int arrive = times[0];

            int start_cook = Math.max(arrive, finished_prev);
            int end_time = start_cook + times[1];
            finished_prev = end_time;
            time_waiting += end_time - arrive;
        }

        return time_waiting / n;
    }
}
