package didi;

import java.io.PrintWriter;
import java.util.Scanner;

public class DD2019011 {
    static Scanner scanner;
    static PrintWriter out;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        out = new PrintWriter(System.out);
        int t = 1;
        // t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();

        // 对于路径上的每一点(x, y)，都保证 x <= y
        if (x1 > y1 || x2 > y2) {
            out.println(0);
            return;
        }
        int x = Math.abs(x1 - x2);
        int y = Math.abs(y1 - y2);
        // res = C(x+y, x)
        int res = (int) comb(x + y, x);

        int u = Math.max(x1, x2) - Math.min(y1, y2);
        if (u > 0) {
            res -= (int) comb(x + y, u - 1);
            res = (res + MOD) % MOD;
        }
        out.println(res);
    }

    static int MOD = (int) 1e9 + 7, MX = (int) 2e6 + 5;
    static long[] F = new long[MX + 1], invF = new long[MX + 1];

    static {
        F[0] = F[1] = invF[0] = invF[1] = 1;
        for (int i = 2; i <= MX; i++) F[i] = F[i - 1] * i % MOD;
        invF[MX] = quickPow(F[MX], MOD - 2);
        for (int i = MX - 1; i >= 2; i--) invF[i] = invF[i + 1] * (i + 1) % MOD;
    }

    static long comb(int n, int m) {
        if (n < m || m < 0) return 0;
        return F[n] * invF[n - m] % MOD * invF[m] % MOD;
    }

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