package lq240810;

import java.util.Scanner;

public class LQ240810T2 {
    static int n;
    static char[] s;
    static int[] p;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        s = scanner.next().toCharArray();
        p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = scanner.nextInt() - 1;
        }
        System.out.println(solve());
    }

    private static String solve() {
        StringBuilder ans = new StringBuilder();
        for (int id : p) {
            ans.append(s[id]);
        }
        return ans.toString();
    }
}
/*
牛郎取名【算法赛】
 */