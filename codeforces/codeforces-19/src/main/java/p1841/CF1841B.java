package p1841;

import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class CF1841B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int q = scanner.nextInt();
            int[] x = new int[q];
            for (int i = 0; i < q; i++) {
                x[i] = scanner.nextInt();
            }
            System.out.println(solve(q, x));
        }
    }

    private static String solve(int q, int[] x) {
        char[] ans = new char[q];

        int cnt = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < q; i++) {
            if (deque.isEmpty()) {
                deque.add(x[i]);
                ans[i] = '1';
            } else {
                // 小于当前最后一个元素 表示有两段递增
                int n1 = x[i] < deque.getLast() ? 1 : 0;
                // 这个时候不能小于第一个元素 x[0]
                int n2 = x[i] > x[0] ? 1 : 0;
                if (n1 + n2 + cnt <= 1) {
                    deque.add(x[i]);
                    ans[i] = '1';
                    cnt += n1;
                } else {
                    ans[i] = '0';
                }
            }
        }
        return new String(ans);
    }
}
/*
B. Keep it Beautiful
https://codeforces.com/contest/1841/problem/B

题目大意：
如果数组[a1,a2,...,ak]可以从数组的开头删除几个(可能是零)元素，并以相同的顺序将所有这些元素插入到数组的后面，从而使结果数组按非降序排序，则称为美观数组。
换句话说，如果存在一个整数 i∈[0,k−1]，使得数组[ai+1,ai+2,...,ak−1,ak,a1,a2,...,ai]按非降序排序，则数组[a1,a2,...,ak]是美丽的。
例如:
- [3,7,7,9,2,3]很漂亮:我们可以删除前面的四个元素，并以相同的顺序插入到后面，我们得到数组[2,3,3,7,7,9]，它是按非降序排序的;
- [1,2,3,4,5]很漂亮:我们可以删除 0 个元素并将它们插入到后面，我们得到数组[1,2,3,4,5]，它是按非降序排序的;
- [5,2,2,1]不漂亮。请注意，任何包含 0 个元素或 1 个元素的数组都是漂亮的。
给你一个数组 a，它最初是空的。你必须处理 q 个查询。在第 i 次查询期间，您将得到一个整数 xi，您必须执行以下操作:
如果你能把整数 xi 加到数组 a 后面让数组 a 保持原样，你就必须把它加进去;
否则，什么都不做。
在每次查询之后，报告是否附加了给定的整数 xi。
---
如果数组 a 是空的，
或者非降的，
或者可以由一个非降数组循环右移得到，
则称 a 是合法的。
从一个空数组开始，不断读取 q 个数，
如果这个数加到数组末尾，可以使数组是合法的，
则加入末尾，并输出 1；否则忽略，并输出 0。

贪心。
======

input
3
9
3 7 7 9 2 4 6 3 4
5
1 1 1 1 1
5
3 2 1 2 3
output
111110010
11111
11011
 */
