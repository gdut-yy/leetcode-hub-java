package p1095;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1095C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        System.out.println(solve(n, k));
    }

    private static String solve(int n, int k) {
        if (k > n || k < Integer.bitCount(n)) {
            return "NO";
        }

        int[] ans = new int[k];
        Arrays.fill(ans, 1);
        n -= k;
        for (int i = 0; i < k; i++) {
            while (ans[i] <= n) {
                n -= ans[i];
                ans[i] = ans[i] << 1;
            }
            if (n == 0) {
                break;
            }
        }
        return "YES" + System.lineSeparator()
                + Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
C. Powers Of Two
https://codeforces.com/contest/1095/problem/C

灵茶の试炼 2023-04-24
题目大意：
输入 n(1≤n≤1e9) k(1≤k≤2e5)。
把 n 分解为 k 个正整数，要求这些数都是 pow(2,i)，即 1,2,4,8,……
如果无法做到，输出 NO，否则输出 YES 和这 k 个数。

rating 1400
https://codeforces.com/contest/1095/submission/202908506
什么时候输出 NO？
k > n，或者 k < n 的二进制中的 1 的个数。
否则一定可以，因为可以把 2^i 拆分成两个更小的 2^(i-1)。
也可以先从 n 中减去 k 个 1，得到 n'，表示剩余需要分配的量。
然后初始化所有 ans[i]=1，
从 a[1]=1 出发，如果 a[1]<=n'，那么把 a[1] 从 1 变成 2，n'-=1
如果 a[1]<=n'，那么把 a[1] 从 2 变成 4，n'-=2。
如此不断循环直到 a[1]>n'，
再尝试让下一个 a[2] 不断变大，……
======

input
9 4
output
YES
1 2 2 4

input
8 1
output
YES
8

input
5 1
output
NO

input
3 7
output
NO
 */
