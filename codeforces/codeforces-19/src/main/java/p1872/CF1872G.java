package p1872;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CF1872G {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
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

    // https://codeforces.com/contest/1872/submission/222437122
    private static String solve() {
        long maxp = 2L * n;
        long prod = 1;
        for (int x : a) {
            prod *= x;
            if (prod > maxp) break;
        }
        if (prod > maxp) {
            int l = 0, r = n - 1;
            while (l < n && a[l] == 1) l++;
            while (r >= 0 && a[r] == 1) r--;
            return (l + 1) + " " + (r + 1);
        }

        List<Integer> not1 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (a[i] > 1) {
                not1.add(i);
            }
        }
        long maxval = 0;
        int l = 0, r = 0;
        int sz = not1.size();
        for (int x = 0; x < sz; x++) {
            long p = 1, s = 0;
            for (int y = x; y < sz; y++) {
                int i = not1.get(x);
                int j = not1.get(y);
                p *= a[j];
                s += a[j] - 1;
                if (maxval <= p - s - (j - i + 1)) {
                    maxval = p - s - (j - i + 1);
                    l = i;
                    r = j;
                }
            }
        }
        return (l + 1) + " " + (r + 1);
    }
}
/*
G. Replace With Product
https://codeforces.com/contest/1872/problem/G

灵茶の试炼 2024-02-08
题目大意：
给定一个包含 n 个正整数的数组 a。以下操作只需要执行一次:
- 选择 2 个整数 l 和 r(1≤l≤r≤n)，将子数组 a[l...r]替换为单个元素:子数组中所有元素的乘积(al·...·ar)。
例如，如果对数组[5,4,3,2,1]进行参数为 l=2,r=4 的操作，则数组将变为[5,24,1]。
您的任务是在应用此操作后最大化数组的和。找到应用此操作的最优子数组。

乘积 爆 long
---
https://codeforces.com/blog/entry/120165
关键观察:如果数组中所有元素的乘积足够大，则对整个数组执行操作总是最佳的，除了可能由 1 组成的前缀/后缀。
你可以估计足够大，例如，2^60(实际上，2·n 就足够了)。不会有证据，但事实就是这样。
现在问题简化为数组的乘积不大于 2^60 的情况。这意味着大于 1 的数组元素的数量最多为 60 个。
注意，在最优线段中，不会出现左/右元素等于 1 的情况，因为这样我们就可以移动边界，总和就会增加 1。
因此，段的开始和结束都必须在非 1 元素中。这意味着最多有 60^2 个有趣的分段选项。
我们可以显式地遍历它们并选择最好的一个。使用前缀乘积和和来快速估计特定部分的价值。
======

input
9
4
1 3 1 3
4
1 1 2 3
5
1 1 1 1 1
5
10 1 10 1 10
1
1
2
2 2
3
2 1 2
4
2 1 1 3
6
2 1 2 1 1 3
output
2 4
3 4
1 1
1 5
1 1
1 2
2 2
4 4
1 6
 */
