package p2026;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF2026D {
    static Scanner scanner = new Scanner(System.in);
    static int n;
    static int[] a;

    public static void main(String[] args) {
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    static long[] sum, iSum, iSumSum;

    private static String solve() {
        sum = new long[n + 1];
        iSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            long v = a[i];
            sum[i + 1] = sum[i] + v;
            iSum[i + 1] = iSum[i] + (n - i) * v;
        }

        iSumSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            iSumSum[i + 1] = iSumSum[i] + iSum[n] - iSum[i];
        }

        int q = scanner.nextInt();
        long[] ans = new long[q];
        for (int i = 0; i < q; i++) {
            long l = scanner.nextLong();
            long r = scanner.nextLong();
            ans[i] = f(r) - f(l - 1);
        }
        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(System.lineSeparator()));
    }

    static long f(long k) {
        long m = n * 2L + 1;
        int i = (int) ((m - Math.ceil(Math.sqrt(m * m - k * 8))) / 2);
        k -= (m - i) * i / 2;
        return iSumSum[i] + iSum[(int) (i + k)] - iSum[i] - (n - i - k) * (sum[(int) (i + k)] - sum[i]);
    }
}
/*
D. Sums of Segments
https://codeforces.com/contest/2026/problem/D

灵茶の试炼 2024-11-28
题目大意：
输入 n(1≤n≤3e5) 和长为 n 的数组 a(-10≤a[i]≤10)。
下标从 1 开始。
定义 s(l,r) = a[l]+a[l+1]+...+a[r]。
定义长为 n*(n+1)/2 的数组 b =
[s(1,1),s(1,2),s(1,3),...,s(1,n),
s(2,2),s(2,3),s(2,4),...,s(2,n),
s(3,3),s(3,4),s(3,5),...,s(3,n),
...
s(n,n)]
然后输入 q(1≤q≤3e5) 和 q 个询问。
每个询问输入两个数 l 和 r (1≤l≤r≤n*(n+1)/2)。
输出 b[l]+b[l+1]+...b[r]。

rating 1900
转换成计算 (b[1]+b[2]+...+b[r]) - (b[1]+b[2]+...+b[l-1])。
我们需要知道：
所有左端点为 1 的子数组的元素和的元素和 tot[1]。
所有左端点为 2 的子数组的元素和的元素和 tot[2]。
...
所有左端点为 n 的子数组的元素和的元素和 tot[n]。
这可以用前缀和处理。
根据询问的 r，我们可以计算出 n+(n-1)+(n-2)+...+(n-x) <= r 的最大的 x 是多少（解一元二次不等式），这些子数组的元素和的元素和，可以直接用 tot 的前缀和算出来。
剩下的 r - (n+(n-1)+(n-2)+...+(n-x)) 个子数组的元素和的元素和，才是本题的难点。
也就是左端点为 i，右端点为 i,i+1,...,j-1 的子数组的元素和的元素和。
讨论每个元素出现了多少次：
a[i] 出现了 j-i 次。
a[i+1] 出现了 j-i-1 次。
a[i+2] 出现了 j-i-2 次。
...
a[j-1] 出现了 1 次。
所以我们本质上计算的是 a 的一个带权子数组和。
这可以用**带权前缀和**计算。
下面讨论的下标从 0 开始。
定义
sum[i+1] = sum[i] + a[i]
iSum[i+1] = iSum[i] + (n-i)*a[i]
那么从 i 到 j-1 的带权子数组和
(j-i)*a[i] + (j-i-1)*a[i+1] + ... + 1*a[j-1]
等于
iSum[j]-iSum[i] - (n-i-(j-i)) * (sum[j]-sum[i])
（梯形面积 - 矩形面积 = 三角形面积）
代码 https://codeforces.com/contest/2026/submission/290988823
代码备份（洛谷）
======

Input
4
1 2 5 10
15
1 1
1 2
1 3
1 4
1 5
1 10
5 10
6 10
2 8
3 4
3 10
3 8
5 6
5 5
1 8
Output
1
4
12
30
32
86
56
54
60
26
82
57
9
2
61
 */
