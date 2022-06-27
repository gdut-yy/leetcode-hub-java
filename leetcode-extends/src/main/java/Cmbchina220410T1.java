public class Cmbchina220410T1 {
    public String deleteText(String article, int index) {
        if (article.charAt(index) == ' ') {
            return article;
        }
        String[] words = article.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        int from = 0;
        int to = 0;
        for (String word : words) {
            to = from + word.length();
            if (index >= from && index < to) {
            } else {
                stringBuilder.append(word).append(" ");
            }
            from = to + 1;
        }
        return stringBuilder.length() == 0 ? "" : stringBuilder.substring(0, stringBuilder.length() - 1);
    }
}
/*
招商银行-01. 文本编辑程序设计
https://leetcode.cn/contest/cmbchina-2022spring/problems/fWcPGC/

请你设计一个文本编辑程序，需要编辑的稿件 article 为仅由大写字母、小写字母与空格组成的字符串（下标从 0 开始），
光标所在字符串下标位置记作 index，程序运行后，若光标停留位置为空格，不作操作，返回原文本；否则光标所在位置对应的整个单词将被删除，并返回编辑后经过整理空格的文本。
注意：
- 输入保证字符串不以空格开头和结尾且不包含连续的空格。
- 返回的字符串不以空格开头和结尾且不包含连续的空格。若删除单词后有多余的空格，需要删除。
提示：
1 <= article.length <= 10^5
0 <= index < article.length
article[i] 仅包含大写字母、小写字母与空格
 */