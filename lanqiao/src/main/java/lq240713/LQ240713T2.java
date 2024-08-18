package lq240713;

import java.util.Scanner;

public class LQ240713T2 {
    static int n;
    static int[][] pt;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        pt = new int[n][2];
        for (int i = 0; i < n; i++) {
            pt[i][0] = scanner.nextInt();
            pt[i][1] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        double min_rate = 1.0;
        int min_id = 1;
        for (int i = 0; i < n; i++) {
            double rate = (double) pt[i][1] / pt[i][0];
            if (min_rate > rate) {
                min_rate = rate;
                min_id = i + 1;
            }
        }
        return String.valueOf(min_id);
    }
}
/*
书籍标签【算法赛】
 */