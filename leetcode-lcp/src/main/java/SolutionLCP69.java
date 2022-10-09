import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionLCP69 {
    private static final int INF = Integer.MAX_VALUE / 2;
    // 0b11111011100，每个字母都选到了对应的上限
    private static final int FULL = 2012;

    private enum RULES {
        // print(Counter('helloleetcode'))
        // stdout:Counter({'e': 4, 'l': 3, 'o': 2, 'h': 1, 't': 1, 'c': 1, 'd': 1})
        E('e', 0, 4, 7),
        L('l', 3, 3, 3),
        O('o', 5, 2, 3),
        H('h', 7, 1, 1),
        T('t', 8, 1, 1),
        C('c', 9, 1, 1),
        D('d', 10, 1, 1),
        ;

        // 字符
        private final char ch;
        // 字母在二进制上的起始位置
        private final int pos;
        // 这个字母能选择的上限
        private final int limit;
        // 位掩码
        private final int m;

        RULES(char ch, int pos, int limit, int m) {
            this.ch = ch;
            this.pos = pos;
            this.limit = limit;
            this.m = m;
        }
    }

    private int n;
    private List<Map<Integer, Integer>> costs;
    private int[][] memo;

    public int Leetcode(String[] words) {
        this.n = words.length;

        // 预处理每个单词的每种选择字母的方案所消耗的代币的最小值
        this.costs = new ArrayList<>();
        for (String word : words) {
            Map<Integer, Integer> costMap = new HashMap<>();
            dfs(word, 0, 0, costMap);
            costs.add(costMap);
        }

        // 记忆化搜索
        memo = new int[n][1 << 11];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        int res = dfs2(0, 0);
        return res == INF ? -1 : res;
    }

    private int dfs2(int i, int mask) {
        if (i == n) {
            // inf 表示不合法，没有选完要求的字母
            return (mask == FULL) ? 0 : INF;
        }
        if (memo[i][mask] != -1) {
            return memo[i][mask];
        }
        int res = INF;
        for (Map.Entry<Integer, Integer> entry : costs.get(i).entrySet()) {
            int add = entry.getKey();
            int tot = entry.getValue();
            // 剪枝
            if (tot >= res) {
                continue;
            }
            int m = merge(mask, add);
            if (m >= 0) {
                res = Math.min(res, tot + dfs2(i + 1, m));
            }
        }
        if (memo[i][mask] == -1) {
            memo[i][mask] = res;
        }
        return res;
    }

    private void dfs(String str, int mask, int tot, Map<Integer, Integer> costMap) {
        if (!costMap.containsKey(mask) || costMap.get(mask) > tot) {
            costMap.put(mask, tot);
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String nextStr = str.substring(0, i) + str.substring(i + 1);
            int nextTot = tot + i * (str.length() - 1 - i);
            for (RULES tuple : RULES.values()) {
                // 可以选 ch
                if (ch == tuple.ch && ((mask >> tuple.pos) & tuple.m) < tuple.limit) {
                    dfs(nextStr, mask + (1 << tuple.pos), nextTot, costMap);
                    break;
                }
            }
        }
    }

    // 合并两种选择字母的方案
    private int merge(int cur, int add) {
        for (RULES tuple : RULES.values()) {
            int c1 = (cur >> tuple.pos) & tuple.m;
            int c2 = (add >> tuple.pos) & tuple.m;
            if (c1 + c2 > tuple.limit) {
                return -1;
            }
            cur += (c2 << tuple.pos);
        }
        return cur;
    }
}
/*
LCP 69. Hello LeetCode!
https://leetcode.cn/problems/rMeRt2/

LCCUP'22 力扣杯秋季编程大赛战队赛 T4。

力扣嘉年华同样准备了纪念品展位，参观者只需要集齐 helloleetcode 的 13 张字母卡片即可获得力扣纪念章。
在展位上有一些由字母卡片拼成的单词，words[i][j] 表示第 i 个单词的第 j 个字母。
你可以从这些单词中取出一些卡片，但每次拿取卡片都需要消耗游戏代币，规则如下：
- 从一个单词中取一个字母所需要的代币数量，为该字母左边和右边字母数量之积
- 可以从一个单词中多次取字母，每个字母仅可被取一次
例如：从 example 中取出字母 a，需要消耗代币 2*4=8，字母取出后单词变为 exmple；
再从中取出字母 m，需要消耗代币 2*3=6，字母取出后单词变为 exple；
请返回取得 helloleetcode 这些字母需要消耗代币的 最少 数量。如果无法取得，返回 -1。
注意：
- 取出字母的顺序没有要求
- 取出的所有字母恰好可以拼成 helloleetcode
提示：
n == words.length
m == words[i].length
1 <= n <= 24
1 <= m <= 8
words[i][j] 仅为小写字母

状态压缩 DP
 */