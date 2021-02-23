package algorithm;

class RobotMove {

    public int movingCount(int threshold, int rows, int cols) {
        if (threshold < 0 || rows < 0 || cols < 0) {
            return 0;
        }
        boolean[] visited = new boolean[rows * cols];
        int count = movingCountCore(threshold, rows, cols, 0, 0, visited);
        return count;
    }

    private int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
        int count = 0;
        if (check(threshold, rows, cols, row, col, visited)) {
            visited[row * cols + col] = true;
            count = 1 + movingCountCore(threshold, rows, cols, row + 1, col, visited)
                    + movingCountCore(threshold, rows, cols, row - 1, col, visited)
                    + movingCountCore(threshold, rows, cols, row, col + 1, visited)
                    + movingCountCore(threshold, rows, cols, row, col - 1, visited);
        }
        return count;

    }

    private boolean check(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
        if (row >= 0 && row < rows && col >= 0 && col < cols && !visited[row * cols + col] && (getDigitSum(row) + getDigitSum(col) <= threshold)) {
            return true;
        }
        return false;
    }

    private int getDigitSum(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number = number / 10;
        }
        return sum;
    }

    boolean[][] visited;
    public int movingCount1(int m, int n, int k) {
        this.visited = new boolean[m][n];
        return dfs(m, n, k, 0, 0);
    }

    public int dfs(int m, int n, int k, int x, int y){
        // 递归终止条件
        if((get(x) + get(y) > k) || x < 0 || x >= m || y < 0 || y >= n || visited[x][y]){
            return 0;
        }
        // 将该格子标记为已经访问过
        visited[x][y] = true;
        // 继续搜索四个方向
        return 1 + dfs(m, n , k, x, y+1)
                + dfs(m, n , k, x, y-1)
                + dfs(m, n , k, x+1, y)
                + dfs(m, n , k, x, y-1);
    }


    private int get(int x) {
        int res = 0;
        while (x != 0) {
            res += x % 10;
            x /= 10;
        }
        return res;
    }

}

public class Solution {

    public static void main(String[] args) {
        RobotMove move = new RobotMove();
        int count = move.movingCount(10,3,3);
        System.out.println("格子总数:" + count);
        int count1 = move.movingCount1(10,3,3);
        System.out.println("格子总数:" + count1);
    }
}
