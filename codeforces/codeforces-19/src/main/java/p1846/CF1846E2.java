package p1846;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1846E2 {
    static long n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextLong();
            System.out.println(solve());
        }
    }

    private static String solve() {
        int ceilLog2n = 64 - Long.numberOfLeadingZeros(n - 1);

        for (int t = ceilLog2n; t >= 3; t--) {
            long k = (long) Math.pow(n, 1.0 / (t - 1));
            long tot = 0;
            for (int i = 0; i < t; i++) {
                tot = tot * k + 1;
                if (tot > n) break;
            }
            if (tot == n) {
//                System.out.printf("k=%d t=%d", k, t);
                return "YES";
            }
        }
        return "NO";
    }
}
/*
E2. Rudolf and Snowflakes (hard version)
https://codeforces.com/contest/1846/problem/E2

题目大意：
这是这个问题的一个简单版本。唯一不同的是，在这个版本中 n≤10^18（E1 n≤10^6）
一个冬天的早晨，鲁道夫若有所思地看着窗外，看着飘落的雪花。他很快注意到雪花的形状有某种对称性。像一个真正的数学家一样，鲁道夫想出了一个雪花的数学模型。
他将雪花定义为根据以下规则构造的无向图:
- 最初，图只有一个顶点。
- 然后，更多的顶点被添加到图中。初始顶点通过边连接到 k 个新顶点(k>1)。
- 每个只连接到另一个顶点的顶点通过边连接到 k 个新的顶点。这一步至少要做一次。k=4 时最小的雪花如图所示。
经过一些数学研究，鲁道夫意识到这样的雪花可能没有任何数量的顶点。帮助鲁道夫检查有 n 个顶点的雪花是否存在。

判断 n 是否存在 k(k>=2) 进制数的所有数位全为 1
https://www.acwing.com/solution/content/388/
======

input
9
1
2
3
6
13
15
255
10101
1000000000000000000
output
NO
NO
NO
NO
YES
YES
YES
YES
NO
 */
