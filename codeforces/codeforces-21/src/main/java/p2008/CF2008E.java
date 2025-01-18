package p2008;

import java.util.Arrays;
import java.util.Scanner;

public class CF2008E {
    static int n;
    static char[] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            s = scanner.next().toCharArray();
            System.out.println(solve());
        }
    }

    private static String solve() {
        int[][] suf = new int[2][26];
        for (int i = 0; i < n; i++) {
            int b = s[i] - 'a';
            suf[i % 2][b]++;
        }
        if (n % 2 == 0) {
            int ans = n - Arrays.stream(suf[0]).max().orElseThrow() - Arrays.stream(suf[1]).max().orElseThrow();
            return String.valueOf(ans);
        }
        int mx = 0;
        int[][] pre = new int[2][26];
        for (int i = 0; i < n; i++) {
            int b = s[i] - 'a';

            suf[i % 2][b]--;
            int mx1 = 0, mx2 = 0;
            for (int j = 0; j < 26; j++) {
                mx1 = Math.max(mx1, pre[0][j] + suf[1][j]);
                mx2 = Math.max(mx2, pre[1][j] + suf[0][j]);
            }
            mx = Math.max(mx, mx1 + mx2);
            pre[i % 2][b]++;
        }
        return String.valueOf(n - mx);
    }
}
/*
E. Alternating String
https://codeforces.com/contest/2008/problem/E

灵茶の试炼 2024-10-01
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(1≤n≤2e5) 和长为 n 的字符串 s，只包含小写英文字母。
你需要把 s 变成长为偶数的交替字符串（所有偶数下标字母都一样，所奇数下标字母都一样）。
有两种操作：
1. 删除 s[i]，该操作至多执行一次。
2. 把 s[i] 改成其他字母。
输出最小操作次数。

rating 1500
考虑最多保留多少个数不变/不删除，答案为 n 减去最多保留的字母个数。
如果 n 是偶数，那么不能删除字母，所以统计偶数下标中的出现次数最多的字母，和奇数下标中的出现次数最多的字母，二者相加。
如果 n 是奇数，那么必须要删除一个字母。前后缀分解，和上面一样，按照下标的奇偶性统计字母的出现次数，具体见代码。
写法一 https://codeforces.com/problemset/submission/2008/281956798
写法二：优化，合并成一个数组 https://codeforces.com/problemset/submission/2008/281957281
======

Input
10
1
a
2
ca
3
aab
5
ababa
6
acdada
9
ejibmyyju
6
bbccbc
6
abacba
5
bcbca
5
dcbdb
Output
1
0
1
1
2
6
2
3
1
1
 */
