package p1365;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CF1365F {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = scanner.nextInt();
            }
            System.out.println(solve(n, a, b));
        }
    }

    private static String solve(int n, int[] a, int[] b) {
        Map<Long, Integer> cntMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long key1 = (long) a[i] << 32 | a[n - 1 - i];
            long key2 = (long) b[i] << 32 | b[n - 1 - i];
            cntMap.put(key1, cntMap.getOrDefault(key1, 0) + 1);
            cntMap.put(key2, cntMap.getOrDefault(key2, 0) - 1);
        }

        if ((n & 1) == 1 && a[n / 2] != b[n / 2]) {
            return "No";
        }
        for (int c : cntMap.values()) {
            if (c > 0) {
                return "No";
            }
        }
        return "yes";
    }
}
/*
F. Swaps Again
https://codeforces.com/contest/1365/problem/F

灵茶の试炼 2023-03-31
题目大意：
输入 t(≤500) 表示 t 组数据。
每组数据输入 n(≤500) 和两个长为 n 的数组 a b，元素范围在 [1,1e9]。
你可以执行如下操作任意次：
首先选择一个在 [1,n/2] 范围内的整数 k，然后交换 a 的长为 k 的前缀与长为 k 的后缀。
例如 [1,2,3,4,5,6] k=2 交换后为 [5,6,3,4,1,2]
a 能否变成 b？输出 Yes 或 No。
进阶：如果可以做到，用 3n/2 次操作完成。

https://codeforces.com/problemset/submission/1365/199894156
提示 1：操作不会改变什么性质？
提示 2：如果两个数 x y 在交换前关于 n/2 对称，那么交换后也是对称的（即便位置变了）
简单证明：x 向右移动距离 = y 向左移动距离（任意被交换的元素移动距离都是相等的）
统计 a 中对称位置组成的数对及其个数，b 中对称位置组成的数对及其个数。
如果所有个数都相同，则方案存在。（注意 n 为奇数时 a[n/2] 需要等于 b[n/2]）
具体可以从内向外构造
例如 abczyx 变成 xcybza，可以先从最内部的 yb 开始。
abczyx -> yxczab -> bxczay -> zaybxc
k 分别是 2,1,3（把 y 和 b 移动到最外侧，然后交换到内侧）
然后解决 cz，k=2 即可：
zaybxc -> xcybza
======

input
5
2
1 2
2 1
3
1 2 3
1 2 3
3
1 2 4
1 3 4
4
1 2 3 2
3 1 2 2
3
1 2 3
1 3 2
output
yes
yes
No
yes
No
 */