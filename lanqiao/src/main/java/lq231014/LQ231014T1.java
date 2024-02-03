package lq231014;

import java.util.Arrays;
import java.util.Scanner;

public class LQ231014T1 {
    static char[] cs;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            cs = scanner.next().toCharArray();
            System.out.println(solve());
        }
    }

    private static String solve() {
        Arrays.sort(cs);
        boolean ans1 = cs[0] == cs[1] && cs[1] == cs[2] && cs[2] != cs[3];
        boolean ans2 = cs[0] != cs[1] && cs[1] == cs[2] && cs[2] == cs[3];
        return ans1 || ans2 ? "Yes" : "No";
    }
}
/*
三带一【算法赛】

枚举。
 */