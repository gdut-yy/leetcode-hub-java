package c107;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Arc107_d {
    static int n, k;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        System.out.println(solve());
    }

    private static final int MOD = 998244353;

    private static String solve() {
        long[][] f = new long[n + 1][n * 2 + 2];
        f[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j > 0; j--) {
                f[i][j] = (f[i - 1][j - 1] + f[i][j * 2]) % MOD;
            }
        }
        return String.valueOf(f[n][k]);
    }

    // 灵神：去掉第一个维度
    private static String solve1() {
        // 	f := []int{1}
        //	for i := 1; i <= n; i++ {
        //		f = append([]int{0}, f...)
        //		for j := i / 2; j > 0; j-- {
        //			f[j] = (f[j] + f[j*2]) % mod
        //		}
        //	}
        List<Long> f = new ArrayList<>();
        f.add(1L);
        for (int i = 1; i <= n; i++) {
            f.add(0, 0L);
            for (int j = i / 2; j > 0; j--) {
                f.set(j, (f.get(j) + f.get(j * 2)) % MOD);
            }
        }
        return String.valueOf(f.get(k));
    }
}
/*
D - Number of Multisets
https://atcoder.jp/contests/arc107/tasks/arc107_d

灵茶の试炼 2025-02-14
题目大意：
输入 n k (1≤k≤n≤3000)。
输出有多少个多重集合，满足如下条件：
1. 恰好有 n 个元素。
2. 每个元素都是 1/2^i，即 1, 1/2, 1/4, 1/8, ... 中的一个。
3. 这 n 个数的和恰好等于 k。
答案模 998244353。

定义 f[i][j] 表示 i 个数且元素和为 j 的多重集合个数，并且这 i 个数都是 1, 1/2, 1/4, ...
如果这 i 个数里面至少有 1 个 1，那么去掉这个 1，问题变成 i-1 个数且元素和为 j-1 的多重集合个数，即 f[i-1][j-1]。
如果这 i 个数里面没有 1，那么（举例）1=1/2+1/4+1/4 等价于 2=1+1/2+1/2，所以问题等价于 i 个数且元素和为 2j 的多重集合个数，即 f[i][2j]。
注：2j 的意义在于让这 i 个数都是 1, 1/2, 1/4, ...，从而【符合状态的定义】。
所以有
f[i][j] = f[i-1][j-1] + f[i][2j]
根据转移方程，j 要倒序遍历。
如果 i<j，那么 f[i][j] = 0。所以 j 最大是 i。
初始值 f[0][0] = 1。
答案为 f[n][k]。
代码实现时，可以去掉第一个维度，那么 f[j] = f[j-1] 相当于在 f 数组最前面插入了一个 0，其余元素向右偏移一位。
代码 https://atcoder.jp/contests/arc107/submissions/62687845
======

Input 1
4 2
Output 1
2

Input 2
2525 425
Output 2
687232272
 */
