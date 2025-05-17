import base.Unaccepted;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@Unaccepted
public class P3373 {
    static Scanner scanner = new Scanner(System.in);
    static int n, q, mod;
    static int[] a;

    public static void main(String[] args) {
        n = scanner.nextInt();
        q = scanner.nextInt();
        mod = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        LazyInfoSegmentTree seg = new LazyInfoSegmentTree(n);
        seg.build(a, 1, 1, n);

        List<String> output = new ArrayList<>();
        while (q-- > 0) {
            int op = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            if (op == 1) { // 将区间 [x,y] 内每个数乘上 k
                int k = scanner.nextInt();
                seg.rangeApply(1, 1, n, x, y, new LazyInfoSegmentTree.Tag(0, k));
            } else if (op == 2) { // 将区间 [x,y] 内每个数加上 k
                int k = scanner.nextInt();
                seg.rangeApply(1, 1, n, x, y, new LazyInfoSegmentTree.Tag(k, 1));
            } else {
                long res = seg.rangeQuery(1, 1, n, x, y).sm;
                output.add(String.valueOf(res));
            }
        }
        return String.join("\n", output);
    }

    // 线段树模板，只需要实现 mergeInfo 和 _do，其余都是固定的
    static class LazyInfoSegmentTree {
        static class Info {
            long sm;

            public Info(long sm) {
                this.sm = sm;
            }

            void apply(int l, int r, Tag t) {
                long sz = r - l + 1;
                // 先乘后加
                if (t.mul != 1) {
                    sm = (sm * t.mul) % mod;
                }
                if (t.add != 0) {
                    sm = (sm + sz * t.add) % mod;
                }
            }
        }

        static class Tag {
            long add = 0, mul = 1;

            public Tag() {
            }

            public Tag(long add, long mul) {
                this.add = add;
                this.mul = mul;
            }

            void apply(Tag t) {
                if (t.mul != 1) {
                    add = (add * t.mul) % mod;
                    mul = (mul * t.mul) % mod;
                }
                if (t.add != 0) {
                    add = (add + t.add) % mod;
                }
            }
        }

        Info mergeInfo(Info a, Info b) {
            long sm = (a.sm + b.sm) % mod;
            return new Info(sm);
        }

        void _do(int p, int l, int r, Tag t) {
            info[p].apply(l, r, t);
            tag[p].apply(t);
        }

        int n;
        Info[] info;
        Tag[] tag;

        public LazyInfoSegmentTree(int n) {
            this.n = n;
            info = new Info[4 * n];
            tag = new Tag[4 * n];
            Arrays.setAll(tag, e -> new Tag());
        }

        void build(int[] A, int p, int l, int r) {
            if (l == r) {
                info[p] = new Info(A[l - 1]);
                return;
            }
            int m = (l + r) >> 1;
            build(A, p << 1, l, m);
            build(A, p << 1 | 1, m + 1, r);
            maintain(p);
        }

        void maintain(int p) {
            info[p] = mergeInfo(info[p << 1], info[p << 1 | 1]);
        }

        void spread(int p, int l, int r) {
            if (tag[p].add == 0 && tag[p].mul == 1) return;
            int m = (l + r) >> 1;
            _do(p << 1, l, m, tag[p]);
            _do(p << 1 | 1, m + 1, r, tag[p]);
            tag[p] = new Tag();
        }

        void rangeApply(int p, int l, int r, int ql, int qr, Tag t) {
            if (ql <= l && r <= qr) {
                _do(p, l, r, t);
                return;
            }
            spread(p, l, r);
            int m = (l + r) >> 1;
            if (ql <= m) rangeApply(p << 1, l, m, ql, qr, t);
            if (qr > m) rangeApply(p << 1 | 1, m + 1, r, ql, qr, t);
            maintain(p);
        }

        Info rangeQuery(int p, int l, int r, int ql, int qr) {
            if (ql <= l && r <= qr) {
                return info[p];
            }
            spread(p, l, r);
            int m = (l + r) >> 1;
            if (qr <= m) return rangeQuery(p << 1, l, m, ql, qr);
            if (ql > m) return rangeQuery(p << 1 | 1, m + 1, r, ql, qr);
            return mergeInfo(rangeQuery(p << 1, l, m, ql, qr), rangeQuery(p << 1 | 1, m + 1, r, ql, qr));
        }
    }
}
/*
# P3373 【模板】线段树 2

## 题目描述

如题，已知一个数列，你需要进行下面三种操作：

- 将某区间每一个数乘上 $x$；
- 将某区间每一个数加上 $x$；
- 求出某区间每一个数的和。

## 输入格式

第一行包含三个整数 $n,q,m$，分别表示该数列数字的个数、操作的总个数和模数。

第二行包含 $n$ 个用空格分隔的整数，其中第 $i$ 个数字表示数列第 $i$ 项的初始值。

接下来 $q$ 行每行包含若干个整数，表示一个操作，具体如下：

操作 $1$： 格式：`1 x y k`  含义：将区间 $[x,y]$ 内每个数乘上 $k$

操作 $2$： 格式：`2 x y k`  含义：将区间 $[x,y]$ 内每个数加上 $k$

操作 $3$： 格式：`3 x y`  含义：输出区间 $[x,y]$ 内每个数的和对 $m$ 取模所得的结果

## 输出格式

输出包含若干行整数，即为所有操作 $3$ 的结果。

## 输入输出样例 #1

### 输入 #1

```
5 5 38
1 5 4 2 3
2 1 4 1
3 2 5
1 2 4 2
2 3 5 5
3 1 4
```

### 输出 #1

```
17
2
```

## 说明/提示

【数据范围】

对于 $30\%$ 的数据：$n \le 8$，$q \le 10$。
对于 $70\%$ 的数据：$n \le 10^3 $，$q \le 10^4$。
对于 $100\%$ 的数据：$1 \le n \le 10^5$，$1 \le q \le 10^5$。

除样例外，$m = 571373$。

（数据已经过加强 ^\_^）

样例说明：

 ![](https://cdn.luogu.com.cn/upload/pic/2255.png)

故输出应为 $17$、$2$（$40 \bmod 38 = 2$）。
 */