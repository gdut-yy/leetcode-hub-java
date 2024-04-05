package lq240210;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LQ240210T3 {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        long ans = 0;
        Map<Long, Integer> mp = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            long key = (long) a[i] * i;
            ans += mp.getOrDefault(key, 0);
            mp.put(key, mp.getOrDefault(key, 0) + 1);
        }
        return String.valueOf(ans);
    }
}
/*
匹配二元组的数量【算法赛】

哈希表统计。累加。
 */