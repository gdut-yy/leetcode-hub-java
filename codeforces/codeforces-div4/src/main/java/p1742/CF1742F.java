package p1742;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CF1742F {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int q = scanner.nextInt();
            int[] d = new int[q];
            int[] k = new int[q];
            String[] x = new String[q];
            for (int j = 0; j < q; j++) {
                d[j] = scanner.nextInt();
                k[j] = scanner.nextInt();
                x[j] = scanner.next();
            }

            List<String> res = solve(q, d, k, x);
            for (String re : res) {
                System.out.println(re);
            }
        }
    }

    private static List<String> solve(int q, int[] d, int[] k, String[] x) {
        long cntA1 = 1;
        long cntA2 = 1;
        long cntOthers1 = 0;
        long cntOthers2 = 0;

        List<String> resList = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            for (char ch : x[i].toCharArray()) {
                if (d[i] == 1) {
                    if (ch == 'a') {
                        cntA1 += k[i];
                    } else {
                        cntOthers1 += k[i];
                    }
                } else {
                    if (ch == 'a') {
                        cntA2 += k[i];
                    } else {
                        cntOthers2 += k[i];
                    }
                }
            }

            if (cntOthers2 > 0) {
                resList.add("YES");
            } else {
                if (cntOthers1 == 0 && cntA1 < cntA2) {
                    resList.add("YES");
                } else {
                    resList.add("NO");
                }
            }
        }
        return resList;
    }
}
/*
F. Smaller
https://codeforces.com/contest/1742/problem/F

题目大意：
给定整数 q 和 q 个询问。Alperen有两个字符串，s 和 t 它们最初都等于 a。
1 k x 在字符串 s 的末尾添加字符串 x k 次。
2 k x 在字符串 t 的末尾添加字符串 x k 次。
在每次操作之后，判断是否可以重新排列 s 和 t 的字符，使 s 在字典序上小于 t。

贪心。只需统计两个字符串 'a' 字符的数量和非 'a' 字符的数量即可。
当 t 含有非 'a' 字符时，恒成立。
否则当 s 只含 'a' 字符且 'a' 字符数量比 t 'a' 字符数量少时，成立。
======

input
3
5
2 1 aa
1 2 a
2 3 a
1 2 b
2 3 abca
2
1 5 mihai
2 2 buiucani
3
1 5 b
2 3 a
2 4 paiu

output
YES
NO
YES
NO
YES
NO
YES
NO
NO
YES
 */