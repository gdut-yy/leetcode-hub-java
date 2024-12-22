package p1781;

import java.util.Arrays;
import java.util.Scanner;

public class CF1781C {
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
        int[] cnt = new int[26];
        for (char b : s) {
            cnt[b - 'a']++;
        }
        Integer[] ids = new Integer[26];
        for (int i = 0; i < 26; i++) ids[i] = i;
        Arrays.sort(ids, (o1, o2) -> Integer.compare(cnt[o2], cnt[o1]));

        int maxSave = 0;
        int k = 0;
        for (int i = 1; i <= 26; i++) {
            if (n % i > 0) continue;
            int save = 0;
            for (int i0 = 0; i0 < i; i0++) {
                int j = ids[i0];
                save += Math.min(cnt[j], n / i);
            }
            if (save > maxSave) {
                maxSave = save;
                k = i; // 变成出现次数最多的 k 种字母
            }
        }

        StringBuilder need = new StringBuilder();
        int m = n / k; // 每种字母最终有 m 个
        for (int i0 = 0; i0 < k; i0++) {
            int i = ids[i0];
            if (cnt[i] > m) {
                cnt[i] = m;
            } else {
                // 还需要 m-cnt[i] 个字母
                char ch = (char) ('a' + i);
                need.append(String.valueOf(ch).repeat(m - cnt[i]));
            }
        }
        for (int i0 = k; i0 < 26; i0++) {
            int i = ids[i0];
            cnt[i] = 0;
        }

        int j = 0;
        for (int i = 0; i < s.length; i++) {
            int b = s[i] - 'a';
            if (cnt[b] > 0) {
                cnt[b]--; // 保持不变
            } else {
                s[i] = need.charAt(j); // 变
                j++;
            }
        }
        return (n - maxSave) + System.lineSeparator() + new String(s);
    }
}
/*
C. Equal Frequencies
https://codeforces.com/contest/1781/problem/C

灵茶の试炼 2024-01-10
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤1e5。
每组数据输入 n(1≤n≤1e5) 和长为 n 的字符串 s，仅包含小写英文字母。
如果一个字符串中的每个字母的出现次数都相同，我们就称该字符串为平衡字符串。
每次操作，你可以修改一个 s[i]。
你需要把 s 变成平衡字符串。
输出最少要操作多少次，以及修改后的字符串。
如果有多个符合要求的字符串，输出任意一个。

rating 1600
1. 统计 s 中 a-z 的出现次数。
2. 枚举 t 中有 k 种不同字母（k=1~26 且 k 是 n 的因子）。例如 k=2 表示 t 有两种字母，且每种字母的出现次数都是 n/2。
3. 计算最多可以保留 s 的多少个字母不变，记录对应的 k。按照字母的出现次数排序，取出现次数最多的 k 种字母，把 s 的其它字母变成这 k 种字母。
4. 用一个数组 need 记录需要变成哪些字母，每种字母各需要多少。在出现次数最多的 k 种字母中，如果 cnt[i]<n/k，则还需要变出 n/k-cnt[i] 个第 i 个字母。
5. 在出现次数最多的 k 种字母中，我们需要保留 left[j] = min(cnt[j],n/k) 个字母不变。
6. 遍历 s，根据 need 修改相应字母。如果 left[s[i]] > 0 则保持 s[i] 不变，把 left[s[i]] 减一，否则把 s[i] 变成 need 中的一个字母。
https://codeforces.com/contest/1781/submission/240233629
======

input
4
5
hello
10
codeforces
5
eevee
6
appall
output
1
helno
2
codefofced
1
eeeee
0
appall
 */