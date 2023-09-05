package p1862;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1862A {
    static int n, m;
    static char[][] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            a = new char[n][m];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.next().toCharArray();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        String t = "vika";
        int p = 0;
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                if (p < t.length() && a[i][j] == t.charAt(p)) {
                    p++;
                    break;
                }
            }
        }
        return p == t.length() ? "YES" : "NO";
    }
}
/*
Codeforces Round 894 (Div. 3)
A. Gift Carpet
https://codeforces.com/contest/1862/problem/A

题目大意：
最近，特玛和维卡庆祝了家庭日。他们的朋友 Arina 送给他们一张地毯，这张地毯可以用一张由小写拉丁字母组成的 n⋅m 表格来表示。
Vika 还没有看到礼物，但是 Tema 知道她喜欢什么样的地毯。如果维卡能在地毯上读她的名字，她会喜欢的。她从左到右逐列阅读，并从当前列中选择一个或零个字母。
正式地说，如果有可能按照从左到右的顺序选择四列不同的列，使第一列包含“v”，第二列包含“i”，第三列包含“k”，第四列包含“a”，女孩会喜欢地毯。
帮助 Tema 提前了解 Vika 是否会喜欢 Arina 的礼物。

双指针。
======

input
5
1 4
vika
3 3
bad
car
pet
4 4
vvvv
iiii
kkkk
aaaa
4 4
vkak
iiai
avvk
viaa
4 7
vbickda
vbickda
vbickda
vbickda
output
YES
NO
YES
NO
YES

1
1 5
vikaa
 */
