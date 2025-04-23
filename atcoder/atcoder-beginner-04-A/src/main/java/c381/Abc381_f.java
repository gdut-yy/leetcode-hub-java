package c381;

import java.util.Arrays;
import java.util.Scanner;

public class Abc381_f {
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

    // 写法二：子序列自动机
    private static String solve() {
        int[] ps = new int[20];
        Arrays.fill(ps, n);
        int[][] nxt = new int[n + 2][20];
        nxt[n + 1] = ps.clone();
        nxt[n] = ps.clone();
        for (int i = n - 1; i >= 0; i--) {
            ps[a[i] - 1] = i;
            nxt[i] = ps.clone();
        }

        int[] f = new int[1 << 20];
        Arrays.fill(f, n);
        f[0] = -1;
        long ans = 0;
        for (int i = 0; i < f.length; i++) {
            if (f[i] == n) continue;
            ans = Math.max(ans, Integer.bitCount(i));
            // for j, lb := len(f)-1^i, 0; j > 0; j ^= lb {
            for (int j = f.length - 1 ^ i, lb = 0; j > 0; j ^= lb) {
                lb = j & -j;
                int v = Integer.numberOfTrailingZeros(lb);
                f[i | lb] = Math.min(f[i | lb], nxt[nxt[f[i] + 1][v] + 1][v]);
            }
        }
        ans *= 2;
        return String.valueOf(ans);
    }
}
/*
F - 1122 Subsequence
https://atcoder.jp/contests/abc381/tasks/abc381_f

灵茶の试炼 2025-01-23
题目大意：
输入 n(1≤n≤2e5) 和长为 n 的数组 a(1≤a[i]≤20)。
输出 a 的子序列 b 的最长长度，满足：
1. b 的长度是偶数。
2. b[0]=b[1], b[2]=b[3], ... 即两个两个一组，每组中的元素都相同。
3. b 中的每种数字恰好在 b 中出现两次。
注：子序列不一定连续。

状态设计题。
定义 f[i] 表示 b 中元素恰好组成集合 i 的情况下，b 的最后一个元素在 a 中的下标的最小值。
枚举不在集合 i 中的 j，在 a 中下标 f[i] 右边寻找两个最近的元素 j，用第二个 j 的下标更新 f[i|1<<j] 的最小值。
初始值 f[0]=-1, f[i]=inf。
最后答案为：对于不等于 inf 的 f[i]，计算 i 的二进制 1 的个数的最大值 * 2。
写法一：二分下标列表 (409ms) https://atcoder.jp/contests/abc381/submissions/61501193
写法二：子序列自动机 (62ms) https://atcoder.jp/contests/abc381/submissions/61501900
======

Input 1
7
1 3 3 1 2 2 1
Output 1
4

Input 2
1
20
Output 2
0
 */
