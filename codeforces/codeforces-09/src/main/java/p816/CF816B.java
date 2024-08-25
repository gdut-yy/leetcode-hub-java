package p816;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF816B {
    static int n, k, q;
    static int[][] lr, ab;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        q = scanner.nextInt();
        lr = new int[n][2];
        for (int i = 0; i < n; i++) {
            lr[i][0] = scanner.nextInt();
            lr[i][1] = scanner.nextInt();
        }
        ab = new int[q][2];
        for (int i = 0; i < q; i++) {
            ab[i][0] = scanner.nextInt();
            ab[i][1] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    static final int N = (int) (2e5 + 5);

    private static String solve() {
        int[] d = new int[N];
        for (int[] p : lr) {
            int l = p[0], r = p[1];
            d[l]++;
            d[r + 1]--;
        }
        int[] s = new int[N];
        int sumD = 0;
        for (int i = 0; i < N - 1; i++) {
            sumD += d[i];
            s[i + 1] = s[i];
            if (sumD >= k) {
                s[i + 1]++;
            }
        }
        int[] ans = new int[q];
        for (int i = 0; i < q; i++) {
            int l = ab[i][0], r = ab[i][1];
            ans[i] = s[r + 1] - s[l];
        }
        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(System.lineSeparator()));
    }
}
/*
B. Karen and Coffee
https://codeforces.com/contest/816/problem/B

灵茶の试炼 2023-11-06
题目大意：
输入 n k(1≤k≤n≤2e5) q(1≤q≤2e5)。
然后输入 n 个 recipe，每个 recipe 输入两个数 L R(1≤L≤R≤2e5)，表示冲一杯咖啡的推荐温度范围为 [L,R]。
定义一个整数温度 t 是「可接受的」，如果 t 包含在至少 k 个 recipe 的推荐温度范围内。
然后输入 q 个询问，每个询问输入两个数 a b(1≤a≤b≤2e5)，输出 [a,b] 内有多少个温度是可接受的，每行一个答案。
进阶：如果 k 是每个询问输入的数呢？@liupengsay

rating 1400
用差分数组维护区间 +1 操作。
然后还原数组，用前缀和统计还原后的数组的每个前缀有多少 >=k 的数。
这样就可以 O(1) 回答每个询问了。
https://codeforces.com/problemset/submission/816/231059531
======

input
3 2 4
91 94
92 97
97 99
92 94
93 97
95 96
90 100
output
3
3
0
4

input
2 1 1
1 1
200000 200000
90 100
output
0
 */
