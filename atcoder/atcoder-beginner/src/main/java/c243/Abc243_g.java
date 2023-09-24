package c243;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc243_g {
    static long x;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            x = scanner.nextLong();
            System.out.println(solve());
        }
    }

    static long[] f;

    private static String solve() {
        if (f == null) {
            f = new long[54773];
            f[1] = 1;
            int rt = 2;
            for (int i = 2; i < f.length; i++) {
                f[i] = f[i - 1];
                if (rt * rt == i) {
                    f[i] += f[rt];
                    rt++;
                }
            }
        }

        long m = (long) Math.sqrt(x);
        if (m * m > x) {
            m--;
        }
        long ans = 0;
        for (int i = 1; (long) i * i <= m; i++) {
            ans += f[i] * (m - (long) i * i + 1);
        }
        return String.valueOf(ans);
    }
}
/*
G - Sqrt
https://atcoder.jp/contests/abc243/tasks/abc243_g

灵茶の试炼 2023-09-08
题目大意：
输入 T(≤20) 表示 T 组数据。
每组数据输入 X(1≤X≤9e18)。
请构造一个长为 10^100 的数组 a，满足：
1. a[i] 均为正整数。
2. a[0] = X。
3. a[i] * a[i] <= a[i-1]。
输出你可以构造出多少个不同的数组。

下标从 0 开始。
提示 1：
枚举 a[2]，那么 a[1] 的范围就确定了。
设 m = floor(sqrt(a[0]))。
那么 a[1] 的范围就是 [a[2]*a[2], m]，这一共有 m-a[2]*a[2]+1 个数，这些数都可以是 a[1]。
提示 2：
定义 f[i] 表示序列的首项为 i 时，可以构造出多少个不同的数组。
根据提示 1，有
f[i] = sum(f[j] * (m-j*j+1))，这里 1 <= j <= sqrt(m)。
提示 3：
预处理出 f[1] 到 f[54772]，就可以直接用上式算出 f[X]。这里 54772 = floor(pow(9e18, 0.25))。
预处理可以不用像上式那样复杂，枚举 a[1]，可以得到
f[i] = sum(f[j])，这里 1 <= j <= sqrt(i)。
这个式子又可以化简成
f[i] = f[i-1] + (i 是完全平方数 ? f[floor(sqrt(i))] : 0)
https://atcoder.jp/contests/abc243/submissions/45083883
======

Input 1
4
16
1
123456789012
1000000000000000000
Output 1
5
1
4555793983
23561347048791096
 */