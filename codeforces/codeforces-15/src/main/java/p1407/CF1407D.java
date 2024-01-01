package p1407;

import java.util.Arrays;
import java.util.Scanner;

public class CF1407D {
    static int n;
    static int[] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        s = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            s[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        int[] f = new int[n + 1];
        Arrays.fill(f, (int) 1e9);
        f[1] = 0;

        int sz1 = 0, sz2 = 0;
        int[] stack1 = new int[n + 1], stack2 = new int[n + 1];
        stack1[++sz1] = 1;
        stack2[++sz2] = 1;
        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + 1;
            while (sz1 > 0 && s[i] >= s[stack1[sz1]]) {
                if (s[i] != s[stack1[sz1]]) {
                    f[i] = Math.min(f[i], f[stack1[sz1 - 1]] + 1);
                }
                sz1--;
            }

            while (sz2 > 0 && s[i] <= s[stack2[sz2]]) {
                if (s[i] != s[stack2[sz2]]) {
                    f[i] = Math.min(f[i], f[stack2[sz2 - 1]] + 1);
                }
                sz2--;
            }
            stack1[++sz1] = i;
            stack2[++sz2] = i;
        }
        return String.valueOf(f[n]);
    }
}
/*
D. Discrete Centrifugal Jumps
https://codeforces.com/contest/1407/problem/D

灵茶の试炼 2022-10-14
题目大意：
输入 n(≤3e5) 和一个长为 n 的数组 h (1≤h[i]≤1e9)。
满足如下三个条件之一，就可以从 i 跳到 j (i<j)：
1. i+1=j
2. max(h[i+1],...,h[j-1]) < min(h[i],h[j])
3. min(h[i+1],...,h[j-1]) > max(h[i],h[j])
输出从 1 跳到 n 最少需要多少步。

rating 2200
https://www.luogu.com.cn/blog/173660/solution-cf1407d
画画图，找找转移来源。转移来源有什么规律？
关键：转移来源一定在单调栈上，不断出栈直到不满足条件。
也可以把 DP 放到单调栈里面：https://codeforces.com/contest/1407/submission/175820402
相似题目:
https://leetcode.cn/problems/jump-game-viii/description/
======

input
5
1 3 1 4 5
output
3

input
4
4 2 2 4
output
1

input
2
1 1
output
1

input
5
100 1 100 1 100
output
2
 */
