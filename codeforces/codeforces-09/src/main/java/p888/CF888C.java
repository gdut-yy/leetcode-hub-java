package p888;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CF888C {
    static char[] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        s = scanner.next().toCharArray();
        System.out.println(solve());
    }

    private static String solve() {
        int n = s.length;
        Map<Integer, List<Integer>> pos = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int b = s[i] - 'a';
            pos.computeIfAbsent(b, e -> new ArrayList<>()).add(i);
        }

        int ans = n;
        for (List<Integer> ps : pos.values()) {
            ps.add(0, -1);
            ps.add(n);

            int maxD = 0;
            for (int i = 1; i < ps.size(); i++) {
                maxD = Math.max(maxD, ps.get(i) - ps.get(i - 1));
            }
            ans = Math.min(ans, maxD);
        }
        return String.valueOf(ans);
    }
}
/*
C. K-Dominant Character
https://codeforces.com/contest/888/problem/C

灵茶の试炼 2023-12-11
题目大意：
输入一个长度 ≤1e5 的字符串 s，只包含小写字母。
找到一个最小的 k，使得所有长度 >= k 的连续子串，有公共字母（这些子串的交集不为空）。

rating 1400
枚举字母 a-z。
对于同一个字母，考虑其相邻出现位置之差的最大值。
例如 axxaxxxa 的最大值是 4，说明要想让子串都包含 a，子串长度至少为 4。
注意最左边的 a 和最右边的 a。例如 xxaxaxxx，最左边的包含 a 的子串长度为 3（xxa），最右边的包含 a 的子串长度为 4（axxx），所以在计算最大值的时候，还需要额外考虑最左最右这两个字母的位置。
预处理每个字母的位置列表，可以做到 O(n)。
https://codeforces.com/problemset/submission/888/235730215
======

input
abacaba
output
2

input
zzzzz
output
1

input
abcde
output
3
 */
