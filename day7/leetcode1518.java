package day7;

public class leetcode1518 {
    // There are numBottles water bottles that are initially full of water. You can exchange numExchange empty water bottles from the market with one full water bottle.

    // The operation of drinking a full water bottle turns it into an empty bottle.

    // Given the two integers numBottles and numExchange, return the maximum number of water bottles you can drink.

    public int numWaterBottles(int numBottles, int numExchange) {
        if (numBottles < numExchange) return numBottles;

        // int fullBottle = numBottles;
        // int emptyBottle = 0;
        // int result = 0;
        // while (fullBottle != 0) {
        //     result = result + fullBottle;
        //     emptyBottle = emptyBottle + fullBottle;
            
        //     fullBottle = emptyBottle / numExchange;
        //     emptyBottle = emptyBottle - fullBottle*numExchange;
        // }
        // // result += 1;
        // return result;
        return numBottles + (numBottles-1) / (numExchange-1);
    }
}
