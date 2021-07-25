public class Solution1859 {
    public String sortSentence(String s) {
        String[] strings = s.split(" ");
        int len = strings.length;
        String[] ans = new String[len];
        for (String str : strings) {
            String word = str.substring(0, str.length() - 1);
            int order = Integer.parseInt(str.substring(str.length() - 1));
            ans[order - 1] = word;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < len - 1; i++) {
            stringBuilder.append(ans[i]).append(" ");
        }
        stringBuilder.append(ans[len - 1]);
        return stringBuilder.toString();
    }
}
/*
1859. 将句子排序
https://leetcode-cn.com/problems/sorting-the-sentence/

第 52 场双周赛 T1。
1 位整数（0-9），难度很低了，String#substring 分离字符串与数字，按序拼接即可。
 */
