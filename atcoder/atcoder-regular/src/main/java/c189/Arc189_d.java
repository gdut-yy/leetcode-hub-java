package c189;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Arc189_d {
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
        long[] sum = new long[n + 1];
        int[] leftGE = new int[n];
        int[] right = new int[n];
        List<Integer> st = new ArrayList<>();
        st.add(-1);
        // java 21
//        for (int i = 0; i < n; i++) {
//            sum[i + 1] = sum[i] + a[i];
//            while (st.size() > 1 && a[st.getLast()] < a[i]) {
//                right[st.getLast()] = i;
//                st.removeLast();
//            }
//            leftGE[i] = st.getLast();
//            st.add(i);
//        }
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + a[i];
            while (st.size() > 1 && a[getLast(st)] < a[i]) {
                right[getLast(st)] = i;
                removeLast(st);
            }
            leftGE[i] = getLast(st);
            st.add(i);
        }
        for (int i = 1; i < st.size(); i++) {
            right[st.get(i)] = n;
        }

        int[] rightGE = new int[n];
        int[] left = new int[n];
        st.clear();
        st.add(n);
        // java 21
//        for (int i = n - 1; i >= 0; i--) {
//            while (st.size() > 1 && a[st.getLast()] < a[i]) {
//                left[st.getLast()] = i;
//                st.removeLast();
//            }
//            rightGE[i] = st.getLast();
//            st.add(i);
//        }
        for (int i = n - 1; i >= 0; i--) {
            while (st.size() > 1 && a[getLast(st)] < a[i]) {
                left[getLast(st)] = i;
                removeLast(st);
            }
            rightGE[i] = getLast(st);
            st.add(i);
        }
        for (int i = 1; i < st.size(); i++) {
            left[st.get(i)] = -1;
        }

        Integer[] ids = new Integer[n];
        for (int i = 0; i < n; i++) ids[i] = i;
        Arrays.sort(ids, Comparator.comparingInt(o -> -a[o]));

        long[] ans = new long[n];
        for (Integer i : ids) {
            if (rightGE[i] - leftGE[i] == 2) {
                ans[i] = a[i];
                continue;
            }
            int l = left[i], r = right[i];
            long s = sum[r] - sum[l + 1];
            if (l >= 0 && s > a[l]) {
                ans[i] = ans[l];
            } else if (r < n && s > a[r]) {
                ans[i] = ans[r];
            } else {
                ans[i] = s;
            }
        }

        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }

    static Integer getLast(List<Integer> a) {
        return a.get(a.size() - 1);
    }

    static void removeLast(List<Integer> a) {
        a.remove(a.size() - 1);
    }
}
/*
D - Takahashi is Slime
https://atcoder.jp/contests/arc189/tasks/arc189_d

灵茶の试炼 2025-01-10
题目大意：
输入 n(2≤n≤5e5) 和长为 n 的数组 a(1≤a[i]≤1e9)。
有 n 只史莱姆排成一行，从左到右第 i 只史莱姆的体积为 a[i]。
假设你是第 k 只史莱姆，每次操作，你可以吃掉左右相邻的体积严格小于你的一只史莱姆，并获得它的体积。把你可以达到的最大体积记为 f(k)。
输出 f(1),f(2),f(3),...,f(n)。

从大到小思考。
a 中最大值的答案是多少？次大值的答案是多少？
设：
a[i] 左边最近 > a[i] 的数的下标为 left[i]，若不存在则为 -1。
a[i] 左边最近 >= a[i] 的数的下标为 leftGE[i]，若不存在则为 -1。
a[i] 右边最近 > a[i] 的数的下标为 right[i]，若不存在则为 n。
a[i] 右边最近 >= a[i] 的数的下标为 rightGE[i]，若不存在则为 n。
分类讨论：
如果 rightGE[i]-leftGE[i]=2，那么啥也做不了，ans[i] = a[i]。
否则，由于 a 中元素都是正数，在吃掉一个史莱姆后，我们的体积一定比初始体积大。
计算从 left[i]+1 到 right[i]-1 的子数组和 s。
如果 left[i] >= 0，且子数组和 s 比 a[i] 左边更大数还要大，那么左边更大数能吃掉的数，a[i] 也可以吃掉，所以 ans[i] 就是左边更大数的答案，即 ans[i] = ans[left[i]]。
否则如果 right[i] < n，且子数组和 s 比 a[i] 右边更大数还要大，那么右边更大数能吃掉的数，a[i] 也可以吃掉，所以 ans[i] 就是右边更大数的答案，即 ans[i] = ans[right[i]]。
其他情况，ans[i] = s。
记得开 LL。
代码 https://atcoder.jp/contests/arc189/submissions/61312220
======

Input 1
6
4 13 2 3 2 6
Output 1
4 30 2 13 2 13

Input 2
12
22 25 61 10 21 37 2 14 5 8 6 24
Output 2
22 47 235 10 31 235 2 235 5 235 6 235
 */
