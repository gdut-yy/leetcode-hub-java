package c299;

import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Abc299_g {
    static int n, m;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        m = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static final int MX = (int) (2e5 + 1);

    private static String solve() {
        int[] cntArr = new int[MX];
        for (int x : a) {
            cntArr[x]++;
        }

        // 栈中元素频次
        int[] stackArr = new int[MX];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int x : a) {
            // 无法入栈
            if (stackArr[x] == 1) {
                cntArr[x]--;
                continue;
            }
            // 栈顶元素能出栈
            while (!stack.isEmpty() && stack.peek() > x && cntArr[stack.peek()] > 1) {
                int pop = stack.pop();
                cntArr[pop]--;
                stackArr[pop]--;
            }
            stack.push(x);
            stackArr[x]++;
        }

        int sz = stack.size();
        int[] b = new int[sz];
        for (int i = sz - 1; i >= 0; i--) {
            b[i] = stack.pop();
        }
        return Arrays.stream(b).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
G - Minimum Permutation
https://atcoder.jp/contests/abc299/tasks/abc299_g

灵茶の试炼 2023-08-11
题目大意：
输入 n m(1≤m≤n≤2e5) 和长为 n 的数组 a(1≤a[i]≤m)，保证 [1,m] 内的所有整数都在 a 中。
输出 a 的一个长为 m 的子序列，要求它是一个 1~m 的排列，且字典序最小。

相似题目: 316. 去除重复字母
https://leetcode.cn/problems/remove-duplicate-letters/
======

Input 1
4 3
2 3 1 3
Output 1
2 1 3

Input 2
4 4
2 3 1 4
Output 2
2 3 1 4

Input 3
20 10
6 3 8 5 8 10 9 3 6 1 8 3 3 7 4 7 2 7 8 5
Output 3
3 5 8 10 9 6 1 4 2 7
 */