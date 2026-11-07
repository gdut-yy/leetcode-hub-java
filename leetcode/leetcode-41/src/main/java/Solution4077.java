import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution4077 {
    private static class Node {
        Node[] son = new Node[10];
        int pos = -1;
    }

    private int ans = 0;

    public int minInversions(String[] words, int[] target) {
        int n = target.length;
        int[] pos = new int[n];
        for (int i = 0; i < n; i++) {
            pos[target[i]] = i;
        }

        // 创建前缀树（字典树）
        Node root = new Node();
        for (int i = 0; i < words.length; i++) {
            Node cur = root;
            for (char ch : words[i].toCharArray()) {
                int c = ch - 'a';
                if (cur.son[c] == null) {
                    cur.son[c] = new Node();
                }
                cur = cur.son[c];
            }
            cur.pos = pos[i];
        }

        dfs(root);
        return ans;
    }

    // 返回 node 子树的 pos 列表（已从小到大排序）
    private List<Integer> dfs(Node node) {
        List<List<Integer>> a = new ArrayList<>();
        for (Node son : node.son) {
            if (son != null) {
                a.add(dfs(son));
            }
        }

        // 预处理逆序对个数
        int m = a.size();
        int[][] inv = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (j != i) {
                    inv[i][j] = calcInversions(a.get(i), a.get(j));
                }
            }
        }

        int u = 1 << m;
        int[] f = new int[u];
        Arrays.fill(f, Integer.MAX_VALUE);
        f[0] = 0;

        for (int s = 0; s < u; s++) { // 之前选的下标集合是 s
            // 在 s 的右边添加 j
            for (int j = 0; j < m; j++) {
                if ((s >> j & 1) > 0) {
                    continue;
                }
                int sum = f[s];
                // 枚举 s 中的下标 i，计算新产生的逆序对个数
                for (int i = 0; i < m; i++) {
                    if ((s >> i & 1) > 0) {
                        sum += inv[i][j];
                    }
                }
                f[s | 1 << j] = Math.min(f[s | 1 << j], sum);
            }
        }
        ans += f[u - 1];

        List<Integer> res = new ArrayList<>();
        int curPos = node.pos;
        if (curPos >= 0) {
            res.add(curPos);
        }
        for (List<Integer> sub : a) {
            if (curPos >= 0) {
                // curPos 与子树之间的逆序对个数
                ans += ~Collections.binarySearch(sub, curPos);
            }
            res.addAll(sub);
        }

        Collections.sort(res);
        return res;
    }

    // 计算 a 在 b 左侧时，a 和 b 之间的逆序对个数
    // a 和 b 已经升序排序
    private int calcInversions(List<Integer> a, List<Integer> b) {
        int n = a.size(), m = b.size();
        int i = 0, j = 0;
        int inv = 0;
        while (i < n && j < m) {
            if (a.get(i) > b.get(j)) {
                // a 的子数组 [i, n-1] 中的数都大于 b[j]
                inv += n - i;
                j++;
            } else {
                i++;
            }
        }
        return inv;
    }
}
/*
4077. 前缀树中的最小逆序对数目
https://leetcode.cn/problems/minimize-inversions-in-a-prefix-tree/description/

第 193 场双周赛 T4。

给你一个包含 n 个 互不相同 字符串的数组 words，这些字符串仅由从 'a' 到 'j' 的小写英文字母组成。另给你一个整数数组 target，其中每个从 0 到 n - 1 的下标都恰好出现一次。
利用 words 构建一棵 前缀树 ：
- 根节点表示空字符串 ""。
- 每个其他节点表示单词中一个不同的非空前缀。一个节点的父节点是通过移除其最后一个字符后得到的前缀。
- 表示完整单词 words[i] 的节点被标记为下标 i。被标记的节点也可以拥有子节点。
你可以 独立地 选择 每个节点 内子节点的访问顺序。但不能改变哪个节点是子节点的父节点。
从根节点开始遍历前缀树。在访问一个节点时，若该节点被标记，则先记录它的下标。然后按照选定的顺序访问它的子节点，在移动到下一个子节点之前，先完成对当前子节点树的遍历。这是一种 先序遍历 。
记录标记的下标构成一个长度为 n 的数组 traversal。设 pos[i] 为下标 i 在 target 中的位置。
一个 逆序对 是一对位置 (a, b)，满足 0 <= a < b < n 且 pos[traversal[a]] > pos[traversal[b]]。
返回在所有子节点顺序的选择下，可能达到的最小逆序对数量。
字符串的 前缀 是指通过从该字符串的末尾移除零个或多个字符而获得的字符串。
示例 1：
输入： words = ["bad","bag","fig","fed"], target = [3,1,0,2]
输出： 2
示例 2：
输入： words = ["ab","ac","ba","bc"], target = [0,3,1,2]
输出： 1
提示：
1 <= n == words.length <= 10^4
1 <= words[i].length <= 20
words[i] 仅包含从 'a' 到 'j' 的小写英文字母
所有 words[i] 都是 唯一 的
0 <= target[i] <= n - 1
target 是 0 到 n - 1 整数的一个排列

树上状压 DP。
https://leetcode.cn/problems/minimize-inversions-in-a-prefix-tree/solutions/4041556/shu-shang-zhuang-ya-dppythonjavacgo-by-e-2ik0/
 */