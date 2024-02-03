package p1907;

import java.util.Arrays;
import java.util.Scanner;

public class CF1907C {
    static int n;
    static String s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            s = scanner.next();
            System.out.println(solve());
        }
    }

    private static String solve() {
        int[] cnt = new int[26];
        for (char ch : s.toCharArray()) {
            cnt[ch - 'a']++;
        }
        int max = Arrays.stream(cnt).max().orElseThrow();
        int ans = Math.max(n % 2, max - (n - max));
        return String.valueOf(ans);
    }
}
/*
C. Removal of Unattractive Pairs
https://codeforces.com/contest/1907/problem/C

题目大意：
弗拉德发现了一个由 n 个小写拉丁字母组成的字符串 s，他想让它尽可能短。
要做到这一点，他可以从 s 中任意次数地删除任何一对相邻字符，只要它们是不同的。例如，如果 s =racoon，那么通过删除一对字符，他可以获得字符串 coon, roon, raon 和 raco，但他不能获得 racn(因为删除的字母相同)或 rcon(因为删除的字母不相邻)。
通过应用任意数量的删除，Vlad 可以实现的最小长度是多少?

贪心不行，猜结论。
显然存在一个下界：n % 2
设最大频次为 max_cnt，其他字符可抵消 n - max_cnt
======

input
10
4
aabc
5
abaca
10
avbvvcvvvd
7
abcdefg
5
dabbb
8
aacebeaa
7
bbbbacc
6
dacfcc
6
fdfcdc
9
dbdcfbbdc
output
0
1
2
1
1
0
1
0
0
1
 */