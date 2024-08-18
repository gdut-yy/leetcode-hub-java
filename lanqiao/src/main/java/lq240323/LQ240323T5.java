package lq240323;

import java.util.Arrays;
import java.util.Scanner;

public class LQ240323T5 {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        // 特判
        if (n == 2) return a[0] == a[1] ? "0" : "1";

        Arrays.sort(a);
        int res = 2;
        if (a[0] == a[1]) {
            if (a[n - 1] == a[n - 2]) res = 0;
            else res = 1;
        } else {
            if (a[n - 1] == a[n - 2] || a[n - 2] == a[n - 3] || a[1] == a[2]) res = 1;
        }
        return String.valueOf(res);
    }
}
/*
美丽圆环【算法赛】

本题可以直接分类讨论，首先直接将序列排序，排序后一共有以下情况的序列
如果首两个数字相同，那就无需考虑尾，尾两个数字相同，也无需考虑首。
注意还有一种可以直接让首=尾的情况

1
2
2 1

1
 */