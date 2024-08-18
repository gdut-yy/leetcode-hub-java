package lq240531;

import java.util.Arrays;
import java.util.Scanner;

public class LQ240531T7 {
    static int n, m;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        long counted = Arrays.stream(a).distinct().count();
        return counted + " " + ((counted == 1 && n == m) ? 1 : 0);
    }
}
/*
猜测数字【算法赛】

总共猜了 k 个不同的数字：肯定猜的这 k 个是对的，其余的可以任意组合
@小羊肖恩Yawn_Sean
 */