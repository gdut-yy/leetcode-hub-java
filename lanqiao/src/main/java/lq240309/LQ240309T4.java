package lq240309;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LQ240309T4 {
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
        long ans = 0;
        for (int k = 0; k < 31; k++) {
            int target = 1 << k;
            Map<Integer, Integer> mp = new HashMap<>();
            for (int i = 0; i < n; i++) {
                if (mp.containsKey(target - a[i])) {
                    ans += mp.get(target - a[i]);
                }
                mp.put(a[i], mp.getOrDefault(a[i], 0) + 1);
            }
        }
        return String.valueOf(ans);
    }
}
/*
可结合的元素对【算法赛】

哈希表。两数之和。
 */