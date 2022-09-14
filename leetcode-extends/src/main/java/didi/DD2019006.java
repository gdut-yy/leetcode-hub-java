package didi;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class DD2019006 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int d = scanner.nextInt();
            System.out.println(solve(n, d));
        }
    }

    // 记忆化搜索
    private static long[][][][][] memo;

    private static String solve(int n, int d) {
        // momo[first][pos][posVal][subStrLen][cnt0]
        memo = new long[2][n + 1][2][n / 2 + 1][n / 2 + 1];
        for (int first = 0; first < 2; first++) {
            for (int pos = 0; pos < n + 1; pos++) {
                for (int posVal = 0; posVal < 2; posVal++) {
                    for (int subStrLen = 0; subStrLen < n / 2 + 1; subStrLen++) {
                        Arrays.fill(memo[first][pos][posVal][subStrLen], -1);
                    }
                }
            }
        }

        long res = 0;
        // 第一位为 0
        res += dfs(n, d, 0, 1, 0, 1, 1);
        // 第一位为 1
        res += dfs(n, d, 1, 1, 1, 1, 0);
        return String.valueOf(res);
    }

    // 总状态 2 * 64 * 2 * 32 * 32 = 262,144
    // first:第一位数字(0/1) pos:当前下标(1~n) posVal:当前状态(0/1) subStrLen:连续子串长度(1~n/2) cnt0:0的数量
    private static long dfs(int n, int d, int first, int pos, int posVal, int subStrLen, int cnt0) {
        if (pos == n) {
            return first == posVal ? 0 : 1;
        }
        // 1 的数量
        int cost1 = pos - cnt0;
        // 必定以 1 结尾
        if (cnt0 == n / 2) {
            return first == 1 ? 0 : 1;
        }
        // 必定以 0 结尾
        if (cost1 == n / 2) {
            return first == 0 ? 0 : 1;
        }
        if (memo[first][pos][posVal][subStrLen][cnt0] != -1) {
            return memo[first][pos][posVal][subStrLen][cnt0];
        }

        long res = 0;
        // 可以继续做同一件事
        if (subStrLen < d) {
            res += dfs(n, d, first, pos + 1, posVal, subStrLen + 1, posVal == 0 ? cnt0 + 1 : cnt0);
        }
        // 做不同的事
        res += dfs(n, d, first, pos + 1, 1 - posVal, 1, posVal == 0 ? cnt0 : cnt0 + 1);

        if (memo[first][pos][posVal][subStrLen][cnt0] == -1) {
            memo[first][pos][posVal][subStrLen][cnt0] = res;
        }
        return res;
    }
}
/*
DD-2019006. 宅男的生活
https://leetcode.cn/problems/zVzrT5/

阿宅是一名工程师，平时业余生活就两件事情，玩游戏和看美剧。好不容易迎来了 n(n 是偶数)天假期，阿宅惯例是宅着家里，玩游戏，看美剧。
他想雨露均沾对待这两件事情，每件事情都刚好占用 n/2 天时间。但是持续做一件事情久了人们就会感到厌倦，阿宅也不例外，
他不想连续 d 天在做同一件事情(如果在某一件事情花费的时间已经到 n/2 天了，剩下时间只能做另外一件事情，这种情况除外)。
阿宅同时还希望第一天的选择和最后一天的选择不一样。现在他想知道有多少种方案安排自己的时间，来最大程度的愉悦自己。聪明的你帮他算一算吧。
格式：
输入：
- 第一行输入一个数字 t, 表示接下来有 t 行输入数据，每行输入 n, d 两个数字。
输出：
- 输出 t 行，每行表示答案。
示例：
输入：
2
2 1
6 2
输出：
2
10
提示：
1 <= t <= 1000
2 <= n <= 64, n 保证是偶数
1 <= d <= n/2

记忆化搜索
相似题目: DD-2019001. 排列小球
https://leetcode.cn/problems/FHnt4H/
 */