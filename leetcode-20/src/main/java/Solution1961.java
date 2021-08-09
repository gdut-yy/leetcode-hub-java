public class Solution1961 {
    public boolean isPrefixString(String s, String[] words) {
        int i = 0;
        int sLen = s.length();
        for (String word : words) {
            int len = word.length();
            // 防止越界
            int curLen = i + len;
            if (curLen <= sLen && s.substring(i, curLen).equals(word)) {
                i = curLen;
                // 完全匹配时结束
                if (i == sLen) {
                    return true;
                }
            } else {
                return false;
            }
        }
        return false;
    }
}
/*
1961. 检查字符串是否为数组前缀
https://leetcode-cn.com/problems/check-if-string-is-a-prefix-of-array/

第 253 场周赛 T1。
根据题意进行模拟。只有长度刚好相等时才是前缀字符串。小于或者大于都返回 false。
 */