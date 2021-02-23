package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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


    public boolean isExist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        if (chars.length == 0) {
            return false;
        }
        int rows = board.length;
        if (rows == 0) {
            return false;
        }
        int cols = board[0].length;
        if (rows * cols < chars.length) {
            return false;
        }
        char begin = chars[0];
        List<List<Integer>> paths = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == begin) {
                    List<Integer> path = new ArrayList<>();
                    path.add(i);
                    path.add(j);
                    paths.add(path);
                }
            }
        }
        if (paths.size() == 0) {
            return false;
        }
        for (int i = 0; i < paths.size(); i++) {
            List<Integer> path = paths.get(i);
            boolean res = isContains(board, chars, path.get(0), path.get(1));
            if (res == true) {
                return true;
            }
        }
        return false;
    }

    public boolean isContains(char[][] board, char[] chars, int row, int col) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(row, col);
        for (int i = 1; i < chars.length; i++) {
            int[] res = isExist(board, row, col, chars[i]);
            int num = res[0];
            if (num == -1) {
                return false;
            }
            if (hashMap.containsKey(num) && hashMap.get(num) == res[1]) {
                return false;
            }
            row = num;
            col = res[1];
            hashMap.put(row, col);
        }
        return true;
    }

    public int[] isExist(char[][] board, int row, int col, char target) {
        int[] pos = {-1, - 1};
        int rows = board.length;
        if (rows == 0) {
            return pos;
        }
        int cols = board[0].length;
        // 左字符
        if (col - 1 >= 0 && board[row][col - 1] == target) {
            return new int[]{row, col - 1};
        }
        // 右字符
        if (col + 1 < cols && board[row][col + 1] == target) {
            return new int[]{row, col + 1};
        }
        // 上字符
        if (row - 1 >= 0 && board[row - 1][col] == target) {
            return new int[]{row - 1, col};
        }
        // 下字符
        if (row + 1 < rows && board[row + 1][col] == target) {
            return new int[]{row + 1, col};
        }
        return pos;
    }


    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(dfs(board, words, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) return false;
        if(k == word.length - 1) return true;
        board[i][j] = '\0';
        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) ||
                dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i , j - 1, k + 1);
        board[i][j] = word[k];
        return res;
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
        char[][] martix1 = {{'A', 'B', 'C', 'E'},{'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String str1 = "ABCCED";
        char[][] martix2 = {{'a', 'b'}, {'c', 'd'}};
        String str2 = "abcd";
        char[][] martix3 = {{'a', 'a'}};
        String str3 = "aaa";
        char[][] martix4 = {{'C', 'A', 'A'}, {'A', 'A', 'A'}, {'B', 'C', 'D'}};
        String str4 = "AAB";
        char[][] martix5 = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String str5 = "SEE";
        boolean isExist = path.exist(martix5, str5);
        if (isExist) {
            System.out.println("存在路径");
        } else {
            System.out.println("不存在路径");
        }
    }

}
