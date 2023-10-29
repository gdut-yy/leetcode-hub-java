package p1861;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1861B {
    static char[] a, b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            a = scanner.next().toCharArray();
            b = scanner.next().toCharArray();
            System.out.println(solve());
        }
    }

    private static String solve() {
        int n = a.length;
        for (int i = 0; i + 1 < n; i++) {
            if (a[i] == b[i] && a[i] == '0' && a[i + 1] == b[i + 1] && a[i + 1] == '1') {
                return "YES";
            }
        }
        return "NO";
    }
}
/*
B. Two Binary Strings
https://codeforces.com/contest/1861/problem/B

题目大意：
给定两个长度相等的字符串 a 和 b，仅由字符 0 和/或 1 组成;两个字符串都以字符 0 开始，以字符 1 结束。
您可以执行以下操作任意次数(可能为零):
选择其中一个字符串和其中两个相等的字符;然后把它们之间的所有字符都变成这些字符。
形式上，您选择这两个字符串中的一个(假设选择的字符串是 s)，然后选择两个整数 l 和 r，使 1≤l<r≤|s|和 sl=sr，然后将每个字符 si 替换为 sl，使 l<i<r。
例如，如果选择的字符串是 010101，您可以通过应用一个操作将其转换为以下字符串之一:
- 000101 if you choose l=1 and r=3 ;
- 000001 if you choose l=1 and r=5 ;
- 010001 if you choose l=3 and r=5 ;
- 010111 if you choose l=4 and r=6 ;
- 011111 if you choose l=2 and r=6 ;
- 011101 if you choose l=2 and r=4 .
您必须通过多次应用此操作来确定是否有可能使给定的字符串相等。

前后缀分解？
---
https://codeforces.com/blog/entry/119964
如果答案是 YES，我们总是可以把这两个字符串都变成 00…01…11 的形式(一些前缀由 0 组成，一些后缀由 1 组成，所有 0 都在所有 1 之前)。这是对的，因为在我们让两个字符串相等之后，我们可以应用另一个运算，l=i r=|a|，其中 i 是最小索引，在我们让它们相等之后，两个字符串都有 1。例如，在第一个测试用例中，应用语句中考虑的所有操作后，字符串等于 01110001。我们可以通过 l=2,r=8 的运算将它们转换成字符串 01111111。
好的，现在让我们试着找出什么时候我们可以把字符串转换成 00…0011…11 的形式。我们声明，当且仅当 si=0 且 si+1=1 时，可以将字符串 s 转换为“前 i 个元素为 0，其余元素为 1”的形式:
- 如果 si=0 和 si+1=1，我们可以应用 l=1,r=i 和 l=i+1,r=|s|两个运算，字符串变成“前 i 个元素为 0，其余元素均为 1”的形式;
- 然而，如果不是这样，那么 si=si+1，或者 si=1 and si+1=0。在前一种情况下，我们需要改变这两个元素中的一个;但是由于它们是相等且相邻的，对它们的每一次操作都会同时影响它们，所以不可能只改变其中一个。在后一种情况下，我们需要先将 si 设为 0 或将 si+1 设为 1;当我们这样做的时候，元素就相等了，对它们的每一个操作都会同时影响它们。因此，不可能将字符串转换为“前 i 个元素为 0，其余所有元素为 1”的形式。
所以，答案是肯定的如果有一个索引 i 使得 ai=bi=0 并且 ai+1=bi+1=1。否则，答案是否定的。
---
脑筋急转弯 * 2
======

input
7
01010001
01110101
01001
01001
000101
010111
00001
01111
011
001
001001
011011
010001
011011
output
YES
YES
YES
NO
NO
NO
YES
 */
