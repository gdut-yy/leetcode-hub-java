package p1283;

import java.util.Scanner;

public class CF1283E {
    static int n;
    static int[] a;

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
        int[] cnt = new int[n + 1];
        for (int v : a) {
            cnt[v]++;
        }

        int low = 0, up = 0;
        int prevLow = -1, prevUp = -1;
        for (int i = 0; i < n + 1; i++) {
            int c = cnt[i];
            if (c > 0 && i > prevLow + 1) {
                prevLow = i + 1;
                low++;
            }
            if (c > 0 && i > prevUp + 1) {
                prevUp = i - 1;
                up++;
                c--;
            }
            if (c > 0 && i == prevUp + 1) {
                prevUp = i;
                up++;
                c--;
            }
            if (c > 0 && i == prevUp) {
                prevUp = i + 1;
                up++;
            }
        }
        return low + " " + up;
    }
}
/*
E. New Year Parties
https://codeforces.com/contest/1283/problem/E

灵茶の试炼 2022-06-24
题目大意：
输入 n(<=2e5) 和长为 n 的数组 a(1<=a[i]<=n)。
对于每个 a[i]，你可以将其 +1 或 -1，每个 a[i] 至多修改一次。
输出修改后的 a 的不同元素个数的最小值和最大值。
不同元素个数即 len(set(a))。

rating 1800
https://codeforces.com/contest/1283/submission/161609016
贪心。先求出 cnt[x] 表示 x 出现的次数。
最小值的操作方案：
从小往大遍历 cnt[x]，用一个变量 prev 记录上一组被修改的数的结果。
如果 prev 是 x-1 或 x，则将 x 并入上一组，否则将 x 都 +1。
最大值的操作方案：
从小往大遍历 cnt[x]，用一个变量 prev 记录上一个被修改的数的结果。
如果 prev < x-1，则将一个 x 减一；
如果还有不止一个 x，则将一个 x 加一。
具体实现见代码。
---
扩展 1：如果改成每个数都有一个变动区间 [left[i], right[i]] 呢？
扩展 2：如果改成可以动态添加删除 a 中的数字，每次添加删除后输出答案呢？
======

input
4
1 2 4 4
output
2 4

input
9
1 1 8 8 8 4 4 4 4
output
3 8

input
7
4 3 7 1 4 3 3
output
3 6
 */
