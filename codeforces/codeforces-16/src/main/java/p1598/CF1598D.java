package p1598;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1598D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[][] ab = new int[n][2];
            for (int i = 0; i < n; i++) {
                ab[i][0] = scanner.nextInt();
                ab[i][1] = scanner.nextInt();
            }
            System.out.println(solve(n, ab));
        }
    }

    private static String solve(int n, int[][] ab) {
        long ans = n * (n - 1L) * (n - 2L) / 6;
        long[] cx = new long[n + 1];
        long[] cy = new long[n + 1];
        for (int i = 0; i < n; i++) {
            cx[ab[i][0]]++;
            cy[ab[i][1]]++;
        }
        for (int[] p : ab) {
            ans -= (cx[p[0]] - 1) * (cy[p[1]] - 1);
        }
        return String.valueOf(ans);
    }
}
/*
D. Training Session
https://codeforces.com/contest/1598/problem/D

灵茶の试炼 2023-01-20
题目大意：
输入 t(≤5e4) 表示 t 组数据，每组数据输入 n(3≤n≤2e5) 和 n 个点 (xi,yi)，横纵坐标都在 [1,n] 内。没有重复的点。所有数据的 n 之和不超过 2e5。
从 n 个点中选出 3 个点，满足「横坐标互不相同」或者「纵坐标互不相同」。
输出有多少种选择方案。注意选的是组合，(1,2,3) 和 (3,2,1) 算相同的方案。

https://codeforces.com/problemset/submission/1598/189793851
提示 1：正难则反，考虑哪些不满足要求的选法。
提示 2：如果选了三个横坐标相同的点，由于题目保证没有重复的点，所以三个纵坐标互不相同，这样是满足题目要求的。纵坐标同理，因此我们只能选恰好有两个横坐标相同的点，恰好有两个纵坐标相同的点。
提示 3：这三个点组成了一个 L 型。
提示 4：枚举每个点 (x,y) 作为 L 型的拐点，那么另外有 cntX[x]-1 个横坐标相同的点，cntY[y]-1 个横坐标相同的点。对答案的贡献是 (cntX[x]-1)*(cntY[y]-1)。
答案为 C(n,3) - 这些贡献之和。
======

input
2
4
2 4
3 4
2 1
1 3
5
1 5
2 4
3 3
4 2
5 1
output
3
10
 */
