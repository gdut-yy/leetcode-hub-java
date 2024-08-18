package lq240531;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LQ240531T3 {
    static int n;
    static String[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(solve());
    }

    private static String solve() {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                set.add(a[i] + a[j]);
            }
        }
        int ans = set.size();
        return String.valueOf(ans);
    }
}
/*
字符串连接计数【算法赛】

哈希表模拟。
 */