package nc60245;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NC60245B {
    static int n;
    static int[] a;
    static String s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        s = scanner.next();
        System.out.println(solve());
    }

    private static String solve() {
        Map<Integer, Integer> red = new HashMap<>();
        Map<Integer, Integer> blue = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'R') {
                red.put(a[i], red.getOrDefault(a[i], 0) + 1);
            } else {
                blue.put(a[i], blue.getOrDefault(a[i], 0) + 1);
            }
        }

        long ans = 0;
        for (Map.Entry<Integer, Integer> entry : red.entrySet()) {
            long rcnt = entry.getValue();
            int bcnt = blue.getOrDefault(entry.getKey(), 0);
            ans += rcnt * bcnt;
        }
        return String.valueOf(ans);
    }
}
/*
游游的数组染色
https://ac.nowcoder.com/acm/contest/60245/B

题目描述
游游拿到了一个数组，其中一些数被染成红色，一些数被染成蓝色。
游游想知道，取两个不同颜色的数，且它们的数值相等，有多少种不同的取法？
我们定义，两种取法如果取的某个数在原数组的位置不同，则定义为不同的取法。
输入描述:
第一行输入一个正整数n，代表数组的长度。
第二行输入n 个正整数ai，代表数组中的元素。
第三行输入一个长度为n ，仅包含 'R' 和 'B' 两种字符的字符串，第i 个字符为 'R' 代表数组第i 个元素被染成红色，为 'B' 代表被染成蓝色。
1≤n≤200000
1≤ai≤10^9
输出描述:
输出一个整数，代表取数的方案数量。

乘法原理
======

示例1
输入
5
1 2 1 2 2
BRRBB
输出
3
说明
第一种取法，取第一个数和第三个数，颜色不同且都是1。
第二种取法，取第二个数和第四个数，颜色不同且都是2。
第三种取法，取第二个数和第五个数，颜色不同且都是2。

示例2
输入
3
2 3 3
BBB
输出
0
说明
所有数都是蓝色，显然取不出两个颜色不同的数。
 */