package lq240629;

import java.util.Arrays;
import java.util.Scanner;

public class LQ240629T3 {
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
        int[] cnt = new int[1005];
        for (int v : a) {
            cnt[v]++;
        }
        int ans = n - Arrays.stream(cnt).max().orElseThrow();
        return String.valueOf(ans);
    }
}
/*
能量圆盘【算法赛】
 */