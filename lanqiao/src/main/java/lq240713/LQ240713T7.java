package lq240713;

import java.util.Scanner;

public class LQ240713T7 {
    static int n, m;
    static String s1, s2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            s1 = scanner.next();
            s2 = scanner.next();
            System.out.println(solve());
        }
    }

    private static String solve() {
        if (s1.equals(s2)) return "red";

        if (s1.substring(0, n - 1).equals(s2)) return "red";

        String tmp = new StringBuilder(s1).reverse().toString();
        if (tmp.equals(s2)) return "red";

        if (!s1.isEmpty() && count(s1, s1.charAt(0)) == n
                && count(s2, s1.charAt(0)) == m && n >= m) return "red";

        tmp = s1.substring(0, n - 1);
        String tmp2 = new StringBuilder(tmp).reverse().toString();
        if (tmp2.equals(tmp) && !tmp.isEmpty()) {
            String tmp3 = tmp.substring(0, tmp.length() - 1);
            if (tmp3.equals(s2)) return "red";

            if (!tmp3.isEmpty() && count(tmp3, tmp3.charAt(0)) == tmp3.length()
                    && count(s2, tmp3.charAt(0)) == m && tmp3.length() >= m) return "red";
        }

        return "blue";
    }

    static int count(String str, char ch) {
        int res = 0;
        for (char c : str.toCharArray()) {
            if (c == ch) res++;
        }
        return res;
    }
}
/*
字符串博弈游戏【算法赛】

在游戏中，蓝方可以通过迅速获得主动权来控制最终形成的字符串形状和内容。否则，蓝方可以选择不配合。因此，我们需要在拥有主动权的时候计算出可以组成的方案。
具体有以下五种情况：
- 原串和新串相同，无需任何操作。
- 从原串中删除最后一个字符，剩余部分与新串相同。
- 翻转原串，使其与新串相同，
- 原串和新串由相同的字符组成，且原串长度大于或等于新串长度。
- 从原串中删除一个字符后形成一个回文串，再从回文串中删除一个字符，使其与新串相同。
综上所述可以发现，真正能完全获得主动权的情况只有在原串是完全回文串的情况下也就是原串由同一个字符组成。则蓝方将快速失去主动权，进而被蓝方控制删除放下，最终获得不同的子串。
 */