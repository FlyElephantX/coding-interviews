package algorithm;

class StringPathInMatrix {

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if(matrix == null || rows < 1 || cols < 1 || str == null){
            return false;
        }
        int[] visted = new int[matrix.length];
        for(int i = 0;i < matrix.length; i++){
            visted[i] = 0;
        }
        for(int i = 0;i < rows; i++) {
            for(int j = 0;j < cols; j++) {
                if(findPath(matrix, rows, cols, i, j, str,0, visted)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean findPath(char[] matrix, int rows, int cols, int row, int col, char[] str, int index, int[] visted){
        if(index == str.length) {
            return true;
        }
        boolean hasPath = false;
        if(row >= 0 && row < rows && col >= 0 && col < cols && matrix[row*cols+col] == str[index] && visted[row*cols+col] == 0) {
            index++;
            visted[row*cols+col] = 1;
            // 上下左右 只要有一条路走通即算成功
            hasPath = findPath(matrix, rows, cols,row-1, col, str, index, visted) ||
                    findPath(matrix, rows, cols,row+1, col, str, index, visted) ||
                    findPath(matrix, rows, cols, row,col-1, str, index, visted) ||
                    findPath(matrix, rows, cols, row,col+1, str, index, visted);

            if(!hasPath) {
                index--;
                visted[row*cols+col] = 0;
            }
        }
        return hasPath;
    }
}

public class Solution {

    public static void main(String[] args) {
        StringPathInMatrix path = new StringPathInMatrix();
        char[] martix = {'a','b','t','g','c','f','c','s','j','d','e','h'};
        char[] str = {'b','f','c','e'};
        boolean res = path.hasPath(martix, 3, 4, str);
        if (res) {
            System.out.println("存在路径");
        } else {
            System.out.println("不存在路径");
        }
    }

}
