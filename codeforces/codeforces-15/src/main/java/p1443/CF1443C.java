package p1443;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class CF1443C {
    static int n;
    static int[] a, b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            a = new int[n];
            b = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            for (int i = 0; i < n; i++) {
                b[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        Integer[] ids = new Integer[n];
        for (int i = 0; i < n; i++) ids[i] = i;
        Arrays.sort(ids, Comparator.comparingInt(o -> a[o]));

        long s = 0;
        for (int i = 0; i < n; i++) {
            s += b[i];
        }

        long ans = s;
        for (Integer id : ids) {
            s -= b[id];
            ans = Math.min(ans, Math.max(a[id], s));
        }
        return String.valueOf(ans);
    }
}
/*
C. The Delivery Dilemma
https://codeforces.com/contest/1443/problem/C

灵茶の试炼 2023-10-23
题目大意：
输入 T(≤2e5) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(1≤n≤2e5) 和两个长为 n 的数组 a b，元素范围在 [1,1e9]。
把下标 0,1,2,...,n-1 分成两组，记作 P 和 Q。
对于 P 中的下标 i，计算 a[i] 的最大值 m。
对于 Q 中的下标 j，计算 b[j] 的和 s。
输出 max(m, s) 的最小值。
例如 a=[3,7,4,5], b=[2,1,2,4]，如果 P=[0,3], Q=[1,2]，那么 m=5, s=3，所以 max(m,s)=5。

https://codeforces.com/contest/1443/submission/228750000
把 a 和 b 绑在一起，按照 a[i] 从小到大排序。
枚举 m=a[i]，所有下标 <=i 的 b[i] 就不用选了，所以 s 等于 b[i+1] 之后的所有元素之和。
======

input
4
4
3 7 4 5
2 1 2 4
4
1 2 3 4
3 3 3 3
2
1 2
10 10
2
10 10
1 2
output
5
3
2
3
 */
