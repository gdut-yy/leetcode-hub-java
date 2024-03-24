package p1081;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1081B {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        List<Integer>[] id = new ArrayList[n + 1];
        Arrays.setAll(id, e -> new ArrayList<>());
        for (int i = 0; i < n; i++) {
            id[n - a[i]].add(i);
        }

        int left = 0, color = 0;
        int[] ans = new int[n];
        for (int c = 1; c <= n; c++) {
            if (id[c].size() % c > 0) {
                return "Impossible";
            }
            for (Integer i : id[c]) {
                if (left == 0) {
                    left = c;
                    color++;
                }
                ans[i] = color;
                left--;
            }
        }
        return "Possible" + System.lineSeparator() +
                Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
B. Farewell Party
https://codeforces.com/contest/1081/problem/B

灵茶の试炼 2022-07-15
题目大意：
输入 n(1<=n<=1e5) 和一个长为 n 的数组 a(0<=a[i]<=n-1)。
请你构造一个长度为 n 的数组 b，对于每个 b[i]，需要满足 b 中恰好有 a[i] 个元素和 b[i] 不同。
要求 1<=b[i]<=n。
如果不能构造，输出 "Impossible"；否则输出 "Possible" 和任意一个满足要求的数组 b。

constructive algorithms
rating 1500
https://codeforces.com/problemset/submission/1081/164214080
提示 1：转换一下，有 n-a[i] 个数和 b[i] 相同。
提示 2：把相同的 a[i] 分为一组。
提示 3：如果同一组内的元素个数比 n-a[i] 还多，那么在构造 b 时，需要每隔 n-a[i] 个数就换一个值。这同时说明，如果组的大小不是 n-a[i] 的倍数，那么就无法构造。
======

input
3
0 0 0
output
Possible
1 1 1

input
5
3 3 2 2 2
output
Possible
1 1 2 2 2

input
4
0 1 2 3
output
Impossible
 */
