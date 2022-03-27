import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        // 邮箱地址 映射到 idx
        int idx = 0;
        Map<String, Integer> idxMap = new HashMap<>();
        Map<String, String> nameMap = new HashMap<>();
        for (List<String> account : accounts) {
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                if (!idxMap.containsKey(account.get(i))) {
                    idxMap.put(account.get(i), idx);
                    idx++;
                    nameMap.put(account.get(i), name);
                }
            }
        }

        // 并查集 合并账户
        UnionFind unionFind = new UnionFind(idx);
        for (List<String> account : accounts) {
            String firstMail = account.get(1);
            for (int i = 2; i < account.size(); i++) {
                unionFind.union(idxMap.get(firstMail), idxMap.get(account.get(i)));
            }
        }

        // 同 祖先 的 emails
        Map<Integer, List<String>> rootEmailsMap = new HashMap<>();
        for (Map.Entry<String, Integer> entry : idxMap.entrySet()) {
            int root = unionFind.find(entry.getValue());
            List<String> emails = rootEmailsMap.getOrDefault(root, new ArrayList<>());
            emails.add(entry.getKey());
            rootEmailsMap.put(root, emails);
        }

        // 返回结果
        List<List<String>> resList = new ArrayList<>();
        for (List<String> emails : rootEmailsMap.values()) {
            List<String> account = new ArrayList<>();
            // 每个账户的第一个元素是名称
            account.add(nameMap.get(emails.get(0)));
            // 其余元素是 按字符 ASCII 顺序排列 的邮箱地址
            Collections.sort(emails);
            account.addAll(emails);
            resList.add(account);
        }
        return resList;
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
    }
}
/*
721. 账户合并
https://leetcode-cn.com/problems/accounts-merge/

给定一个列表 accounts，每个元素 accounts[i] 是一个字符串列表，其中第一个元素 accounts[i][0] 是 名称 (name)，其余元素是 emails 表示该账户的邮箱地址。
现在，我们想合并这些账户。如果两个账户都有一些共同的邮箱地址，则两个账户必定属于同一个人。
请注意，即使两个账户具有相同的名称，它们也可能属于不同的人，因为人们可能具有相同的名称。一个人最初可以拥有任意数量的账户，但其所有账户都具有相同的名称。
合并账户后，按以下格式返回账户：每个账户的第一个元素是名称，其余元素是 按字符 ASCII 顺序排列 的邮箱地址。账户本身可以以 任意顺序 返回。
提示：
1 <= accounts.length <= 1000
2 <= accounts[i].length <= 10
1 <= accounts[i][j].length <= 30
accounts[i][0] 由英文字母组成
accounts[i][j] (for j > 0) 是有效的邮箱地址

并查集 + HashMap
 */