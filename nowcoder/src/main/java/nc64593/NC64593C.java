package nc64593;

import java.util.Scanner;

public class NC64593C {
    static char[] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        s = scanner.next().toCharArray();
        System.out.println(solve());
    }

    // https://ac.nowcoder.com/acm/contest/view-submission?submissionId=63868084
    private static String solve() {
        int n = s.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int a = 0, b = 0, c = 0, d = 0;
            for (int j = i; j < n; j++) {
                if (j % 2 == i % 2) {
                    if (s[j] == '0') b++;
                    else a++;
                } else {
                    if (s[j] == '0') d++;
                    else c++;
                }
                ans += Math.min(a + d, b + c);
            }
        }
        return String.valueOf(ans);
    }
}
/*
小美的01串翻转
https://ac.nowcoder.com/acm/contest/64593/C

题目描述
小美定义一个 01 串的权值为：每次操作选择一位取反，使得相邻字符都不相等的最小操作次数。
例如，"10001"的权值是 1，因为只需要修改一次：对第三个字符取反即可。
现在小美拿到了一个 01 串，她希望你求出所有非空连续子串的权值之和，你能帮帮她吗？
输入描述:
一个仅包含'0'和'1'的字符串，长度不超过 2000。
输出描述:
所有非空子串的权值和。

======

示例1
输入
10001
输出
8
说明
长度为 2 的子串中，有 2 个"00"的权值是 1。
长度为 3 的 3 个子串权值都是 1。
长度为 4 的 2 个子串权值都是 1。
长度为 5 的 1 个子串权值是 1。
总权值之和为 2+3+2+1=8
 */