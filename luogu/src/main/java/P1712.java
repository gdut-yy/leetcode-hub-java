import base.Unaccepted;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

@Unaccepted
public class P1712 {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    record pair(int l, int r) {
    }

    private static void solve() {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        pair[] a = new pair[n];
        for (int i = 0; i < n; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            a[i] = new pair(l, r);
        }

        Set<Integer> set = new HashSet<>(n * 2);
        for (pair p : a) {
            set.add(p.l);
            set.add(p.r);
        }
        Arrays.sort(a, Comparator.comparingInt(p -> p.r - p.l));
        List<Integer> b = new ArrayList<>(set);
        b.sort(null);
        int k = b.size();

        LazyInfoSegmentTree seg = new LazyInfoSegmentTree(k - 1);
        seg.build(new int[k], 1, 0, k - 1);
        int inf = (int) 2e9;
        int ans = inf;
        int left = 0;
        for (pair p : a) {
            seg.modify(1, 0, k - 1, searchInts(b, p.l), searchInts(b, p.r), 1);
            while (seg.info[1].mx >= m) {
                pair q = a[left];
                ans = Math.min(ans, p.r - p.l - (q.r - q.l));
                seg.modify(1, 0, k - 1, searchInts(b, q.l), searchInts(b, q.r), -1);
                left++;
            }
        }
        if (ans == inf) {
            ans = -1;
        }
        out.println(ans);
    }

    private static int searchInts(List<Integer> a, int key) {
        int l = 0, r = a.size();
        while (l < r) {
            int m = l + (r - l) / 2;
            if (a.get(m) >= key) r = m;
            else l = m + 1;
        }
        return l;
    }

    // 线段树模板，只需要实现 mergeInfo 和 _do，其余都是固定的
    static class LazyInfoSegmentTree {
        static class Info {
            int mx, lazy;

            public Info(int mx, int lazy) {
                this.mx = mx;
                this.lazy = lazy;
            }
        }

        Info mergeInfo(Info a, Info b) {
            int mx = Math.max(a.mx, b.mx);
            return new Info(mx, 0);
        }

        void _do(int p, int qv) {
            info[p].mx += qv;
            info[p].lazy += qv;
        }

        int n;
        Info[] info;

        public LazyInfoSegmentTree(int n) {
            this.n = n;
            info = new Info[4 * n];
            Arrays.setAll(info, e -> new Info(0, 0));
        }

        void build(int[] A, int p, int l, int r) {
            if (l == r) {
                info[p] = new Info(0, 0);
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

        void spread(int p) {
            if (info[p].lazy == 0) return;
            _do(p << 1, info[p].lazy);
            _do(p << 1 | 1, info[p].lazy);
            info[p].lazy = 0;
        }

        void modify(int p, int l, int r, int ql, int qr, int qv) {
            if (ql <= l && r <= qr) {
                _do(p, qv);
                return;
            }
            spread(p);
            int m = (l + r) >> 1;
            if (ql <= m) modify(p << 1, l, m, ql, qr, qv);
            if (qr > m) modify(p << 1 | 1, m + 1, r, ql, qr, qv);
            maintain(p);
        }

        Info query(int p, int l, int r, int ql, int qr) {
            if (ql <= l && r <= qr) {
                return info[p];
            }
            spread(p);
            int m = (l + r) >> 1;
            if (qr <= m) return query(p << 1, l, m, ql, qr);
            if (ql > m) return query(p << 1 | 1, m + 1, r, ql, qr);
            return mergeInfo(query(p << 1, l, m, ql, qr), query(p << 1 | 1, m + 1, r, ql, qr));
        }
    }
}
/*
https://www.luogu.com.cn/problem/P1712

灵茶の试炼 2025-06-12
输入 n m(1≤m≤n≤5e5) 和 n 个闭区间，数据范围 $[0,1e9]$。
从这 n 个区间中，选择 m 个区间，要求这 m 个区间的交集不为空。
输出这 m 个区间的「最大区间长度减去最小区间长度」的最小值。无解输出 -1。
注：区间长度为右端点减去左端点。

选 m 个区间，交集不为空，等价于选择若干区间，执行区间 +1 后，整体最大值 = m。
这个最大值，一定来自某 m 个区间。
把区间按照长度排序。
然后跑不定长滑窗，进入窗口的区间执行区间 +1。
然后 while 整体最大值 >= m，则更新最小值，把左端点区间执行区间 -1，移除窗口。
代码 https://www.luogu.com.cn/paste/zqenvxzl
======

# P1712 [NOI2016] 区间

## 题目描述

在数轴上有 $n$ 个闭区间从 $1$ 至 $n$ 编号，第 $i$ 个闭区间为 $[l_i,r_i]$ 。

现在要从中选出 $m$ 个区间，使得这 $m$ 个区间共同包含至少一个位置。换句话说，就是使得存在一个 $x$ ，使得对于每一个被选中的区间 $[l_i,r_i]$，都有 $l_i \leq x \leq r_i$ 。

对于一个合法的选取方案，它的花费为被选中的最长区间长度减去被选中的最短区间长度。

区间 $[l_i,r_i]$ 的长度定义为 $(r_i-l_i)$ ，即等于它的右端点的值减去左端点的值。

求所有合法方案中最小的花费。如果不存在合法的方案，输出 $-1$。

## 输入格式

第一行包含两个整数，分别代表 $n$ 和 $m$。

第 $2$ 到第 $(n + 1)$ 行，每行两个整数表示一个区间，第 $(i + 1)$ 行的整数 $l_i, r_i$ 分别代表第 $i$ 个区间的左右端点。

## 输出格式

输出一行一个整数表示答案。

## 输入输出样例 #1

### 输入 #1

```
6 3
3 5
1 2
3 4
2 2
1 5
1 4
```

### 输出 #1

```
2
```

## 说明/提示

#### 样例输入输出 1 解释

![](https://cdn.luogu.com.cn/upload/image_hosting/qoddox9k.png)

 如图，当 $n=6$，$m=3$ 时，花费最小的方案是选取 $[3,5],[3,4],[1,4]$ 这三个区间，它们共同包含了 $4$ 这个位置，所以是合法的。其中最长的区间是 $[1, 4]$，最短的区间是 $[3, 4]$，所以它的花费是 $(4 - 1) - (4 - 3) = 2$。

#### 数据规模与约定

本题共 20 个测试点，各测试点信息如下表。
| 测试点编号 | $ n= $ | $ m= $ | $ l_i,r_i $ |
|:-:|:-:|:-:|:-:|
| 1 | $ 20 $ | $ 9 $ | $ 0 \le l_i \le r_i \le 100 $ |
| 2 | $ 20 $ | $ 10 $ | $ 0 \le l_i \le r_i \le 100 $ |
| 3 | $ 199 $ | $ 3 $ | $ 0 \le l_i \le r_i \le 100000 $ |
| 4 | $ 200 $ | $ 3 $ | $ 0 \le l_i \le r_i \le 100000 $ |
| 5 | $ 1000 $ | $ 2 $ | $ 0 \le l_i \le r_i \le 100000 $ |
| 6 | $ 2000 $ | $ 2 $ | $ 0 \le l_i \le r_i \le 100000 $ |
| 7 | $ 199 $ | $ 60 $ | $ 0 \le l_i \le r_i \le 5000 $ |
| 8 | $ 200 $ | $ 50 $ | $ 0 \le l_i \le r_i \le 5000 $ |
| 9 | $ 200 $ | $ 50 $ | $ 0 \le l_i \le r_i \le 10^9 $ |
| 10 | $ 1999 $ | $ 500 $ | $ 0 \le l_i \le r_i \le 5000 $ |
| 11 | $ 2000 $ | $ 400 $ | $ 0 \le l_i \le r_i \le 5000 $ |
| 12 | $ 2000 $ | $ 500 $ | $ 0 \le l_i \le r_i \le 10^9 $ |
| 13 | $ 30000 $ | $ 2000 $ | $ 0 \le l_i \le r_i \le 100000 $ |
| 14 | $ 40000 $ | $ 1000 $ | $ 0 \le l_i \le r_i \le 100000 $ |
| 15 | $ 50000 $ | $ 15000 $ | $ 0 \le l_i \le r_i \le 100000 $ |
| 16 | $ 100000 $ | $ 20000 $ | $ 0 \le l_i \le r_i \le 100000 $ |
| 17 | $ 200000 $ | $ 20000 $ | $ 0 \le l_i \le r_i \le 10^9 $ |
| 18 | $ 300000 $ | $ 50000 $ | $ 0 \le l_i \le r_i \le 10^9 $ |
| 19 | $ 400000 $ | $ 90000 $ | $ 0 \le l_i \le r_i \le 10^9 $ |
| 20 | $ 500000 $ | $ 200000 $ | $ 0 \le l_i \le r_i \le 10^9 $ |

对于全部的测试点，保证 $1 \leq m \leq n$，$1 \leq n \leq 5 \times 10^5$，$1 \leq m \leq 2 \times 10^5$，$0 \leq l_i \leq r_i \leq 10^9$。
 */