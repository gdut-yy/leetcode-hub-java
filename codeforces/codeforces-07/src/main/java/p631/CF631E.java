package p631;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class CF631E {
    static int n;
    static int[] a;

    record vec(long x, long y) {
        vec sub(vec b) {
            return new vec(x - b.x, y - b.y);
        }

        long dot(vec b) {
            return x * b.x + y * b.y;
        }

        long det(vec b) {
            return x * b.y - y * b.x;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        List<vec> q = new ArrayList<>();
        q.add(new vec(-1, 0)); // s[-1] = 0
        long tot = 0, s = 0;
        for (int i = 0; i < n; i++) {
            tot += a[i] * (i + 1L);
            s += a[i];
            vec v = new vec(i, -s); // 由于 i 是单调递增的，求上凸包无需排序
            while (q.size() > 1 && q.getLast().sub(q.get(q.size() - 2)).det(v.sub(q.getLast())) >= 0) {
                q.removeLast();
            }
            q.addLast(v);
        }

        s = 0;
        long mx = 0;
        for (int i = 0; i < n; i++) {
            long x = a[i];
            vec p = new vec(x, 1);
            int j = sortSearch(q.size() - 1, m -> {
                return p.dot(q.get(m)) > p.dot(q.get(m + 1));
            }); // 二分找峰顶
            s += x;
            mx = Math.max(mx, p.dot(q.get(j)) - x * i + s);
        }
        long ans = tot + mx;
        return String.valueOf(ans);
    }

    static int sortSearch(int n, Function<Integer, Boolean> f) {
        int l = 0, r = n;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (f.apply(mid)) r = mid;
            else l = mid + 1;
        }
        return l;
    }
}
/*
E. Product Sum
https://codeforces.com/contest/631/problem/E

灵茶の试炼 2025-04-11
题目大意：
输入 n(2≤n≤2e5) 和长为 n 的数组 a(-1e6≤a[i]≤1e6)。
执行如下操作恰好一次：
把 a[i] 从 i 移动到 j。
可以原地不动，即 i = j。
输出 a[1] * 1 + a[2] * 2 + ... + a[n] * n 的最大值。

rating 2600
https://www.luogu.com.cn/article/pnxayvgt
======

Input
4
4 3 2 5
Output
39

Input
5
1 1 2 7 1
Output
49

Input
3
1 1 2
Output
9
 */
