package p1878;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1878E {
    static int n;
    static int[] a;
    static int q;
    static int[][] lk;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            q = scanner.nextInt();
            lk = new int[q][2];
            for (int i = 0; i < q; i++) {
                lk[i][0] = scanner.nextInt() - 1;
                lk[i][1] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    static int[][] preSum;

    private static String solve() {
        preSum = new int[n + 1][31];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 31; j++) {
                if ((a[i] >> j & 1) == 1) {
                    preSum[i + 1][j] = preSum[i][j] + 1;
                }
            }
        }

        int[] ans = new int[q];
        for (int i = 0; i < q; i++) {
            int l = lk[i][0], k = lk[i][1];

            int left = l;
            int right = n;
            while (left < right) {
                int mid = left + (right - left) / 2;
                // 边界二分 F, F,..., F, [T, T,..., T]
                // ----------------------^
                if (!checkMid(l, k, mid)) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            ans[i] = left > l ? left : -1;
        }
        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }

    static boolean checkMid(int l, int k, int mid) {
        int tot = 0;
        for (int j = 0; j < 31; j++) {
            int cnt = preSum[mid + 1][j] - preSum[l][j];
            if (cnt == mid + 1 - l) {
                tot |= 1 << j;
            }
        }
        return tot >= k;
    }
}
/*
E. Iva & Pav
https://codeforces.com/contest/1878/problem/E

题目大意：
Iva 和 Pav 是一对著名的塞尔维亚竞技编程夫妇。在塞尔维亚，人们称帕夫为“帕普卡”，这就是为什么他会让伊娃的所有愿望都实现。
Iva 给了 Pav 一个 n 个元素的数组 a。
让我们定义 f(l,r)=al & al+1 & ... & ar(这里&表示位与运算)。
注意，当 l>r 时，f(l,r)没有定义。
Iva 还向 Pav 提出了 q 个问题。
每个查询由 2 个数字 k 和 l 组成，她希望 Pav 找到最大的索引 r (l≤r≤n)，使得 f(l,r)≥k。
帕夫想尽快解决这个问题，因为他不想惹伊娃生气。他需要你的帮助。

暴力解法 qn
优化至 qlogn
拆位
======

input
3
5
15 14 17 42 34
3
1 7
2 15
4 5
5
7 5 3 1 7
4
1 7
5 7
2 3
2 2
7
19 20 15 12 21 7 11
4
1 15
4 4
7 12
5 7
output
2 -1 5
1 5 2 2
2 6 -1 5
 */
