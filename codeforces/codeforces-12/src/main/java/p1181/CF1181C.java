package p1181;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1181C {
    private static int n, m;
    private static char[][] blanket;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        m = scanner.nextInt();
        blanket = new char[n][m];
        for (int i = 0; i < n; i++) {
            blanket[i] = scanner.next().toCharArray();
        }
        System.out.println(solve());
    }

    private static String solve() {
        int ans = 0;
        int[] f = new int[n];
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                if (j > 0 && blanket[i][j] == blanket[i][j - 1]) {
                    f[i]++;
                } else {
                    f[i] = 1;
                }
            }
            next:
            for (int i = 0; i < n; ) {
                int i0 = i;
                // 左侧最短同色长度
                int min = f[i];
                i++;
                for (; i < n && blanket[i][j] == blanket[i0][j]; i++) {
                    min = Math.min(min, f[i]);
                }
                int size = i - i0;
                if (i0 < size || i + size > n) {
                    continue;
                }

                // 前一段同色 size
                for (int k = i0 - 1; k >= i0 - size; k--) {
                    if (blanket[k][j] != blanket[i0 - 1][j]) {
                        continue next;
                    }
                    min = Math.min(min, f[k]);
                }

                // 后一段同色 size
                for (int k = i; k < i + size; k++) {
                    if (blanket[k][j] != blanket[i][j]) {
                        continue next;
                    }
                    min = Math.min(min, f[k]);
                }
                ans += min;
            }
        }
        return String.valueOf(ans);
    }

    private static int[] f;
    private static int ans;

    // 消掉 continue label
    private static String solve1() {
        ans = 0;
        f = new int[n];
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                if (j > 0 && blanket[i][j] == blanket[i][j - 1]) {
                    f[i]++;
                } else {
                    f[i] = 1;
                }
            }

            dfs(j, 0);
        }
        return String.valueOf(ans);
    }

    private static void dfs(int j, int start) {
        for (int i = start; i < n; ) {
            int i0 = i;
            // 左侧最短同色长度
            int min = f[i];
            i++;
            for (; i < n && blanket[i][j] == blanket[i0][j]; i++) {
                min = Math.min(min, f[i]);
            }
            int size = i - i0;
            if (i0 < size || i + size > n) {
                continue;
            }

            // 前一段同色 size
            for (int k = i0 - 1; k >= i0 - size; k--) {
                if (blanket[k][j] != blanket[i0 - 1][j]) {
                    dfs(j, i);
                    return;
                }
                min = Math.min(min, f[k]);
            }

            // 后一段同色 size
            for (int k = i; k < i + size; k++) {
                if (blanket[k][j] != blanket[i][j]) {
                    dfs(j, i);
                    return;
                }
                min = Math.min(min, f[k]);
            }
            ans += min;
        }
    }
}
/*
C. Flag
https://codeforces.com/contest/1181/problem/C

灵茶の试炼 2023-03-22
题目大意：
输入 n(≤1e3) m(≤1e3) 和一个 n 行 m 列的字符矩阵，元素都是小写字母。
定义「国旗」为一个 3h 行的子矩阵，前 h 行的字符都相同，中间 h 行的字符都相同，后 h 行的字符都相同，它们分别记作 A B C，要求 A 和 B 的字符不同，B 和 C 的字符不同（A 和 C 无要求）。
输出是国旗的子矩阵数量。

rating 1900
https://codeforces.com/contest/1181/submission/198473717
提示 1：枚举子矩阵的右边界（第 j 列）。
提示 2：枚举第 j 列的连续三种字符。
比如这一列从上到下是 aabbbbcccddcc，那么压缩成 abcdc，枚举 abc bcd cdc，这一列上的国旗只会有这三种情况。
提示 3：需要知道从 (i,j) 往左连续出现了多少个相同字符，记作 f[i][j]，这可以递推预处理，或者一边遍历一边算。
这个国旗的最远左边界就是 f[i][j] 的最小值。从最远左边界到 j 都可以作为国旗的左边界，贡献答案。
======

input
4 3
aaa
bbb
ccb
ddd
output
6

input
6 1
a
a
b
b
c
c
output
1

10 10
aaaaarpppp
bbbbsssssu
cciiiiiiqq
ddmmgggggg
eeebbbbbbb
fffffqoooo
gxxxxrrrrr
hhfuuuuuuu
iiillqqqqq
jjjjjppwww
138

10 10
itttrrrnnn
bbbbpppkdv
bbbbpppkzv
bbbbpppkzv
bbbbpppbbv
ippeerrsss
ippeerrsss
ibbeeeesss
iiieeeeeef
llorrrrvzz
14
 */

