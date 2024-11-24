package p1730;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1730C {
    static char[] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            s = scanner.next().toCharArray();
            System.out.println(solve());
        }
    }

    private static String solve() {
        List<Character> st = new ArrayList<>();
        List<Character> t = new ArrayList<>();
        for (char b : s) {
            while (!st.isEmpty() && b < st.getLast()) {
                char c = (char) Math.min(st.getLast() + 1, '9');
                t.add(c);
                st.removeLast();
            }
            st.add(b);
        }
        st.addAll(t);
        st.sort(Comparator.comparingInt(o -> o));
        return st.stream().map(String::valueOf).collect(Collectors.joining(""));
    }
}
/*
C. Minimum Notation
https://codeforces.com/contest/1730/problem/C

灵茶の试炼 2024-02-20
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的字符串长度之和 ≤2e5。
每组数据输入字符串 s，仅包含 '0' 到 '9'。
你可以执行如下操作任意次：
把 s 中的一个字符 c 删除，然后在任意位置插入 min(c+1,'9')。
输出你能得到的字典序最小的字符串。

rating 1200
单调栈套路。
遍历 s，维护一个非降的单调栈，把弹出的字符加一（但不超过 '9'）。
然后把这些字符从小到大排序，即为答案。
https://codeforces.com/contest/1730/submission/245469787
【题单】单调栈（矩形系列/字典序最小/贡献法）
======

input
4
04829
9
01
314752277691991
output
02599
9
01
111334567888999
 */
