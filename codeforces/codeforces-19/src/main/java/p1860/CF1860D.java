package p1860;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1860D {
    static char[] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        s = scanner.next().toCharArray();
        System.out.println(solve());
    }

    private static final int N = 111;

    private static String solve() {
        int n = s.length;
        int[][][] dp = new int[2][N][N * N];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j <= i + 1; ++j) {
                for (int cnt = 0; cnt <= j * (i + 1 - j); ++cnt) {
                    dp[1][j][cnt] = n;
                }
            }
            for (int j = 0; j <= i; ++j) {
                for (int cnt = 0; cnt <= j * (i - j); ++cnt) {
                    dp[1][j + 1][cnt] = Math.min(dp[1][j + 1][cnt], dp[0][j][cnt] + (s[i] != '0' ? 1 : 0));
                    dp[1][j][cnt + j] = Math.min(dp[1][j][cnt + j], dp[0][j][cnt] + (s[i] != '1' ? 1 : 0));

                }
            }
            // swap(dp[0], dp[1]);
            int[][] tmp = dp[0].clone();
            dp[0] = dp[1];
            dp[1] = tmp;
        }

        int cnt0 = 0;
        for (char c : s) {
            if (c == '0') cnt0++;
        }
        int ans = dp[0][cnt0][cnt0 * (n - cnt0) / 2] / 2;
        return String.valueOf(ans);
    }
}
/*
D. Balanced String
https://codeforces.com/contest/1860/problem/D

题目大意：
您将得到一个二进制字符串 s(二进制字符串是由字符 0 和/或 1 组成的字符串)。
如果子序列 01(1≤i<j≤n, si=0, sj=1 的索引 i 和 j 的数目)等于子序列 10(1≤k<l≤n, sk=1, sl=0 的索引 k 和 l 的数目)，则称二元字符串为平衡字符串。
例如，字符串 1000110 是均衡的，因为子序列 01 的个数和子序列 10 的个数都等于 6。另一方面，11010 是不均衡的，因为子序列 01 的个数是 1，而子序列 10 的个数是 5。
以下操作可执行任意次数:从“s”中选择两个字符进行交换。你的任务是计算使字符串平衡的最小操作数。

熟悉的感觉
---
https://codeforces.com/blog/entry/119504
让我们计算以下动态规划:dpi,cnt0,cnt01—如果只考虑字符串 s 的 i 个首字符，则字符串 s 的最小更改次数，该前缀上的字符数 0 为 cnt0，该前缀上的子序列数 01 等于 cnt01。
转换非常简单。让我们根据要放置在下一个位置的角色来看看过渡:
- 如果为 0，则从状态(i,cnt0,cnt01)过渡到状态(i+1,cnt0+1,cnt01)， dp 的值取决于 si(如果 si=0，值保持不变，否则增加 1);
- 如果为 1，则存在从状态(i,cnt0,cnt01)到状态(i+1,cnt0,cnt01+cnt0)的转换，dp 的值取决于 si(如果 si=1，值保持不变，否则增加 1)。
所以，这个动态规划在 0 (n4)中有效。
我们需要从动态规划中得到问题的答案。它存储在 dpn,cnt0,need 中，其中 cnt0 等于字符串 s 中的字符数 0,need =cnt0·cnt12(因为子序列 01 的个数应该等于子序列 10 的个数)。但是我们的动态规划存储了字符串中更改的次数，问题要求最小的交换次数。然而，我们可以很容易地从 dp 值中得到它。由于字符串中 0 和 1 的数量是固定的，那么从 0 到 1 的变化次数等于从 1 到 0 的变化次数，我们可以将它们配对。所以，问题的答案是 dp 值的一半。
======

input
101
output
0

input
1000110
output
0

input
11010
output
1

input
11001100
output
2
 */
