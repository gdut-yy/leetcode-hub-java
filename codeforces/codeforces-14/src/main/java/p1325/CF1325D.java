package p1325;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1325D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        long u = scanner.nextLong();
        long v = scanner.nextLong();
        System.out.println(solve(u, v));
    }

    private static String solve(long xor, long sum) {
        if (xor > sum || ((sum - xor) & 1) == 1) {
            return "-1";
        }
        if (xor == sum) {
            if (xor == 0) {
                return "0";
            } else {
                return "1" + System.lineSeparator() + xor;
            }
        }
        long and = (sum - xor) / 2;
        if ((and & xor) > 0) {
            return "3"
                    + System.lineSeparator()
                    + xor + " " + and + " " + and;
        } else {
            return "2"
                    + System.lineSeparator()
                    + (xor | and) + " " + and;
        }
    }
}
/*
D. Ehab the Xorcist
https://codeforces.com/contest/1325/problem/D

灵茶の试炼 2023-03-21
题目大意：
输入 u 和 v，范围均在 [0,1e18]。
构造一个长度最短的数组，满足异或和等于 u，和等于 v。
如果无法构造，输出 -1，否则输出数组长度和任意满足要求的数组。

rating 1700
constructive algorithms
https://codeforces.com/contest/1325/submission/97080317
提示 1：u <= v
提示 2：如果 u 是奇数，那么必然有奇数个奇数，所以 v 也是奇数；同理，偶数……
所以 v-u 必须是偶数
提示 3：设 x = (v-u)/2，那么构造数组 [u,x,x]，其异或和为 u，元素和为 2x+u = v
这说明数组长度至多为 3。
什么时候数组长度为 2？也就是说，找到两个数 a b 满足 a^b=u，a+b=v。
提示 4-1：你能得到 | ^ & + 这些运算的关系吗？
提示 4-2：
a|b = (a^b) + (a&b)    类比集合论
a+b = (a|b) + (a&b)    类比加法器
联立得
a+b = (a&b)*2 + (a^b)
提示 5-1：x = a&b
提示 5-2：
如果 u&x = 0，那么直接把 x 放到 u 里面，数组为 [u|x, x]
如果 u&x ≠ 0，说明有个比特位都是 1，但是 p^q=1 和 p&q=1 不能同时成立，所以此时无法构造长为 2 的数组。
======

input
2 4
output
2
3 1

input
1 3
output
3
1 1 1

input
8 5
output
-1

input
0 0
output
0
 */
