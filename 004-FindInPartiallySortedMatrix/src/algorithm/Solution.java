package algorithm;

class FindInPartiallySortedMatrix {

    public boolean Find(int target, int[][] array) {
        int row = array.length;
        int column = array[0].length;
        int i = 0;
        int j = column - 1;
        while (i < row && j >=0) {
            int val = array[i][j];
            if (target > val) {
                i++;
            } else if (target < val) {
                j--;
            } else {
                return true;
            }

        }
        return false;
    }
}

public class Solution {

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}};
        FindInPartiallySortedMatrix sort = new FindInPartiallySortedMatrix();
        boolean res =  sort.Find(100, arr);
        System.out.println("查找结果:" + res);
    }
}
