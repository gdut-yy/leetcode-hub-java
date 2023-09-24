package c268;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class Abc268_f {
    static int n;
    static String[] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        s = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = scanner.next();
        }
        System.out.println(solve());
    }

    private static String solve() {
        long ans = 0;
        Node[] a = new Node[n];
        for (int i = 0; i < n; i++) {
            a[i] = new Node();
            for (char ch : s[i].toCharArray()) {
                if (ch == 'X') {
                    a[i].x++;
                } else {
                    ans += a[i].x * (ch - '0');
                    a[i].s += (ch - '0');
                }
            }
        }
        Arrays.sort(a, (o1, o2) -> Long.compare(o2.x * o1.s, o1.x * o2.s));
        long c = 0;
        for (int i = 0; i < n; i++) {
            ans += c * a[i].s;
            c += a[i].x;
        }
        return String.valueOf(ans);
    }

    private static class Node {
        long x, s;
    }
}
/*
F - Best Concatenation
https://atcoder.jp/contests/abc268/tasks/abc268_f

灵茶の试炼 2022-12-28
题目大意：
输入 n(≤2e5) 和 n 个字符串，总长度不超过 2e5。
每个字符串包含 X 和数字 1~9。
重排这些字符串，然后拼接成一个字符串 t。
对每个 1≤i<j≤len(t)，如果 t[i]=X 且 t[j]=1 则得 1 分，如果 t[i]=X 且 t[j]=2 则得 2 分，依此类推。
输出你最多可以得到多少分。

https://atcoder.jp/contests/abc268/submissions/37573533
提示 1：邻项交换法，对于两个字符串，哪个应该排在前面？
提示 2：X 越多，数字之和越小的。
======

Input 1
3
1X3
59
XXX
Output 1
71

Input 2
10
X63X395XX
X2XX3X22X
13
3716XXX6
45X
X6XX
9238
281X92
1XX4X4XX6
54X9X711X1
Output 2
3010
 */