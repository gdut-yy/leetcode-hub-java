public class Solution392 {
    public boolean isSubsequence(String s, String t) {
        int curIndex = -1;
        for (char ch : s.toCharArray()) {
            curIndex = t.indexOf(ch, curIndex + 1);
            if (curIndex == -1) {
                return false;
            }
        }
        return true;
    }
}
/*
392. 判断子序列
https://leetcode-cn.com/problems/is-subsequence/

双指针，判断 s 是否为 t 的子序列。
s 逐个字符，若能在 t 中按顺序找到，即满足要求。
 */
