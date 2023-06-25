package p1834;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1834C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int n = scanner.nextInt();
            String s = scanner.next();
            String t = scanner.next();
            System.out.println(solve(n, s, t));
        }
    }

    // https://codeforces.com/contest/1834/submission/210223495
    private static String solve(int n, String s, String t) {
        // 不翻转
        int cnt1 = 0, cnt2 = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != t.charAt(i)) cnt1++;
        }
        // 翻转
        t = new StringBuilder(t).reverse().toString();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != t.charAt(i)) cnt2++;
        }

        // 特判
        int ans1 = 2 * cnt1 - cnt1 % 2;
        int ans2 = cnt2 == 0 ? 2 : 2 * cnt2 - (cnt2 + 1) % 2;
        return String.valueOf(Math.min(ans1, ans2));
    }
}
/*
C. Game with Reversing
https://codeforces.com/contest/1834/problem/C

题目大意：
爱丽丝和鲍勃在玩游戏。它们有两个相同长度 n 的字符串 S 和 T，由小写拉丁字母组成。玩家轮流上场，爱丽丝先上场。
轮到爱丽丝从 1 到 n 中选择一个整数 i，字符串 S 或 T 中的一个，以及任何小写拉丁字母 c，并用字符 c 替换所选字符串中的第 i 个符号。
轮到鲍勃时，他从 S 或 T 中选择一个，然后把它倒过来。更正式地说，Bob 进行替换 S:=rev(S)或 T:=rev(T)，其中 rev(P)=PnPn−1...P1。
游戏一直持续到字符串 S 和 T 相等。一旦琴弦相等，游戏立即结束。
将游戏持续时间定义为两个玩家在游戏中所走的总步数。例如，如果 Alice 总共走了 2 步，Bob 走了 1 步，那么这个游戏的持续时间是 3。
Alice 的目标是最小化游戏的持续时间，Bob 的目标是最大化游戏的持续时间。
如果两个玩家都玩得最优，那么游戏的持续时间是多少?可以证明，游戏将在有限的回合数中结束。
---
在第一个测试案例中，爱丽丝可以将字符串 S 中的第三个符号替换为 x。之后，两个字符串将等于“abxde”，游戏将在一次移动后结束。由于 Alice 的目标是在尽可能少的移动中完成游戏，这一移动将是她最优的第一步，最终答案将是 1。
在第二个测试用例中，轮到爱丽丝用 h 替换字符串 T 的第五个符号。移动之后，S=“hello”，T=“olleh”。然后轮到鲍勃了。轮到他时，他必须反转其中一根弦。如果 Bob 选择了字符串 S，那么在他的回合之后，两个字符串将等于“olleh”，如果他选择了字符串 T，那么在他的回合之后，两个字符串将等于“hello”。因此，在呈现 Alice 的第一步后，游戏将以 2 步结束。可以证明，没有任何策略可以让 Alice 在少于 2 步的情况下完成游戏，并且双方都是最优的。最后的答案是 2。
在第三个测试用例中，在她的第一次移动中，Alice 可以用 c 替换字符串 S 的第二个符号。在这一次移动之后，S=“ac”，T=“cd”。然后轮到鲍勃了。如果 Bob 将字符串 S 倒过来，那么在轮到他之后 S= "ca"， T= "cd"。那么很容易看出，在这种情况下，Alice 可以在第三步时完成游戏，通过将字符串 T 的第二个符号替换为 a，之后两个字符串将等于“ca”。如果 Bob 将字符串 T 反转，那么在他之后 S= "ac"， T= "dc"。在这种情况下，Alice 也可以在第三步时完成游戏，通过将字符串 S 的第一个符号替换为 d，之后两个字符串将等于“dc”。因此，无论鲍勃如何移动，爱丽丝都可以在 3 步内完成游戏。可以证明，游戏不能在少于 3 步的情况下结束，并且双方都处于最佳状态。
在第五个测试用例中，字符串 S 和 T 相等，因此游戏将在 0 步时结束而不开始。

考虑对称性？
======

input
7
5
abcde
abxde
5
hello
olleo
2
ab
cd
7
aaaaaaa
abbbbba
1
q
q
6
yoyoyo
oyoyoy
8
abcdefgh
hguedfbh
output
1
2
3
9
0
2
6
 */
