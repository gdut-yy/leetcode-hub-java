import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Java is J2SE 1.5, enjoy it!
 */
public class POJ2282 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        while (!line.equals("0 0")) {
            String[] lines = line.split(" ");
            int a = Integer.parseInt(lines[0]);
            int b = Integer.parseInt(lines[1]);
            System.out.println(solve(a, b));
            line = reader.readLine();
        }
    }

    private static String solve(int a, int b) {
        StringBuilder stringBuilder = new StringBuilder();
        int low = Math.min(a, b);
        int high = Math.max(a, b);
        long[] nums = new long[10];
        for (int i = 0; i <= 9; i++) {
            nums[i] = digitsCount(i, low, high);
            stringBuilder.append(nums[i]).append(" ");
        }
        return stringBuilder.substring(0, stringBuilder.length() - 1);
    }

    private static int x;

    public static long digitsCount(int d, int low, int high) {
        x = d;
        return countDigitOne(high) - countDigitOne(low - 1);
    }

    private static char[] s;
    private static long[][] dp;

    private static long countDigitOne(int n) {
        s = String.valueOf(n).toCharArray();
        int len = s.length;
        dp = new long[len][10];
        for (int i = 0; i < len; i++) {
            Arrays.fill(dp[i], -1);
        }
        return f(0, 0, true, false);
    }

    private static long f(int i, int sum, boolean isLimit, boolean isNum) {
        if (i == s.length) {
            return isNum ? sum : 0;
        }
        // 记忆化搜索
        if (!isLimit && isNum && dp[i][sum] >= 0) {
            return dp[i][sum];
        }
        long res = 0;
        if (!isNum) {
            // 可以跳过当前数位
            res = f(i + 1, sum, false, false);
        }
        int up = isLimit ? s[i] - '0' : 9;
        for (int d = isNum ? 0 : 1; d <= up; d++) {
            res += f(i + 1, sum + (d == x ? 1 : 0), isLimit && d == up, true);
        }
        if (!isLimit && isNum) {
            dp[i][sum] = res;
        }
        return res;
    }
}
/*
The Counting Problem
http://poj.org/problem?id=2282
 */