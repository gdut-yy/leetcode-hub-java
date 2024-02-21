package p1148;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1148D {
    static int n;
    static List<Pair> a, b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new ArrayList<>();
        b = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            if (x < y) {
                a.add(new Pair(x, i));
            } else {
                b.add(new Pair(x, i));
            }
        }
        System.out.println(solve());
    }

    private static String solve() {
        if (a.size() > b.size()) {
            a.sort((o1, o2) -> Integer.compare(o2.x, o1.x));
        } else {
            b.sort(Comparator.comparingInt(o -> o.x));
            a = b;
        }
        return a.size() + System.lineSeparator()
                + a.stream().map(o -> String.valueOf(o.i)).collect(Collectors.joining(" "));
    }

    static class Pair {
        int x;
        int i;

        public Pair(int x, int i) {
            this.x = x;
            this.i = i;
        }
    }
}
/*
D. Dirty Deeds Done Dirt Cheap
https://codeforces.com/contest/1148/problem/D

灵茶の试炼 2022-05-16
题目大意：
给你 n(<=3e5) 个 pair，每个 pair 有两个整数。这 2n 个数各不相同，且元素值在 [1,2n] 中。
现在让你选择 k 个 pair，将这 k 个 pair 重新排列后（pair 内的数字顺序不变），组成一个振荡序列（不能出现连续两个递增或连续两个递减）。
比如 [(1,7), (6,4), (2,10), (9,8), (3,5)]
选择 (1,7) (3,5) (2,10)
得到振荡序列 1,7,3,5,2,10
求 k 的最大值，和组成序列的 pair 的下标。

rating 1800
https://codeforces.com/contest/1148/submission/157360894
构造。
设 pair 为 (a,b)，将所有 a<b 的 pair 归为一组，a>b 的归为另一组。
以 a<b 为例，将这组的 pair 按照 a 从大到小排序后，组成的一定是振荡序列，并且无法在任何位置插入任何 a>b 的 pair。
选 pair 多的那一组作为答案。
======

input
5
1 7
6 4
2 10
9 8
3 5
output
3
1 5 3

input
3
5 4
3 2
6 1
output
3
3 2 1
 */
