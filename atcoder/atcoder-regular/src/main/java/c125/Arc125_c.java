package c125;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Arc125_c {
    static int n, k;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        k = scanner.nextInt();
        a = new int[k];
        for (int i = 0; i < k; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        List<Integer> miss = new ArrayList<>();
        int x = 0;
        for (int v : a) {
            // for x++; x < a[i]; x++ {
            //   miss = append(miss, x)
            // }
            x++;
            while (x < v) {
                miss.add(x);
                x++;
            }
        }
        // for x++; x <= n; x++ {
        //   miss = append(miss, x)
        // }
        x++;
        while (x <= n) {
            miss.add(x);
            x++;
        }

        int j = 0;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k - 1; i++) {
            ans.add(a[i]);
            if (j < miss.size() && miss.get(j) < a[i]) {
                ans.add(miss.get(j));
                j++;
            }
        }
        int i = miss.size() - 1;
        while (i >= j && miss.get(i) > a[k - 1]) {
            ans.add(miss.get(i));
            i--;
        }
        ans.add(a[k - 1]);
        while (i >= j) {
            ans.add(miss.get(i));
            i--;
        }
        return ans.stream().map(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
C - LIS to Original Sequence
https://atcoder.jp/contests/arc125/tasks/arc125_c

灵茶の试炼 2022-12-13
题目大意：
输入 n k (k≤n≤2e5) 和一个长为 k 的严格递增数组 a，元素范围 [1,n]。
输出一个 1~n 的排列 p，使得 a 是 p 的一个 LIS。
如果有多个这样的 p，输出字典序最小的那个。
注：LIS 指最长上升子序列。

https://atcoder.jp/contests/arc125/submissions/37235888
提示 1：先思考（手玩）一个简单的情况，如果没有字典序最小的要求，要如何构造答案？
提示 2：继续手玩，让你构造出的排列的字典序尽量小。
提示 3：构造方案如下：
把不在 a 中的数字记到 miss 数组中。
双指针遍历 a 的前 k-1 个数以及 miss，如果 miss[j] < a[i]，那么 miss[j] 就可以插在 a[i] 和 a[i+1] 之间。
最后把 a[k-1] 加到剩余的 miss 中，从大到小输出。
======

Input 1
3 2
2 3
Output 1
2 1 3

Input 2
5 1
4
Output 2
5 4 3 2 1
 */