package bytedance;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Bytedance003 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        String[] strings = scanner.next().split(",");
        System.out.println(solve(strings));
    }

    private static String solve(String[] strings) {
        int len1 = strings[0].length();
        int len2 = strings[1].length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i < len1 + 1; i++) {
            for (int j = 1; j < len2 + 1; j++) {
                dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1);
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + (strings[0].charAt(i - 1) == strings[1].charAt(j - 1) ? 0 : 1));
            }
        }
        return String.valueOf(dp[len1][len2]);
    }
}
/*
bytedance-003. 古生物血缘远近判定
https://leetcode.cn/problems/LJXRel/

DNA 是由 ACGT 四种核苷酸组成，例如 AAAGTCTGAC，假定自然环境下 DNA 发生异变的情况有：
1.基因缺失一个核苷酸
2.基因新增一个核苷酸
3.基因替换一个核苷酸
且发生概率相同。
古生物学家 Sam 得到了若干条相似 DNA 序列，Sam 认为一个 DNA 序列向另外一个 DNA 序列转变所需的最小异变情况数可以代表其物种血缘相近程度，
异变情况数越少，血缘越相近，请帮助 Sam 实现获取两条 DNA 序列的最小异变情况数的算法。
格式：
输入：
- 每个样例只有一行，两个 DNA 序列字符串以英文逗号“,”分割
输出：
- 输出转变所需的最少情况数，类型是数字
示例：
输入：ACT,AGCT
输出：1
提示：
每个 DNA 序列不超过 100 个字符
 */