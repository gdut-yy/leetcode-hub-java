package c119;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Arc119_b {
    static int n;
    static char[] s, t;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        s = scanner.next().toCharArray();
        t = scanner.next().toCharArray();
        System.out.println(solve());
    }

    private static String solve() {
        int cnt0 = 0;
        for (char c : s) if (c == '0') cnt0++;
        for (char c : t) if (c == '0') cnt0--;
        if (cnt0 != 0) return "-1";

        int ans = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == '0') {
                while (t[j] != '0') j++;
                if (i != j) ans++;
                j++;
            }
        }
        return String.valueOf(ans);
    }
}
/*
B - Electric Board
https://atcoder.jp/contests/arc119/tasks/arc119_b

灵茶の试炼 2022-11-25
题目大意：
输入 n(≤5e5) 和两个长为 n 的 01 字符串 s 和 t。
每次操作，你可以把 s 中形如 011..1 或 11..10 的子串的最左最右两个字符交换。
输出把 s 变成 t 最小操作次数，如果无法做到输出 -1。

https://atcoder.jp/contests/arc119/submissions/36760648
首先 0 的个数必须相同，否则输出 -1。
考察 s 和 t 中的第一个 0 的下标，设为 i 和 j。
无论 i>j 还是 i<j，都可以用一次操作，使得 s 中的 0 和 t 的匹配。
因此设 s 中 0 的下标数组为 p，t 中 0 的下标数组为 q。
那么答案就是 p[i] != q[i] 的个数。
代码实现时可以用双指针减小内存消耗。
======

Input 1
7
1110110
1010111
Output 1
2

Input 2
20
11111000000000011111
11111000000000011111
Output 2
0

Input 3
6
111100
111000
Output 3
-1

Input 4
119
10101111011101001011111000111111101011110011010111111111111111010111111111111110111111110111110111101111111111110111011
11111111111111111111111111011111101011111011110111110010100101001110111011110111111111110010011111101111111101110111011
Output 4
22
 */