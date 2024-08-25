package p1714;

import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CF1714E {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = scanner.nextInt();
            }
            System.out.println(solve(n, a));
        }
    }

    private static String solve(int n, int[] a) {
        Set<Integer> hashSet = new HashSet<>();
        for (int ai : a) {
            if (ai % 10 == 0) {
                hashSet.add(ai);
            } else if (ai % 10 == 5) {
                ai += ai % 10;
                hashSet.add(ai);
            } else {
                for (int j = 0; j < 4; j++) {
                    ai += ai % 10;
                    ai %= 20;
                    // 6 or 16
                    if (ai % 10 == 6) {
                        hashSet.add(ai);
                    }
                }
            }
        }
        if (hashSet.size() == 1) {
            return "Yes";
        }
        return "No";
    }
}
/*
E. Add Modulo 10
https://codeforces.com/contest/1714/problem/E

灵茶の试炼 2023-05-15
题目大意：
给定整数 n 和长为 n 的数组 ai，每次操作可以将一个数 ai 置换成 ai + ai %10，判断是否可以通过若干次操作使数组所有元素相等。

rating 1400
本质为判断环长
假设 ai = 1，1->2->4->8->16->22->24->28->36->42 发现个位数存在循环且环长为 4；
假设 ai = 11，11->12->14->18->26->32->34->38->46->52 发现个位数存在循环且环长为 4；
其余个位数字 3->6; 7->14; 9->18; 均会进入上述循环
注意 0->0; 5->0; 是另外一个环，需要单独讨论。
======

input
10
2
6 11
3
2 18 22
5
5 10 5 10 5
4
1 2 4 8
2
4 5
3
93 96 102
2
40 6
2
50 30
2
22 44
2
1 5

output
Yes
No
Yes
Yes
No
Yes
No
No
Yes
No
 */