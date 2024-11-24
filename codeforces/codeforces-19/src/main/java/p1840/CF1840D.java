package p1840;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.TreeSet;

public class CF1840D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve(n, a));
        }
    }

    private static int min, max;

    private static String solve(int n, int[] a) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int x : a) {
            treeSet.add(x);
        }
        min = treeSet.first();
        max = treeSet.last();

        int left = 0;
        int right = max - min;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (checkMid(treeSet, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return String.valueOf(left);
    }

    private static boolean checkMid(TreeSet<Integer> treeSet, int mid) {
        int lo = min + mid * 2;
        int hi = max - mid * 2;
        Integer low = treeSet.higher(lo);
        Integer high = treeSet.lower(hi);
        if (low == null || high == null) return true;
        return high - low <= mid * 2;
    }
}
/*
D. Wooden Toy Festival
https://codeforces.com/contest/1840/problem/D

灵茶の试炼 2024-07-01
题目大意：
在一个小镇上，有一家木工作坊。由于小镇很小，只有三个雕刻师在那里工作。
不久，镇上计划举办一个木制玩具节。车间员工想为此做准备。
他们知道 n 个人会带着制作木制玩具的要求来车间。每个人都是不同的，可能想要不同的玩具。为简单起见，我们将第 i 个人想要的玩具样式表示为 ai(1≤ai≤109)。
每个雕刻家可以提前选择一个图案 x(1≤x≤10^9)，不同的雕刻家可以选择不同的图案。在节日的准备过程中，雕刻家将完美地研究出制作选定图案的玩具的技术，这将使他们能够立即将其从木头中切割出来。
为选择了 x 图案的雕刻家制作一个 y 图案的玩具，需要花费 x - y 时间，因为这个玩具越像他能立即做出来的玩具，雕刻家就能越快地完成工作。
在节日当天，当下一个人带着制作木制玩具的要求来到作坊时，雕刻家可以选择谁来做这项工作。同时，雕刻师是非常熟练的人，可以同时为不同的人工作。
由于人们不喜欢等待，雕刻家希望选择这样的准备模式，即所有人的最大等待时间尽可能小。
输出雕刻师可以达到的最佳最大等待时间。
---
在第一个例子中，雕刻家可以选择图案 1、7、9 进行准备。
在第二例中，雕刻家可以选择图案 3、30、60 进行准备。
在本例中，雕刻师可选择图案 14、50、85 进行准备。

rating 1400
二分套二分
======

input
5
6
1 7 7 9 9 9
6
5 4 2 1 30 60
9
14 19 37 59 1 4 4 98 73
1
2
6
3 10 1 17 15 11
output
0
2
13
0
1
 */
