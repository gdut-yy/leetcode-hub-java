package lq231209;

import java.util.Scanner;

public class LQ231209T1 {
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
        for (int i = 1; i + 1 < n; i++) {
            if (a[i] >= a[i - 1] + a[i + 1]) {
                ans++;
            }
        }
        return String.valueOf(ans);
    }
}
/*
蘑菇炸弹【算法赛】

枚举。
 */