package lq240824;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LQ240824T6 {
    static int n, m;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        System.out.println(solve());
    }

    private static final int MOD = 998244353;

    private static String solve() {
        List<Integer> d = new ArrayList<>();
        for (int i = 2; i * i <= m; i++) {
            int cnt = 0;
            while (m % i == 0) {
                cnt++;
                m /= i;
            }
            if (cnt > 0) d.add(cnt);
        }
        if (m != 1) d.add(1);

        long ans = 1;
        for (int i : d) {
            ans = ans * (quickPow(i + 1, n) - quickPow(i, n)) % MOD;
        }
        if (ans < 0) ans += MOD;
        return String.valueOf(ans);
    }

    // 快速幂 res = a^b % mod
    static long quickPow(long a, long b) {
        long res = 1L;
        while (b > 0) {
            if ((b & 1) != 0) res = res * a % MOD;
            a = a * a % MOD;
            b >>= 1;
        }
        return res;
    }
}
/*
智算士气【算法赛】

为了简化分析，我们首先对 m 进行质因数分解：
m = p_1^{a_1} \times p_2^{a_2} \times \ldots \times p_k^{a_k}
这里，p_1, p_2, \dots, p_k 是 m 的质因子，a_1, a_2, \dots, a_k 是对应的幂次。
根据题目要求，每个队伍的“士气”不能超过 m，而且所有队伍的“士气”最小公倍数必须正好是 m。这意味着每个队伍的“士气”中必须至少包含一个 p_i^{k_i}，其中 0 \leq k_i \leq a_i，并且至少有一个 k_i = a_i。
我们可以对每个质因子 p_i 分别进行分析：
1. **总组合数**：对于每个队伍，p_i 的指数可以从 0 到 a_i 选择，因此总组合数为：
   (a_i + 1)^n
2. **不包含 p_i^{a_i} 的组合数**：如果我们只考虑指数从 0 到 a_i - 1 的情况，组合数为：
   a_i^n
根据乘法原理，我们可以计算最终答案。对于每个质因子 p_i，有效的组合数为总组合数减去不包含 p_i^{a_i} 的组合数：
有效组合数 = (a_i + 1)^n - a_i^n
因此，最终答案为：
\prod_{i=1}^{k} \left((a_i + 1)^n - a_i^n\right)
 */