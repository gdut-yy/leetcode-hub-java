package lq240518;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LQ240518T7 {
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
        Map<Integer, Integer> ans = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int v = a[i];
            Map<Integer, Integer> cnt = new HashMap<>();
            while (v > 1) {
                int c = lpf[v];
                v /= c;
                cnt.merge(c, 1, Integer::sum);
            }

            for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
                Integer x = entry.getKey(), w = entry.getValue();
                if (w % 2 == 1) {
                    ans.merge(x, 1, Integer::sum);
                }
            }
        }

        long res = 0;
        for (Integer w : ans.values()) {
            res += Math.min(w, n - w);
        }
        return String.valueOf(res);
    }

    // 预处理
    static int[] lpf;
    static int MAX_N = (int) 1e6;

    static {
        // 埃氏筛 预处理 最小质因子
        lpf = new int[MAX_N + 1];
        for (int i = 2; i <= MAX_N; i++) {
            if (lpf[i] == 0) {
                for (int j = i; j <= MAX_N; j += i) {
                    if (lpf[j] == 0) {
                        lpf[j] = i;
                    }
                }
            }
        }
    }
}
/*
拔苗助长【算法赛】

质因数分解。
对于一个完全平方数 x 来说，考虑其唯一分解的形式 x = p_1^{a_1} \times p_2^{a_2} \times ... \times p_n^{a_n}，应当满足 a1,a2,...,an 均为偶数。
---
这比较好证明，我们设 b^2 = x，则显然有 b = p_1^{a_1/2} \times p_2^{a_2/2} \times ... \times p_n^{a_n/2}，由于指数系数应当一定为整数，
所以 a1,a2,...,an 一定为 2 的倍数，即为偶数。
---
设 c * d 为完全平方数，其中 c = p_1^{a_1} \times p_2^{a_2} \times ... \times p_n^{a_n}，d = p_1^{b_1} \times p_2^{b_2} \times ... \times p_n^{b_n}
则应满足 a1+b1, a2+b2, ..., an+bn 均为偶数，等价于对于任意 i 均满足 ai mod 2 = bi mod 2。
---
题目要求数组中任意两个数相乘均为完全平方数，等于要求对于任意质数 p，数组中每个数的质因数分解中，与 p 相关的指数的奇偶性均相同。
我们考虑每个质数对答案的贡献，假设某个质数 p，设在这 n 个数中以奇数作为指数系数的次数为 x，则对答案的贡献为 min(x, n-x)。
具体实现时，我们可以对每个数进行质因数分解，使用哈希表记录每个质数以奇数作为指数系数的次数。
 */