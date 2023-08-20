package p1857;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class CF1857B {
    static String x;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            x = scanner.next();
            System.out.println(solve());
        }
    }

    private static String solve() {
        char[] cs = x.toCharArray();
        int n = cs.length;
        int begin = n;
        for (int i = n - 1; i > 0; i--) {
            if (cs[i] >= '5') {
                begin = i;
                cs[i] = '0';
                cs[i - 1]++;
            }
        }
        if (cs[0] >= '5') {
            begin = 0;
            cs[0] = '0';
            Arrays.fill(cs, begin, n, '0');
            return "1" + new String(cs);
        }
        Arrays.fill(cs, begin, n, '0');
        return new String(cs);
    }
}
/*
B. Maximum Rounding
https://codeforces.com/contest/1857/problem/B

题目大意：
给定一个自然数 x。您可以执行以下操作:
- 选择一个正整数 k，将 x 四舍五入到第 k 位
请注意，这些位置是从右到左编号的，从 0 开始。如果数有 k 位，则认为第(k+1)位的数字等于 0。
舍入方法如下:
- 如果第(k−1)位的数字大于或等于 5，则第 k 位的数字增加 1，否则第 k 位的数字保持不变(使用数学四舍五入)。
- 如果在操作之前，第 k 位的数字是 9，它应该加 1，那么我们搜索最小的位置 k ' (k ' >k)，其中第 k 位的数字小于 9，并在第 k 位的数字上加 1。然后赋值 k=k '
- 之后，所有位置小于 k 的数字都被替换为 0。
你的任务是使 x 尽可能的大，如果你可以执行尽可能多的操作的话。
例如，如果 x 等于 3451，那么如果选择第一个操作:
- K =1，那么运算后 x 将变成 3450
- K =2，那么运算后 x 将变成 3500
- K =3，那么经过运算后 x 将变成 3000
- K =4，那么运算后 x 将变成 0
为了使答案最大化，你需要先选择 k=2，然后 k=3，然后这个数字就变成了 4000。

贪心。后往前，大于等于 5 就直接进 1。
======

input
10
1
5
99
913
1980
20444
20445
60947
419860
40862016542130810467
output
1
10
100
1000
2000
20444
21000
100000
420000
41000000000000000000
 */
