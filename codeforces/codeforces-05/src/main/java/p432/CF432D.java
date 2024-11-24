package p432;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF432D {
    static String s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        s = scanner.next();
        System.out.println(solve());
    }

    private static String solve() {
        int n = s.length();
        int[] z = z_function(s.toCharArray());
        z[0] = n;

        int[] sortedZ = z.clone();
        Arrays.sort(sortedZ);

        List<int[]> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (z[n - i] == i) {
                int j = searchInts(sortedZ, i);
                ans.add(new int[]{i, n - j});
            }
        }
        return ans.size() + System.lineSeparator()
                + ans.stream().map(o -> o[0] + " " + o[1]).collect(Collectors.joining(System.lineSeparator()));
    }

    static int searchInts(int[] a, int key) {
        int l = 0, r = a.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (a[m] >= key) r = m;
            else l = m + 1;
        }
        return l;
    }

    static int[] z_function(char[] s) {
        int n = s.length;
        int[] z = new int[n];
        for (int i = 1, l = 0, r = 0; i < n; ++i) {
            if (i <= r && z[i - l] < r - i + 1) {
                z[i] = z[i - l];
            } else {
                z[i] = Math.max(0, r - i + 1);
                while (i + z[i] < n && s[z[i]] == s[i + z[i]]) ++z[i];
            }
            if (i + z[i] - 1 > r) {
                l = i;
                r = i + z[i] - 1;
            }
        }
        return z;
    }
}
/*
D. Prefixes and Suffixes
https://codeforces.com/contest/432/problem/D

灵茶の试炼 2024-02-22
题目大意：
输入长度 ≤1e5 的字符串 s，只包含大写英文字母。
对于每个既是 s 前缀又是 s 后缀的子串 t，计算 t 的长度，以及 t 在 s 中的出现次数。
注意 t 可以等于 s。
输出格式：
第一行，输出有多少种长度不同的 t。把这个数字记作 k。
然后输出 k 行，每行两个数，分别表示 t 的长度和 t 在 s 中的出现次数。
必须按照 t 长度递增的顺序输出这 k 行。

rating 2000
有两种基于 Z 函数（扩展 KMP）的做法。
方法一
求出 z 数组，以及 z 数组排序后的数组 sortedZ。注意 z[0]=n。
设长为 L 的同时是 s 前缀和后缀的字符串为 t，那么 t 需要满足 z[n-L] == L。
如果 t 出现在 s 的中间某一段，那么 t 对应的 z[i] 一定 >= L。（后缀的前缀是子串。）
所以，在 sortedZ 中二分找第一个 >= L 的数的下标 j，那么 t 的出现次数就是 n-j。
时间复杂度 O(nlogn)。
O(nlogn) 代码 https://codeforces.com/contest/432/submission/247583742
方法二
统计 z[i] 的出现次数（把 z[0]=n 也算上），记到 cnt 数组中。
那么 cnt[L]+cnt[L+1]+...+cnt[n] 就是在方法一中，原本要通过排序+二分才能算出的个数了。
计算 cnt 数组的后缀和，从而快速算出这一和式。
时间复杂度 O(n)。
O(n) 代码 https://codeforces.com/contest/432/submission/247584529
======

input
ABACABA
output
3
1 4
3 2
7 1

input
AAA
output
3
1 3
2 2
3 1
 */
