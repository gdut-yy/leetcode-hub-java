package lq240727;

import java.util.Scanner;

public class LQ240727T2 {
    static int n;
    static String s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        s = scanner.next();
        System.out.println(solve());
    }

    private static String solve() {
        int index = s.indexOf("L");
        s = s.substring(index) + s.substring(0, index);

        int i = 0;
        long ans = 0;
        while (i < n) {
            // 分组循环
            int st = i;
            for (i++; i < n && s.charAt(i) == s.charAt(st); i++) {
            }
            if (s.charAt(st) == 'Q') {
                long len = i - st;
                ans += len * (len + 1) / 2;
            }
        }
        return String.valueOf(ans);
    }
}
/*
大闹蟠桃园【算法赛】

设连续 Q 的长度为 len，对答案的贡献为 len*(len+1)/2
 */