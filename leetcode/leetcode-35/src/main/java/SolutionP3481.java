import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionP3481 {
    private Map<Character, String> replace;
    private Map<String, String> memo;

    public String applySubstitutions(List<List<String>> replacements, String text) {
        replace = new HashMap<>();
        for (List<String> re : replacements) {
            replace.put(re.get(0).charAt(0), re.get(1));
        }
        memo = new HashMap<>();
        return dfs(text);
    }

    private String dfs(String s) {
        if (memo.containsKey(s)) return memo.get(s);
        StringBuilder sb = new StringBuilder();
        int i = 0, n = s.length();
        while (i < n) {
            if (s.charAt(i) != '%') {
                sb.append(s.charAt(i));
                i += 1;
            } else {
                sb.append(dfs(replace.get(s.charAt(i + 1))));
                i += 3;
            }
        }
        String res = sb.toString();
        memo.put(s, res);
        return res;
    }
}
/*
$3481. 应用替换
https://leetcode.cn/problems/apply-substitutions/description/

给定一个 replacements 映射和一个可能包含格式为 %var% 占位符 的字符串 text，其中每个 var 对应 replacements 中的一个键。每个替换值本身可能包含 一个或多个 此类占位符。每个 占位符 都被与其相应的替换键对应的值替换。
返回完全替换后 不 含任何 占位符 的 text 字符串。
提示：
1 <= replacements.length <= 10
replacements 中的每个元素是一个双值列表 [key, value]，其中：
  key 是一个大写英语字母。
  value 是一个最多有 8 个字符，可能包含 0 个或更多格式为 %<key>% 的占位符的非空字符串。
所有的替换键互不相同。
text 字符串是通过从替换映射中随机串联所有 key 占位符（格式为 %<key>%）而形成的，以虚线分隔。
text.length == 4 * replacements.length - 1
text 或任何替换值中的每个占位符对应 replacements 映射中的一个键。
替换键之间没有循环依赖。

记忆化搜索。
https://leetcode.cn/problems/apply-substitutions/solutions/3680990/ji-yi-hua-sou-suo-by-endlesscheng-kn4j/
时间复杂度：O(L * 2^n)。其中 L <= 8。
 */