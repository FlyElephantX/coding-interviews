package algorithm;

import java.util.ArrayList;
import java.util.List;

class LastNumberInCircle {

    public int lastRemaining(int n, int step) {
        if (n < 0 || step < 1) {
            return -1;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int current = 0;
        while (list.size() > 1) {
            for (int i = 0; i < step - 1; i++) {
                current++;
                if (current == list.size()) {
                    current = 0;
                }
            }
            list.remove(current);
            if (current >= list.size()) {
                current = 0;
            }
        }
        return list.get(0);
    }

    public int lastRemaining1(int n, int m) {
        // 存活的最后一个人的位置
        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }
        return last;
    }

}

public class Solution {

    public static void main(String[] args) {
        LastNumberInCircle circle = new LastNumberInCircle();
        int res1 = circle.lastRemaining(5, 3);
        System.out.println("圆圈中最后的数字:" + res1);
        int res2 = circle.lastRemaining(5, 3);
        System.out.println("圆圈中最后的数字:" + res2);
    }
}
