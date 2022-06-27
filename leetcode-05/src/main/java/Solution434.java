public class Solution434 {
    public int countSegments(String s) {
        String[] strings = s.split(" ");
        int cnt = 0;
        for (String string : strings) {
            if (string != null && string.length() != 0) {
                cnt++;
            }
        }
        return cnt;
    }
}
/*
434. 字符串中的单词数
https://leetcode.cn/problems/number-of-segments-in-a-string/

统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
请注意，你可以假定字符串里不包括任何不可打印的字符。
 */