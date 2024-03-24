package p1281;

import java.util.Arrays;
import java.util.Scanner;

public class CF1281B {
    static char[] s, t;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            s = scanner.next().toCharArray();
            t = scanner.next().toCharArray();
            System.out.println(solve());
        }
    }

    private static String solve() {
        int[] last = new int[26];
        Arrays.fill(last, -1);
        for (int i = 0; i < s.length; i++) {
            last[s[i] - 'A'] = i;
        }
        int k = 0;
        for (int i = 0; i < s.length; i++) {
            while (k < s[i] - 'A' && last[k] < i) {
                k++;
            }
            if (k < s[i] - 'A') {
                // s[i], s[last[k]] = s[last[k]], s[i]
                char tmp = s[i];
                s[i] = s[last[k]];
                s[last[k]] = tmp;
                break;
            }
        }
        if (Arrays.compare(s, t) < 0) {
            return new String(s);
        } else {
            return "---";
        }
    }
}
/*
B. Azamon Web Services
https://codeforces.com/contest/1281/problem/B

灵茶の试炼 2022-07-27
题目大意：
输入 t(≤1500) 表示 t 组数据，每组数据输入两个字符串 s 和 c，长度不超过 5000，由大写字母组成。
你可以交换 s 中的至多一对字符，得到 s'，问能否使 s' < c（即 s' 的字典序严格小于 c）。
若能则输出任意一个符合要求的 s'，否则输出 "---"。
所有数据的 s 和 c 的长度之和各不超过 5000。
进阶：你能实现一个线性时间复杂度的做法吗？

rating 1600
https://codeforces.com/contest/1281/submission/165847470
不妨求 s 交换一次后的最小字典序 s'，然后看 s' < c 是否成立。
从左往右遍历 s，如果在 s[i] 右侧存在比它更小的字符，那么选择一个最小且最靠右的字符和 s[i] 交换，即得到 s'。
预处理每个字符在 s 中最后一次出现的下标即可。
你可以写一个 O(26n) 的代码，但是注意到如果 s[i] 右侧没有字符 k，那么继续遍历 s 也不会找到 k，根据这一点我们可以做到 O(n+26)，代码见上面链接。
群友写的 O(n) 时间 + O(1) 额外空间的写法 ->
#include <bits/stdc++.h>
using namespace std;
int main() {
    int t, n;
    string s, c;
    cin >> t;
    while (t--) {
        cin >> s >> c;
        n = s.size();
        int x = n, a = 0, b = 0;
        for (int i = n - 1; i >= 0; --i) {
            if (x != n && s[x] < s[i]) {
                a = i;
                b = x;
            }
            if (x == n || s[x] > s[i]) {
                x = i;
            }
        }
        swap(s[a], s[b]);
        if (s < c) cout << s << "\n";
        else cout << "---\n";
    }
    return 0;
}
======

input
3
AZAMON APPLE
AZAMON AAAAAAAAAAALIBABA
APPLE BANANA
output
AMAZON
---
APPLE
 */
