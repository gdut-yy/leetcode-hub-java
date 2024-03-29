package ponyai;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Ponyai005 {
    static int[][] lines;
    static int n, k, a, b;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        n = Integer.parseInt(reader.readLine());
        lines = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] s = reader.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                lines[i][j] = Integer.parseInt(s[j]);
            }
        }

        String[] s = reader.readLine().split(" ");
        reader.close();
        a = Integer.parseInt(s[0]);
        b = Integer.parseInt(s[1]);
        k = Integer.parseInt(s[2]);

        if (!satisfy(0)) {
            System.out.println(-1);
            return;
        }

        int L = 0, R = k;
        while (L < R) {
            int mid = (L + R + 1) >> 1;
            if (satisfy(mid)) L = mid;
            else R = mid - 1;
        }

        System.out.println(L);
    }

    static boolean satisfy(int cost) {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (k - cost <= Math.min(lines[i][j],
                        Math.min(lines[i][a] + cost + lines[b][j],
                                lines[i][b] + cost + lines[a][j]))) {
                    return false;
                }
            }
        }
        return true;
    }
}
/*
Pony.ai-005. 新增的专线
https://leetcode.cn/problems/wLynQ1/

Pony.ai 有 N 个 office 分布在不同地方(编号从 0 开始），某些 office 之间有部署专线，office 之间可以通过专线间接连接（专线是双向的），
例如 广州 和 背景 广州 和 深圳 之间有专线，那么 背景 可以通过 广州 与 深圳 间接地通讯，这条信路的总延时是两条专线的延时之和。
两个 office 之间的通讯延时是他们之间延时最短的信路的延时。
Infra 团队知道当前任意两个 office 之间的通讯延时。最近 Infra 团队希望在 office a与 office b 之间部署一条新的专线，
希望这条专线的延时 t 尽可能大（出于成本考虑）同时延时最大的两个 office 之间的通讯延时与 t 之和小于 k，你能帮忙求出这个 t 吗？
输入描述：
第一行一个正整数 N <= 1000，表示 office 的数目
接下来 N 行，每行 N 个非负整数，用空格分开。第 i 行第 j 个数表示当前office i 和 office j 之间的通讯延时，保证小于 1e9。
接下来一行 3 个整数，依次表示 a，b，k。其中 0 ≤ a,b <N, k<10^9
输出描述：
输出一行一个整数，满足条件的 t，注意 t 不能是负数。如果不存在满足条件的 t，输出 -1。
示例 1
输入
3
0 2 3
2 0 5
3 5 0
1 2 3
输出
0
说明
增加从 office 1 到 office 2 之间延时 t = 0 的专线后，延时最大的两个office之间的延时为 2。 而 t + 2 < 3 满足题意
 */