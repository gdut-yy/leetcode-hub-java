package p1861;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1861A {
    static char[] cs;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            cs = scanner.next().toCharArray();
            System.out.println(solve());
        }
    }

    private static String solve() {
        int i1 = 0, i3 = 0;
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == '1') i1 = i;
            else if (cs[i] == '3') i3 = i;
        }
        if (i1 < i3) return "13";
        return "31";
    }
}
/*
Educational Codeforces Round 154 (Rated for Div. 2)
A. Prime Deletion
https://codeforces.com/contest/1861/problem/A

题目大意：
素数是一个正整数，它有两个不同的正因子:1 和整数本身。例如，2、3、13 和 101 是质数;1,4,6 和 42 不是。
给定一个从 1 到 9 的数字序列，其中从 1 到 9 的每个数字只出现一次。
您可以执行以下操作几次(可能是零次):从序列中选择任意数字并删除它。如果序列只有两位数字，则不能执行该操作。
你的目标是得到一个表示素数的序列。注意，不能对序列中的数字重新排序。
打印结果序列，或者报告不可能执行这些操作以使结果序列为素数。

数论？二进制枚举？
2^9 * logU
---
https://codeforces.com/blog/entry/119964
有许多可能的方法来解决这个问题。
例如，您可以使用蛮力来解决它:迭代从 1 开始的每个整数，通过迭代其除数来检查它是否是素数，并检查它是否作为给定数字序列中的子序列出现。如果你找到了答案，打破循环并打印你找到的数字。
但是这个代码有点长。我们试试不一样的东西吧。
我们可以试着寻找一个小的素数集合，使得这个集合中至少有一个素数出现在给定的序列中。我们试试短质数，它们更容易处理。
如果存在两个长度为 2 的质数，由数字 x 和 y 组成，其中一个是 xy，另一个是 yx，那么它们中的一个肯定会出现在我们的数列中。如果 x 比 y 早出现，那么 xy 出现在序列中，否则就是 yx。
幸运的是，我们有可能找到这两个质数。例如，您可以使用 13 和 31;其中一个肯定会出现在序列中。
所以，最简单的解决方法就是找出序列中 1 是否早于 3。如果 1 在前面，那么答案是 13，否则是 31。
---
脑筋急转弯
======

input
4
123456789
987654321
243567918
576318429
output
167
53
3571
57638429
 */
