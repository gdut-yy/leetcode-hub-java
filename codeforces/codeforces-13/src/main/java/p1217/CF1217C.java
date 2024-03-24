package p1217;

import java.util.Scanner;

public class CF1217C {
    static char[] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            s = scanner.next().toCharArray();
            System.out.println(solve());
        }
    }

    private static String solve() {
        int ans = 0, cnt0 = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == '0') {
                cnt0++;
                continue;
            }
            int v = 0;
            for (int j = i; j < s.length; j++) {
                int b = s[j];
                v = (v << 1) | (b & 1);
                if (v > cnt0 + (j - i) + 1) {
                    break;
                }
                // 由于 v 最高位为 1，v >= 2^j >= j+1 是恒成立的
                // 因此当 j+1 <= v <= j+1+cnt0 时，一定能添加足够的前导零组成长度为 v 的二进制
                ans++;
            }
            cnt0 = 0;
        }
        return String.valueOf(ans);
    }
}
/*
C. The Number Of Good Substrings
https://codeforces.com/contest/1217/problem/C

灵茶の试炼 2022-08-11
题目大意：
输入 t(t≤1000) 表示 t 组数据。
每组数据输入一个 01 串 s，长度不超过 2e5。所有数据的字符串长度和不超过 2e5。
定义 f(t) 表示子串 t 转换成十进制的值，如 f("011")=3。
求 s 的所有满足 f(t)=len(t) 的非空子串 t 的个数。
注：子串是连续的。
进阶：你能做到 O(1) 额外空间吗？（不含输入）

rating 1700
https://codeforces.com/contest/1217/submission/167830191
做法不止一种，这里说一个效率更好的解法。
提示 1：枚举所有 '1' 开头的子串，即从 s[i]='1' 的位置开始向右扩展子串。
提示 2：向右扩展时，二进制的值是指数增长的，因此至多向右扩展 O(log n) 次。
提示 3：如何考虑前导零？
具体实现逻辑见代码（含注释）。
这个代码的时间复杂度是 O(n) 的，因为每个 0 算一次，在扩展 1 的时候至多算一次（把 log x 放缩到 x），所以所有扩展次数的和是 O(n) 的。
更紧的界：https://www.yuque.com/docs/share/9a07a90f-c56d-410b-97e8-b68bb97f7638  @啇水苍秀
======

input
4
0110
0101
00001000
0001000
output
4
3
4
3
 */