package p1851;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class CF1851B {
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
        boolean[] odd = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (a[i] % 2 == 1) {
                odd[i] = true;
            }
        }

        Arrays.sort(a);
        for (int i = 0; i < n; i++) {
            if ((a[i] % 2 == 1) != odd[i]) {
                return "NO";
            }
        }
        return "YES";
    }
}
/*
B. Parity Sort
https://codeforces.com/contest/1851/problem/B

题目大意：
你有一个长度为 n 的整数数组。你可以对给定的数组应用以下操作:
交换两个元素 ai 和 aj 使得 i≠j, ai 和 aj 要么都是偶数，要么都是奇数。确定是否可以通过执行任意次数(可能为零)的操作来以非递减顺序对数组进行排序。
例如，设 a =[7,10,1,3,2]。然后我们可以执行 3 个操作来对数组进行排序:
- 交换 a3=1 和 a1=7，因为 1 和 7 是奇数。得到 a = [1,10,7,3,2];
- 交换 a2=10 和 a5=2，因为 10 和 2 是偶数。得到 a = [1,2,7,3,10];
- 交换 a4=3 和 a3=7，因为 3 和 7 是奇数。得到 a =[1,2,3,7,10]。

排序后判断每个下标的奇偶性是否跟排序前一致。
======

input
6
5
7 10 1 3 2
4
11 9 3 5
5
11 3 15 3 2
6
10 7 8 1 2 3
1
10
5
6 6 4 1 6
output
YES
YES
NO
NO
YES
NO
 */
