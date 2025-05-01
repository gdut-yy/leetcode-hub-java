package p2040;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF2040C {
    static int n;
    static long k;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            k = scanner.nextLong();
            System.out.println(solve());
        }
    }

    private static String solve() {
        k--;
        // if k>>(n-1) > 0 {
        if ((k >> Math.min(63, n - 1)) > 0) {
            return "-1";
        }

        int[] a = new int[n];
        int l = 0, r = n - 1;
        for (int i = 1; i <= n; i++) {
            // if k<<1>>(n-i)&1 == 0 {
            if ((k << 1 >> Math.min(63, n - i) & 1) == 0) {
                a[l] = i;
                l++;
            } else {
                a[r] = i;
                r--;
            }
        }
        return Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
C. Ordered Permutations
https://codeforces.com/contest/2040/problem/C

灵茶の试炼 2024-12-24
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(1≤n≤2e5) 和 k(1≤k≤1e12)。
考虑 1~n 的一个排列 p。
计算 p 的所有非空连续子数组的最小值的和，记作 S(p)。
在所有 1~n 的排列中，设 S(p) 的最大值为 maxS。
对于所有满足 S(p) = maxS 的排列 p，输出其中字典序第 k 小的排列 p。
如果满足 S(p) = maxS 的排列个数小于 k，输出 -1。

rating 1600
1 放在哪？
如果 1 放在下标 i 处，那么包含 1 的子数组有多少个？
考虑贡献法，子数组左端点有 i+1 个，右端点有 n-i 个，一共有 (i+1)*(n-i) 个。
当 i=0 或者 n-1 时，(i+1)*(n-i) 取到最小值。
所以 1 放在最左边或者最右边，2 种方案。
此时问题变成 n-1 个数的子问题。
依此类推，一共有 2^(n-1) 种最优排列方案。
如果 k > 2^(n-1)，输出 -1。
根据 k-1 的二进制，我们可以知道每个数放左边还是右边。
枚举 i=1,2,3,...,n-1，如果 (k-1)>>(n-i-1)&1 是 0，那么 i 放在左边，否则放在右边。
最后的 n 放在剩下的位置上。也可以不特判 i=n 的情况，具体见代码。
代码 https://codeforces.com/contest/2040/submission/297373047
代码备份（洛谷）
======

Input
6
3 2
3 3
4 11
4 6
6 39
7 34
Output
1 3 2
2 3 1
-1
2 4 3 1
-1
2 3 4 5 7 6 1


1
70 376581200601
 */
