package p1848;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1848F {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    // https://codeforces.com/contest/1848/submission/214080768
    private static String solve() {
        int ans = 0;
        for (int i = n / 2; i >= 1; i /= 2) {
            int[] b = new int[n];
            for (int j = 0; j < n; j += 1) {
                b[j] = a[j] ^ a[(j + i) % n];
            }
            int zero = ranges_count(b, 0);
            if (zero != n) {
                a = b;
                ans += i;
            }
        }
        int zero = ranges_count(a, 0);
        ans += zero != n ? 1 : 0;
        return String.valueOf(ans);
    }

    private static int ranges_count(int[] arr, int value) {
        int cnt = 0;
        for (int x : arr) {
            if (x == value) cnt++;
        }
        return cnt;
    }
}
/*
F. Vika and Wiki
https://codeforces.com/contest/1848/problem/F

题目大意：
最近，Vika 正在研究她最喜欢的互联网资源——维基百科。
在维基百科上，她读到了一个有趣的数学运算，按位异或，用 ⊕ 表示。
维卡开始研究这个神秘操作的性质。为了做到这一点，她取了一个由 n 个非负整数组成的数组 a，并同时对其所有元素应用以下操作:ai=ai⊕a(i+1)modn。这里 x mod y 表示 x 除以 y 的余数。数组的元素从 0 开始编号。
因为对于一个完整的研究来说，执行一次上述操作是不够的，所以 Vika 会重复执行这些操作，直到数组 a 全部变为零。
确定需要执行多少次上述操作才能使数组的所有元素都为零。如果没有此时刻，输出 −1。

rating 2400
======

input
4
1 2 1 2
output
2

input
2
0 0
output
0

input
1
14
output
1

input
8
0 1 2 3 4 5 6 7
output
5
 */
