import java.util.Set;

public class Solution246 {
    public boolean isStrobogrammatic(String num) {
        int left = 0;
        int right = num.length() - 1;
        // 无法组成中心对称数的数字
        Set<Integer> hashSet = Set.of(2, 3, 4, 5, 7);
        while (left <= right) {
            int leftNum = num.charAt(left) - '0';
            int rightNum = num.charAt(right) - '0';
            if (hashSet.contains(leftNum) || hashSet.contains(rightNum)) {
                return false;
            }
            if (leftNum == 0 && rightNum != 0) {
                return false;
            }
            if (leftNum == 1 && rightNum != 1) {
                return false;
            }
            if (leftNum == 8 && rightNum != 8) {
                return false;
            }
            if ((leftNum == 6 && rightNum != 9) || (leftNum == 9 && rightNum != 6)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
/*
$246. 中心对称数
https://leetcode.cn/problems/strobogrammatic-number/

中心对称数是指一个数字在旋转了 180 度之后看起来依旧相同的数字（或者上下颠倒地看）。
请写一个函数来判断该数字是否是中心对称数，其输入将会以一个字符串的形式来表达数字。
 */