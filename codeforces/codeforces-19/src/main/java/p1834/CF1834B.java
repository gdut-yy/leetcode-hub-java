package p1834;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1834B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            String l = scanner.next();
            String r = scanner.next();
            System.out.println(solve(l, r));
        }
    }

    private static String solve(String l, String r) {
        if (l.length() > r.length()) {
            String tmp = l;
            l = r;
            r = tmp;
        }
        // 补全前置 0
        l = "0".repeat(r.length() - l.length()) + l;

        char[] ls = l.toCharArray();
        char[] rs = r.toCharArray();

        int ans = 0;
        boolean flag = false;
        for (int i = 0; i < l.length(); i++) {
            if (l.charAt(i) != r.charAt(i) && !flag) {
                ans += Math.abs(ls[i] - rs[i]);
                flag = true;
            } else if (flag) {
                ans += 9;
            }
        }
        return String.valueOf(ans);
    }
}
/*
B. Maximum Strength
https://codeforces.com/contest/1834/problem/B

题目大意：
Fedya 正在玩一款名为“The Legend of Link”的新游戏，其中角色的一项能力是将两种材料组合成一种武器。每种材料都有自己的强度，可以用正整数 x 表示。所产生的武器的强度由每个位置的整数十进制表示中数字的绝对差的总和决定。
形式上，设第一种材料的强度 X=x1x2...xn，第二种材料的强度 Y=y1y2...yn。然后计算出武器的强度为|x1−y1|+|x2−y2|+...+|xn−yn|。如果整数长度不同，则较短的整数用前导零填充。
Fedya 有无限的材料供应，从 L 到 R，包括所有可能的强度。帮助他找到他所能获得的武器的最大强度。
整数 C=c1c2...ck 定义为将数字 c1,c2,...,ck 从左到右依次写得到的整数，即 10^k−1·c1 + 10^k−2·c2 + ... + ck。
---
在第一个测试案例中，由强度为 53 和 57 的材料制成的武器将具有最大可能的强度:|5−5|+|3−7|=4。
在第二个测试用例中，强度为 190 和 209 的材料达到最大强度:|1−2|+|9−0|+|0−9|=19。
在第四个测试用例中，只有一个有效强度，因此答案是 0。
在第六个测试用例中，强度为 1909 和 90 的材料达到最大强度:|1−0|+|9−0|+|0−9|+|9−0|=28。注意，较短的整数用前导零填充。

观察规律，贪心。
179 239 -> 199 200
13 37 -> 19 30
---
54943329752812629795 55157581939688863366 163 = 9*18+1
54999999999999999999 55000000000000000000
---
88 1914 -> 0099 1900
-> 999 1000
---
9 101 -> 99 100
======

input
6
53 57
179 239
13 37
132228 132228
54943329752812629795 55157581939688863366
88 1914
output
4
19
11
0
163
28
 */
