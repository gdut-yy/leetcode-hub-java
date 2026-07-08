package p1080;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF1080E {
    static Scanner scanner;
    static PrintWriter out;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        out = new PrintWriter(System.out);
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt(), m = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) a[i] = scanner.next();
        long ans = 0;
        int sz = n * 2 + 3;
        int[] halfLen = new int[sz - 2];
        halfLen[1] = 1;
        for (int r = 0; r < m; r++) {
            int[][] t = new int[sz][26];
            int[] odd = new int[sz];
            odd[0] = 2;
            odd[sz - 1] = 2;
            for (int l = r; l >= 0; l--) {
                for (int i = 0; i < n; i++) {
                    int idx = a[i].charAt(l) - 'a';
                    t[i * 2 + 2][idx]++;
                    odd[i * 2 + 2] += (t[i * 2 + 2][idx] % 2) * 2 - 1;
                }
                int boxM = 0, boxR = 0;
                for (int i = 2; i < sz - 2; i++) {
                    int hl = 0;
                    if (i < boxR) {
                        hl = Math.min(halfLen[boxM * 2 - i], boxR - i);
                    }
                    while (odd[i - hl] <= 1 && odd[i + hl] <= 1 && eq(t[i - hl], t[i + hl])) {
                        hl++;
                        boxM = i;
                        boxR = i + hl;
                    }
                    halfLen[i] = hl;
                    ans += hl / 2;
                }
            }
        }
        out.println(ans);
    }

    static boolean eq(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}
/*
E. Sonya and Matrix Beauty
https://codeforces.com/contest/1080/problem/E

灵茶の试炼 2026-01-30
题目大意：
输入 n m(1≤n,m≤250) 和 n 行 m 列的矩阵，只包含小写英文字母。
有多少个子矩阵，在重排子矩阵每一行的字母后，子矩阵每行每列都是回文串？

rating 2400
本题有两个要求：
1. 子矩阵每一行都是回文串。由于我们可以重排行，所以只需关注行的字母个数，至多有一个字母出现奇数次。
2. 子矩阵每一列都是回文串。考察子矩阵中的（关于水平中轴）对称的两行，这两行重排后要完全一样。这要求在重排前，这两行每种字母的个数要完全相等。
枚举子矩阵的左右边界，统计每一行的每种字母的出现次数，把每一行的信息压缩到一个长为 26 的 int 数组中，问题变成：
给你一个长为 n 的数组（数组的每个元素是长为 26 的 int 数组），计算其中有多少个回文子数组。
其中「回文」的判定条件是，对称位置的长为 26 的 int 数组要相等，且都是至多有一个字母出现奇数次。
用 Manacher 算法计算回文子数组的个数，见 LC647. 回文子串。
代码 https://codeforces.com/contest/1080/submission/345953769
代码备份（上面打不开的同学看这个）
======

Input
1 3
aba
Output
4

Input
2 3
aca
aac
Output
11

Input
3 5
accac
aaaba
cccaa
Output
43
 */
