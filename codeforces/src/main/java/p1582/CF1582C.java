package p1582;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class CF1582C {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8));
        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            reader.readLine();
            String line = reader.readLine();
            writer.write(solution(line).concat(System.lineSeparator()));
        }
        writer.close();
        reader.close();
    }

    private static String solution(String line) {
        int len = line.length();
        int min = Integer.MAX_VALUE;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            int left = 0;
            int right = len - 1;
            int erased = 0;
            while (left < right) {
                if (line.charAt(left) == line.charAt(right)) {
                    left++;
                    right--;
                } else {
                    if (line.charAt(left) == ch) {
                        erased++;
                        left++;
                    } else if (line.charAt(right) == ch) {
                        erased++;
                        right--;
                    } else {
                        break;
                    }
                }
            }
            // 能处理成回文
            if (left >= right) {
                min = Math.min(min, erased);
            }
        }
        return min == Integer.MAX_VALUE ? "-1" : String.valueOf(min);
    }
}
/*
C. Grandma Capa Knits a Scarf
https://codeforces.com/contest/1582/problem/C

题目大意：
给出字符串 s。选一个字母，在 s 中删除一些这种字母，使其变为回文串，求可删除的最小数。

枚举 + 双指针
只能删一种字母，即只能删除 'a' ~ 'z' 中的一个。假设当前能删除的字符为 ch，当首位字符相等时，两个都选取；
当首尾字符不等时，如果字符为 ch，可以擦除，否则不能构成回文。统计 26 种情况的最小值即可。
======

input
5
8
abcaacab
6
xyzxyz
4
abba
8
rprarlap
10
khyyhhyhky

output
2
-1
0
3
2
 */