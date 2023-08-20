package p1851;

import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.Scanner;

public class CF1851F {
    static int n, k;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            k = scanner.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    static Random rng = new Random();
    static TrieNode root;

    private static String solve() {
        root = new TrieNode();
//        add_num(v, a[0], k - 1, 0);
        add_num(a[0], 0);

        int ians = 0, jans = 1, xans = 0;
        for (int i = 1; i < n; ++i) {
            x = 0;
            j = -1;
            TrieNode o = root;
            int cur = down(o, a[i], k - 1);
            if (cur > ((a[ians] ^ xans) & (a[jans] ^ xans))) {
                ians = j;
                jans = i;
                xans = x;
            }
//            add_num(v, a[i], k - 1, i);
            add_num(a[i], i);
        }

        return (ians + 1) + " " + (jans + 1) + " " + xans;
    }

//    node *mem = new node[MAXMEM];
//    node *root, *mpos;
//
//    void add_num(node* &v, int val, int i, int id) {
//        if (v == nullptr) *(v = mpos++) = node();
//        v->sz++;
//        if (i == -1) {
//            v->id = id;
//            return;
//        }
//        add_num(v->chi[val >> i & 1], val, i - 1, id);
//    }

    static void add_num(int val, int id) {
        TrieNode o = root;
        for (int j = k - 1; j >= 0; j--) {
            int b = val >> j & 1;
            if (o.chi[b] == null) {
                o.chi[b] = new TrieNode();
            }
            o = o.chi[b];
            o.sz++;
        }
        o.id = id;
    }

    static int x, j;

    static int down(TrieNode v, int val, int i) {
        if (i == -1) {
            j = v.id;
            return 0;
        }
        int b = val >> i & 1;
        if (v.chi[b] != null) {
            v = v.chi[b];
            x ^= ((1 ^ b) << i);
            return down(v, val, i - 1) | (1 << i);
        }
        v = v.chi[b ^ 1];
        x ^= ((rng.nextInt() & 1) << i);
        return down(v, val, i - 1);
    }

    private static class TrieNode {
        TrieNode[] chi;
        int sz, id;

        public TrieNode() {
            chi = new TrieNode[2];
            sz = 0;
            id = -1;
        }
    }
}
/*
F. Lisa and the Martians
https://codeforces.com/contest/1851/problem/F

题目大意：
丽莎被火星人绑架了!没关系，因为她看过很多关于外星人的电视节目，所以她知道等待她的是什么。如果整数是非负整数且严格小于 2^k，我们称其为火星整数，例如，当 k=12 时，51、1960、0 是火星整数，而 π、- 1、21/8、4096 不是火星整数。
外星人会给丽萨 n 个火星数字 a1,a2,...,an。然后他们会让她说出任何火星数字 x。之后，Lisa 将在给定序列中选择一对数字 ai,aj (i≠j)，并计数(ai⊕x)&(aj⊕x)。
操作 ⊕ 表示按位异或，操作&表示按位与。例如，(5⊕17)&(23⊕17)=(00101⊕10001)&(10111⊕10001)=10100&00110=00100=4。
丽莎确信，计算值越高，她回家的可能性就越大。帮助女孩选择使计算值最大化的 i,j,x。

拆位 0-1 Trie
(0^0)&(0^0)=0
(0^0)&(1^0)=0
(1^0)&(0^0)=0
(1^0)&(1^0)=1
---
(0^1)&(0^1)=1
(0^1)&(1^1)=0
(1^1)&(0^1)=0
(1^1)&(1^1)=0
https://codeforces.com/blog/entry/118667
解决方案 1。让我们使用一种被称为按位 trie 的数据结构。修复一些 ai，其中所有 j<i 的 aj 已经添加到 trie 中。
我们将迭代 ai 中的位，从第(k−1)位到第 0 位。由于 2^t>2^(t-1)+2^(t-2)+...+2+1，如果在 ai 的相应位置存在 aj，那么我们将进入该分支并将 1-b 附加到相应的位 x 上。
否则，我们的道路是独一无二的。当我们到达叶节点时，路径上的位对应于 ai 的最优数 aj。这个解的复杂度是 O(nk)。
---
解决方案 2。对 a1,a2,...,an 按非降序排序。我们将证明答案是一对相邻的数。设答案是数字 ai,aj (j-i>1)如果 ai=aj，那么 ai=ai+1。
否则，它们有一个共同的位前缀，之后有一个不同的位。也就是说，在某个位置 t, ai 是 0, aj 是 1。
由于 j−i>1，在这个位置上，ai+1 可以是 0 或 1，但在第一种情况下，选择 ai,ai+1 作为答案更有利，在第二种情况下，选择 ai+1,aj 作为答案更有利。这个解的复杂度是 O(nlogn)。
======

input
10
5 4
3 9 1 4 13
3 1
1 0 1
6 12
144 1580 1024 100 9 13
4 3
7 3 0 4
3 2
0 0 1
2 4
12 2
9 4
6 14 9 4 4 4 5 10 2
2 1
1 0
2 4
11 4
9 4
2 11 10 1 6 9 11 0 5
output
1 3 14
1 3 0
5 6 4082
2 3 7
1 2 3
1 2 15
4 5 11
1 2 0
1 2 0
2 7 4
 */
