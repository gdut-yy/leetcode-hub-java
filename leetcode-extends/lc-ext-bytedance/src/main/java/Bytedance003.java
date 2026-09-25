import java.io.PrintWriter;
import java.util.Scanner;

public class Bytedance003 {
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
        String[] strings = scanner.next().split(",");
        String s = strings[0], t = strings[1];

        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1);
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + (s.charAt(i - 1) == t.charAt(j - 1) ? 0 : 1));
            }
        }
        out.println(dp[n][m]);
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