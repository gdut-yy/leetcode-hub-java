package didi;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class DD2019011 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();
        System.out.println(solve(x1, y1, x2, y2));
    }

    private static final int MOD = (int) 1e9 + 7;

    private static String solve(int x1, int y1, int x2, int y2) {
        // 对于路径上的每一点(x, y)，都保证 x <= y
        if (x1 > y1 || x2 > y2) {
            return "0";
        }
        int x = Math.abs(x1 - x2);
        int y = Math.abs(y1 - y2);
        // res = C(x+y, x)
        int res = (int) combination(x + y, x, MOD);

        int u = Math.max(x1, x2) - Math.min(y1, y2);
        if (u > 0) {
            res -= (int) combination(x + y, u - 1, MOD);
            res = (res + MOD) % MOD;
        }
        return String.valueOf(res);
    }

    // C(n, m) = n! / m!(n-m)! （n 为下标） (% mod)
    private static long combination(int n, int m, int mod) {
        if (n == 0 && m == 0) {
            return 1;
        }
        // 线性求逆元
        long[] inv = new long[n + 1];
        inv[1] = 1;
        for (int i = 2; i <= n; i++) {
            inv[i] = (mod - mod / i) * inv[mod % i] % mod;
        }
        // 递推求组合数，初值 C(k, 0) = 1
        long res = 1;
        for (int i = 1; i <= m; i++) {
            res = res * (n - i + 1) % mod * inv[i] % mod;
        }
        return res;
    }
}
/*
DD-2019011. DIST
https://leetcode.cn/problems/zbgPf1/

在平面直角坐标系上，从(x1, y1)到(x2, y2)有多少条路径，使得
a) 对路径上经过每一点(x, y)，x和y至少有一个是整数。
b) 路径的长度最短，为 |x1 – x2| + |y1 – y2|
c) 对于路径上的每一点(x, y)，都保证 x <= y
这个答案可能很大，只需要输出它对质数(1e9 + 7)取模的结果即可
格式：
输入：
- 每组测试数据一行，为 4 个整数x1, y1, x2, y2 。
输出：
- 输出查询的结果，每行一个结果。
示例：
输入：
0 0 0 0
0 0 1 1
输出：
1
1
提示：
对所有数据, x1, y1, x2, y2都是整数，且 -1e6 <= x1, y1, x2, y2 <= 1e6
其中 20% 的数据, max(x1, x2) <= min(y1, y2), 0 <= x1, y1, x2, y2 <= 100
其中20%的数据, (x1, y1) = 0; 0 <= x2, y2 <= 100
其中20%的数据, -100 <= x1, y2, x2, y2 <= 100
其中20%的数据, (x1, y1) = 0, 0 <= x2, y2 <= 1e6
其中20%的数据, -1e6 <= x1, y1, x2, y2 <= 1e6

组合数学，乘法逆元
 */