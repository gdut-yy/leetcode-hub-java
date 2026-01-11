package p1270;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CF1270F {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static final int MAX_N = 200000;
    static int[] cnt = new int[450 * MAX_N];

    private static void solve() {
        String s = scanner.next();
        int n = s.length();
        int B = (int) Math.ceil(Math.sqrt(n));

        long ans = 0;

        // 第一部分：k从1到B-1
        for (int k = 1; k < B; k++) {
            int pre = 0;
            // 第一次遍历：计数
            for (int i = 0; i < n; i++) {
                cnt[pre + n]++;
                pre += k * (s.charAt(i) == '1' ? 1 : 0) - 1;
                ans += cnt[pre + n];
            }
            // 重置cnt数组
            pre = 0;
            for (int i = 0; i < n; i++) {
                cnt[pre + n] = 0;
                pre += k * (s.charAt(i) == '1' ? 1 : 0) - 1;
            }
        }

        // 第二部分：处理较大的k值
        List<Integer> pos1 = new ArrayList<>();
        pos1.add(-1);
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                pos1.add(i);
            }
        }

        int tot1 = 0;
        for (int i = 0; i < n; i++) {
            tot1 += s.charAt(i) == '1' ? 1 : 0;
            int mn = Math.min(tot1, n / B);

            for (int cnt1 = 1; cnt1 <= mn; cnt1++) {
                int j = tot1 - cnt1;
                int maxK = (i - pos1.get(j)) / cnt1;
                int minK = Math.max((i - pos1.get(j + 1)) / cnt1 + 1, B);
                ans += Math.max(maxK - minK + 1, 0);
            }
        }

        out.println(ans);
    }
}
/*
F. Awesome Substrings
https://codeforces.com/contest/1270/problem/F

灵茶の试炼 2025-08-29
题目大意：
输入长度 ≤2e5 的字符串 s，只包含 0 和 1。
输出 s 有多少个子串 t，满足 t 包含 1，且 t 的长度是 t 中 1 的个数的倍数。
例如子串 1,1010,111 符合要求，0,110,01010 不符合要求。
注：本题时限 8s。

rating 2600
设子串长度 / 子串中的 1 的个数 = k。或者说子串长度 = k * (子串中的 1 的个数)。
由于 k * (子串中的 1 的个数) <= n，所以 k 和子串中的 1 的个数二者中必有一个 <= sqrt(n)。
核心思路：如果 k 比较小，枚举 k；如果 k 比较大，那么子串中的 1 的个数比较少，枚举 1 的个数，根据 1 的位置计算。
设阈值为 B。
如果 k < B。枚举 k=1,2,3,...,B-1。
设子串左端点为 i，右端点为 j-1，那么子串长度为 j-i = k*(子串中的 1 的个数) = k*(sum[j]-sum[i])，其中 sum 是 s 的前缀和（把字符 '0' '1' 当作数字 0 1）。
变形得到 k*si-i = k*sj-j，用「枚举右维护左」解决。推荐直接开 O(nB) 大小的数组，而不是哈希表/有序集合。
时间复杂度 O(nB)。
如果 k >= B。
由于子串长度 <= n，所以有 k * (子串中的 1 的个数) <= n，所以子串中的 1 的个数 <= n/k <= n/B。
枚举子串右端点，枚举子串中的 1 的个数 cnt1 = 1,2,3,...,floor(n/B)，从而确定子串左端点的范围。
计算在这个范围中，满足子串长度至少是 B*cnt1，且子串长度是 cnt1 的倍数的左端点的个数。
解不等式，求出左端点的最大值和最小值即可。
需要预处理 1 的位置，从而加速这个过程。
时间复杂度 O(n^2/B)。
B 取 sqrt(n) 比较均衡。
代码 https://codeforces.com/problemset/submission/1270/335229526
代码备份（上面打不开的同学看这个）
======

Input
111
Output
6

Input
01010
Output
10

Input
0000
Output
0

Input
1111100000
Output
25
 */
