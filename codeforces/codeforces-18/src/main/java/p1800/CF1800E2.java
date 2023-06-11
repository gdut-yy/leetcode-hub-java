package p1800;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CF1800E2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            String s = scanner.next();
            String t = scanner.next();
            System.out.println(solve(n, k, s, t));
        }
    }

    private static String solve(int n, int k, String s, String t) {
        DSU dsu = new DSU(n + 1);
        for (int i = 0; i + k < n; i++) {
            dsu.union(i, i + k);
            dsu.union(i, i + k + 1);
        }

        Map<Integer, List<Character>> sGroups = new HashMap<>();
        Map<Integer, List<Character>> tGroups = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int fa = dsu.find(i);
            sGroups.computeIfAbsent(fa, key -> new ArrayList<>()).add(s.charAt(i));
            tGroups.computeIfAbsent(fa, key -> new ArrayList<>()).add(t.charAt(i));
        }

        // sGroups.size() == tGroups.size()
        for (Map.Entry<Integer, List<Character>> entry : sGroups.entrySet()) {
            List<Character> sList = entry.getValue();
            List<Character> tList = tGroups.get(entry.getKey());
            Collections.sort(sList);
            Collections.sort(tList);
            if (!sList.equals(tList)) {
                return "NO";
            }
        }
        return "YES";
    }

    private static class DSU {
        int[] fa;

        public DSU(int n) {
            int N = n + 1;
            fa = new int[N];
            for (int i = 0; i < N; i++) {
                fa[i] = i;
            }
        }

        int find(int x) {
            if (x != fa[x]) {
                fa[x] = find(fa[x]);
            }
            return fa[x];
        }

        void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            }
            // 合并到较小的节点
            if (rootP < rootQ) {
                fa[rootQ] = rootP;
            } else {
                fa[rootP] = rootQ;
            }
        }
    }
}
/*
E2. Unforgivable Curse (hard version)
https://codeforces.com/contest/1800/problem/E2

题目大意：
给定整数 n, k 和长度为 n 的字符串 s, t。可以在距离 k 或者 k+1 的地方交换 s 的字母，可以交换任意次。求是否可以使 s == t

并查集。放力扣也就是中等题。。
相似题目: 1202. 交换字符串中的元素
https://leetcode.cn/problems/smallest-string-with-swaps/
======

input
7
6 3
talant
atltna
7 1
abacaba
aaaabbc
12 6
abracadabraa
avadakedavra
5 3
accio
cicao
5 4
lumos
molus
4 3
uwjt
twju
4 3
kvpx
vxpk

output
YES
YES
NO
YES
NO
YES
NO
 */