package lq240727;

import java.util.Scanner;

public class LQ240727T9 {
    static long N;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextLong();
        System.out.println(solve());
    }

    private static String solve() {
        long[] dp = new long[63];
        dp[0] = 1;
        for (int i = 1; i < 63; i++) {
            for (int j = 0; j < 63 - i; j++) {
                dp[i + j] += dp[j];
            }
        }

        long ans = 1;
        for (int i = 2; i <= 1e6; i++) {
            int cnt = 0;
            while (N % i == 0) {
                cnt++;
                N /= i;
            }
            ans *= dp[cnt];
        }
        long sqrtN = (long) Math.sqrt(N);
        if (N > 1 && sqrtN * sqrtN == N) {
            ans *= 2;
        }
        return String.valueOf(ans - 1);
    }
}
/*
神通顶点【算法赛】

根据唯一分解定理，我们可以将 N 进行质因数分解，即
N = p_{1}^{a_{1}} \times p_{2}^{a_{2}}\times \cdots \times p_{k}^{a_{k}}
其中 p1,𝑝2,\dots,pk 为互不相同的质数，a_1, a_2, \dots, a_k 为正整数。

设满足条件的序列为 C_1, C_2, \dots , C_m，其中 m 表示序列的长度（m \geq 2）。
同时，对于任意正整数 x 和质数 p，设 x 能被 p 整除的最大次数为 cnt_p(x)。那么，根据“**后一项是前一项的倍数**”的条件，对于任意质数 p_i 我们有：
cnt_{p_i}(C_1) \leq cnt_{p_i}(C_2) \leq \cdots  \leq cnt_{p_i}(C_m)
再根据“**所有元素的乘积等于** N”（即 C_1 \times C_2 \times C_m = N）的条件，对于任意质数 p_i 我们有：
cnt_{p_i}(C_1) + cnt_{p_i}(C2) + \cdots + cnt_{p_i}(C_m) = a_i
此时，根据以上两条性质不难发现，cnt_{p_i}(C_1),cnt_{p_i}(C2),\dots ,cnt_{p_i}(C_m) 实为 a_i 的一种“划分数”。
“划分数”指的是将一个正整数拆分成若干个正整数之和的不同方式的数量。
例如，对于数字 4，它的分割方式有以下 5 种：
4 &= 1 + 1 + 1 + 1
4 &= 1 + 1 + 2
4 &= 1 + 3
4 &= 2 + 2
4 &= 4
C_1, C_2, \ldots, C_m 与 a_i 的划分之间存在一个双射关系。从 C_1, C_2, \dots, C_m 以及 cnt_{p_i} 的值可以得到 a_i 的划分。
反过来，从 a_i 的划分中，通过将分割的长度的最大值记为 m，并在缺少长度的情况下在前面补 0，使长度一致，可以得到唯一的 C_1, C_2, \cdots, C_m。
满足条件的序列为不同 a_i 的划分方式的组合。记 a_i 的划分数为 A_i，那么答案则可表示为：
A_1 \times A_2 \times \cdots \times A_m
根据条件“**第一个元素的值大于或等于** 2”以及“N \leq 10^{18}”可得 A_m 的值不超过 62。于是，我们可以用动态规划计算出 A \in (1\sim 62) 的值。而后，只要我们求出 N 的每个质因数 p_i 对应的 a_i 即可完成求解。
如何求出每个 p_i 对应的  a_i 呢？采用试除法。
1. 对于数值范围在 [1,10^6] 内的质数（记为小质数），我们可以直接暴力枚举计算其对应的 a_i，并将其在 N 中除掉。
2. 对于数值范围大于 10^6 的质数（记为大质数），此时 N  只有两种情况：
   - 如果 N 等于两个不同的大质数相乘，则两者对应的 a_i 均为 1，对答案无影响，所以无需对该情况进行处理。
   - 如果 N 等于两个相同的大质数相乘，则其对应的 a_i 为 2。
如此，便可完成求解。
 */