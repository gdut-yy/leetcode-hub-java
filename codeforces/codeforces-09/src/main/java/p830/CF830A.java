package p830;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CF830A {
    static int n, k, p;
    static int[] a, b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        p = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        b = new int[k];
        for (int i = 0; i < k; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        Arrays.sort(a);

        int left = 0;
        int right = (int) 2e9;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (checkMid(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return String.valueOf(left);
    }

    static boolean checkMid(int t) {
        List<int[]> ps = new ArrayList<>();
        for (int bi : b) {
            int q = Math.abs(bi - p);
            int d = t - q;
            if (d >= 0) {
                ps.add(new int[]{bi - d, bi + d});
            }
        }
        ps.sort((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return Integer.compare(o1[0], o2[0]);
            }
            return Integer.compare(o1[1], o2[1]);
        });

        int i = -1;
        for (int ai : a) {
            for (i++; i < ps.size() && ps.get(i)[1] < ai; i++) {
            }
            if (i == ps.size() || ai < ps.get(i)[0]) {
                return false;
            }
        }
        return true;
    }
}
/*
A. Office Keys
https://codeforces.com/contest/830/problem/A

灵茶の试炼 2022-04-22
题目大意：
在一条直线上有 n(<=1000) 个员工和 k(n<=k<=2000) 把钥匙。
n 个人的坐标为 a[i](1~1e9), k 把钥匙的坐标为 b[j](1~1e9)。
办公室位于坐标 p(1~1e9)。
员工的速度为一个单位。所有员工都必须要取得一把钥匙才能进入办公室。
一个坐标上的钥匙被拿了就没有了。
输出所有人均到达办公室的最短时间。

rating 1800
https://www.luogu.com.cn/blog/endlesscheng/solution-cf830a
https://www.luogu.com.cn/problem/solution/CF830A
二分贪心的话，可以做到 O((klogk+n) * log(2e9))
二分答案，即时间上限，然后把时间拆成两个部分：人拿钥匙的时间，钥匙到办公室的时间。
对于一把钥匙来说，其到办公室的时间是固定的，由于我们二分了时间上限，所以一把钥匙会对应着一个坐标区间，在这个区间内的人可以在时限内拿到该钥匙后再去办公室。
这样就变成了一个经典的区间贪心问题：有若干个区间和 n 个点，能否使每个点都落到一个区间内，且一个区间至多包含一个点？
贪心策略是把区间按照右端点从小到大排序，右端点相同的按照左端点从小到大排序，然后从小到大遍历所有点，同时遍历区间找能否包含该点。
遍历区间的过程可以用一个下标记录，在包含了一个点后，下一个点对应的区间可以从上一个点之后开始。
---
钥匙题专项训练
https://www.luogu.com.cn/blog/666666new/keys-tm
======

input
2 4 50
20 100
60 10 40 80
output
50

input
1 2 10
11
15 7
output
7

2 5 15
10 4
29 23 21 22 26
23
 */
