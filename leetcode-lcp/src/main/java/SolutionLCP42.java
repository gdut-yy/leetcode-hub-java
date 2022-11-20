import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SolutionLCP42 {
    private static final long MAX_N = (long) 1e9;

    public int circleGame(int[][] toys, int[][] circles, int r) {
        // pos, ri
        Map<Long, Integer> posRiMap = new HashMap<>();
        for (int[] toy : toys) {
            long pos = toy[0] * MAX_N + toy[1];
            posRiMap.put(pos, toy[2]);
        }

        Set<Long> visited = new HashSet<>();
        int res = 0;
        for (int[] cir : circles) {
            int x = cir[0];
            int y = cir[1];
            for (int i = x - r; i <= x + r; i++) {
                for (int j = y - r; j <= y + r; j++) {
                    long pos = i * MAX_N + j;
                    if (!posRiMap.containsKey(pos)) {
                        continue;
                    }
                    if (posRiMap.get(pos) + Math.sqrt((i - x) * (i - x) + (j - y) * (j - y)) > r) {
                        continue;
                    }
                    if (!visited.contains(pos)) {
                        visited.add(pos);
                        res++;
                    }
                }
            }
        }
        return res;
    }
}
/*
LCP 42. 玩具套圈
https://leetcode.cn/problems/vFjcfV/

LCCUP 力扣杯 2021 秋季编程大赛个人赛 T4。

「力扣挑战赛」场地外，小力组织了一个套玩具的游戏。所有的玩具摆在平地上，toys[i] 以 [xi,yi,ri] 的形式记录了第 i 个玩具的坐标 (xi,yi) 和半径 ri。
小扣试玩了一下，他扔了若干个半径均为 r 的圈，circles[j] 记录了第 j 个圈的坐标 (xj,yj)。套圈的规则如下：
- 若一个玩具被某个圈完整覆盖了（即玩具的任意部分均在圈内或者圈上），则该玩具被套中。
- 若一个玩具被多个圈同时套中，最终仅计算为套中一个玩具
请帮助小扣计算，他成功套中了多少玩具。
注意：
输入数据保证任意两个玩具的圆心不会重合，但玩具之间可能存在重叠。
提示：
1 <= toys.length <= 10^4
0 <= toys[i][0], toys[i][1] <= 10^9
1 <= circles.length <= 10^4
0 <= circles[i][0], circles[i][1] <= 10^9
1 <= toys[i][2], r <= 10
 */