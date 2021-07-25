public class Solution1869 {
    public boolean checkZeroOnes(String s) {
        int maxOne = maxNum(s, "0");
        int maxZero = maxNum(s, "1");
        return maxOne > maxZero;
    }

    private int maxNum(String s, String split) {
        String[] nums = s.split(split);
        int cnt = 0;
        for (String num : nums) {
            if (num.length() > cnt) {
                cnt = num.length();
            }
        }
        return cnt;
    }
}
/*
1869. 哪种连续子字符串更长
https://leetcode-cn.com/problems/longer-contiguous-segments-of-ones-than-zeros/submissions/

第 242 场周赛 T1。
String#split() 后统计最大值进行比较即可。
 */
