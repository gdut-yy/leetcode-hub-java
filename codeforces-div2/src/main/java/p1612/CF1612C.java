package p1612;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class CF1612C {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8));
        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            String line = reader.readLine();
            writer.write(solution(line).concat(System.lineSeparator()));
        }
        writer.close();
        reader.close();
    }

    private static String solution(String line) {
        String[] lines = line.split(" ");
        long k = Long.parseLong(lines[0]);
        long x = Long.parseLong(lines[1]);
        // 第 1 到第 k 行
        long halfUp = k * (k + 1) / 2;
        long halfDown = k * (k - 1) / 2;
        long all = halfUp + halfDown;
        if (all <= x) {
            return String.valueOf(k * 2 - 1);
        }
        if (x <= halfUp) {
            long left = 1;
            long right = k;
            while (left <= right) {
                long mid = left + (right - left) / 2;
                if (mid * mid + mid >= x * 2 && x * 2 > mid * mid - mid) {
                    return String.valueOf(mid);
                } else if (x * 2 > mid * mid + mid) {
                    left = mid + 1;
                } else if (mid * mid - mid >= x * 2) {
                    right = mid - 1;
                }
            }
        } else {
            x = all - x;
            long left = 1;
            long right = k;
            while (left <= right) {
                long mid = left + (right - left) / 2;
                if (mid * mid + mid > x * 2 && x * 2 >= mid * mid - mid) {
                    return String.valueOf(2 * k - 1 - mid + 1);
                } else if (x * 2 >= mid * mid + mid) {
                    left = mid + 1;
                } else if (mid * mid - mid > x * 2) {
                    right = mid - 1;
                }
            }
        }
        return "-2";
    }
}
/*
C. Chat Ban
https://codeforces.com/contest/1612/problem/C

题目大意：
给出整数 k 和 x，要输出一个 2k-1 的表情，但是系统检测到输入达到 x 个表情就会拦截，问最多能输入多少行

看到一组用例很大，需要二分查找。
======

input
7
4 6
4 7
1 2
3 7
2 5
100 1
1000000000 923456789987654321

output
3
4
1
4
3
1
1608737403
 */
