package lq240309;

import java.util.Arrays;
import java.util.Scanner;

public class LQ240309T8 {
    static int[][][] dp = new int[2][503][263];
    static int[] p = new int[102];
    static int[] s = new int[102];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            sol(scanner);
        }
        scanner.close();
    }

    static void sol(Scanner scanner) {
        int n = scanner.nextInt();
        for (int i = 1; i <= n; ++i) {
            p[i] = scanner.nextInt();
            s[i] = scanner.nextInt();
        }

        int now = 1, pre = 0;
        for (int[][] row : dp) {
            for (int[] subRow : row) {
                Arrays.fill(subRow, Integer.MAX_VALUE);
            }
        }
        dp[now][0][0] = 0;
        int sump = 0;
        for (int i = 1; i <= n; ++i) {
            now ^= 1;
            pre ^= 1;
            for (int[] subRow : dp[now]) {
                Arrays.fill(subRow, Integer.MAX_VALUE);
            }
            for (int a = 0; a <= sump; ++a) {
                int smx = (sump - a) / 2 + 1;
                for (int b = 0; b <= smx; ++b) {
                    if (dp[pre][a][b] > 1_000_000_000) continue;
                    for (int j = 0; j <= s[i]; ++j) {
                        int nows = j / 2, lk = s[i] - j;
                        int tmp = j * p[i];
                        for (int ap = 0; ap <= Math.min(nows, a) + Math.min(lk, b); ++ap) {
                            dp[now][a - ap + lk][b + nows - ap] = Math.min(dp[now][a - ap + lk][b + nows - ap], dp[pre][a][b] + tmp);
                        }
                    }
                }
            }
            sump += s[i];
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 260; ++i) {
            ans = Math.min(ans, dp[now][0][i]);
        }
        System.out.println(ans);
    }
}
/*
食堂【算法赛】

解题思路
考察动态规划。
我们定义 dp_i,j,k 代表处理完前 i 个种菜，目前还有 j 盘菜缺失，k 盘送其他菜的机会的最小价格。
j 盘菜缺失指的是前 i 种菜中缺失 j 盘，在前 i 种菜种获得了送菜的机会，但是有 k 盘多余的。
初值 dp_0,0,0 = 0。
转移，我们枚举第 i+1 种菜买多少盘，我们假设当前状态为 dp_i,j,k，我们买第 i+1 种菜 x 盘，月么需要花费 x * p_i+1 元，能够赠送 x/2 盘，同时第 i+1 种菜缺失了 s_i+1 -x 盘。我们就需要用 j,k,x/2，s_i+1 -x 这四个数相互补足。
但是我们不知道当前送菜有多少盘是弥补之前缺失的，也不知道之前送的有多少能过弥补当前这盘菜缺失的。
所以我们需要枚举这两个值，即在之前状态中，还多了 k 盘，缺失了 j 盘，这次缺失了 a=s_i+1 -x, 送了 b=x/2 盘，我们枚举从这次送的 b 盘中，取出 b'盘，弥补之前的缺失的，并且枚举从之前送的 k 盘中，取出 k'盘弥补当前缺失的，那么就转移到了状态
dp_i+1,j+а-а'-k',k+b-a'-k', 这种转移的理论复杂度在 O((\sigma si)^5)，这样不能通过本题。
我们考虑优化，注意到 a'+k' 会有很多重复的，我们可以直接用一个值 p=a'+k'，即我们枚举 p 从 0 到 min(k,a)+min(j,b) 即可。
这样单样例复杂度可以减低到 O((\sigma si)^4)，但是由于状态数远远达不到上界，同时时限较长，可以通过本题。
小羊肖恩计算的单样例复杂度上界为 O((\sigma si)^4 / 108)， 参考其 Python 代码。
实现中用滚动数组会更快。
 */