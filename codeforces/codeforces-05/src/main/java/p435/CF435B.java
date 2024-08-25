package p435;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF435B {
    static long a;
    static int k;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        a = scanner.nextLong();
        k = scanner.nextInt();
        System.out.println(solve());
    }

    private static String solve() {
        char[] s = String.valueOf(a).toCharArray();
        int n = s.length;

        for (int i = 0; i < n && k > 0; i++) {
            int mxI = i;
            for (int j = i + 1; j < n && j <= i + k; j++) {
                if (s[mxI] < s[j]) {
                    mxI = j;
                }
            }
            while (mxI > i) {
                char tmp = s[mxI - 1];
                s[mxI - 1] = s[mxI];
                s[mxI] = tmp;

                k--;
                mxI--;
            }
        }

        return new String(s);
    }
}
/*
B. Pasha Maximizes
https://codeforces.com/contest/435/problem/B

灵茶の试炼 2023-06-12
題目大意：
输入 a(1≤a≤1e18) 和 k(0≤k≤100)。
你需要操作至多 k 次。
每次操作，交换 a 的两个相邻数位。
输出 a 的最大值。

rating 1400
https://codeforces.com/contest/435/submission/209289302
由于 k 较小，直接模拟。
每次循环尽量把大的换到前面。
具体来说，第 i 次循环，贪心找从第 i 个位置往后 min(k+1,n) 个数位的最大值，然后不断交换到第 i 个位置上。
直接模拟邻项交换，每次交换把 k 减一。这样写是最稳的。
======

input
1990 1
output
9190

input
300 0
output
300

input
1034 2
output
3104

input
9090000078001234 6
output
9907000008001234
 */
