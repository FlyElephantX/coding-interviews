package algorithm;

class TranslateNumbersToStrings {
    /**
     * 先看这里  先看这里  先看这里  先看这里
     * 看官方的例子
     * 输入: 12258
     * 输出: 5
     * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
     * 也就是数字搭配可以是一位，可以是两位（两位情况下要小于26），也就是0-25取值范围
     */
    public int translateNum(int num) {
//如果num小于10了，也就没有得拆分了，只有一种情况，例如数字 5 ，只有 f 这个字母表示
        if (num < 10) {
            return 1;
        }
        //大于10的情况，就要分情况讨论了
        int re = num % 100;
        if (re < 10) {
            //情况1.：128105 % 100 = 5，那么5这个数字和无法和0合体的。那么去掉他 （num / 10），继续下一轮递归
            return translateNum(num / 10);
        } else if (re < 26) {
            //情况2.：12810 % 100 = 10 ，可以分成两种情况进行讨论，就是1281 和 128 进行下一轮的递归，也就是对10这两位数选择，可以选择成为ba和k。两种情况
            return translateNum(num / 10) + translateNum(num / 100);
        } else {
            //情况.：128 % 100 = 28，这种情况比26大，因为题目要求是字母，28明显比z大了，所以不能像情况2哪样进行拆分成两个递归进行相加
            return translateNum(num / 10);
        }
    }

}

public class Solution {

    public static void main(String[] args) {
        TranslateNumbersToStrings nums = new TranslateNumbersToStrings();
        int count = nums.translateNum(12258);
        System.out.println("总数:" + count);
    }
}
