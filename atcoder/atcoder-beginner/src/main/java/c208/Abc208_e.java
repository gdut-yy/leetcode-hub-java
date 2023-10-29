package c208;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Abc208_e {
    static char[] s;
    static int k;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        s = scanner.next().toCharArray();
        k = scanner.nextInt();
        System.out.println(solve());
    }

    static Map<Long, Long>[] dp;

    private static String solve() {
        dp = new HashMap[s.length];
        Arrays.setAll(dp, e -> new HashMap<>());
        long ans = f(0, 1, true, false);
        return String.valueOf(ans);
    }

    private static long f(int i, long mul, boolean isLimit, boolean isNum) {
        if (i == s.length) {
            return isNum && mul <= k ? 1 : 0;
        }
        // 记忆化搜索
        if (!isLimit && isNum && dp[i].containsKey(mul)) {
            return dp[i].get(mul);
        }
        long res = 0;
        if (!isNum) {
            // 可以跳过当前数位
            res = f(i + 1, mul, false, false);
        }
        for (int d = isNum ? 0 : 1, up = isLimit ? s[i] - '0' : 9; d <= up; d++) {
            res += f(i + 1, mul * d, isLimit && d == up, true);
        }
        if (!isLimit && isNum) {
            dp[i].put(mul, res);
        }
        return res;
    }
}
/*
E - Digit Products
https://atcoder.jp/contests/abc208/tasks/abc208_e

灵茶の试炼 2023-09-28
题目大意：
输入 n(1≤n≤1e18) 和 k(1≤k≤1e9)。
问：有多少个不超过 n 的正整数，其数位乘积不超过 k？

注意到乘积要么是 0，要么可以写成 2^a * 3^b * 5^c * 7^d 的形式。
所以只有 O(log^4 k) 个不同的数位乘积。
数位 DP 模板秒杀。记忆化用哈希表。
https://atcoder.jp/contests/abc208/submissions/45250040
======

Input 1
13 2
Output 1
5

Input 2
100 80
Output 2
99

Input 3
1000000000000000000 1000000000
Output 3
841103275147365677
 */