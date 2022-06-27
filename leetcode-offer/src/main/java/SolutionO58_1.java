import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SolutionO58_1 {
    public String reverseWords(String s) {
        List<String> list = Arrays.stream(s.trim().split(" "))
                .filter(s1 -> s1.length() != 0)
                .collect(Collectors.toList());
        Collections.reverse(list);
        return String.join(" ", list);
    }
}
/*
剑指 Offer 58 - I. 翻转单词顺序
https://leetcode.cn/problems/fan-zhuan-dan-ci-shun-xu-lcof/

输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。
例如输入字符串"I am a student. "，则输出"student. a am I"。

输入: "the sky is blue"
输出: "blue is sky the"

同: 151. 翻转字符串里的单词
https://leetcode.cn/problems/reverse-words-in-a-string/
 */