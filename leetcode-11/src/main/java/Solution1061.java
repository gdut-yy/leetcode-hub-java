public class Solution1061 {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int len = s1.length();

        UnionFind unionFind = new UnionFind(26);
        for (int i = 0; i < len; i++) {
            int idx1 = s1.charAt(i) - 'a';
            int idx2 = s2.charAt(i) - 'a';
            unionFind.union(idx1, idx2);
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (char ch : baseStr.toCharArray()) {
            int idx = unionFind.find(ch - 'a');
            stringBuilder.append((char) (idx + 'a'));
        }
        return stringBuilder.toString();
    }

    static class UnionFind {
        // 记录每个节点的父节点
        int[] parent;
        // (可选) 连通分量
        int count;

        // 0 ~ n-1
        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
            count = n;
        }

        // 返回节点 x 的根节点
        private int find(int x) {
            int ret = x;
            while (ret != parent[ret]) {
                // 路径压缩
                parent[ret] = parent[parent[ret]];
                ret = parent[ret];
            }
            return ret;
        }

        // 将 p 和 q 连通
        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP != rootQ) {
                // 不按 rank，连接到字典序小的点
                if (rootP <= rootQ) {
                    parent[rootQ] = rootP;
                } else {
                    parent[rootP] = rootQ;
                }
                count--;
            }
        }
    }
}
/*
$1061. 按字典序排列最小的等效字符串
https://leetcode.cn/problems/lexicographically-smallest-equivalent-string/

给出长度相同的两个字符串s1 和 s2 ，还有一个字符串 baseStr 。
其中  s1[i] 和 s2[i]  是一组等价字符。
- 举个例子，如果 s1 = "abc" 且 s2 = "cde"，那么就有 'a' == 'c', 'b' == 'd', 'c' == 'e'。
等价字符遵循任何等价关系的一般规则：
- 自反性 ：'a' == 'a'
- 对称性 ：'a' == 'b' 则必定有 'b' == 'a'
- 传递性 ：'a' == 'b' 且 'b' == 'c' 就表明 'a' == 'c'
例如， s1 = "abc" 和 s2 = "cde" 的等价信息和之前的例子一样，那么 baseStr = "eed" , "acd" 或 "aab"，这三个字符串都是等价的，而 "aab" 是 baseStr 的按字典序最小的等价字符串
利用 s1 和 s2 的等价信息，找出并返回 baseStr 的按字典序排列最小的等价字符串。

不同于一般并查集，连接到字典序小的点
 */