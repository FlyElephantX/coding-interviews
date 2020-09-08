package algorithm;

import java.util.HashMap;

class FirstNotRepeatingChar {

    public char getFirstNotRepeatingChar(String s) {
        int[] nums = new int[s.length()];
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (hashMap.containsKey(s.charAt(i))) {
                int index = hashMap.get(s.charAt(i));
                nums[index] = nums[index] + 1;
            } else {
                hashMap.put(s.charAt(i), i);
                nums[i] = 1;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (nums[i] == 1) {
                return s.charAt(i);
            }
        }
        return '\0';
    }

    public char getFirstNotRepeatingChar1(String s) {
        int TABLE_SIZE = 256;
        int[] hashTable = new int[TABLE_SIZE];
        for (int i = 0; i < s.length(); i++) {
            hashTable[s.charAt(i)]++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (hashTable[s.charAt(i)] == 1) {
                return s.charAt(i);
            }
        }
        return '\0';
    }
}

public class Solution {

    public static void main(String[] args) {
        FirstNotRepeatingChar repeat = new FirstNotRepeatingChar();
        Character res = repeat.getFirstNotRepeatingChar1("abaccdef");
        System.out.println("第一次出现的字符:" + res);
    }
}
