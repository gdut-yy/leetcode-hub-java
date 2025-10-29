package c428;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Abc428_b {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        String s = scanner.next();
        Map<String, Integer> cnt = new HashMap<>();
        for (int i = 0; i + k <= n; i++) {
            String substr = s.substring(i, i + k);
            cnt.merge(substr, 1, Integer::sum);
        }
        int maxC = 0;
        Map<Integer, List<String>> group = new HashMap<>();
        for (Map.Entry<String, Integer> entry : cnt.entrySet()) {
            String key = entry.getKey();
            Integer val = entry.getValue();
            maxC = Math.max(maxC, val);
            group.computeIfAbsent(val, e -> new ArrayList<>()).add(key);
        }

        out.println(maxC);
        List<String> ans = group.get(maxC);
        ans.sort(null);
        out.println(String.join(" ", ans));
    }
}
/*
B - Most Frequent Substrings
https://atcoder.jp/contests/abc428/tasks/abc428_b

题目大意：
给你一个长度为 N 的字符串 S ，由小写英文字母组成。
将长度为 K 的字符串 t 的 出现次数 定义为满足以下条件的整数 i 的个数：
- 1 <= i <= N-K+1
- 从 i-th 字符到 (i+K-1)-th 字符的 S 子串匹配 t 。
求长度为 K 的字符串出现次数的最大值 x 。同时，以升序词法输出所有长度为 K 的字符串中出现 x 次的字符串。

模拟。
======

Input 1
9 3
ovowowovo
Output 1
2
ovo owo

Input 2
9 1
ovowowovo
Output 2
5
o

Input 3
35 3
thequickbrownfoxjumpsoverthelazydog
Output 3
2
the
 */
