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
}

public class Solution {

    public static void main(String[] args) {
        MaxValueOfGifts gift = new MaxValueOfGifts();
        int[][] values = {{1, 10, 3, 8}, {12, 2, 9, 6}, {5, 7, 4, 11}, {3, 7, 16, 5}};
        int max = gift.maxValueOfGifts(values);
        System.out.println("最大值:" + max);
    }
}
