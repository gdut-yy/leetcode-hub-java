package lq240531;

import java.util.Arrays;
import java.util.Scanner;

public class LQ240531T8 {
    static int n;
    static int[] nums;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt() - 1;
        }
        System.out.println(solve());
    }

    private static String solve() {
        int[] dp = new int[f(n, n)];
        int[] left = new int[n];
        Arrays.fill(left, n);
        int[] right = new int[n];
        Arrays.fill(right, -1);

        for (int i = 0; i < n; i++) {
            left[nums[i]] = Math.min(left[nums[i]], i);
            right[nums[i]] = Math.max(right[nums[i]], i);
        }

        for (int i = 0; i < n; i++) {
            if (left[nums[i]] == right[nums[i]] && left[nums[i]] == i) {
                dp[f(i, i)] = 1;
            }
        }

        for (int length = 2; length < n + 1; length++) {
            for (int l = 0; l < n - length + 1; l++) {
                int r = l + length - 1;

                int l_score = (left[nums[l]] == l && right[nums[l]] <= r) ? 1 : 0;
                int r_score = (right[nums[r]] == r && left[nums[r]] >= l) ? 1 : 0;
                dp[f(l, r)] = Math.max(l_score - dp[f(l + 1, r)], r_score - dp[f(l, r - 1)]);
            }
        }

        int tot = 0;
        for (int i = 0; i < n; i++) {
            if (right[i] != -1) tot += 1;
        }
        int ans = dp[f(0, n - 1)];
        return ((tot + ans) / 2) + " " + ((tot - ans) / 2);
    }

    static int f(int x, int y) {
        return x * n + y;
    }
}
/*
气球大比拼【算法赛】

很典型的区间 DP
l 到 r 的博弈结果是 dp[l][r]
dp[l+1][r] 和 dp[l][r-1]
dp[l][r] 先手比后手多拿了多少分
dp[l][r] = max(取 l 的得分 - dp[l+1][r], 取 r 的得分 -dp[l][r-1])
O(n^2)
只需要判断当前区间是 [l,r] 的情况下，取 l 拿多少分
只需看区间外是否出现了 nums[l]
@小羊肖恩Yawn_Sean
 */