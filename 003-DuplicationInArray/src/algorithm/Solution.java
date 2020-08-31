package algorithm;

class DuplicationInArray {

    public boolean duplicate(int[] numbers, int length, int[] duplication) {
        boolean[] map = new boolean[length];
        for (int i = 0; i < length; i++) {
            if (map[numbers[i]] == true) {
                duplication[0] = numbers[i];
                return true;
            }
            map[numbers[i]] = true;
        }
        return false;
    }


}

public class Solution {

    public static void main(String[] args) {
        DuplicationInArray arr = new DuplicationInArray();
        int[] data = {2,3,1,0,2,5,3};
        int[] duplication = new int[data.length];
        boolean res = arr.duplicate(data, 7, duplication);
        System.out.println("重复结果:" + res);
    }
}
