package c292;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Abc292_b {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        int[][] events = new int[q][2];
        for (int i = 0; i < q; i++) {
            events[i][0] = scanner.nextInt();
            events[i][1] = scanner.nextInt();
        }
        System.out.println(solve(n, q, events));
    }

    private static String solve(int n, int q, int[][] events) {
        List<String> resList = new ArrayList<>();
        boolean[][] peoples = new boolean[n][3];
        for (int[] event : events) {
            int c = event[0];
            int x = event[1] - 1;
            if (c == 1) {
                if (!peoples[x][0]) {
                    peoples[x][0] = true;
                } else {
                    peoples[x][1] = true;
                }
            } else if (c == 2) {
                peoples[x][1] = true;
            } else if (c == 3) {
                resList.add(peoples[x][1] ? "Yes" : "No");
            }
        }
        return String.join(System.lineSeparator(), resList);
    }
}
/*
B - Yellow and Red Card
https://atcoder.jp/contests/abc292/tasks/abc292_b

N 个从 1 到 N 的球员将进行一场足球比赛。
当一个球员犯规时，他将得到一张黄牌或一张红牌。
满足下列条件之一的选手将被取消比赛资格。
- 累积两张黄牌。
- 收到红牌。
一旦玩家被移除，该玩家将不再收到任何卡牌。
你要看这场比赛。最初，玩家没有收到任何卡片。
将会有 Q 个事件。正确回答活动中提出的问题。
有三种类型的事件，它们以输入的格式 c x 给出，其中 c 为 1、2 或 3。事件如下。
- 1 x: 球员 x 吃到黄牌。
- 2 x: 玩家 x 得到红牌。
- 3 x: 询问玩家 x 是否已被移出游戏。回答“是”或“否”。

模拟。
======

Input 1
3 9
3 1
3 2
1 2
2 1
3 1
3 2
1 2
3 2
3 3
Output 1
No
No
Yes
No
Yes
No
 */