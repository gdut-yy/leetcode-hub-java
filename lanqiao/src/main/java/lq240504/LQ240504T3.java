package lq240504;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LQ240504T3 {
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
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int v : a) {
            cntMap.merge(v, 1, Integer::sum);
        }

        int ans = 0;
        for (int x : a) {
            for (int y = x - 45; y <= x; y++) {
                int need = y == x ? 2 : 1;
                if (cntMap.getOrDefault(y, 0) >= need) {
                    ans = Math.max(ans, getAns(x, y));
                }
            }
        }
        return String.valueOf(ans);
    }

    static int getAns(int x, int y) {
        int res = x + y;
        while (x > 0 && y > 0) {
            if (x % 10 == y % 10) {
                res -= x % 10;
            }
            x /= 10;
            y /= 10;
        }
        return res;
    }
}
/*
咒语融合【算法赛】

由于数值的最大值小于等于 10^5，我们可以把数值当做切入点。假设最大值是 v，我们可以发现，假如选择的第一个数是 x，
那么这种选法的权值至少是（x+v-45），因为我们选择 v 作为第二个数的话，即使二者每一位都相同，权值也可以达到（x+v-45）。
正是如此，我们在枚举第个数 ai 之后，只需要在（v-45）到 v 的范围内枚举第二个数，暴力计算权值即可。
 */