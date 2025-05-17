package p2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class CF2000H {
    static final int MX = (int) 4e6 + 1;
    // Time limit exceeded on test 16
//    static Scanner scanner = new Scanner(System.in);
    static FastReader scanner = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        while (t-- > 0) {
            solve();
        }
        out.flush();
    }

    private static void solve() {
        StNode t = new StNode(1, MX);
        Map<Integer, TreapMS> gap = new HashMap<>();
        TreapMS set = new TreapMS();
        set.put(0);

        int pre = 0;
        int n = scanner.nextInt();
        while (n-- > 0) {
            int v = scanner.nextInt();
            set.put(v);
            putGap(gap, t, pre, v);
            pre = v;
        }
        set.put(MX);
        putGap(gap, t, pre, MX);

        int m = scanner.nextInt();
        while (m-- > 0) {
            String op = scanner.next();
            int v = scanner.nextInt();

            if ("+".equals(op)) {
                int i = set.lowerBoundIndex(v);
                Integer l = set.kth(i - 1);
                Integer r = set.kth(i);
                set.put(v);
                delGap(gap, t, l, r);
                putGap(gap, t, l, v);
                putGap(gap, t, v, r);
            } else if ("-".equals(op)) {
                set.delete(v);
                int i = set.lowerBoundIndex(v);
                Integer l = set.kth(i - 1);
                Integer r = set.kth(i);
                delGap(gap, t, l, v);
                delGap(gap, t, v, r);
                putGap(gap, t, l, r);
            } else if ("?".equals(op)) {
                int res = t.query(v);
                out.print(res + " ");
            }
        }
        out.println();
    }

    static void putGap(Map<Integer, TreapMS> gap, StNode t, int l, int r) {
        int k = r - l - 1;
        if (k == 0) return;
        TreapMS treap = gap.computeIfAbsent(k, key -> new TreapMS());
        treap.put(l + 1);
        Integer min = treap.min();
        t.update(k, min != null ? min : StNode.ST_NODE_DEFAULT_VAL);
    }

    static void delGap(Map<Integer, TreapMS> gap, StNode t, int l, int r) {
        int k = r - l - 1;
        if (k == 0) return;
        TreapMS treap = gap.get(k);
        if (treap == null) return;
        treap.delete(l + 1);
        if (treap.isEmpty()) {
            t.update(k, StNode.ST_NODE_DEFAULT_VAL);
        } else {
            Integer min = treap.min();
            t.update(k, min != null ? min : StNode.ST_NODE_DEFAULT_VAL);
        }
    }

    static class NodeMS {
        NodeMS[] son = new NodeMS[2];
        long priority;
        Integer key;
        int keyCnt;
        int subSize;

        void maintain() {
            subSize = keyCnt;
            if (son[0] != null) subSize += son[0].subSize;
            if (son[1] != null) subSize += son[1].subSize;
        }

        NodeMS rotate(int d) {
            NodeMS x = son[d ^ 1];
            son[d ^ 1] = x.son[d];
            x.son[d] = this;
            maintain();
            x.maintain();
            return x;
        }
    }

    static class TreapMS {
        private long rd = 1;
        NodeMS root;

        public TreapMS() {
        }

        private long fastRand() {
            rd ^= rd << 13;
            rd ^= rd >> 17;
            rd ^= rd << 5;
            return rd;
        }

        public boolean isEmpty() {
            return root == null || root.subSize == 0;
        }

        public void put(Integer key) {
            root = put(root, key);
        }

        private NodeMS put(NodeMS o, Integer key) {
            if (o == null) {
                NodeMS newNode = new NodeMS();
                newNode.priority = fastRand();
                newNode.key = key;
                newNode.keyCnt = 1;
                newNode.maintain();
                return newNode;
            }
            int c = key.compareTo(o.key);
            if (c == 0) {
                o.keyCnt++;
            } else {
                int d = c < 0 ? 0 : 1;
                o.son[d] = put(o.son[d], key);
                if (o.son[d].priority > o.priority) {
                    o = o.rotate(d ^ 1);
                }
            }
            o.maintain();
            return o;
        }

        public void delete(Integer key) {
            root = delete(root, key);
        }

        private NodeMS delete(NodeMS o, Integer key) {
            if (o == null) return null;
            int c = key.compareTo(o.key);
            if (c != 0) {
                int d = c > 0 ? 1 : 0;
                o.son[d] = delete(o.son[d], key);
            } else {
                if (o.keyCnt > 1) {
                    o.keyCnt--;
                } else {
                    if (o.son[0] == null) return o.son[1];
                    if (o.son[1] == null) return o.son[0];
                    int d = (o.son[0].priority > o.son[1].priority) ? 1 : 0;
                    o = o.rotate(d);
                    o.son[d] = delete(o.son[d], key);
                }
            }
            o.maintain();
            return o;
        }

        public Integer min() {
            return kth(0);
        }

        public int lowerBoundIndex(Integer key) {
            int kth = 0;
            NodeMS o = root;
            while (o != null) {
                int c = key.compareTo(o.key);
                if (c < 0) {
                    o = o.son[0];
                } else if (c > 0) {
                    kth += (o.son[0] != null ? o.son[0].subSize : 0) + o.keyCnt;
                    o = o.son[1];
                } else {
                    kth += (o.son[0] != null ? o.son[0].subSize : 0);
                    break;
                }
            }
            return kth;
        }

        public Integer kth(int k) {
            if (k < 0 || (root == null ? 0 : root.subSize) <= k) {
                return null;
            }
            NodeMS o = root;
            while (o != null) {
                int leftSize = (o.son[0] != null) ? o.son[0].subSize : 0;
                if (k < leftSize) {
                    o = o.son[0];
                } else {
                    k -= leftSize + o.keyCnt;
                    if (k < 0)
                        break;
                    o = o.son[1];
                }
            }
            return o != null ? o.key : null;
        }
    }

    static class StNode {
        StNode lo, ro;
        int l, r;
        int val;
        static final int ST_NODE_DEFAULT_VAL = (int) 1e9;
        static StNode EMPTY = new StNode();

        StNode() {
            lo = this;
            ro = this;
            val = ST_NODE_DEFAULT_VAL;
            l = Integer.MAX_VALUE;
            r = Integer.MIN_VALUE;
        }

        StNode(int l, int r) {
            this();
            this.l = l;
            this.r = r;
            lo = EMPTY;
            ro = EMPTY;
            val = ST_NODE_DEFAULT_VAL;
        }

        void update(int i, int val) {
            if (this == EMPTY) {
                return;
            }
            if (l == r) {
                this.val = val;
                return;
            }
            int m = (l + r) >> 1;
            if (i <= m) {
                if (lo == EMPTY) {
                    lo = new StNode(l, m);
                }
                lo.update(i, val);
            } else {
                if (ro == EMPTY) {
                    ro = new StNode(m + 1, r);
                }
                ro.update(i, val);
            }
            this.val = Math.min(lo.val, ro.val);
        }

        int query(int l) {
            if (this == EMPTY || l > r) {
                return ST_NODE_DEFAULT_VAL;
            }
            if (l <= this.l) {
                return val;
            }
            return Math.min(lo.query(l), ro.query(l));
        }
    }

    static class FastReader {
        private final BufferedReader bufferedReader;
        private StringTokenizer stringTokenizer;

        public FastReader() {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            while (stringTokenizer == null || !stringTokenizer.hasMoreElements()) {
                try {
                    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return stringTokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
            String str = "";
            try {
                if (stringTokenizer.hasMoreTokens()) {
                    str = stringTokenizer.nextToken("\n");
                } else {
                    str = bufferedReader.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
/*
H. Ksyusha and the Loaded Set
https://codeforces.com/contest/2000/problem/H

灵茶の试炼 2024-12-27
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5，m 之和 ≤2e5。
每组数据输入 n(1≤n≤2e5) 和长为 n 的严格递增数组 a(1≤a[i]≤2e6)。
a 表示 n 个数的集合 S。
然后输入 m(1≤m≤2e5) 和 m 个询问，格式如下：
"+ x"：往集合 S 中添加元素 x(1≤x≤2e6)，保证 x 不在 S 中。
"- x"：从集合 S 中移除元素 x(1≤x≤2e6)，保证 x 在 S 中。
"? k"：输出最小的正整数 d，满足 [d,d+k-1] 中的整数都不在 S 中。(1≤k≤2e6)
相似题目：P2894 [USACO08FEB] Hotel G
https://www.luogu.com.cn/problem/P2894

rating 2200
设 a 中两个相邻元素为 x 和 y，为了方便回答询问，用（动态开点）线段树维护如下信息：
下标（位置）为 y-x-1，
值为 x+1 的最小值。
题目的 "? k" 询问，相当于问 [k,∞] 的后缀最小值。
为了支持添加和删除操作，需要用一个有序集合维护每个数的左右两侧最近的数，这样我们可以算出 y-x-1 是多少。
此外，考虑到同一个 y-x-1 可能有多个不同的 x+1，我们还需要用一个 map 套 multiset（或者懒删除堆）维护每个 y-x-1 对应的所有 x+1。把 multiset 的最小值更新到线段树中。
可以添加 0 和 4e6+1 哨兵，简化逻辑。
代码 https://codeforces.com/problemset/submission/2000/298374818
代码备份（洛谷）
======

Input
3
5
1 2 5 905 2000000
15
- 2
? 2
? 1
- 1
? 1
+ 4
+ 2
? 2
+ 6
- 4
+ 7
? 2
? 3
? 4
? 2000000
5
3 4 5 6 8
9
? 5
- 5
? 5
+ 1
? 2
- 6
- 8
+ 6
? 5
5
6 7 8 9 10
10
? 5
- 6
? 4
- 10
+ 5
- 8
+ 3
+ 2
- 3
+ 10
Output
2 2 1 6 3 8 8 2000001
9 9 9 7
1 1
 */
