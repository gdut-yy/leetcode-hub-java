package nc65051;

import java.util.Scanner;

public class NC65051B {
    static int n, m;
    static char[][] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        a = new char[n][m];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next().toCharArray();
        }
        System.out.println(solve());
    }

    private static String solve() {
        // 预处理
        boolean[][] meituan = new boolean[n][7];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 'm') meituan[i][0] = true;
                else if (a[i][j] == 'e') meituan[i][1] = true;
                else if (a[i][j] == 'i') meituan[i][2] = true;
                else if (a[i][j] == 't') meituan[i][3] = true;
                else if (a[i][j] == 'u') meituan[i][4] = true;
                else if (a[i][j] == 'a') meituan[i][5] = true;
                else if (a[i][j] == 'n') meituan[i][6] = true;
            }
        }

        int j = 0;
        for (int i = 0; i < n; i++) {
            if (meituan[i][j]) {
                j++;
            }
            if (j == 7) break;
        }
        return j == 7 ? "YES" : "NO";
    }
}
/*
小美的子序列
https://ac.nowcoder.com/acm/contest/65051/B

题目描述
小美在 n 行 m 列的本子上写了许多字母，她会在每一行中找出一个字母，然后组成一个字符串。
小美想知道，组成的字符串中是否存在至少一个字符串包含 "meituan" 子序列。
输入描述:
第一行输入 2 个整数 n,m(1≤n,m≤1000) 。
接下来 n 行，每行输入一个长度为 m 的字符串表示小美写下的字母。
输出描述:
若存在至少一个字符串包含 "meituan" 子序列，则输出 "YES"，否则输出 "NO"。

枚举
======

示例1
输入
3 3
abc
def
ghi
输出
NO
说明
显然并不能找到meituan子序列。

示例2
输入
8 2
nm
ex
it
td
ul
qu
ac
nt
输出
YES
说明
第1行选择第2个字母。
第2行选择第1个字母。
第3行选择第1个字母。
第4行选择第1个字母。
第5行选择第2个字母。
第6行选择第2个字母。
第7行选择第1个字母。
第8行选择第1个字母。
组成字符串"meitluan"，其中存在"meituan"子序列。
当然，第6行选第1个字母且第5行选第1个字母组成的字符串"meituqan"中也存在"meituan"子序列。
 */