import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SolutionLCR181 {
    public String reverseMessage(String message) {
        List<String> list = Arrays.stream(message.trim().split(" "))
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList());
        Collections.reverse(list);
        return String.join(" ", list);
    }
}
/*
LCR 181. 字符串中的单词反转
https://leetcode.cn/problems/fan-zhuan-dan-ci-shun-xu-lcof/

你在与一位习惯从右往左阅读的朋友发消息，他发出的文字顺序都与正常相反但单词内容正确，为了和他顺利交流你决定写一个转换程序，把他所发的消息 message 转换为正常语序。
注意：输入字符串 message 中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
提示：
0 <= message.length <= 104
message 中包含英文大小写字母、空格和数字
message 中至少有一个单词

同: 151. 翻转字符串里的单词
https://leetcode.cn/problems/reverse-words-in-a-string/
 */