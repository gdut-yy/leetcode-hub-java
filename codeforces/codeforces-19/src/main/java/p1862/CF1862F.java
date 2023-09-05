package p1862;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1862F {
    static int w, f;
    static int n;
    static int[] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            w = scanner.nextInt();
            f = scanner.nextInt();
            n = scanner.nextInt();
            s = new int[n];
            for (int i = 0; i < n; i++) {
                s[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    static int sum;

    private static String solve() {
        sum = 0;
        for (int v : s) {
            sum += v;
        }

        int left = 0;
        int right = (int) (1e6 + 5);
        while (left < right) {
            int mid = left + (right - left) / 2;
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

    private static boolean checkMid(long t) {
        long wt = w * t;
        long ft = f * t;
        if (wt + ft < sum) return false;

        int M = (int) Math.min(wt, sum);
        int[] f = new int[M + 1];
        for (int i = 0; i < n; i++) {
            int wi = s[i];
            int vi = s[i];
            for (int j = M; j >= wi; j--) {
                f[j] = Math.max(f[j], f[j - wi] + vi);
            }
        }
        return sum - f[M] <= ft;
    }
}
/*
F. Magic Will Save the World
https://codeforces.com/contest/1862/problem/F

题目大意：
黑暗势力的入口在世界的边界打开了，现在整个世界都处于可怕的威胁之下。为了关闭传送门并拯救世界，你需要打败从传送门中一个接一个出现的怪物。
只有女巫维卡才能处理这事。她拥有两种魔法——水魔法和火魔法。在一秒钟内，Vika 可以产生 w 单位的水魔法和 f 单位的火魔法。她需要法力才能施法。最初 Vika 有 0 单位的水魔法和 0 单位的火魔法。
从传送门中出现的 n 个怪物中的每一个都有自己的力量，用正整数表示。为了打败强度为 si 的怪物 i, Vika 需要施放一个至少相同强度的水法术或火法术。换句话说，Vika 可以在一个水法术上花费至少 si 个单位的水魔法，或者在一个火法术上花费至少 si 个单位的火魔法。
维卡可以立即创造和施放法术。只要维卡有足够的法力，她每秒钟可以施放无限数量的法术。
女巫想尽快拯救世界，所以告诉她她需要多少时间。
---
在第一个样本中，在第一秒之后，Vika 可以花费 2 个单位的火焰法力去杀死第一个怪物。然后她有 2 单位的水魔法和 1 单位的火魔法。在第三秒之后，她将有 6 个单位的水魔法和 7 个单位的火魔法可供她使用。这将足以立即杀死第二个和第三个怪物。

二分答案 + 0-1背包
======

input
4
2 3
3
2 6 7
37 58
1
93
190 90
2
23 97
13 4
4
10 10 2 45
output
3
2
1
5
 */
