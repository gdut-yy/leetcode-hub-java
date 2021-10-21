import java.util.HashMap;
import java.util.Map;

public class SolutionO50 {
    public char firstUniqChar(String s) {
        Map<Character, Integer> cntMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            cntMap.put(ch, cntMap.getOrDefault(ch, 0) + 1);
        }
        for (char ch : s.toCharArray()) {
            if (cntMap.getOrDefault(ch, 0) == 1) {
                return ch;
            }
        }
        return ' ';
    }
}
/*
剑指 Offer 50. 第一个只出现一次的字符
https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/

在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。

输入：s = "abaccdeff"
输出：'b'

两次遍历。第一次遍历统计频次，第二次遍历获取第一个频次为 1 的字符。
 */