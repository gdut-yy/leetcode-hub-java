package p1800;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1800F {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        String[] s = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = scanner.next();
        }
        System.out.println(solve(n, s));
    }

    private static String solve(int n, String[] s) {
        int[] and = new int[n];
        int[] xor = new int[n];
        for (int i = 0; i < n; i++) {
            for (char ch : s[i].toCharArray()) {
                // 或操作 0/1 表示是否字符出现过，异或操作 0/1 表示字符出现次数是否为奇数
                int mask = 1 << (ch - 'a');
                and[i] |= mask;
                xor[i] ^= mask;
            }
        }

        long res = 0L;
        int FULL = (1 << 26) - 1;
        // 枚举 26 种情况
        for (int k = 0; k < 26; k++) {
            // 二进制 25 个 1
            int bitCount25 = FULL ^ (1 << k);

            // 2^26 = 67,108,864
            int[] cnt = new int[1 << 26];
            // (and[i] | and[j]) = (xor[i] ^ xor[j]) = 25
            for (int i = 0; i < n; i++) {
                if (((and[i] >> k) & 1) == 0) {
                    cnt[xor[i]]++;
                    int j = xor[i] ^ bitCount25;
                    res += cnt[j];
                }
            }
        }
        return String.valueOf(res);
    }
}
/*
F. Dasha and Nightmares
https://codeforces.com/contest/1800/problem/F

题目大意：
给定字符串 s。求 i<j 的 (i,j) 对的数量。
- 它是由 si sj 级联得到的
- 它的长度是奇数
- 不同字母的数目正好是 25
- 单词中每个字母出现的次数是奇数

状态压缩 + 哈希表。枚举 26 种情况，统计方案数。
and 操作 0/1 表示是否字符出现过，xor 操作 0/1 表示字符出现次数是否为奇数
等价于 (and[i] | and[j]) = (xor[i] ^ xor[j]) = 25
======

input
10
ftl
abcdefghijklmnopqrstuvwxy
abcdeffghijkllmnopqrsttuvwxy
ffftl
aabbccddeeffgghhiijjkkllmmnnooppqqrrssttuuvvwwxxyy
thedevid
bcdefghhiiiijklmnopqrsuwxyz
gorillasilverback
abcdefg
ijklmnopqrstuvwxyz

output
5
 */