package c303;

import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Abc303_c {
    static int n, m, h, k;
    static String s;
    static int[][] xy;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        m = scanner.nextInt();
        h = scanner.nextInt();
        k = scanner.nextInt();
        s = scanner.next();
        xy = new int[m][2];
        for (int i = 0; i < m; i++) {
            xy[i][0] = scanner.nextInt();
            xy[i][1] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        Set<String> set = new HashSet<>();
        for (int[] p : xy) {
            set.add(p[0] + ":" + p[1]);
        }

        // x,y,idx,health,items
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0, 0, h});
        while (!queue.isEmpty()) {
            int[] tuple = queue.remove();
            int cx = tuple[0], cy = tuple[1], idx = tuple[2], health = tuple[3];
            if (idx == n) {
                return "Yes";
            }

            char ch = s.charAt(idx);
            if (ch == 'R') cx++;
            else if (ch == 'L') cx--;
            else if (ch == 'U') cy++;
            else if (ch == 'D') cy--;

            health--;
            if (health < 0) {
                return "No";
            }

            String key = cx + ":" + cy;
            if (set.contains(key)) {
                if (health < k) {
                    health = k;
                    set.remove(key);
                }
            }
            queue.add(new int[]{cx, cy, idx + 1, health});
        }
        return "Yes";
    }
}
/*
C - Dash
https://atcoder.jp/contests/abc303/tasks/abc303_c

题目大意：
在二维平面上，Takahashi 最初位于点(0,0)，初始生命值为 h，平面上放置 M 个恢复生命值的物品;第 I 个在(xi, yi)处。
高桥将走 N 步。第 i 步如下。
- 设(x,y)为它的当前坐标。他消耗 1 点生命值移动到以下点，这取决于 S 的第 i 个字符:
  - (x+1,y) 如果 Si = R;
  - (x−1,y) 如果 Si = L;
  - (x,y+1) 如果 Si = U;
  - (x,y-1) 如果 Si = D。
如果高桥的健康值变为负值，他就会倒下并停止移动。否则，如果道具被放置在玩家所移动的地点，并且玩家的生命值严格小于 K，那么他便会消耗道具以使自己的生命值变为 K。
确定 Takahashi 是否可以在不被击晕的情况下完成 N 步。
---
最初，高桥的生命值是 3。我们在下面描述这些动作。
第 1 步: Si 是 R，所以他移动到(1,0)点。他的生命值降为 2。尽管道具被放置在(1,0)点，但他不会消费它，因为他的生命值不低于 K=1。
第 2 步: Si 是 U，所以他移动到(1,1)点。他的生命值降为 1。
第 3 步: Si 是 D，所以他移动到(1,0)点。他的生命值降为 0。道具被放置在点(1,0)，而玩家的生命值小于 K=1，所以他将消耗道具使自己的生命值变为 1。
第 4 步: Si 是 L，所以他移动到点(0,0)。他的生命值降为 0。
因此，他可以在不崩溃的情况下走 4 步，所以应该打印 Yes。请注意，运行状况可能达到 0。
---
最初，高桥的生命值是 1。我们在下面描述这些动作。
第 1 步: Si 是 L，所以他移动到(-1,0)点。他的生命值降为 0。
第 2 步: Si 是 D，所以他移动到点(-1,-1)。他的生命值降为 -1。现在他的生命值是 -1，他倒下并停止移动。
因此，他将被击晕，所以应该打印 No。
注意，尽管在初始点(0,0)有一个道具，但他在第 1 步之前并没有消耗它，因为道具在第一步之后已经被消耗了。

模拟。读题题。理解了好久。恶心。。
======

Input 1
4 2 3 1
RUDL
-1 -1
1 0
Output 1
Yes

Input 2
5 2 1 5
LDRLD
0 0
-1 -1
Output 2
No
 */