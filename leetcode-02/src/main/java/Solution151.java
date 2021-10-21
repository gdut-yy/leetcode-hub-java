import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution151 {
    public String reverseWords(String s) {
        List<String> list = Arrays.stream(s.trim().split(" "))
                .filter(s1 -> s1.length() != 0)
                .collect(Collectors.toList());
        Collections.reverse(list);
        return String.join(" ", list);
    }
}
/*
151. 翻转字符串里的单词
https://leetcode-cn.com/problems/reverse-words-in-a-string/

给你一个字符串 s ，逐个翻转字符串中的所有 单词 。
单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
请你返回一个翻转 s 中单词顺序并用单个空格相连的字符串。
说明：

输入字符串 s 可以在前面、后面或者单词间包含多余的空格。
翻转后单词间应当仅用一个空格分隔。
翻转后的字符串中不应包含额外的空格。

同: 剑指 Offer 58 - I. 翻转单词顺序
https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/
 */