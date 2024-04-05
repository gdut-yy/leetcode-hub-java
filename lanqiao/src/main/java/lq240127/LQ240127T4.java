package lq240127;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LQ240127T4 {
    static int n, q;
    static int[] a;
    static int[][] lr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        q = scanner.nextInt();
        a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
        }
        lr = new int[q][2];
        for (int i = 0; i < q; i++) {
            lr[i][0] = scanner.nextInt();
            lr[i][1] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        String[] ans = new String[q];
        for (int i = 0; i < q; i++) {
            int l = lr[i][0], r = lr[i][1];
            if (r - l + 1 > 100) {
                ans[i] = "YES";
            } else {
                List<Integer> b = new ArrayList<>();
                for (int j = l; j <= r; j++) {
                    b.add(a[j]);
                }
                b.sort(null);
                boolean isValid = false;
                for (int j = 1; j < b.size(); j++) {
                    if (b.get(j) - b.get(j - 1) <= 365) {
                        ans[i] = "YES";
                        isValid = true;
                        break;
                    }
                }
                if (!isValid) {
                    ans[i] = "NO";
                }
            }
        }
        return String.join(System.lineSeparator(), ans);
    }
}
/*
乘飞机【算法赛】

暴力，抽屉原理。。
 */