import java.util.regex.Pattern;

public class Solution2047 {
    private static final Pattern PATTERN = Pattern.compile("^(([a-z]+[-]?[a-z]+)|([a-z]*))[!.,]?$");

    public int countValidWords(String sentence) {
        int cnt = 0;
        String[] tokens = sentence.split(" ");
        for (String token : tokens) {
            if (PATTERN.matcher(token).matches() && token.length() != 0) {
                cnt++;
            }
        }
        return cnt;
    }
}
/*
2047. 句子中的有效单词数
https://leetcode-cn.com/problems/number-of-valid-words-in-a-sentence/

第 264 场周赛 T1。
状态机感觉比赛是写不出来的，手撸 if-else 模拟容易漏，不如试试正则表达式？
 */