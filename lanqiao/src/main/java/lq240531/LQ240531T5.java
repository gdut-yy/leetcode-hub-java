package lq240531;

import java.util.Scanner;

public class LQ240531T5 {
    static int n;
    static String s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        s = scanner.next();
        System.out.println(solve());
    }

    private static String solve() {
        int tot = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') tot++;
        }

        s = s + s;
        int cnt = 0;
        int ans = 0;
        for (char c : s.toCharArray()) {
            cnt = (c == '0' ? cnt + 1 : 0);
            ans = Math.max(ans, cnt);
        }
        return String.valueOf(tot - ans);
    }
}
/*
体育课【算法赛】

最后的情况是剩下一段 0 和一段 1
在这种情况下，某一段的 0 的数量每次最多增加 1
我们可以取最开始最长的一段 0，让其连续的一段逐渐增长
此时答案是 0的总数 - 0的最长段长度
@小羊肖恩Yawn_Sean
 */