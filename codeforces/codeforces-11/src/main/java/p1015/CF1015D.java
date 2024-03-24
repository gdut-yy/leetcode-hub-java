package p1015;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1015D {
    static int n, k;
    static long s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        s = scanner.nextLong();
        System.out.println(solve());
    }

    private static String solve() {
        if (s < k || s > k * (n - 1L)) {
            return "NO";
        }

        List<Long> ans = new ArrayList<>();
        long cur = 1;
        while (k > 0 && (s - (n - 1) >= k - 1)) {
            s -= n - 1;
            k--;
            cur = n + 1 - cur;
            ans.add(cur);
        }
        if (k != 0) {
            int d;
            if (cur == 1) {
                cur += s - k + 1;
                d = 1;
            } else {
                cur -= s - k + 1;
                d = -1;
            }
            ans.add(cur);
            while (k > 1) {
                k--;
                d = -d;
                cur += d;
                ans.add(cur);
            }
        }
        return "YES" + System.lineSeparator() +
                ans.stream().map(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
D. Walking Between Houses
https://codeforces.com/contest/1015/problem/D

灵茶の试炼 2022-07-12
题目大意：
【易错题】
输入正整数 n(2<=n<=2e9), k(1<=k<=2e5) 和 s(1<=s<=1e18)。
在数轴上有 1,2,3,...,n 共 n 个整点（位置），你一开始在 1 上。
每一步你可以移动到任意位置上（但不能原地不动），移动的距离就是两个位置的距离。
问能不能恰好走 k 步，使得移动的距离之和恰好为 s？
若不能，输出 "NO"；否则输出 "YES" 和 k 个数，表示每一步移动之后的位置。

constructive algorithms
rating 1600
https://codeforces.com/contest/1015/submission/163682002
构造方法有多种，分享下我的做法（Z 字抖动）。
大跨步：距离 = n-1
中跨步：距离 = 2~n-2
小碎步：距离 = 1
s 需要在 [k,(n-1)k] 中。
不断大跨步，每步会导致 s-=n-1，k--。
如果下一个大跨步之后不能让 s 在 [k,(n-1)k] 中，
则先走一个长为 s-k+1 的中跨步，然后剩下的都是小碎步。
实现见上面的代码。
======

input
10 2 15
output
YES
10 4

input
10 9 45
output
YES
10 1 10 1 2 1 2 1 6

input
10 9 81
output
YES
10 1 10 1 10 1 10 1 10

input
10 9 82
output
NO
 */
