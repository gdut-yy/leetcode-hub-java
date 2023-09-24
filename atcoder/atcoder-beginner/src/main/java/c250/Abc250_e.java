package c250;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Abc250_e {
    static int n;
    static int[] a, b;
    static int q;
    static int[][] xy;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
        }
        b = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            b[i] = scanner.nextInt();
        }
        q = scanner.nextInt();
        xy = new int[q][2];
        for (int i = 0; i < q; i++) {
            xy[i][0] = scanner.nextInt();
            xy[i][1] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static final int INF = (int) 1e9;

    private static String solve() {
        Map<Integer, Integer> id = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            int v = a[i];
            if (!id.containsKey(v)) {
                id.put(v, id.size() + 1);
            }
            a[i] = Math.max(a[i - 1], id.get(v));
        }

        int mx = 1;
        // set := map[int]struct{}{}
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            int v = id.getOrDefault(b[i], 0);
            if (v == 0) {
                mx = INF;
            }
            mx = Math.max(mx, v);
            // set[v] = struct{}{}
            set.add(v);
            if (mx == set.size()) {
                b[i] = mx;
            } else {
                b[i] = 0;
            }
        }

        String[] ans = new String[q];
        for (int i = 0; i < q; i++) {
            int x = xy[i][0], y = xy[i][1];
            ans[i] = (a[x] == b[y]) ? "Yes" : "No";
        }
        return String.join(System.lineSeparator(), ans);
    }
}
/*
E - Prefix Equality
https://atcoder.jp/contests/abc250/tasks/abc250_e

灵茶の试炼 2022-10-21
题目大意：
输入 n(≤2e5) 和两个长为 n 的数组 a 和 b，元素范围在 [1,1e9]。
然后输入 q(≤2e5) 表示 q 个询问，每个询问输入两个数 x 和 y，范围在 [1,n]。
对每个询问，设 a 的前 x 个元素去重得到集合 A，b 的前 y 个元素去重得到集合 B，如果 A = B，输出 "Yes"，否则输出 "No"。

https://atcoder.jp/contests/abc250/submissions/35814659
为方便处理，首先把数组 a 转换成升序：
例如，先把 31412 置换为 12324，然后求前缀最大值得到 12334（不影响答案的正确性）。
数组 b 也做同样的置换，然后我们需要找到一个前缀，恰好包含 1~x 所有数字（即不能有断开的部分）实现方法见 https://leetcode.cn/problems/max-chunks-to-make-sorted/ 中提到的技巧。
这样可以标记 b[i] 应该匹配到 a 中的哪个数。
======

Input 1
5
1 2 3 4 5
1 2 2 4 3
7
1 1
2 2
2 3
3 3
4 4
4 5
5 5
Output 1
Yes
Yes
Yes
No
No
Yes
No
 */