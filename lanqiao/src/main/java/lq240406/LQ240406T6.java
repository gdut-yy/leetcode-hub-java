package lq240406;

import java.util.Scanner;

public class LQ240406T6 {
    static long n, m;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextLong();
            m = scanner.nextInt();
            System.out.println(solve());
        }
    }

    private static String solve() {
        long digit_cnt = 1;
        long cur_num = m - 1;

        long start = 1;
        while (n >= digit_cnt * cur_num) {
//        while (n / digit_cnt >= cur_num) {
            n -= digit_cnt * cur_num;
            digit_cnt++;
            cur_num *= m;
            start *= m;
        }

        // python: v = (n - 1) // digit_cnt
        long v = Math.floorDiv((n - 1), digit_cnt);
        start += v;
        n -= v * digit_cnt;

        for (int i = 0; i < digit_cnt - n; i++) {
            start /= m;
        }
        return String.valueOf(start % m);
    }
}
/*
无理数位数查询【算法赛】

解法 1
考虑某一 m 进制的情况，设 g（x）为 1~x 的数位个数和，显然 g(x) 单调递增。
故我们可以二分 x 来找到当前位置属于哪个数的数位。
然后在这个数找到所需数位即可。
解法 2
不难发现，R 进制中长度为 t 的所有数的长度和为 (R-1)R^(t-1)（第一个数字必须非负，后面任意填写）。
于是我们就可以预处理出，长度为 1~t 的 R 进制的长度之和 leng[R][t]
我们二分找到第一个大于等于 n 的 leng[R][t]，于是 t 也就是那个数字所对应的 R 进制数的长度。
因为当前位置，跟最后一个长度为 t-1 的数的位置都知道。于是我们可以知道这是第 num = (n-leng[R][t-1]-1) / t 个长度为 t 的 R 进制数（从 0 开始计数）。
不难发现只要在 num 的从低到高的第 t 位加一，即是这个数的大小 res。容易得到前面长度的总和为 tot = num*t+leng[R][t-1]。故 res 的第 n-tot 个数字就是我们要求求解的答案。
@小羊肖恩Yawn_Sean

1
1 2
 */