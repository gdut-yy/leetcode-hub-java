public class Solution1528 {
    public String restoreString(String s, int[] indices) {
        int len = s.length();
        char[] resArr = new char[len];
        for (int i = 0; i < len; i++) {
            resArr[indices[i]] = s.charAt(i);
        }
        return new String(resArr);
    }
}
/*
1528. 重新排列字符串
https://leetcode-cn.com/problems/shuffle-string/

给你一个字符串 s 和一个 长度相同 的整数数组 indices 。
请你重新排列字符串 s ，其中第 i 个字符需要移动到 indices[i] 指示的位置。
返回重新排列后的字符串。

模拟。
 */