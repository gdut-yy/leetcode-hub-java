package p1296;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CF1296C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            String s = scanner.next();
            System.out.println(solve(n, s));
        }
    }

    private static String solve(int n, String s) {
        Map<String, Integer> sumLastMap = new HashMap<>();
        sumLastMap.put("0:0", 0);

        long cx = 0, cy = 0;
        int ansL = -1, ansR = n;
        for (int i = 1; i <= n; i++) {
            char ch = s.charAt(i - 1);
            if (ch == 'L') cx--;
            else if (ch == 'R') cx++;
            else if (ch == 'U') cy++;
            else if (ch == 'D') cy--;

            // 负数场景不能 x = cx << 32 | cy
            String x = cx + ":" + cy;
            if (sumLastMap.containsKey(x)) {
                int j = sumLastMap.get(x) + 1;
                if (i - j < ansR - ansL) {
                    ansL = j;
                    ansR = i;
                }
            }
            sumLastMap.put(x, i);
        }

        if (ansL == -1) {
            return "-1";
        }
        return ansL + " " + ansR;
    }
}
/*
C. Yet Another Walking Robot
https://codeforces.com/contest/1296/problem/C

灵茶の试炼 2023-04-11
题目大意：
输入 t(≤1e3) 表示 t 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(≤2e5) 和长为 n 的字符串 s，仅包含 LRUD，分别表示左右上下四个方向。
一个机器人初始在 (0,0)，按照 s 移动，每一步移动一个单位长度。
设机器人最终移动到了 (x,y)。
你需要从 s 中删除一段尽量短的非空连续子串，得到 s'，使得机器人从 (0,0) 出发，按照 s' 也能移动到 (x,y)。
输出你删除的这段子串的左右端点（下标从 1 开始）。
如果无法做到，输出 -1。

https://codeforces.com/contest/1296/submission/201606705
提示 1：如果只有左右两个方向，要怎么做？
提示 2：转换成 -1 和 +1，问题变成去掉一个子数组，使得数组的和等于 0。
提示 3：经典前缀和+哈希表的套路。
提示 4：回到原问题，遍历 s，用哈希表记录位置 (x,y) 及此时的下标。
如果 (x,y) 在哈希表中出现过，那么就找到了要删除的左端点。
维护删除长度的最小值。
======

input
4
4
LRUD
4
LURD
5
RRUDU
5
LLDDR
output
1 2
1 4
3 4
-1
 */

