package lq231111;

import java.util.Scanner;

public class LQ231111T3 {
    static String s1, s2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            s1 = scanner.next();
            s2 = scanner.next();
            System.out.println(solve());
        }
    }

    static final String[] PAIRS = {"MF", "FM", "33", "44", "55", "66", "77", "88", "99", "XX", "JJ", "QQ", "KK", "AA", "22", "MM", "FF"};
    static final String SORT = "3456789XJQKA2MF";

    private static String solve() {
        // 浅梦先手
        // 对子
        for (String pair : PAIRS) {
            if (s1.equals(pair)) {
                return "ShallowDream";
            }
        }
        // 单张
        if (s2.equals("MF") || s2.equals("FM")) {
            return "Joker";
        }
        int p1 = SORT.indexOf(s1.charAt(0));
        int p2 = SORT.indexOf(s1.charAt(1));
        int q1 = SORT.indexOf(s2.charAt(0));
        int q2 = SORT.indexOf(s2.charAt(1));
        // 出的牌必须比对手出的牌要大
        if (Math.max(p1, p2) >= Math.max(q1, q2)) {
            return "ShallowDream";
        }
        return "Joker";
    }
}
/*
被替换的身份证【算法赛】

分类讨论。
 */