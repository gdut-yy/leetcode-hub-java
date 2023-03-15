package p1674;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CF1674B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            String s = scanner.next();
            System.out.println(solve(s));
        }
    }

    private static Map<String, Integer> idxMap;

    private static String solve(String s) {
        if (idxMap == null) {
            idxMap = new HashMap<>();
            int idx = 1;
            for (char i = 'a'; i <= 'z'; i++) {
                for (char j = 'a'; j <= 'z'; j++) {
                    if (i != j) {
                        idxMap.put("" + i + j, idx++);
                    }
                }
            }
        }
        return String.valueOf(idxMap.get(s));
    }
}
/*
B. Dictionary
https://codeforces.com/contest/1674/problem/B

题目大意：
Berland language 单词仅由两个不同的字母的组成，ab,ac,...,zx,zy（共 650 个），给定单词，求对应的索引。

打表 + HashMap 查找即可。
======

input
7
ab
ac
az
ba
bc
zx
zy

output
1
2
25
26
27
649
650
 */