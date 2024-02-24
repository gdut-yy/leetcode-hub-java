package p872;

import java.util.Arrays;
import java.util.Scanner;

public class CF872A {
    static char[] s;
    static int k, st;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        char[] ans = new char[MAX_N - 1];
        Arrays.fill(ans, 'a');
        int end = 0;
        DSU dsu = new DSU(MAX_N);
        while (n-- > 0) {
            s = scanner.next().toCharArray();
            k = scanner.nextInt();
            for (int j = 0; j < k; j++) {
                st = scanner.nextInt();
                st--;
                int e = st + s.length;
                if (end < e) {
                    end = e;
                }
                for (int i = dsu.find(st); i < e; i = dsu.find(i + 1)) {
                    ans[i] = s[i - st];
                    dsu.fa[i] = e;
                }
            }
        }
        System.out.println(new String(Arrays.copyOf(ans, end)));
    }

    static final int MAX_N = (int) 2e6;

    public static class DSU {
        int[] fa;

        public DSU(int n) {
            fa = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
            }
        }

        int find(int x) {
            if (x != fa[x]) {
                fa[x] = find(fa[x]);
            }
            return fa[x];
        }
    }
}
/*
A. String Reconstruction
https://codeforces.com/contest/827/problem/A

灵茶の试炼 2022-05-02
题目大意：
有一个未知的字符串 s（长度也未知），输入 n(<=1e5) 个子串的信息，每条信息包含一个子串和该子串在 s 中的至少哪些位置出现过。（输入的子串的长度之和 <=1e6，位置的个数 <=1e6，位置的下标<=1e6）
请你根据上述信息还原出一个字典序最小的 s。（保证 s 存在）

rating 1700
每个出现的位置等价于一个操作：将区间 [x,x+len(substr)-1] 上的字符置为 substr。
由于题目保证 s 是存在的，那么已经赋值字符的位置就不用重新赋值了，需要跳过，跳过操作可以用并查集来实现。
最后为了保证 s 的字典序最小，没有赋值的位置要置为 'a'。
https://codeforces.com/contest/827/submission/155731179
======

input
3
a 4 1 3 5 7
ab 2 1 5
ca 1 4
output
abacaba

input
1
a 1 3
output
aaa

input
3
ab 1 1
aba 1 3
ab 2 3 5
output
ababab
 */