package lq240210;

import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

public class LQ240210T2 {
    static int n;
    static int[][] ab;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        ab = new int[n][2];
        for (int i = 0; i < n; i++) {
            ab[i][0] = scanner.nextInt();
            ab[i][1] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        Set<Long> set = new HashSet<>();
        for (int[] p : ab) {
            long key = (long) p[0] << 32 | p[1];
            set.add(key);
        }
        return String.valueOf(set.size());
    }
}
/*
欢迎参加福建省大学生程序设计竞赛【算法赛】

哈希表统计。答案为集合大小。
 */