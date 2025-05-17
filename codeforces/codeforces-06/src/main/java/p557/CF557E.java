package p557;

import java.util.Scanner;

public class CF557E {
    static char[] s;
    static int k;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        s = scanner.next().toCharArray();
        k = scanner.nextInt();
        System.out.println(solve());
    }

    private static String solve() {
        int n = s.length;
        boolean[][] isPal = new boolean[n][n];
        for (int i = 0; i < 2 * n - 1; i++) {
            int l = i / 2, r = (i + 1) / 2;
            while (l >= 0 && r < n && s[l] == s[r]) {
                isPal[l][r] = true;
                l -= 2;
                r += 2;
            }
            l = i / 2 - 1;
            r = (i + 1) / 2 + 1;
            while (l >= 0 && r < n && s[l] == s[r]) {
                isPal[l][r] = true;
                l -= 2;
                r += 2;
            }
        }

        for (int i = 0; i < isPal.length; i++) {
            boolean[] row = isPal[i];
            put(s, row, i);
        }
        return kth(k);
    }

//    static class TrieNode {
//        TrieNode[] son = new TrieNode[2];
//        int cnt;
//        int sum;
//    }
//
//    static TrieNode root = new TrieNode();
//
//    static void put(char[] s, boolean[] isPal, int beginIndex) {
//        int tot = 0;
//        for (int i = beginIndex; i < isPal.length; i++) {
//            if (isPal[i]) {
//                tot++;
//            }
//        }
//        TrieNode o = root;
//        for (int i = beginIndex; i < s.length; i++) {
//            int b = s[i] - 'a';
//            if (o.son[b] == null) {
//                o.son[b] = new TrieNode();
//            }
//            o = o.son[b];
//            o.sum += tot;
//            if (isPal[i]) {
//                o.cnt++;
//                tot--;
//            }
//        }
//    }
//
//    static String kth(int k) {
//        TrieNode o = root;
//        StringBuilder sb = new StringBuilder();
//        while (true) {
//            for (int i = 0; i < o.son.length; i++) {
//                TrieNode son = o.son[i];
//                if (son == null) {
//                    continue;
//                }
//                if (k > son.sum) {
//                    k -= son.sum;
//                    continue;
//                }
//                sb.append((char) ('a' + i));
//                o = son;
//                k -= o.cnt;
//                if (k <= 0) {
//                    return sb.toString();
//                }
//                break;
//            }
//        }
//    }

    // 0-1 Trie
    static int N = 5005, M = 5005; // N:字符串长度 M:2^M
    static int[][] dict = new int[2][N * M];
    static int[] cnt = new int[N * M], sum = new int[N * M];
    static int nextIdx = 1;

    static void put(char[] s, boolean[] isPal, int beginIndex) {
        int tot = 0;
        for (int i = beginIndex; i < isPal.length; i++) {
            if (isPal[i]) {
                tot++;
            }
        }
        int idx = 0;
        for (int i = beginIndex; i < s.length; i++) {
            int b = s[i] - 'a';
            if (dict[b][idx] == 0) {
                dict[b][idx] = nextIdx++;
            }
            idx = dict[b][idx];
            sum[idx] += tot;
            if (isPal[i]) {
                cnt[idx]++;
                tot--;
            }
        }
    }

    static String kth(int k) {
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        while (true) {
            for (int b = 0; b < 2; b++) {
                if (dict[b][idx] == 0) {
                    continue;
                }
                if (k > sum[dict[b][idx]]) {
                    k -= sum[dict[b][idx]];
                    continue;
                }
                sb.append((char) ('a' + b));
                idx = dict[b][idx];
                k -= cnt[idx];
                if (k <= 0) {
                    return sb.toString();
                }
                break;
            }
        }
    }
}
/*
E. Ann and Half-Palindrome
https://codeforces.com/contest/557/problem/E

灵茶の试炼 2025-03-14
题目大意：
输入长度 ≤5000 的字符串 s，只包含 'a' 和 'b'。
设 t 是 s 的一个连续子串，长为 m，下标从 1 开始。如果对于 [1,(m+1)/2] 中的所有奇数下标 i，都满足 t[i] = t[m-i+1]，那么称 t 为半回文串。
然后输入正整数 k。
输出 s 的字典序第 k 小的半回文子串。
保证 k 不超过 s 的半回文子串的个数。

rating 2300
核心思路：中心扩展法（或者 DP）+ 字典树 + 在字典树上求第 k 小。
首先 O(n^2) 找到所有的半回文串，这可以用中心扩展法（比 DP 方便一些，不用考虑初始值）。
然后把所有半回文串都插到字典树中，但直接插所有半回文串，是 O(n^3) 的。
这里需要「压缩」一下，对于所有左端点在 i 的半回文串，一次性地全部加到字典树中。
做法：在把后缀 s[i:] 加到字典树的过程中，如果发现 s[i] ~ s[j] 是半回文串，那么在字典树的 s[j] 位置处标记这里有半回文串（半回文串个数加一）。
换句话说，每个节点都有一个 cnt，表示（根到）当前节点对应的半回文串有 cnt 个。
有了 cnt，我们可以计算出每棵子树的 cnt 之和 sum。（这也可以在插入的时候更新）
有了 sum，我们就可以算第 k 小了。这是字典树的经典应用。
比如根节点下面有 a 和 b：
如果 a 子树的 sum >= k，那么答案必然以 a 开头，我们递归 a 子树。
如果 a 子树的 sum < k，那么答案必然不会以 a 开头，由于只有 a 和 b，我们递归 b 子树，同时把 k 减去 a 子树的 sum。
这个过程可以写递归，也可以写迭代。代码用的迭代写法，且更加通用。
代码 https://codeforces.com/problemset/submission/557/309909251
代码备份（洛谷）
======

Input
abbabaab
7
Output
abaa

Input
aaaaa
10
Output
aaa

Input
bbaabb
13
Output
bbaabb
 */
