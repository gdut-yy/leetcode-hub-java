package p1730;

import java.util.Arrays;
import java.util.Scanner;

public class CF1730D {
    static int n;
    static char[] s, t;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            n = scanner.nextInt();
            s = scanner.next().toCharArray();
            t = scanner.next().toCharArray();
            System.out.println(solve());
        }
    }

    private static String solve() {
        int[] cnt = new int[26];
        int[][] cnt2 = new int[26][26];
        for (int i = 0; i < s.length; i++) {
            int v = s[i] - 'a';
            int w = t[n - 1 - i] - 'a';
            cnt[v] ^= 1;
            cnt[w] ^= 1;
            cnt2[Math.min(v, w)][Math.max(v, w)] ^= 1;
        }
        int odd = 0;
        for (int i = 0; i < 26; i++) {
            for (int j = i; j < 26; j++) {
                odd += cnt2[i][j];
            }
        }
        if (odd <= n % 2 && Arrays.equals(cnt, new int[26])) {
            return "YES";
        }
        return "NO";
    }
}
/*
D. Prefixes and Suffixes
https://codeforces.com/contest/1730/problem/D

灵茶の试炼 2024-11-22
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(1≤n≤1e5) 和两个长为 n 的字符串 s 和 t，只包含小写英文字母。
你可以执行如下操作任意次：
选择一个 [1,n] 中的整数 k。
交换 s[:k] 和 t[n-k:]，即 s 的长为 k 的前缀和 t 的长为 k 的后缀。
能否使 s = t？
输出 YES 或 NO。

rating 2200
首先，s+t 的每种字母的出现次数必须是偶数，这是最终 s=t 的必要条件。

举例说明，假设 s 的前三个字母（abc）和 t 的后三个字母（xyz）交换
s = abc...
t = ...xyz
为方便大家看出规律，把 t 翻转，也就是
s = abc...
t'= zyx...
交换后就是
s = xyz...
t'= cba...
可以发现，对于 s 和 t'，交换前和交换后，a 和 z 始终是对应的，b 和 y 始终是对应的，c 和 x 始终是对应的。
所以无论交换多少次，s[i] 始终与 t'[i]，也就是 t[n-1-i] 对应。（下标从 0 开始）
这个结论也可以通过打表发现。
注意令 k=n，可以交换 s 和 t，综合前面的操作，相当于翻转 s 的一个前缀。
此外，在满足对应关系的前提下，s 的任意排列都是可以得到的：
从 s 的排列 p 的最后一个字母（目标字母）开始，先把 s 中的目标字母翻转到最前面，再把 s 整个翻转，就可以把目标字母翻转到末尾。
然后考虑 p 的倒数第二个字母，依此类推。
再从结果来看。
示例 2 两个字符串都变成了
cbbaa
cbbaa
s[0] 和 t[4] 是一对 (a,c)，s[4] 和 t[0] 也是 (a,c)。
所以要想让 s=t，字母对 (s[i],t[n-1-i]) 的出现次数必须是偶数，除了在 n 是奇数的情况下，允许有一对字母的出现次数是奇数。
代码 https://codeforces.com/contest/1730/submission/292443246
代码备份（洛谷）
======

Input
7
3
cbc
aba
5
abcaa
cbabb
5
abcaa
cbabz
1
a
a
1
a
b
6
abadaa
adaaba
8
abcabdaa
adabcaba
Output
YES
YES
NO
YES
NO
NO
YES
 */
