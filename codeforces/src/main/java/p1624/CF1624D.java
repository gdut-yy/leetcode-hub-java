package p1624;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class CF1624D {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8));
        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            String line1 = reader.readLine();
            String line2 = reader.readLine();
            writer.write(solution(line1, line2).concat(System.lineSeparator()));
        }
        writer.close();
        reader.close();
    }

    private static String solution(String line1, String line2) {
        String[] line1s = line1.split(" ");
        int n = Integer.parseInt(line1s[0]);
        int k = Integer.parseInt(line1s[1]);
        Map<Character, Integer> cntMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char ch = line2.charAt(i);
            cntMap.put(ch, cntMap.getOrDefault(ch, 0) + 1);
        }
        // 统计奇偶
        int cntOdd = 0;
        int cntEven = 0;
        for (int num : cntMap.values()) {
            if (num % 2 == 1) {
                cntOdd++;
            }
            cntEven += num / 2;
        }

        // 分类讨论
        if (cntOdd == 0) {
            // 无奇数，拆偶数
            int cntEvenNew = cntEven - (k + 1) / 2;
            int split = 1 + cntEvenNew / k * 2;

            // 无奇数，不拆偶数
            if (cntEven >= k) {
                int noSplit = cntEven / k * 2;
                return String.valueOf(Math.max(split, noSplit));
            } else {
                return String.valueOf(split);
            }
        } else {
            // 奇数足够，唯一可能
            if (cntOdd >= k) {
                return String.valueOf(1 + cntEven / k * 2);
            }
            int need = k - cntOdd;

            // 有奇数，拆偶数
            int cntEvenNew = cntEven - (need + 1) / 2;
            int split = 1 + cntEvenNew / k * 2;

            // 有奇数，不拆偶数
            if (cntEven >= need) {
                int cntEvenNew2 = cntEven - need;
                int remain = cntEvenNew2 % k;
                if (remain >= cntOdd) {
                    int noSplit = 2 + cntEvenNew2 / k * 2;
                    return String.valueOf(Math.max(split, noSplit));
                } else {
                    int noSplit = 1 + cntEvenNew2 / k * 2;
                    return String.valueOf(Math.max(split, noSplit));
                }
            } else {
                return String.valueOf(split);
            }
        }
    }
}
/*
D. Palindromes Coloring
https://codeforces.com/contest/1624/problem/D

题目大意：
给出整数 n,k 和长度为 n 的字符串 s，将字符串分成 k 组，要求全为回文串，问最短回文串的最大长度。

分类讨论，本题跟具体字符无关，跟字符顺序无关，只跟字符的奇偶次数有关，奇数字符要置于中心，偶数字符可以叠加在任意字符串两侧。
可分为以下五种情况，注意2.1需要考虑边界条件。
1.奇数能覆盖一层
2.奇数覆盖不满一层 2.1拆偶数/2.2不拆偶数
3.无奇数 3.1拆偶数/3.2不拆偶数
======

%2 /2

10
8 2
bxyaxzay
6 3
aaaaaa
6 1
abcdef
6 6
abcdef
3 2
dxd
11 2
abcabcabcac
6 6
sipkic
7 2
eatoohd
3 1
llw
6 2
bfvfbv

3
2
1
1
1
5
1
1
3
3

补充用例
input
2
10 5
abcccccccc
12 5
abcccccccccc

output
1
2
 */