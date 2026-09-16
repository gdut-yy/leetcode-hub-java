import java.util.Arrays;
import java.util.List;

public class Solution3995 {
    public int minCost(String source, String target, List<List<String>> rules, int[] costs) {
        int n = source.length();
        if (n != target.length()) {
            return -1;
        }
        int k = rules.size();
        String[] pats = new String[k];
        String[] reps = new String[k];
        int[] cost = new int[k];
        for (int i = 0; i < k; i++) {
            pats[i] = rules.get(i).get(0);
            reps[i] = rules.get(i).get(1);
            int stars = 0;
            for (int j = 0; j < pats[i].length(); j++) {
                if (pats[i].charAt(j) == '*') {
                    stars++;
                }
            }
            cost[i] = costs[i] + stars;
        }
        final int INF = Integer.MAX_VALUE / 2;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        char[] s = source.toCharArray();
        char[] t = target.toCharArray();
        for (int i = 0; i < n; i++) {
            if (dp[i] >= INF) {
                continue;
            }
            if (s[i] == t[i]) {
                dp[i + 1] = Math.min(dp[i + 1], dp[i]);
            }
            for (int r = 0; r < k; r++) {
                int m = pats[r].length();
                if (i + m > n || dp[i] + cost[r] >= dp[i + m]) {
                    continue;
                }
                String p = pats[r], rep = reps[r];
                boolean ok = true;
                for (int j = 0; j < m; j++) {
                    char pc = p.charAt(j);
                    if ((pc != '*' && pc != s[i + j]) || rep.charAt(j) != t[i + j]) {
                        ok = false;
                        break;
                    }
                }
                if (ok) {
                    dp[i + m] = dp[i] + cost[r];
                }
            }
        }
        return dp[n] >= INF ? -1 : dp[n];
    }
}
/*
3995. 转换字符串的最小成本 III
https://leetcode.cn/problems/minimum-cost-to-convert-string-iii/description/

第 187 场双周赛 T4。

给你两个字符串 source 和 target。
同时给你一个二维字符串数组 rules，其中 rules[i] = [patterni, replacementi]，以及一个整数数组 costs，其中 costs[i] 是应用 rules[i] 的基本成本。两个数组长度相同。此外，patterni 和 replacementi 的长度也相同。
你可以 任意 次数地应用 任意 规则。每次应用规则 rule[i] 的过程如下：
- 选择当前字符串的一个下标 l，使得从 l 到 l + patterni.length - 1 的位置范围存在于当前字符串中，并且这些位置中 没有 任何一个在之前的规则应用中被使用过。
- 对于 patterni 每个下标 j，字符 patterni[j] 必须 等于 当前字符串位置 l + j 处的字符，或者是 '*'。
- 将该范围内的字符替换为 replacementi。替换内容将 完全 按照给定的使用，且不包含通配符。
- 这次规则应用的成本是 costs[i] 加上 patterni 中 '*' 字符的数量。
- 一旦某个字符位置在某次规则应用中被使用，它就 不能 在 后续 的任何规则应用中被再次使用。
因为每个 patterni 和 replacementi 的长度都相同，所以在每次规则应用之后，字符的位置都会保留。
返回将 source 转换为 target 所需的 最小 总成本。如果无法完成转换，则返回 -1。
提示：
1 <= source.length, target.length <= 5000
source 和 target 仅由小写英文字母组成。
1 <= rules.length == costs.length <= 200
rules[i] = [patterni, replacementi]
1 <= patterni.length == replacementi.length <= 20
patterni 至少包含一个小写英文字母，且最多包含 5 个 '*' 字符。
replacementi 仅包含小写英文字母。
1 <= costs[i] <= 1000

动态规划 + 暴力枚举。
 */