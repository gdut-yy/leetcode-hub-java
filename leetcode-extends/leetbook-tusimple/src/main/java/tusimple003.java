import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class tusimple003 {
    static Scanner scanner;
    static PrintWriter out;
    static final int MOD = (int) (1e9 + 7);

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
        int k = scanner.nextInt();

        Map<String, Integer> groups = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String s = scanner.next();
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            groups.put(key, groups.getOrDefault(key, 0) + 1);
        }

        // 组合数 C[i][j]
        int[][] C = new int[n + 1][n + 1];
        C[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            C[i][0] = C[i][i] = 1;
            for (int j = 1; j < i; j++) {
                C[i][j] = C[i - 1][j - 1] + C[i - 1][j];
                if (C[i][j] >= MOD) C[i][j] -= MOD;
            }
        }

        int[] dp = new int[k + 1];
        dp[0] = 1;

        for (int cnt : groups.values()) {
            int[] ndp = dp.clone(); // 当前组选 0 个

            for (int x = 1; x <= cnt; x++) {
                int pairs = x * (x - 1) / 2;
                if (pairs > k) break;

                long ways = C[cnt][x];
                for (int j = 0; j + pairs <= k; j++) {
                    if (dp[j] == 0) continue;
                    ndp[j + pairs] = (int) ((ndp[j + pairs] + dp[j] * ways) % MOD);
                }
            }

            dp = ndp;
        }

        out.println(dp[k]);
    }
}
/*
tusimple-003. 相似单词
https://leetcode.cn/problems/va5fO1/description/

TuTu 新接到一个任务。
他现在一共有 n 个单词。他需要完成一个和相似单词相关的任务。
相似单词的定义是这样的：如果可以通过重新排列一个单词的字母，从而得到另一个单词，则这两个单词是相似的。
现在 TuTu 想知道，有多少种不同的方案数，可以从 n 个单词中选择一个子集（可以是空集），而且该子集中恰好有 k 对相似的单词。
输入描述:
第一行包含整数 n 和 k (1 <= n <= 2000, 0 <= k <= 2000)，分别表示单词数量和所需的相似对数。
接下来的 n 行，每行包含一个由最多 10 个小写字母组成的单词。
输入保证所有给定的单词都是不同的。
输出描述:
输出一行包含一个整数，表示答案，因为答案可能很大，所以只需要输出以 10^9+7 为模的符合条件的子集的数量。
样例1
输入
3 1
ovo
ono
voo
输出 2
说明 正好有一对相似单词的子集是 {ovo,ono,voo} 和 {ovo,voo}。
备注:
对于其中 40% 的数据，满足 1 <= n <= 15； 对于其中另外 30% 的数据，满足 0 <= k <= 3。
 */