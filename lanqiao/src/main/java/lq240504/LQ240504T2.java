package lq240504;

import java.util.Scanner;

public class LQ240504T2 {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        int ans = 0;
        for (int v : a) {
            ans += Math.max(0, v / 3 - 1);
        }
        return String.valueOf(ans);
    }
}
/*
合成贤者之石【算法赛】

由于要求红水晶数量 < 蓝水晶数量 < 黄水晶数量， 因此假如我们向某个锅里放了 x 颗红水晶，
那么至少已经放了（x+1）颗蓝水晶和（x+2）颗黄水晶，也就是至少总共放了（3x+3）颗水晶。
那么可以看出，在一般情况下，假如某个坩锅的容量是 K，那么我们最多可以放入（K/3-1）个红水晶。
由于每一个坩锅是独立的，因此我们只需要把所有坩锅的红水晶数量加起来即可。注意特判一下容量很少的情况。
 */