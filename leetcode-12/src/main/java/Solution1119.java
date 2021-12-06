public class Solution1119 {
    public String removeVowels(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!"aeiou".contains(String.valueOf(s.charAt(i)))) {
                stringBuilder.append(s.charAt(i));
            }
        }
        return stringBuilder.toString();
    }
}
/*
1119. 删去字符串中的元音
https://leetcode-cn.com/problems/remove-vowels-from-a-string/

第 4 场双周赛 T2。

给你一个字符串 S，请你删去其中的所有元音字母（ 'a'，'e'，'i'，'o'，'u'），并返回这个新字符串。

直接遍历。
 */