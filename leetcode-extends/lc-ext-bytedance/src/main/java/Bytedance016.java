import java.io.PrintWriter;
import java.util.Scanner;

public class Bytedance016 {
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
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
        }

        int[] cnt = new int[n + 1];
        for (int j = 0; j < m; j++) {
            int b = scanner.nextInt();
            cnt[b]++;
        }

        // 计算树的最大深度（根深度为 0）
        int maxDepth = 0;
        for (int i = 1; i <= n; i++) {
            int d = 0;
            int x = i;
            while (x > 1) {
                d++;
                x /= 2;
            }
            if (d > maxDepth) maxDepth = d;
        }
        int L = maxDepth + 2;

        // distS[i][d]：以 i 为根的子树中，未匹配的松鼠到 i 的距离为 d 的数量
        // distR[i][d]：以 i 为根的子树中，未匹配的房间到 i 的距离为 d 的数量
        long[] distS = new long[(n + 1) * L];
        long[] distR = new long[(n + 1) * L];

        for (int i = 1; i <= n; i++) {
            int base = i * L;
            distS[base] = cnt[i];
            distR[base] = a[i];
        }

        long ans = 0;

        // 自底向上处理每个节点
        for (int i = n; i >= 1; i--) {
            int base = i * L;

            long S = 0, R = 0, sumS = 0, sumR = 0;
            for (int d = 0; d < L; d++) {
                long cs = distS[base + d];
                long cr = distR[base + d];
                if (cs != 0) {
                    S += cs;
                    sumS += cs * d;
                }
                if (cr != 0) {
                    R += cr;
                    sumR += cr * d;
                }
            }

            // 在节点 i 处尽量匹配松鼠和房间
            if (S > 0 && R > 0) {
                if (S <= R) {
                    // 松鼠少，所有松鼠都被匹配，选择距离最近的 S 个房间
                    ans += sumS;
                    long need = S;
                    for (int d = 0; d < L && need > 0; d++) {
                        long cr = distR[base + d];
                        if (cr > 0) {
                            long take = Math.min(cr, need);
                            ans += take * d;
                            distR[base + d] = cr - take;
                            need -= take;
                        }
                    }
                    // 松鼠全部匹配完，清空
                    for (int d = 0; d < L; d++) distS[base + d] = 0;
                } else {
                    // 房间少，所有房间都被匹配，选择距离最近的 R 个松鼠
                    ans += sumR;
                    long need = R;
                    for (int d = 0; d < L && need > 0; d++) {
                        long cs = distS[base + d];
                        if (cs > 0) {
                            long take = Math.min(cs, need);
                            ans += take * d;
                            distS[base + d] = cs - take;
                            need -= take;
                        }
                    }
                    // 房间全部匹配完，清空
                    for (int d = 0; d < L; d++) distR[base + d] = 0;
                }
            }

            // 将剩余未匹配的松鼠和房间向上传递给父节点，距离加 1
            if (i > 1) {
                int p = i / 2;
                int pbase = p * L;
                for (int d = 0; d < L - 1; d++) {
                    long cs = distS[base + d];
                    if (cs != 0) {
                        distS[pbase + d + 1] += cs;
                        distS[base + d] = 0;
                    }
                    long cr = distR[base + d];
                    if (cr != 0) {
                        distR[pbase + d + 1] += cr;
                        distR[base + d] = 0;
                    }
                }
            }
        }

        out.println(ans);
    }
}
/*
bytedance-016. 最短移动距离
https://leetcode.cn/problems/YWWN3V/

给定一棵 n 个节点树。节点 1 为树的根节点，对于所有其他节点 i，它们的父节点编号为 floor(i/2) (i 除以 2 的整数部分)。在每个节点 i 上有 a[i] 个房间。此外树上所有边均是边长为 1 的无向边。
树上一共有 m 只松鼠，第 j 只松鼠的初始位置为 b[j]，它们需要通过树边各自找到一个独立的房间。请为所有松鼠规划一个移动方案，使得所有松鼠的总移动距离最短。
格式：
输入：
- 输入共有三行。
- 第一行包含两个正整数 n 和 m，表示树的节点数和松鼠的个数。
- 第二行包含 n 个自然数，其中第 i 个数表示节点 i 的房间数 a[i]。
- 第三行包含 m 个正整数，其中第 j 个数表示松鼠 j 的初始位置 b[j]。
输出：
- 输出一个数，表示 m 只松鼠各自找到独立房间的最短总移动距离。
示例：
输入：
     5 4
     0 0 4 1 1
     5 4 2 2
输出：4
解释：前两只松鼠不需要移动，后两只松鼠需要经节点 1 移动到节点 3
提示：
对于 30% 的数据，满足 n,m <=100。
对于 50% 的数据，满足 n,m <=1000。
对于所有数据，满足 n,m<=100000，0<=a[i]<=m, 1<=b[j]<=n。
 */