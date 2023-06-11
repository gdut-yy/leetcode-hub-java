package c303;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class Abc303_d {
    private static int x, y, z;
    private static String s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        x = scanner.nextInt();
        y = scanner.nextInt();
        z = scanner.nextInt();
        s = scanner.next();
        System.out.println(solve());
    }

    private static int n;
    private static char[] cs;
    private static long[][] memo;

    private static String solve() {
        n = s.length();
        cs = s.toCharArray();

        memo = new long[2][n];
        for (int i = 0; i < 2; i++) {
            Arrays.fill(memo[i], -1);
        }
        return String.valueOf(dfs(0, 0));
    }

    // capsLock = 0 熄灭，= 1 打开
    private static long dfs(int capsLock, int i) {
        if (i == n) {
            return 0;
        }
        if (memo[capsLock][i] != -1) {
            return memo[capsLock][i];
        }

        long res = 0;
        if (cs[i] == 'a' && capsLock == 1 || cs[i] == 'A' && capsLock == 0) {
            // min(x+z, y)
            res = Math.min(x + z + dfs(capsLock ^ 1, i + 1), y + dfs(capsLock, i + 1));
        } else {
            // min(x, z+y)
            res = Math.min(x + dfs(capsLock, i + 1), z + y + dfs(capsLock ^ 1, i + 1));
        }
        return memo[capsLock][i] = res;
    }
}
/*
D - Shift vs. CapsLock
https://atcoder.jp/contests/abc303/tasks/abc303_d

题目大意：
你的电脑键盘上有三个键:“a”键、“Shift”键和“Caps Lock”键。Caps Lock 键上有一盏灯。最初，Caps Lock 键上的灯是熄灭的，屏幕显示一个空字符串。
你可以按任意顺序任意次数地做以下三个动作:
- 花 X 毫秒只按“a”键。如果 Caps Lock 键上的灯熄灭，则在屏幕上的字符串后面添加 a;如果打开，则 A 打开。
- 花 Y 毫秒同时按下“a”键和 Shift 键。如果 Caps Lock 键上的灯熄灭，则 A 被附加到屏幕上的字符串上;如果打开，则为 a。
- 花 Z 毫秒按下 Caps Lock 键。如果 Caps Lock 键上的灯不亮，则打开;如果它是打开的，它就会关闭。
给定由 a 和 a 组成的字符串 S，确定至少需要花费多少毫秒才能使屏幕上显示的字符串等于 S。

记忆化搜索。
======

Input 1
1 3 3
AAaA
Output 1
9

Input 2
1 1 100
aAaAaA
Output 2
6

Input 3
1 2 4
aaAaAaaAAAAaAaaAaAAaaaAAAAA
Output 3
40
 */