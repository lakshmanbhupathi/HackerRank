package com.lakshman.basicPrograms;

/**
 * Imagine you are playing a board game. You roll a 6-faced dice and move forward the same number of spaces that you rolled.
 * If the finishing point is “n” spaces away from the starting point,
 * please implement a program that calculates how many possible ways there are to arrive exactly at the finishing point.
 *
 *
 * LINE April'18
 */
public class DicePermutations {

    /**
     * not right XXXXX
     *
     * @param numDice
     * @param sum
     * @return
     */
    public static int numPossibilities(int numDice, int sum) {
        if (numDice == sum)
            return 1;
        else if (numDice == 0 || sum < numDice)
            return 0;
        else
            return numPossibilities(numDice, sum - 1) +
                    numPossibilities(numDice - 1, sum - 1) -
                    numPossibilities(numDice - 1, sum - 7);
    }

    public static void main(String[] args) {
        System.out.println(numPossibilities(new int[]{1, 2, 3, 4, 5, 6}, 610));
        System.out.println(numPossibilities(6,8));
    }

    /**
     *
     * @see <a href="https://gist.github.com/ccuhospital/41be69f5a1f0c3d6e0ed86dbb81c17a6">github</a>
     * @param coins
     * @param finish
     * @return
     */
    public static int numPossibilities(int coins[], int finish) {
        int[][] cache = new int[coins.length + 1][finish + 1];

        for (int i = 0; i <= coins.length; ++i) {
            cache[i][0] = 1;
        }

        for (int i = 1; i <= coins.length; ++i) {
            for (int j = 1; j <= finish; ++j) {
                cache[i][j] = 0;
                for (int k = 0; k <= j / coins[i - 1]; ++k) {
                    cache[i][j] += cache[i - 1][j - k * coins[i - 1]];
                }
            }
        }

        return cache[coins.length][finish];
    }
}
