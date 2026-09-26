import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class tusimple004 {
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
        String str = scanner.next();

        int y = 0;
        List<int[]> vec = new ArrayList<>();
        char last = '=';

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == '+') {
                if (last == '+') y++;
                vec.add(new int[]{y, '/'});
                last = '+';
            } else if (c == '-') {
                if (last != '+') y--;
                vec.add(new int[]{y, '\\'});
                last = '-';
            } else {
                if (last == '+') y++;
                vec.add(new int[]{y, '-'});
                last = '=';
            }
        }

        int mn = Integer.MAX_VALUE;
        int mx = Integer.MIN_VALUE;

        for (int[] p : vec) {
            mn = Math.min(mn, p[0]);
            mx = Math.max(mx, p[0]);
        }

        char[][] ans = new char[mx - mn + 1][n];
        for (int i = 0; i < ans.length; i++) {
            Arrays.fill(ans[i], '.');
        }

        for (int i = 0; i < vec.size(); i++) {
            int[] p = vec.get(i);
            ans[p[0] - mn][i] = (char) p[1];
        }

        for (int i = ans.length - 1; i >= 0; i--) {
            out.println(new String(ans[i]));
        }
    }
}
/*
tusimple-004. 可视化
https://leetcode.cn/problems/NMTYve/description/

作为即将成为自动驾驶工程师的 TuTu 自然需要掌握对一些内容进行可视化的技能。
为了训练自己，现在 TuTu 决定画一条线代表他在 n 天时间内的净资产变化。
对于 n 天中的每一天，他的净资产会增加 1 单位（以 + 表示）、减少 1 单位（以 - 表示）或保持不变（以 = 表示）。其中，在第一天之前，TuTu 的净资产等于零。
TuTu 将以一个无限大的字符矩阵来画线。矩阵行的索引向上增长，并且列的索引向右增长。
在第 i 天，他将在第 i 列中绘制一些字符。该行的字符和索引由以下规则决定：
如果净资产在第 i 天增加，则他将在某行中绘制 / ，其行索引等于当日开始时的净资产。
如果净资产在第 i 天减少，则他将在某行中绘制 \ ，其行索引等于当日结束时的净资产。
如果第 i 天的净值未发生变化，则他将在某行中绘制 - ，其行索引等于该天的净资产 。 所有其他单元格都用 . 填充。
TuTu 的任务是输出该无限大矩阵中一个包含所有有效信息的整行的最小矩阵，即包含所有字符 / 、 \ 和 - 的矩阵。
输入描述:
第一行包含整数 n (1 <= n <= 100) ，表示天数。
第二行包含 n 个字符的字符串 + ，- 和 =，代表净资产在指定时间内发生了变化。
输出描述:
输出无限大矩阵中一个包含所有有效信息的整行的最小矩阵。
样例1
输入
7
++---==
输出
./\....
/..\...
....\--
备注:
对于其中 40% 的数据，输入内容将不包含字符 -。
 */