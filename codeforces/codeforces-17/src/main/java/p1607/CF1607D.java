package p1607;

import java.io.IOException;
import java.util.Scanner;

public class CF1607D {
    static int n;
    static int[] a;
    static char[] s;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            s = scanner.next().toCharArray();
            System.out.println(solve());
        }
    }

    private static String solve() {
        int[] cnt = new int[n + 1];
        int[] cnt2 = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int v = a[i];
            if (s[i] == 'B') {
                if (v < 1) {
                    return "NO";
                }
                cnt[Math.min(v, n)]++;
            } else {
                if (v > n) {
                    return "NO";
                }
                cnt2[Math.max(v, 1)]++;
            }
        }
        int left = 0;
        for (int i = 1; i <= n; i++) {
            left += 1 - cnt[i];
            if (left < 0) {
                return "NO";
            }
        }
        left = 0;
        for (int i = n; i > 0; i--) {
            left += 1 - cnt2[i];
            if (left < 0) {
                return "NO";
            }
        }
        return "YES";
    }
}
/*
D. Blue-Red Permutation
https://codeforces.com/contest/1607/problem/D

灵茶の试炼 2024-04-09
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(1≤n≤2e5) 和长为 n 的数组 a(-1e9≤a[i]≤1e9)，长为 n 的字符串 s，仅包含 'B' 和 'R'。
每次操作，你可以选择一个下标 i。
如果 s[i]=B，把 a[i] 减少 1。
如果 s[i]=R，把 a[i] 增加 1。
能否在执行若干次（或者零次）操作后，把 a 变成一个 1 到 n 的排列？
输出 YES 或 NO。

rating 1300
由于 B（对应的数）可以减少，R（对应的数）可以增大，考虑最后操作成：任意 B（对应的数）小于任意 R（对应的数）。
这样就可以分别处理 B 和 R。
先说 B。
如果 a[i]<1 直接输出 NO。
否则超过 n 的数先变成 n，统计 v=min(a[i],n) 的出现次数 cnt[v]。
由于只能变小不能变大，相当于一条路上有 n 个停车位，车只能向左开，这些车是否都有位置停？
从 i=1 开始遍历到 n，同时维护空位个数 left。每遍历到一个 i 就先把 left 增加 1，然后减少 cnt[i]，意思是把位置 = i 的车开到 <=i 的空位中。
如果 left < 0 则输出 NO。
R 的处理方式同理。
如果 a[i]>n 直接输出 NO。
否则低于 1 的数先变成 1，统计 v=max(a[i],1) 的出现次数 cnt2[v]。
由于只能变大不能变小，相当于一条路上有 n 个停车位，车只能向右开，这些车是否都有位置停？
从 i=n 开始遍历到 1，同时维护空位个数 left。每遍历到一个 i 就先把 left 增加 1，然后减少 cnt2[i]，意思是把位置 = i 的车开到 >=i 的空位中。
如果 left < 0 则输出 NO。
时间复杂度：O(n)。
https://codeforces.com/problemset/submission/1607/255612007
======

Input
8
4
1 2 5 2
BRBR
2
1 1
BB
5
3 1 4 2 5
RBRRB
5
3 1 3 1 3
RBRRB
5
5 1 5 1 5
RBRRB
4
2 2 2 2
BRBR
2
1 -2
BR
4
-2 -1 4 0
RRRR
Output
YES
NO
YES
YES
NO
YES
YES
YES
 */
