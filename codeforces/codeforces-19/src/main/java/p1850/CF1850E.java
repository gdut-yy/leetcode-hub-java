package p1850;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1850E {
    static int n;
    static long c;
    static int[] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            c = scanner.nextLong();
            s = new int[n];
            for (int i = 0; i < n; i++) {
                s[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        long left = 0;
        long right = (long) (1e9 + 5);
//        long right = Integer.MAX_VALUE / 10;
        while (left < right) {
            long mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (checkMid(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return String.valueOf(left);
    }

    private static boolean checkMid(long mid) {
        long tot = 0;
        for (int x : s) {
            long side = x + mid + mid;
            tot += side * side;
            if (tot > c) return true;
        }
        return tot >= c;
    }
}
/*
E. Cardboard for Pictures
https://codeforces.com/contest/1850/problem/E

题目大意：
Mircea 有 n 张照片。第 i 张照片是一个边长为 si 厘米的正方形。
他把每幅画都装在一张正方形的硬纸板上，这样每幅画的四周都有一个宽 w 厘米的硬纸板边框。他总共用了 c 平方厘米的纸板。给定图片大小和值 c，你能找到 w 的值吗?
请注意，这张硬纸板在每张图片的后面，而不仅仅是边框。

二分答案
======

input
10
3 50
3 2 1
1 100
6
5 500
2 2 2 2 2
2 365
3 4
2 469077255466389
10000 2023
10 635472106413848880
9181 4243 7777 1859 2017 4397 14 9390 2245 7225
7 176345687772781240
9202 9407 9229 6257 7743 5738 7966
14 865563946464579627
3654 5483 1657 7571 1639 9815 122 9468 3079 2666 5498 4540 7861 5384
19 977162053008871403
9169 9520 9209 9013 9300 9843 9933 9454 9960 9167 9964 9701 9251 9404 9462 9277 9661 9164 9161
18 886531871815571953
2609 10 5098 9591 949 8485 6385 4586 1064 5412 6564 8460 2245 6552 5089 8353 3803 3764
output
1
2
4
5
7654321
126040443
79356352
124321725
113385729
110961227
 */
