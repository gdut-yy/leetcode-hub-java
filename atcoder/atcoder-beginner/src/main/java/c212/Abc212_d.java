package c212;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Abc212_d {
    static Scanner scanner = new Scanner(System.in);
    static int q;

    public static void main(String[] args) {
        q = scanner.nextInt();
        System.out.println(solve());
    }

    private static String solve() {
        List<String> output = new ArrayList<>();

        PriorityQueue<Long> pq = new PriorityQueue<>();
        long add = 0;
        while (q-- > 0) {
            int op = scanner.nextInt();
            if (op == 1) {
                int x = scanner.nextInt();
                pq.add(x - add);
            } else if (op == 2) {
                int x = scanner.nextInt();
                add += x;
            } else {
                long res = pq.remove() + add;
                output.add(String.valueOf(res));
            }
        }
        return String.join(System.lineSeparator(), output);
    }
}
/*
D - Querying Multiset
https://atcoder.jp/contests/abc212/tasks/abc212_d

灵茶の试炼 2025-04-28
题目大意：
一开始，有一个空的可重集合。
输入 q(1≤n≤2e5)，然后输入 q 个询问，格式如下：
"1 x"：把 x(1≤x≤1e9) 加到可重集合中。
"2 x"：把可重集合中的元素都增加 x(1≤x≤1e9)。
"3"：输出可重集合中的最小值，然后删除这个最小值。保证此时集合非空。

用最小堆维护。
同时额外用一个 add 变量，表示堆中的元素都要增加 add。
当我们添加元素的时候，改成添加 x-add，这样就能统一起来了。
代码 https://atcoder.jp/contests/abc212/submissions/64677519
注：这个技巧可以用于一些树上启发式合并（DSU）题目。
======

Input 1
5
1 3
1 5
3
2 2
3
Output 1
3
7

Input 2
6
1 1000000000
2 1000000000
2 1000000000
2 1000000000
2 1000000000
3
Output 2
5000000000
 */
