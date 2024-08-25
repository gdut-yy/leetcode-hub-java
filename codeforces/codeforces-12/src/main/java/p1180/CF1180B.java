package p1180;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1180B {
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
        int t = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] >= 0) {
                a[i] = -a[i] - 1;
            }
            if (a[i] < a[t]) {
                t = i;
            }
        }
        if (n % 2 == 1) {
            a[t] = -a[t] - 1;
        }
        return Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
B. Nick and Array
https://codeforces.com/contest/1180/problem/B

灵茶の试炼 2023-10-31
题目大意：
输入 n(1≤n≤1e5) 和长为 n 的数组 a(-1e6≤a[i]≤1e6)。
你可以执行如下操作任意次：
选择一个 a[i]，把它替换为 -a[i]-1。
你需要让所有数的乘积最大。
输出修改后的数组。

rating 1500
只看绝对值的话，对非负数操作是更优的。
操作后所有元素都是负数了。
如果 n 是偶数，那么这样就行。
如果 n 是奇数，需要选一个绝对值最大的负数操作一下。
https://codeforces.com/contest/1180/submission/230002609
======

input
4
2 2 2 2
output
-3 -3 -3 -3

input
1
0
output
0

input
3
-3 -3 2
output
-3 -3 2
 */
