public class Solution2000 {
    public String reversePrefix(String word, char ch) {
        int idx = word.indexOf(ch);
        String subString1 = word.substring(0, idx + 1);
        String subString2 = word.substring(idx + 1);
        String reverseSubString = new StringBuilder(subString1).reverse().toString();
        return reverseSubString + subString2;
    }
}
/*
2000. 反转单词前缀
https://leetcode-cn.com/problems/reverse-prefix-of-word/

第 258 场周赛 T1。
 */