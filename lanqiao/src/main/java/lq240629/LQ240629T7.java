package lq240629;

import java.util.Arrays;
import java.util.Scanner;

public class LQ240629T7 {
    static int n, m;
    static String s;
    static int start;
    static String[] a = new String[30], b = new String[30];

    public static void main(String[] args) {
        Arrays.fill(a, "");
        Arrays.fill(b, "");

        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            s = scanner.next();
            a[s.charAt(0) - 'a' + 1] = s;
            if (i == 0) start = s.charAt(0) - 'a' + 1;
        }
        for (int i = 0; i < m; i++) {
            s = scanner.next();
            b[s.charAt(0) - 'a' + 1] = s;
        }
        System.out.println(solve());
    }

    private static String solve() {
        a[start - 1] = "";
        b[start - 1] = "";
        for (int i = start; i < 30; i++) {
            if ("".equals(a[i]) && b[i - 1].compareTo(a[i - 1]) > 0) return "Q";
            if ("".equals(b[i]) && a[i - 1].compareTo(b[i - 1]) > 0) return "L";
        }
        return "";
    }
}
/*
单词博弈【算法赛】

首先，需要注意的是，如果小蓝和小桥两人对于字母表中的每一个字母，都至少有一个单词以该字母开头，那么胜负就取决于谁拥有字典序最大的单词。
这引导我们思考另一个问题：如果两人都有以前 x 个字母开头的单词，但只有一方有以第 x+1 个字母开头的单词，会怎么样呢？
假设小蓝有一个以第 x+1 个字母开头的单词。那么，如果小蓝拥有所有以前 x 个字母开头的单词中字典序最大的单词，她将获胜
否则，如果小桥拥有前 x 个字母开头的单词中字典序最大的单词，游戏将继续。
由上，可以得出结论：胜负由“某个玩家缺少以某个字母开头的单词，同时另一个玩家在之前的字母中拥有字典序最大的单词”决定。
我们仅需根据结论进行模拟，即可完成解答。
 */