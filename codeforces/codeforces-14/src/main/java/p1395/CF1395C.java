package p1395;

import java.util.Scanner;

public class CF1395C {
    static int n, m;
    static int[] a, b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(solve1());
    }

    private static String solve() {
        label0:
        for (int m = 0; ; m++) {
            label1:
            for (int v : a) {
                for (int w : b) {
                    if ((v & w | m) == m) continue label1;
                }
                continue label0;
            }
            return String.valueOf(m);
        }
    }

    // 消掉 continue label
    private static String solve1() {
        for (int ans = 0; ; ans++) {
            if (check1(ans)) {
                return String.valueOf(ans);
            }
        }
    }

    // 是否全部 a[i] 均满足 check2
    private static boolean check1(int ans) {
        for (int i = 0; i < n; i++) {
            if (!check2(ans, i)) return false;
        }
        return true;
    }

    // 是否存在 b[j] 满足 (a[i] & b[j] | ans) == ans
    private static boolean check2(int ans, int i) {
        for (int j = 0; j < m; j++) {
            if ((a[i] & b[j] | ans) == ans) return true;
        }
        return false;
    }
}
/*
C. Boboniu and Bit Operations
https://codeforces.com/contest/1395/problem/C

灵茶の试炼 2022-09-19
题目大意：
输入 n(≤200) 和 m(≤200)，长为 n 的数组 a(0≤a[i]<512) 和长为 m 的数组 b(0≤b[i]<512)。
对于每个 a[i]，你可以选择任意一个 b[j]，组成 c[i]=a[i]&b[j]。
输出 c 数组的所有元素按位或的最小值。
思考：如果值域是 1e9 要怎么做？

rating 1600
https://codeforces.com/contest/1395/submission/148506798
方法一：暴力枚举
提示 1：枚举答案 ans。
提示 2：这意味着 c[i] | ans = ans。
提示 3：对每个 a[i]，枚举看是否存在 a[j] 使得 (a[i]&b[j]) | ans = ans。
时间复杂度 O(nmU)，U=512。
方法二：从高到低逐个考虑每个比特位
如果答案的某个比特位可以是 0，那么需要更新 a[i] 可以选择的 b[j] 的集合。
时间复杂度 O(nmlogU)，U=512。
可以参考 https://www.luogu.com.cn/blog/yltx/solution-cf1395c
======

input
4 2
2 6 4 0
2 4
output
2

input
7 6
1 9 1 9 8 1 0
1 1 4 5 1 4
output
0

input
8 5
179 261 432 162 82 43 10 38
379 357 202 184 197
output
147
 */
