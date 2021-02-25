package algorithm;

class MaxValueOfGifts {

    public int maxValueOfGifts(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        int[][] maxValues = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int top = 0;
                int left = 0;
                if (i > 0) {
                    top = maxValues[i - 1][j];
                }
                if (j > 0) {
                    left = maxValues[i][j - 1];
                }
                maxValues[i][j] = Math.max(top, left) + grid[i][j];
            }
        }
        return maxValues[rows - 1][columns - 1];

    }

    public int maxValue(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        //dp[i][j]表示从grid[0][0]到grid[i - 1][j - 1]时的最大价值
        int[][] dp = new int[row + 1][column + 1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
            }
        }
        return dp[row][column];
    }
}

public class Solution {

    public static void main(String[] args) {
        MaxValueOfGifts gift = new MaxValueOfGifts();
        int[][] values = {{1, 10, 3, 8}, {12, 2, 9, 6}, {5, 7, 4, 11}, {3, 7, 16, 5}};
        int max = gift.maxValueOfGifts(values);
        System.out.println("最大值:" + max);
        int max1 = gift.maxValue(values);
        System.out.println("最大值:" + max1);
    }
}
