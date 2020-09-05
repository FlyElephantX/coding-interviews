package algorithm;

class PrintMatrix {

    public void printMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        int top = 0, left = 0, right = columns - 1, bottom = rows - 1;
        while (left <= right && top <= bottom) {
            for (int column = left; column <= right; column++) {
                System.out.print(" "+ matrix[top][column]);
            }
            System.out.println();
            for (int row = top + 1; row <= bottom; row++) {
                System.out.print(" " + matrix[row][right]);
            }
            System.out.println();
            if (left < right && top < bottom) {
                for (int column = right - 1; column > left; column--) {
                    System.out.print(" " + matrix[bottom][column]);
                }
                System.out.println();
                for (int row = bottom; row > top; row--) {
                    System.out.print(" " + matrix[row][left]);
                }
                System.out.println();
            }
            left++;
            right--;
            top++;
            bottom--;
        }
    }

}

public class Solution {

    public static void main(String[] args) {
        int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        PrintMatrix matrix = new PrintMatrix();
        matrix.printMatrix(arr);
    }
}
