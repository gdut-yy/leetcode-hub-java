package p1469;

import java.util.Scanner;

public class CF1469C {
    static int n, k;
    static int[] h;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            k = scanner.nextInt();
            h = new int[n];
            for (int i = 0; i < n; i++) {
                h[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        k--;
        int l = h[0], r = h[0];
        for (int i = 1; i < n - 1; i++) {
            l = Math.max(l - k, h[i]);
            r = Math.min(r, h[i]) + k;
            if (l > r) {
                return "NO";
            }
        }
        if (l - k > h[n - 1] || r + k < h[n - 1]) {
            return "NO";
        }
        return "YES";
    }
}
/*
C. Building a Fence
https://codeforces.com/contest/1469/problem/C

灵茶の试炼 2022-08-08
题目大意：
输入 t(≤1e4) 表示 t 组数据。
每组数据输入 n(2≤n≤2e5) 和 k(2≤k≤1e8) 和长为 n 的数组 h(0≤h[i]≤1e8)。
所有数据的 n 之和不超过 2e5。
你需要在地面上修一个长为 n 的栅栏，地面的海拔高度用 h 数组表示。
你有 n 块高度均为 k 的木板，你需要用这些木板组成栅栏，要求如下：
1. 相邻两块木板的接触长度至少为 1；
2. 第一块和最后一块木板必须正好与地面接触；
3. 其余木板可以与地面接触，或者位于地面之上，每块木板与地面的距离不能超过 k-1。
如果可以修栅栏，输出 YES，否则输出 NO。

rating 1600
https://codeforces.com/contest/1469/submission/167464872
上下界分析。
维护 l 表示当前木板下边缘的最小海拔，r 表示当前木板下边缘的最大海拔。
对于每个 h[i] 去更新 l 最小能是多少（不能低于 h[i]），更新 r 最大能是多少（不能高于 h[i]+k-1）。
如果更新过程中 l > r 则输出 NO。
如果最后一块木板无法放在地上则输出 NO。
具体实现见代码。
======

input
3
6 3
0 0 2 5 1 1
2 3
0 2
3 2
3 0 2
output
YES
YES
NO
 */