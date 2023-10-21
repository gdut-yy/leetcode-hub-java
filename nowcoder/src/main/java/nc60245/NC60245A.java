package nc60245;

import java.util.Scanner;

public class NC60245A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(solve(n));
    }

    private static String solve(int n) {
        String[] ans = new String[n * 4];
        for (int i = 0; i < n * 3; i++) {
//            String s = "*".repeat(n) + ".".repeat(n * 2) + "*".repeat(n);
            String s = repeat("*", n) + repeat(".", n * 2) + repeat("*", n);
            ans[i] = s;
        }
        int j = 1;
        for (int i = n * 3; i < n * 4; i++) {
//            String s = ".".repeat(j) + "*".repeat(n) + ".".repeat(n - j)
//                    + ".".repeat(n - j) + "*".repeat(n) + ".".repeat(j);
            String s = repeat(".", j) + repeat("*", n) + repeat(".", n - j)
                    + repeat(".", n - j) + repeat("*", n) + repeat(".", j);
            ans[i] = s;
            j++;
        }
        return String.join(System.lineSeparator(), ans);
    }

    static String repeat(String s, int count) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }
}
/*
牛客周赛 Round 1
游游画U
https://ac.nowcoder.com/acm/contest/60245/A

题目描述
游游想让你画一个大小为 n 的 "U" ，你能帮帮她吗？
具体的画法见样例说明。
输入描述:
一个正整数 n。
1≤n≤50
输出描述:
共输出4n 行，每行输出一个长度为4n 的，仅包含 '*' 和 '.' 两种字符的字符串。

找规律
======

示例1
输入
1
输出
*..*
*..*
*..*
.**.

示例2
输入
2
输出
**....**
**....**
**....**
**....**
**....**
**....**
.**..**.
..****..

示例3
输入
3
输出
***......***
***......***
***......***
***......***
***......***
***......***
***......***
***......***
***......***
.***....***.
..***..***..
...******...
 */