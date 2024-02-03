package p1861;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1861C {
    static String s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            s = scanner.next();
            System.out.println(solve());
        }
    }

    private static String solve() {
        int maxSortedPref = 0;
        int minNotSortedPref = 0;
        int bal = 0;

        for (char c : s.toCharArray()) {
            if (c == '+') {
                bal++;
            } else if (c == '-') {
                bal--;
                maxSortedPref = Math.min(maxSortedPref, bal);
                if (bal < minNotSortedPref) {
                    minNotSortedPref = 0;
                }
            } else if (c == '1') {
                maxSortedPref = Math.max(maxSortedPref, bal);
            } else {
                if (bal <= 1) {
                    return "NO";
                }
                if (minNotSortedPref == 0 || minNotSortedPref > bal) {
                    minNotSortedPref = bal;
                }
            }
            if (minNotSortedPref <= maxSortedPref && minNotSortedPref != 0) {
                return "NO";
            }
        }
        return "YES";
    }
}
/*
C. Queries for the Array
https://codeforces.com/contest/1861/problem/C

灵茶の试炼 2023-11-15
题目大意：
Monocarp 有一个由整数组成的数组。最初，这个数组是空的。
Monocarp 对这个数组执行了三种类型的查询:
- 选择一个整数并将其附加到数组的末尾。每次 Monocarp 执行这种类型的查询时，他都会写出一个字符+;
- 从数组中删除最后一个元素。每次 Monocarp 执行这种类型的查询时，他都会写出一个字符-。Monocarp 从不对空数组执行此查询;
- 检查数组是否按非降序排序，例如。A1≤a2≤...≤ak，其中 k 为当前数组中元素的个数。每个少于 2 个元素的数组都被认为是有序的。如果数组是按照 Monocarp 执行查询的时间排序的，他就会写出一个字符 1。否则，他会写出一个字符 0。
给定一个序列 s，包含 q 个字符 0、1、+和/或-。这些是 Monocarp 写出来的字，按照他写出来的顺序排列。
你必须检查这个顺序是否一致，即。Monocarp 有可能执行查询，使他写出来的字符序列恰好是 s。

rating 1600
https://codeforces.com/blog/entry/119964
首先，让我们分析一下哪些情况会导致答案是否定的。有两种类型:
- 如果当前数组中的元素数小于 2，则数组肯定已排序。所以，如果我们得到一个 0 元素的个数是 0 或 1，答案是 NO;
- 如果数组已排序，但它的某些前缀(可能与整个数组一致)未排序，则这也是 NO。
只有这两种情况会导致 NO。我们可以证明，如果这些都不发生，答案是 YES，使用以下结构:每次有一个+查询，我们将向数组添加 1;每次有一个 0 查询，并且当前数组已排序，我们将把数组的最后一个元素更改为 0(并假设我们在添加它的查询中添加了 0 而不是 1)。这样，我们可以确保数组尽可能长时间地保持排序。这种结构不起作用的唯一情况是:
- 我们尝试将一个元素更改为 0，但是没有这样的元素(数组为空)，或者在更改后数组保持排序(我们更改了第一个元素)。这正是出现查询 0 且当前元素数小于 2 的时候;
- 我们将一个元素更改为 0，它使当前数组非排序，但由于类型 1 的查询影响它，它必须排序。这就是当我们有一个排序数组和一个非排序前缀的时候。好了，现在我们要检查一下这两个条件。第一个很简单:只需要跟踪数组中元素的数量;每次处理+时，增加它;每次你处理-，减少它;每次处理 0 时，检查元素的数量。
第二个条件比较棘手。如何处理它有很多方法;我将描述其中的两个。
---
Solution 1 (Roms)
我们感兴趣的是一个排序数组有一个未排序前缀的情况。假设当这种情况发生时，我们的数组有一个状态。如果这个数组有多个前缀，我们知道它们是排序的，我们应该选择哪一个?它应该是最长的排序前缀，因为我们希望未排序的前缀更短(或具有相同的长度)。在所有未排序的前缀中，出于同样的原因，我们对最短的前缀感兴趣。
那么，让我们回顾一下查询并跟踪数组中最短的非排序前缀和最长的排序前缀。让我们分析一下查询是如何影响这两个值的。
- 当我们添加一个新元素(类型为+的查询)时，我们不再知道当前数组是有序的，但它的最长有序前缀保持不变，它的最短非有序前缀也保持不变。所以，我们不需要更新这些值;
- 当我们删除最后一个元素(类型为-的查询)时，排序前缀的长度可能会改变。如果它等于查询前的元素数，则它应该减少 1，因为该前缀上的最后一个元素已被删除，并且该前缀不再存在。对于最短的未排序前缀的长度，如果它等于查询前数组中的元素数，则应该设置为 0 -因为可能是数组的最后一个元素使数组未排序，而我们对它之前的前缀一无所知。
- 当处理类型为 0 或 1 的查询时，应该相应地更新最短的非排序前缀或最长的排序前缀。
在每次查询之后，我们可以检查最长的排序前缀是否比最短的非排序前缀短(或者其中一个不存在)。
======

input
7
++1
+++1--0
+0
0
++0-+1-+0
++0+-1+-0
+1-+0
output
YES
NO
NO
NO
YES
NO
NO
 */
