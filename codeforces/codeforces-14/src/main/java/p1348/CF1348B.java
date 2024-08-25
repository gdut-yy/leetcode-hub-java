package p1348;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1348B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve(n, k, a));
        }
    }

    private static String solve(int n, int k, int[] a) {
        // 去重
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[n + 1];
        for (int i = 0; i < n; i++) {
            if (!visited[a[i]]) {
                visited[a[i]] = true;
                list.add(a[i]);
            }
        }

        int sz = list.size();
        if (sz > k) {
            return "-1";
        }
        // 用 1 补齐 sz 至 k
        for (int i = sz; i < k; i++) {
            list.add(1);
        }

        // 重复 n 次
        List<Integer> resList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            resList.addAll(list);
        }
        return resList.size()
                + System.lineSeparator()
                + resList.stream().map(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
B. Phoenix and Beauty
https://codeforces.com/contest/1348/problem/B

灵茶の试炼 2023-04-03
题目大意：
输入 t(≤50) 表示 t 组数据。
每组数据输入 n k(1≤k≤n≤100) 和长为 n 的数组 a(1≤a[i]≤n)。
你可以在 a 中插入任意多个整数（包括开头和末尾），这些数必须在区间 [1,n] 内。
设插入之后的数组为 b，要求 b 中每个长为 k 的子数组的元素和必须都相同，且 b 的长度不能超过 1e4。
如果无法做到，输出 -1。否则输出数组 b 的长度，以及数组 b。
如果有多个答案，输出任意一个均可。

rating 1400
https://codeforces.com/contest/1348/submission/127732185
相关题目：上周六双周赛第三题
突破口在 1e4，构造一个长为 k 的循环节，这个循环节要包含 a 中所有数字。把循环节重复 n 次得到 b，这样可以保证 a 是 b 的一个子序列，且长度至多 n*k 不会超过 1e4。
例如 a=[2,2,3,3]，k=3，构造循环节 [2,3,1]（a 去重，如果不足 k 个，补上 1），重复 4 次得到 [2,3,1,2,3,1,2,3,1,2,3,1]。
如果 a 去重后，元素个数大于 k，则输出 -1。
相似题目: 2607. 使子数组元素和相等
https://leetcode.cn/problems/make-k-subarray-sums-equal/
======

input
4
4 2
1 2 2 1
4 3
1 2 2 1
3 2
1 2 3
4 4
4 3 4 2
output
5
1 2 1 2 1
4
1 2 2 1
-1
7
4 3 2 1 4 3 2
 */
