package p1822;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1822E {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            String s = scanner.next();
            if (n == 10000){
                System.out.println();
            }

            System.out.println(solve(n, s));
        }
    }

    private static String solve(int n, String s) {
        // 长度为奇数不可能
        if ((n & 1) == 1) {
            return "-1";
        }
        int[] cntArr = new int[26];
        for (char ch : s.toCharArray()) {
            cntArr[ch - 'a']++;
        }
        for (int cnt : cntArr) {
            // 某个字符超过一半长度，不可能
            if (cnt > n / 2) {
                return "-1";
            }
        }

        int[] cntPair = new int[26];
        int pair = 0;
        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) == s.charAt(n - 1 - i)) {
                pair++;
                cntPair[s.charAt(i) - 'a']++;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (cntPair[i] * 2 > pair) {
                return String.valueOf(cntPair[i]);
            }
        }
        return String.valueOf((pair + 1) / 2);
    }
}
/*
E. Making Anti-Palindromes
https://codeforces.com/contest/1822/problem/E

题目大意：
你会得到一个由小写英文字母组成的字符串 s。在一个操作中，您可以交换字符串 s 中的任意两个字符。
长度为 n 的字符串 s 称为反回文，如果对于每一个 i(1≤i≤n) s[i]≠s[n-i+1]。例如，字符串"codeforces"， "string"是反回文，但字符串"abacaba", "abc", "test"不是。
确定使字符串 s 成为反回文所需的最小操作数，如果不可能，则输出 −1。

如果 n 是奇数，则不存在解，因为 s[(n+1)/2]=s[(n+1)−(n+1)/2]。
如果 n 是偶数，那么所有的符号被分成 s[i], s[n+1-i] 对。我们把符号 c 出现的次数记为 cnt[c]。
请注意，如果对于某些 c, cnt[c]>n/2，那么在应用这些操作之后，将会有一对字符，其中两个字符都等于 c，那么不可能使字符串成为反回文。
否则，我们将计算 k -对的数量，其中 s[i]=s[n+1-i]，我们还将找到 m -对的最大数量，其中 s[i]=s[n+1-i]=c，对于所有字符 c。
设 x 是一个符号，其中这种配对的数目等于 m。请注意 ans≥m，因为在一个操作中，s[i]=s[n+1-i]=x 的配对数不能减少超过 1。
还要注意 ans≥ceil(k/2)，因为对于每个操作，我们将 s[i]=s[n+1-i]的对的个数减少不超过 2。结果是 ans=max(m,ceil(k/2))，为了证明这一点，你可以贪心——直到 k>0:
- 如果 k=m，则求出一对 s[i]=s[n+1−i]=x，由于 cnt[x]≤n/2，则存在 s[j]≠x 且 s[n+1−j]≠x 的对。然后交换 s[i]和 s[j]。
- 否则，求 s[i]=s[n+1−i]=x，且 s[j]=s[n+1−j]≠x。然后交换 s[i]和 s[j]。
不难看出，在这两种情况下，max(m,ceil(k/2)) 都会正好减小 1，这意味着该算法实现了 ans。
======

input
10
10
codeforces
3
abc
10
taarrrataa
10
dcbdbdcccc
4
wwww
12
cabbaccabaac
10
aadaaaaddc
14
aacdaaaacadcdc
6
abccba
12
dcbcaebacccd
output
0
-1
1
1
-1
3
-1
2
2
2
 */
