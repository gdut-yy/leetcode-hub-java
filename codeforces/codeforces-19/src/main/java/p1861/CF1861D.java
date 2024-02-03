package p1861;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1861D {
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

    private static String solve() {
        int cnt = 0;
        for (int i = 1; i < n; i++) {
            if (a[i - 1] >= a[i]) {
                cnt++;
            }
        }

        int res = n, cnt2 = 0;
        for (int i = 0; i < n; i++) {
            int isMultipliedByNegative = (i > 0) ? 1 : 0;
            res = Math.min(res, isMultipliedByNegative + cnt + cnt2);

            if (i + 1 < n) {
                if (a[i] >= a[i + 1]) {
                    cnt--;
                }
            }
            if (i > 0) {
                if (a[i - 1] <= a[i]) {
                    cnt2++;
                }
            }
        }
        return String.valueOf(res);
    }
}
/*
D. Sorting By Multiplication
https://codeforces.com/contest/1861/problem/D

灵茶の试炼 2023-12-14
题目大意：
给定一个长度为 n 的数组 a，由正整数组成。
您可以对该数组执行以下操作任意次数(可能为零):
选择三个整数 l, r 和 x，使 1≤l≤r≤n，并将每个 ai 乘以 x，使 l≤i≤r。
注意，你可以选择任何整数作为 x，它不一定是正数。
你必须计算操作的最小数量，以使数组按严格升序排序(即:条件 a1<a2<...<an 必须满足)。

rating 1800
https://codeforces.com/blog/entry/119964
首先，让我们找出要执行的是哪些负数乘法。经过几次乘法运算后，数组 a 的一些子数组可能变为负值。如果有多个这样的负子数组(并且它们之间有非负元素)，则不能通过非负值的乘法对该数组进行排序。如果存在这样的子数组，那么它必须是该数组的前缀。
我们试着在 O(n^2)内解决这个问题。让我们遍历负前缀的长度，并解决某个固定负前缀的问题。使该前缀上的所有元素为负(例如，通过乘以 −1)，然后按升序遍历数组的下标。
如果 ai<ai+1(其中 i 是当前索引)，那么我们就去下一个索引。否则，我们总是可以将前缀(如果 ai<0)或后缀(如果 ai>0)乘以某个正值，以便前缀 a1,..,ai,ai+1 被排序。
注意，如果我们固定了负前缀，我们不能仅通过一次操作就在多个索引 i 上恢复条件 ai<ai+1。
例如，如果 ai、ai+1、aj、aj+1 均为正数，且 ai≥ai+1、aj≥aj+1，则至少需要两次运算才能保证 ai<ai+1、aj<aj+1。在第一个操作中，我们应该选择 l=i+1，在第二个操作中，我们应该选择 l=j+1，这样 ai+1 大于 ai, aj+1 大于 aj。
例如，如果数组 a 是[−1,−2,−3,2,1,3](在我们确定前3个元素为负之后)。我们执行以下一系列动作:
- i=1, a1≥a2 且 a1<0，因此我们只需将前缀 a1,...,a1 乘以某个正值(例如 4);之后，当前数组 a=[−4,−2,−3,2,1,3];
- i=2, a2≥a3 且 a2<0，因此我们只需将前缀 a1,...,a2 乘以某个正值(例如 2);之后，当前数组 a=[−8,−4,−3,2,1,3];
- i=3, a3<a4 那么我们就去下一个指标;
- i=4, a4≥a5 和 a4>0，因此我们只需将后缀 a5,...,a6 乘以某个正值(例如 10);之后，当前数组 a=[−8,−4,−3,2,10,30];
- i=5, a5<a6 所以我们去下一个索引;
- i=6，那么数组已经排序好了。
为了解决 O(n)中的问题，我们需要以下观察:如果负前缀的长度为 x，我们执行两种情况的操作:
- 如果 ai≤ai+1(在原数组中)且 i+1≤x;
- 如果 ai≥ai+1 且 i≥x。
所以，我们可以迭代负前缀 x 的长度并保持
- 使 ai−1≤ai 且 i <x 的指标 i 的个数;
- 以及满足 aj≥aj+1 和 j≥x 的指标 j 的个数。
不要忘记 x=0 的情况，那么我们不需要额外的操作来使前缀为负。
======

input
3
5
1 1 2 2 2
6
5 4 3 2 5 1
3
1 2 3
output
3
2
0
 */
