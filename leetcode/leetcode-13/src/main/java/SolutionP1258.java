import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionP1258 {
    public List<String> generateSentences(List<List<String>> synonyms, String text) {
        String[] words = text.split(" ");

        // 将 String 映射到 idx
        int idx = 0;
        Map<String, Integer> idxMap = new HashMap<>();
        for (List<String> synonym : synonyms) {
            for (String s : synonym) {
                if (!idxMap.containsKey(s)) {
                    idxMap.put(s, idx);
                    idx++;
                }
            }
        }

        // 并查集 处理 近义词
        UnionFind unionFind = new UnionFind(idx);
        for (List<String> synonym : synonyms) {
            String syn0 = synonym.get(0);
            String syn1 = synonym.get(1);
            unionFind.union(idxMap.get(syn0), idxMap.get(syn1));
        }

        // 回溯 + 排序
        List<String> resList = new ArrayList<>();
        dfs(unionFind, resList, idxMap, words, 0);
        Collections.sort(resList);
        return resList;
    }

    private void dfs(UnionFind unionFind, List<String> resList, Map<String, Integer> idxMap, String[] words, int curI) {
        if (curI == words.length) {
            resList.add(String.join(" ", words));
        } else {
            // 存在近义词，能够交换
            if (idxMap.containsKey(words[curI])) {
                String oldWord = words[curI];
                for (Map.Entry<String, Integer> entry : idxMap.entrySet()) {
                    if (unionFind.connected(entry.getValue(), idxMap.get(oldWord))) {
                        String newWord = entry.getKey();
                        words[curI] = newWord;
                        dfs(unionFind, resList, idxMap, words.clone(), curI + 1);
                        words[curI] = oldWord;
                    }
                }
            }
            // 不存在近义词
            else {
                dfs(unionFind, resList, idxMap, words.clone(), curI + 1);
            }
        }
    }

    private static class UnionFind {
        // 记录每个节点的父节点
        int[] parent;
        // 记录每棵树的重量
        int[] rank;
        // (可选) 连通分量
        int count;

        // 0 ~ n-1
        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = i;
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
                if (rank[rootP] > rank[rootQ]) {
                    parent[rootQ] = rootP;
                } else if (rank[rootP] < rank[rootQ]) {
                    parent[rootP] = rootQ;
                } else {
                    parent[rootQ] = rootP;
                    // 重量平衡
                    rank[rootP] += 1;
                }
                count--;
            }
        }

        // p 和 q 是否连通
        public boolean connected(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            return rootP == rootQ;
        }
    }
}
/*
$1258. 近义词句子
https://leetcode.cn/problems/synonymous-sentences/

给你一个近义词表 synonyms 和一个句子 text ， synonyms 表中是一些近义词对 ，你可以将句子 text 中每个单词用它的近义词来替换。
请你找出所有用近义词替换后的句子，按 字典序排序 后返回。
提示：
0 <= synonyms.length <= 10
synonyms[i].length == 2
synonyms[0] != synonyms[1]
所有单词仅包含英文字母，且长度最多为 10 。
text 最多包含 10 个单词，且单词间用单个空格分隔开。

并查集+回溯
并查集处理近义词，然后再跑一次 DFS 得出所有用近义词替换后的句子，排序即可。
时间复杂度 O(n*n!) 最坏情况下，text 每个单词都存在近义词。
空间复杂度 O(n)
相似题目: 46. 全排列
https://leetcode.cn/problems/permutations/
 */