package algorithm;

import java.util.HashMap;

class LongestSubstringWithoutDup {

    public int longestSubsingWithoutDuplication(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int left = -1;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (hashMap.containsKey(s.charAt(i))) {
                left = Math.max(left, hashMap.get(s.charAt(i))); // 数字重复之后，重新开始计算
            }
            hashMap.put(s.charAt(i), i);
            res = Math.max(res, i - left);
        }
        return res;
    }
}

public class Solution {

    public static void main(String[] args) {
        LongestSubstringWithoutDup sub = new LongestSubstringWithoutDup();
        String str = "arabcacfr";
        int res = sub.longestSubsingWithoutDuplication(str);
        System.out.println("最长不含重复字符串的子字符串长度:" + res);
    }
}
