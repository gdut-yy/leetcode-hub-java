package p920;

import java.util.Arrays;
import java.util.Scanner;

public class CF920C {
    static int n;
    static int[] a;
    static char[] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        s = scanner.next().toCharArray();
        System.out.println(solve());
    }

    private static String solve() {
        int i = 0;
        for (; i < n - 1; i++) {
            if (s[i] == '0') continue;
            int st = i;
            for (; i < n - 1 && s[i] == '1'; i++) {
            }
            Arrays.sort(a, st, i + 1);
        }
        for (int j = 1; j < n; j++) {
            if (a[j - 1] > a[j]) {
                return "NO";
            }
        }
        return "YES";
    }
}
/*
C. Swap Adjacent Elements
https://codeforces.com/contest/920/problem/C

灵茶の试炼 2023-12-04
题目大意：
输入 n(1≤n≤3e5) 和一个 1~n 的排列 a，然后输入一个长为 n-1 的 01 字符串 s。
s[i]=1 表示你可以交换 a[i] 和 a[i+1]（交换次数不限），s[i]=0 表示不能交换 a[i] 和 a[i+1]。
判断能否把 a 变成递增的。输出 YES 或 NO。

rating 1400
分组循环找 s 的连续 1 段，然后把这段对应的子数组排序。（邻项交换=冒泡排序）
最后判断 a 是否有序。
https://codeforces.com/contest/920/submission/234864893
其它写法：由于 a 是一个排列，可以用 vis 标记来代替排序（0 之前的段必须 1~i 都出现），这样可以做到 O(n) 时间。
======

input
6
1 2 5 3 4 6
01110
output
YES

input
6
1 2 5 3 4 6
01010
output
NO
 */
