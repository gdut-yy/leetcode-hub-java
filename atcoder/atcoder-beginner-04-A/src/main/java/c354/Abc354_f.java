package c354;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Abc354_f {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        int[] pre = new int[n];
        List<Integer> g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int v = a[i];
            int j = lowerBound(g, v);
            if (j == g.size()) g.add(v);
            else g.set(j, v);
            pre[i] = j + 1;
        }

        int[] suf = new int[n];
        g.clear();
        for (int i = n - 1; i >= 0; i--) {
            int v = -a[i];
            int j = lowerBound(g, v);
            if (j == g.size()) g.add(v);
            else g.set(j, v);
            suf[i] = j + 1;
        }

        int lis = g.size();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (pre[i] + suf[i] - 1 == lis) {
                ans.add(i + 1);
            }
        }
        return ans.size() + System.lineSeparator()
                + ans.stream().map(String::valueOf).collect(Collectors.joining(" "));
    }

    static int lowerBound(List<Integer> a, int key) {
        int l = 0, r = a.size();
        while (l < r) {
            int m = l + (r - l) / 2;
            if (a.get(m) >= key) r = m;
            else l = m + 1;
        }
        return l;
    }
}
/*
F - Useless for LIS
https://atcoder.jp/contests/abc354/tasks/abc354_f

灵茶の试炼 2024-05-31 ext
题目大意：
给你一个长度为 $N$ 的整数序列 $A$ 。
对于每个 $t = 1, 2, \dots, N$ ，判断 $A_t$ 是否包含在 $A$ 的最长递增子序列中。
这里，当且仅当以下条件成立时， $A_t$ 才包含在 $A$ 的最长递增子序列中：
- 设 $L$ 是 $A$ 的最长递增子序列的长度。存在一个严格递增的整数序列 $i = (i_1, i_2, \dots, i_L) \ (i_1 &lt; i_2 &lt; \dots &lt; i_L)$ ，其中每个元素都在 $1$ 和 $N$ 之间，且满足以下所有条件：
    - $A_{i_1} &lt; A_{i_2} &lt; \dots &lt; A_{i_L}$ .
    - $i_k = t$ 为某个 $k \ (1 \leq k \leq L)$ 。
给你 $T$ 个测试用例，请逐个求解。
什么是最长递增子序列？
序列 $A$ 的子序列是从 $A$ 中抽取一些元素而不改变顺序得到的序列。
序列 $A$ 的最长递增子序列是 $A$ 的子序列，它以最大可能的长度严格递增。
- $1 \leq T \leq 2 \times 10^5$
- $1 \leq N \leq 2 \times 10^5$
- $1 \leq A_i \leq 10^9$
- 所有测试用例中 $N$ 的总和最多为 $2 \times 10^5$ 。

https://atcoder.jp/contests/abc354/submissions/54037743
======

Input 1
1
5
2 1 4 5 3
Output 1
4
1 2 3 4

Input 2
2
6
2 5 3 4 3 4
5
10000 1000 100 1 10
Output 2
5
1 3 4 5 6
2
4 5
 */