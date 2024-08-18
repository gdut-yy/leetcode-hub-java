package lq240615;

import java.util.Scanner;

public class LQ240615T7 {
    static int n;
    static char[] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            s = scanner.next().toCharArray();
            System.out.println(solve());
        }
    }

    private static String solve() {
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (s[i] == s[i - 1]) ans++;
        }
        return ans % 3 != 0 ? "lan" : "qiao";
    }
}
/*
电力之城【算法赛】

提示 1：
当相邻的两个位置不同时2，可以产生 1 点电力，N 根电力之柱显然可以最多产生 N - 1 点电力。
提示 2：
任意一方操作时要么让电力增加 1，要么增加 2.
根据提示 1 和 提示 2，这个问题可以转换为以下经典博弈问题：
- 给定一堆数量为 x 的石头，每次可以移除 1 颗石子或者 2 颗石子，不能不移除，问先手必胜还是后手必胜。
答案的结论为：当 x 为 3 的倍数时先手必败，否则先手必胜。
在这道题目中 x 的值为相邻且状态相等的电力之柱数量。
 */