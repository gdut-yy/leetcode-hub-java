public class Solution1967 {
    public int numOfStrings(String[] patterns, String word) {
        int cnt = 0;
        for (String pattern : patterns) {
            if (word.contains(pattern)) {
                cnt++;
            }
        }
        return cnt;
    }
}
/*
1967. 作为子字符串出现在单词中的字符串数目
https://leetcode-cn.com/problems/number-of-strings-that-appear-as-substrings-in-word/

第 254 场周赛 T1。
统计 patterns 中有多少个字符串是 word 的子字符串。返回字符串数目。直接 String#contains() 即可
 */