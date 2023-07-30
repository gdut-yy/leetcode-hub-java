package p1051;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CF1051C {
    static int n;
    static int[] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        s = new int[n];
        for (int i = 0; i < n; i++) {
            s[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        Map<Integer, List<Integer>> posMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            posMap.computeIfAbsent(s[i], key -> new ArrayList<>()).add(i);
        }

        int c1 = 0;
        int v0 = 0;
        for (Map.Entry<Integer, List<Integer>> entry : posMap.entrySet()) {
            int v = entry.getKey();
            List<Integer> pos = entry.getValue();
            if (pos.size() == 1) {
                c1++;
            } else if (pos.size() > 2) {
                v0 = v;
            }
        }

        char[] ans = new char[n];
        Arrays.fill(ans, 'A');
        if (c1 % 2 == 1) {
            if (v0 == 0) {
                return "NO";
            }
            ans[posMap.get(v0).get(0)] = 'B';
            c1++;
        }
        c1 /= 2;
        for (List<Integer> p : posMap.values()) {
            if (p.size() == 1) {
                if (c1 > 0) {
                    c1--;
                } else {
                    ans[p.get(0)] = 'B';
                }
            }
        }
        return "YES" + System.lineSeparator()
                + new String(ans);
    }
}
/*
C. Vasya and Multisets
https://codeforces.com/contest/1051/problem/C

灵茶の试炼 2023-07-04
题目大意：
输入 n(2≤n≤100) 和长为 n 的数组 s(1≤s[i]≤100)。
把 s 分成两个子序列 A 和 B（子序列可以为空），使得 A 里面只出现一次的数的个数，等于 B 里面只出现一次的数的个数。
如果无法做到，输出 NO。
否则输出 YES 以及方案（见样例）。
注意 s 中可能有重复元素。
思考题：如果子序列不能为空呢？
思考题：如果分成 k 个子序列要怎么做？

https://codeforces.com/contest/1051/submission/211938643
设 s 中有 c1 个数出现一次。
如果 c1 是偶数，那么选 c1/2 个数分到 B，其余分到 A。
如果 c1 是奇数，由于出现两次的数分开对答案没有影响，所以要考虑选一个出现次数 >= 3 次的数分到 B，然后再选 floor(c1/2) 个数分到 B，其余分到 A。
如果没有出现次数 >= 3 次的数，则无解。
======

input
4
3 5 7 1
output
YES
BABA

input
3
3 5 1
output
NO
 */
