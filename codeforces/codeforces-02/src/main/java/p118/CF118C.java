package p118;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CF118C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        char[] digits = scanner.next().toCharArray();
        System.out.println(solve(n, k, digits));
    }

    private static String solve(int n, int k, char[] digits) {
        Map<Character, List<Integer>> chIdsMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            chIdsMap.computeIfAbsent(digits[i], key -> new ArrayList<>()).add(i);
        }

        String ans = "";
        int minCost = Integer.MAX_VALUE;
        // 有 k 个 x
        for (char x = '0'; x <= '9'; x++) {
            char[] cs = digits.clone();
            int cost = 0;
            // 还需要转换 remain 个 x
            int remain = k - chIdsMap.getOrDefault(x, new ArrayList<>()).size();
            for (int d = 1; d <= 9; d++) {
                if (x + d <= '9') {
                    List<Integer> p = chIdsMap.getOrDefault((char) (x + d), new ArrayList<>());
                    // 正序
                    for (int i = 0; i < p.size() && remain > 0; i++) {
                        cs[p.get(i)] = x;
                        remain--;
                        cost += d;
                    }
                }
                if (x - d >= '0') {
                    List<Integer> p = chIdsMap.getOrDefault((char) (x - d), new ArrayList<>());
                    // 逆序
                    for (int i = p.size() - 1; i >= 0 && remain > 0; i--) {
                        cs[p.get(i)] = x;
                        remain--;
                        cost += d;
                    }
                }
            }

            if (minCost > cost) {
                minCost = cost;
                ans = new String(cs);
            } else if (minCost == cost && new String(cs).compareTo(ans) < 0) {
                // 8 4
                // 22294777
                ans = new String(cs);
            }
        }
        return minCost
                + System.lineSeparator()
                + ans;
    }
}
/*
C. Fancy Number
https://codeforces.com/contest/118/problem/C

灵茶の试炼 2023-03-17
题目大意：
输入 n k(2≤k≤n≤1e4) 和长为 n 的字符串 s，仅包含 '0'~'9'。
每次操作你可以把一个 s[i] 修改成任意 '0'~'9'，假设修改成 b，则花费为 abs(s[i]-b)。
要使 s 中至少有 k 个相同字符，求最小总花费。
同时，你需要在总花费最小的前提下，让修改后的 s 的字典序尽量小。
输出最小总花费以及修改后的 s。
思考：如果把 s 换成一个值域范围更大的整数数组，你能想出一个更优的做法吗？

rating 1900
https://codeforces.com/contest/118/submission/197621784
枚举 + 贪心。
枚举修改后有 k 个 0/1/2/.../9。取花费最小且字典序最小的为答案。
比如修改成 4，那么从近到远依次考虑，修改 53627189 成 4。（注意先改 5 再改 3）
为了让字典序尽量小：
比 4 大的数字，从左到右修改。
比 4 小的数字，从右到左修改。
======

input
6 5
898196
output
4
888188

input
3 2
533
output
0
533

input
10 6
0001112223
output
3
0000002223
 */
