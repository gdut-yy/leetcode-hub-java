package abl;

import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.Scanner;

public class Abl_e {
    static int n, q;
    static int[][] lrd;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        q = scanner.nextInt();
        lrd = new int[q][3];
        for (int i = 0; i < q; i++) {
            lrd[i][0] = scanner.nextInt();
            lrd[i][1] = scanner.nextInt();
            lrd[i][2] = scanner.nextInt();
        }
        solve();
    }

    static final int mod = 998244353;
    static Random rand = new Random();
    static long[] ones, p10;
    static long ans;

    private static void solve() {
        ones = new long[n + 1];
        p10 = new long[n + 1];
        p10[0] = 1;
        for (int i = 1; i <= n; i++) {
            ones[i] = (ones[i - 1] * 10 + 1) % mod;
            p10[i] = (p10[i - 1] * 10) % mod;
        }
        ans = ones[n];
        Treap t = new Treap();
        t.put(1, n, 1);
        for (int[] p : lrd) {
            int l = p[0], r = p[1], d = p[2];
            t.merge(l, r, d);
            System.out.println(ans);
        }
    }

    private static class Node {
        Node[] lr;
        long priority;
        int l, r, d;

        public Node(long priority, int l, int r, int d) {
            this.lr = new Node[2];
            this.priority = priority;
            this.l = l;
            this.r = r;
            this.d = d;
        }

        private int cmp(int b) {
            if (b < l) return 0;
            else if (b > l) return 1;
            else return -1;
        }

        private Node rotate(int d) {
            Node x = lr[d ^ 1];
            lr[d ^ 1] = x.lr[d];
            x.lr[d] = this;
            return x;
        }
    }

    private static class Treap {
        long rd;
        Node root;

        public Treap() {
            this.rd = rand.nextLong();
        }

        private Node _put(Node o, int l, int r, int dig) {
            if (o == null) {
                return new Node(rand.nextLong(), l, r, dig);
            }
            int d = o.cmp(l);
            if (d >= 0) {
                o.lr[d] = _put(o.lr[d], l, r, dig);
                if (o.lr[d].priority > o.priority) {
                    o = o.rotate(d ^ 1);
                }
            } else {
                o.d = dig;
            }
            return o;
        }

        private void put(int l, int r, int d) {
            root = _put(root, l, r, d);
        }

        private Node _delete(Node o, int l) {
            if (o == null) {
                return null;
            }
            int d = o.cmp(l);
            if (d >= 0) {
                o.lr[d] = _delete(o.lr[d], l);
            } else {
                if (o.lr[1] == null) {
                    return o.lr[0];
                }
                if (o.lr[0] == null) {
                    return o.lr[1];
                }
                d = 0;
                if (o.lr[0].priority > o.lr[1].priority) {
                    d = 1;
                }
                o = o.rotate(d);
                o.lr[d] = _delete(o.lr[d], l);
            }
            return o;
        }

        private void delete(int l) {
            root = _delete(root, l);
        }

        private Node floor(int key) {
            Node floor = null;
            Node o = root;
            while (o != null) {
                int c = o.cmp(key);
                if (c == 0) {
                    o = o.lr[0];
                } else if (c > 0) {
                    floor = o;
                    o = o.lr[1];
                } else {
                    return o;
                }
            }
            return floor;
        }

        private Node next(int l) {
            Node next = null;
            Node o = root;
            while (o != null) {
                if (o.cmp(l) == 0) {
                    next = o;
                    o = o.lr[0];
                } else {
                    o = o.lr[1];
                }
            }
            return next;
        }

        private void split(int mid) {
            Node o = floor(mid);
            if (o.l < mid && mid <= o.r) {
                int r = o.r, d = o.d;
                o.r = mid - 1;
                put(mid, r, d);
            }
        }

        private void prepare(int l, int r) {
            split(l);
            split(r + 1);
        }

        private void updateAns(Node o, int d) {
            ans = (ans + (d - o.d) * ones[o.r - o.l + 1] * p10[n - o.r] % mod + mod) % mod;
        }

        private void merge(int l, int r, int d) {
            prepare(l, r);
            for (Node o = next(l); o != null && o.l <= r; o = next(o.l)) {
                updateAns(o, d);
                delete(o.l);
            }
            Node o = floor(l);
            updateAns(o, d);
            o.r = r;
            o.d = d;
        }
    }
}
/*
E - Replace Digits
https://atcoder.jp/contests/abl/tasks/abl_e

灵茶の试炼 2022-11-02
题目大意：
输入 n(≤2e5) 和 q(≤2e5)。
初始有一个长为 n 的字符串 s，所有字符都是 1，s 的下标从 1 开始。
然后输入 q 个替换操作，每个操作输入 L,R (1≤L≤R≤n) 和 d (1≤d≤9)。
你需要把 s 的 [L,R] 内的所有字符替换为 d。
对每个操作，把替换后的 s 看成一个十进制数，输出这个数模 998244353 的结果。

https://atcoder.jp/contests/abl/submissions/36147029
珂朵莉树练习题。
预处理 11...1 (i 个 1) 以及 10^i 的值，就可以套模板了，核心在于更新答案的逻辑。
比如把 111xxx 替换成 333xxx，那么 ans 增加了 (3-1)*111*1000。
======

Input 1
8 5
3 6 2
1 4 7
3 8 3
2 2 2
4 5 1
Output 1
11222211
77772211
77333333
72333333
72311333

Input 2
200000 1
123 456 7
Output 2
641437905
 */