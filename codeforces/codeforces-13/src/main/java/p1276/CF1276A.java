package p1276;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1276A {
    static String s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            s = scanner.next();
            System.out.println(solve());
        }
    }

    private static String solve() {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i + 2 < s.length(); i++) {
            // if i+4 < len(s) && s[i:i+5] == "twone" {
            if (i + 4 < s.length() && s.startsWith("twone", i)) {
                ans.add(i + 3);
                i += 4;
            } else {
                String subStr = s.substring(i, i + 3);
                if (subStr.equals("one") || subStr.equals("two")) {
                    ans.add(i + 2);
                    i += 2;
                }
            }
        }
        return ans.size() + System.lineSeparator()
                + ans.stream().map(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
A. As Simple as One and Two
https://codeforces.com/contest/1276/problem/A

灵茶の试炼 2023-07-31
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据字符串长度之和 ≤1.5e6。
每组数据输入一个长度 ≤1.5e5 的字符串 s，只包含小写字母。
删除尽量少的字符，使得字符串中不存在任何连续子串为 one 或 two。
输出：第一行为删除的字符个数。第二行为删除的字符下标（下标从 1 开始）。

rating 1400
https://codeforces.com/problemset/submission/1276/216058616
注意到对于 oooneee 这样的字符串，删除 o 或 e 仍然会产生 one，但是删除 n 就不会有 one 了。
同理对于 two 应该删除 w。但是，如果子串是 twone，删除 o 更好。
======

input
4
onetwone
testme
oneoneone
twotwo
output
2
6 3
0

3
4 1 7
2
1 4

input
10
onetwonetwooneooonetwooo
two
one
twooooo
ttttwo
ttwwoo
ooone
onnne
oneeeee
oneeeeeeetwooooo
output
6
18 11 12 1 6 21
1
1
1
3
1
2
1
6
0

1
4
0

1
1
2
1 11
 */
