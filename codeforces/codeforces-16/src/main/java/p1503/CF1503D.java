package p1503;

import java.util.Scanner;

public class CF1503D {
    static int n;
    static int[] to, pos;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        to = new int[n * 2 + 1];
        pos = new int[n * 2 + 1];
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            pos[y] = 1;
            to[x] = y;
            to[y] = x;
        }
        System.out.println(solve());
    }

    private static String solve() {
        long ans = 0;

        int[] a = new int[n];
        int al = 0, ar = n - 1;
        int[] b = new int[n];
        int bl = 0, br = n - 1;
        boolean[] vis = new boolean[n * 2 + 2];
        int mn = 1, mx = n * 2;
        while (mn < mx) {
            int[] cnt = new int[2];
            int t = mn;
            while (t > 0) {
                int last = 0;
                for (; mn <= t; mn++) {
                    if (vis[mn]) {
                        continue;
                    }
                    cnt[pos[mn]]++;

                    vis[mn] = true;
                    a[al] = mn;
                    al++;

                    last = to[mn];
                    vis[last] = true;
                    b[bl] = last;
                    bl++;
                }
                if (last == 0) {
                    break;
                }

                t = last;
                last = 0;
                for (; mx >= t; mx--) {
                    if (vis[mx]) {
                        continue;
                    }
                    cnt[pos[mx]]++;

                    vis[mx] = true;
                    a[ar] = mx;
                    ar--;

                    last = to[mx];
                    vis[last] = true;
                    b[br] = last;
                    br--;
                }
                t = last;
            }
            ans += Math.min(cnt[0], cnt[1]);
        }

        reverse(b);
        if (!isSorted(a) || !isSorted(b)) {
            return "-1";
        }
        return String.valueOf(ans);
    }

    static void reverse(int[] a) {
        for (int l = 0, r = a.length - 1; l < r; l++, r--) {
            int tmp = a[l];
            a[l] = a[r];
            a[r] = tmp;
        }
    }

    static boolean isSorted(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] > a[i]) return false;
        }
        return true;
    }
}
/*
D. Flip the Cards
https://codeforces.com/contest/1503/problem/D

灵茶の试炼 2024-09-13
题目大意：
输入 n(1≤n≤2e5) 和 n 个数对 (ai,bi)，保证这 2n 个数在 [1,2n] 中且互不相同。
有 n 张牌，第 i 张牌的正面是 ai，反面是 bi。
你可以随意排列这些牌，也可以翻转牌（交换 ai 和 bi）。
要使 a 是递增的，b 是递减的，最少要翻多少张牌？
如果无法做到，输出 -1。

rating 2600
做法不止一种，下面是我想出来的构造方法。
举例说明。
从写有 1 的牌开始。
这张牌要么在最左边（1 在上），要么在最右边（1 在下）。
不妨设其在最左边。
假设 1 反面的数字是 8。
现在牌是这样放的（下划线表示空位）：
1 _ _ _ _
8 _ _ _ _
比 8 大的那些数应该在哪？
假如最大的数是 10，那么 10 只能在最右边且朝上。9 也同理。
假设 10 的反面的数字是 3，9 的反面的数字是 4。
现在牌是这样放的：
1 _ _ 9 10
8 _ _ 4 3
比 3 小的数（2）应该在哪？
只能在 1 右边且朝上。
假设其反面为 7。
现在牌是这样放的：
1 2 _ 9 10
8 7 _ 4 3
不断重复上述过程，直到没有必须放在左/右的牌。
上述过程中，如果放了 x 张牌，其中翻转了 k 张牌，那么不翻转这 k 张牌，改为翻转另外 x-k 张牌，也可以满足题目要求。
所以把 min(k, x-k) 加入答案。
如果发现没有必须放在左/右的牌，那么剩余问题变成一个规模更小的子问题，迭代解决。
最后判断两个数组是否有序。
代码 https://codeforces.com/contest/1503/submission/280933172
======

Input
5
3 10
6 4
1 9
5 8
2 7
Output
2

Input
2
1 2
3 4
Output
-1

Input
3
1 2
3 6
4 5
Output
-1
 */
