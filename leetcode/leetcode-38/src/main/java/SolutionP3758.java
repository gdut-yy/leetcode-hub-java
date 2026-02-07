public class SolutionP3758 {
    private static final String[] WORDS = {
            "zero", "one", "two", "three", "four",
            "five", "six", "seven", "eight", "nine"
    };

    public String convertNumber(String s) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < WORDS.length; j++) {
                String w = WORDS[j];
                int r = i + w.length();
                if (r <= s.length() && s.substring(i, r).equals(w)) {
                    ans.append((char) ('0' + j));
                    i = r - 1;
                    break;
                }
            }
        }
        return ans.toString();
    }
}
/*
$3758. 将数字词转换为数字
https://leetcode.cn/problems/convert-number-words-to-digits/description/

给定一个由小写英文字母组成的字符串 s。s 可能包含表示数字 0 到 9 的 有效连续 英文单词，没有空格。
你的任务是 按顺序 提取 每个 有效的数字词，并将其转换为相应的数字，生成一个数字字符串。
从左往右解析 s。在每个位置：
- 如果当前位置有一个有效的数字单词，将其对应的数字添加到结果中，并将位置向前移动该单词的长度。
- 否则，跳过 恰好 一个字符，继续解析。
返回结果数字字符串。如果没有找到数字单词，返回空字符串。
提示：
1 <= s.length <= 10^5
s 只包含小写英文字母。

暴力枚举。
https://leetcode.cn/problems/convert-number-words-to-digits/solutions/3840487/bao-li-mei-ju-by-endlesscheng-izem/
更通用的做法是字典树或者 AC 自动机。
 */