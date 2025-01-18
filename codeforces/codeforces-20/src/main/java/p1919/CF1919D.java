package p1919;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CF1919D {
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
        int c0 = 0;
        for (int v : a) if (v == 0) c0++;
        if (c0 != 1) return "NO";

        int[] left = new int[n];
        List<Integer> st = new ArrayList<>();
        st.add(-1);
        for (int i = 0; i < n; i++) {
            while (st.size() > 1 && st.getLast() >= a[i]) {
                st.removeLast();
            }
            left[i] = st.getLast();
            st.add(a[i]);
        }

        st.clear();
        st.add(n);
        for (int i = n - 1; i >= 0; i--) {
            int v = a[i];
            while (st.size() > 1 && st.getLast() >= v) {
                st.removeLast();
            }
            int right = st.getLast();
            if (v > 0 && right != v - 1 && left[i] != v - 1) {
                return "NO";
            }
            st.add(v);
        }
        return "YES";
    }
}
/*
D. 01 Tree
https://codeforces.com/contest/1919/problem/D

灵茶の试炼 2024-09-19
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(2≤n≤2e5) 和长为 n 的数组 a(0≤a[i]≤n-1)。
判断能否构造一棵有 n 个节点的带权满二叉树（每个节点都有 0 或 2 个子节点），满足如下性质：
1. 对于每个非叶节点 x，x 到其左右儿子的边权，其中一个是 0，另一个是 1。
2. 按照先序遍历访问叶子，根到第 i 个叶子的距离恰好等于 a[i]。
能否构造？输出 YES 或 NO。

rating 2100
逆向思维，考虑怎么从一个节点开始，得到这棵树。
n=1，树上只有一个节点（根节点），它到自己的距离为 0，数组是 [0]。
n=2，在 n=1 的基础上添加两个节点，现在数组是 [0,1] 或者 [1,0]。相当于原数组中的 0 保持不变，我们插入了一个 1。
一般地，每次添加两个节点，相当于在数组中的某个数 x 的左边或右边插入一个数 x+1。
这给出了从 [0] 得到数组 a 的过程。
根据这样的生成过程，判断是否有解的做法如下：
1. 数组中恰好有一个 0。
2. 对于非零数字 x，要么其左侧最近小于 x 的元素是 x-1，要么其右侧最近小于 x 的元素是 x-1，这两个条件至少要成立一个。
用单调栈解决。
代码 https://codeforces.com/contest/1919/submission/281294065
======

Input
2
5
2 1 0 1 1
5
1 0 2 1 3
Output
YES
NO
 */
