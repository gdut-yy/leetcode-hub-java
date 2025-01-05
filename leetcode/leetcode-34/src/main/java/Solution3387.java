import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution3387 {
    private record Node(String to, double rate) {
    }

    private String initialCurrency;
    private Map<String, List<Node>> g;
    private double ans;

    public double maxAmount(String initialCurrency, List<List<String>> pairs1, double[] rates1, List<List<String>> pairs2, double[] rates2) {
        this.initialCurrency = initialCurrency;
        g = new HashMap<>();
        buildGraph(pairs1, rates1, "");
        for (String s : g.keySet()) {
            g.computeIfAbsent(s, e -> new ArrayList<>()).add(new Node(s + "2", 1.0));
        }
        buildGraph(pairs2, rates2, "2");

        ans = 1.0;
        dfs(initialCurrency, "", 1.0);
        return ans;
    }

    private void dfs(String x, String fa, double curAmount) {
        if (x.equals(initialCurrency + "2")) {
            ans = Math.max(ans, curAmount);
            return;
        }
        for (Node p : g.getOrDefault(x, new ArrayList<>())) {
            if (!p.to.equals(fa)) {
                dfs(p.to, x, curAmount * p.rate);
            }
        }
    }

    private void buildGraph(List<List<String>> pairs, double[] rates, String suffix) {
        for (int i = 0; i < pairs.size(); i++) {
            List<String> pair = pairs.get(i);
            String x = pair.get(0) + suffix;
            String y = pair.get(1) + suffix;
            double rate = rates[i];
            g.computeIfAbsent(x, e -> new ArrayList<>()).add(new Node(y, rate));
            g.computeIfAbsent(y, e -> new ArrayList<>()).add(new Node(x, 1.0 / rate));
        }
    }
}
/*
3387. 两天自由外汇交易后的最大货币数
https://leetcode.cn/problems/maximize-amount-after-two-days-of-conversions/description/

第 428 场周赛 T2。

给你一个字符串 initialCurrency，表示初始货币类型，并且你一开始拥有 1.0 单位的 initialCurrency。
另给你四个数组，分别表示货币对（字符串）和汇率（实数）：
- pairs1[i] = [startCurrencyi, targetCurrencyi] 表示在 第 1 天，可以按照汇率 rates1[i] 将 startCurrencyi 转换为 targetCurrencyi。
- pairs2[i] = [startCurrencyi, targetCurrencyi] 表示在 第 2 天，可以按照汇率 rates2[i] 将 startCurrencyi 转换为 targetCurrencyi。
- 此外，每种 targetCurrency 都可以以汇率 1 / rate 转换回对应的 startCurrency。
你可以在 第 1 天 使用 rates1 进行任意次数的兑换（包括 0 次），然后在 第 2 天 使用 rates2 再进行任意次数的兑换（包括 0 次）。
返回在两天兑换后，最大可能拥有的 initialCurrency 的数量。
注意：汇率是有效的，并且第 1 天和第 2 天的汇率之间相互独立，不会产生矛盾。
提示：
1 <= initialCurrency.length <= 3
initialCurrency 仅由大写英文字母组成。
1 <= n == pairs1.length <= 10
1 <= m == pairs2.length <= 10
pairs1[i] == [startCurrencyi, targetCurrencyi]
pairs2[i] == [startCurrencyi, targetCurrencyi]
1 <= startCurrencyi.length, targetCurrencyi.length <= 3
startCurrencyi 和 targetCurrencyi 仅由大写英文字母组成。
rates1.length == n
rates2.length == m
1.0 <= rates1[i], rates2[i] <= 10.0
输入保证两个转换图在各自的天数中没有矛盾或循环。
输入保证输出 最大 为 5 * 10^10。

只构建一张图，可以更容易扩展到层数 > 2 的场景。
 */