import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionLCP80 {
    private Map<Integer, List<Integer>> g;

    public String evolutionaryRecord(int[] parents) {
        int n = parents.length;
        g = new HashMap<>();
        for (int i = 1; i < n; i++) {
            g.computeIfAbsent(parents[i], key -> new ArrayList<>()).add(i);
        }
        // 去掉第一个 0 和末尾连续的 1
        return dfs(0).substring(1).replaceAll("1+$", "");
    }

    private String dfs(int x) {
        List<String> a = new ArrayList<>();
        for (int y : g.getOrDefault(x, new ArrayList<>())) {
            a.add(dfs(y));
        }
        Collections.sort(a);
        return "0" + String.join("", a) + "1";
    }
}
/*
LCP 80. 生物进化录
https://leetcode.cn/problems/qoQAMX/

LCCUP'23 春季战队赛 T4。

在永恒之森中，存在着一本生物进化录，以 一个树形结构 记载了所有生物的演化过程。经过观察并整理了各节点间的关系，parents[i] 表示编号 i 节点的父节点编号(根节点的父节点为 -1)。
为了探索和记录其中的演化规律，队伍中的炼金术师提出了一种方法，可以以字符串的形式将其复刻下来，规则如下：
- 初始只有一个根节点，表示演化的起点，依次记录 01 字符串中的字符，
- 如果记录 0，则在当前节点下添加一个子节点，并将指针指向新添加的子节点；
- 如果记录 1，则将指针回退到当前节点的父节点处。
现在需要应用上述的记录方法，复刻下它的演化过程。请返回能够复刻演化过程的字符串中， 字典序最小 的 01 字符串。
注意：
- 节点指针最终可以停在任何节点上，不一定要回到根节点。
提示：
1 <= parents.length <= 10^4
-1 <= parents[i] < i (即父节点编号小于子节点)

树形 DP + 排序
相似题目: 761. 特殊的二进制序列
https://leetcode.cn/problems/special-binary-string/
时间复杂度 O(n^2)
 */