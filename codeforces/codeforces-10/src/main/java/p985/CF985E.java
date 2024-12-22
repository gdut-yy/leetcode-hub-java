package p985;

import java.util.Arrays;
import java.util.Scanner;

public class CF985E {
    static int n, k, d;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        d = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        Arrays.sort(a);
        boolean[] f = new boolean[n + 1];
        f[0] = true;
        int left = 0, cnt = 0;
        for (int i = k; i <= n; i++) {
            if (f[i - k]) {
                cnt++;
            }
            while (a[i - 1] - a[left] > d) {
                if (f[left]) {
                    cnt--;
                }
                left++;
            }
            f[i] = cnt > 0;
        }
        return f[n] ? "YES" : "NO";
    }
}
/*
E. Pencils and Boxes
https://codeforces.com/contest/985/problem/E

灵茶の试炼 2024-07-25
题目大意：
输入 n k(1≤k≤n≤5e5) d(0≤d≤1e9) 和长为 n 的数组 a(1≤a[i]≤1e9)。
你需要把 a 分成若干个集合，每个集合的大小至少为 k，且同一集合中任意两数之差至多为 d。
能否做到？输出 YES 或 NO。

rating 2100
把 a 从小到大排序后，如果分组方案存在，那么一定有一个分组方案是，同一组的数在 a 中是连续的。因为交换两个不同组的数，一定不会变得更优。
定义 f[i] 表示能否把 a 的前 i 个数分组。
f[0] = true。
f[i] = 是否存在 j 满足 f[j] 为 true 且 i - j >= k 且 a[i-1] - a[j] <= d。
用前缀和或者滑窗优化，维护窗口内的 true 的个数。如果个数 > 0 则 f[i] = true。
答案为 f[n]。
代码 https://codeforces.com/contest/985/submission/269815919
======

Input
6 3 10
7 2 7 7 4 2
Output
YES

Input
6 2 3
4 5 3 13 4 10
Output
YES

Input
3 2 5
10 16 22
Output
NO
 */