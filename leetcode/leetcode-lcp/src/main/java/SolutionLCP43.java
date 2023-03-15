import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionLCP43 {
    private String[] directions;
    private static final char[] DIR = {'E', 'S', 'W', 'N'};
    private int[][][][] memo;

    public int trafficCommand(String[] directions) {
        this.directions = directions;

        memo = new int[21][21][21][21];
        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 21; j++) {
                for (int k = 0; k < 21; k++) {
                    Arrays.fill(memo[i][j][k], -1);
                }
            }
        }
        return dfs(0, 0, 0, 0);
    }

    private boolean check2(char[] car1, char[] car2) {
        char from1 = car1[0];
        char to1 = car1[1];
        char from2 = car2[0];
        char to2 = car2[1];
        //----目的地相同的情况
        if (to1 == to2) {
            return false;
        }
        //----检验是否有交叉（有重复讨论的情况，重复就重复吧）
        if (from1 == 'N') {
            if (from2 == 'E') {
                if (to1 == 'E' && (to2 == 'W' || to2 == 'S')) return false;
                else return to1 != 'S' || to2 != 'W';
            } else if (from2 == 'S') {
                if (to1 == 'E' && to2 == 'N') return false;
                else return to1 != 'S' || to2 != 'W';
            } else if (from2 == 'W') {
                if (to1 == 'E' && to2 == 'N') return false;
                else return to1 != 'S' || (to2 != 'N' && to2 != 'E');
            }
        } else if (from1 == 'E') {
            if (from2 == 'S') {
                if (to1 == 'W' && to2 == 'N') return false;
                else return to1 != 'S' || (to2 != 'W' && to2 != 'N');
            } else if (from2 == 'W') {
                if (to1 == 'W' && to2 == 'N') return false;
                else return to1 != 'S' || to2 != 'E';
            } else if (from2 == 'N') {
                if (to1 == 'W' && (to2 == 'E' || to2 == 'S')) return false;
                else return to1 != 'S' || to2 != 'E';
            }
        } else if (from1 == 'S') {
            if (from2 == 'W') {
                if (to1 == 'N' && to2 == 'E') return false;
                else return to1 != 'W' || (to2 != 'N' && to2 != 'E');
            } else if (from2 == 'N') {
                if (to1 == 'N' && to2 == 'E') return false;
                else return to1 != 'W' || to2 != 'S';
            } else if (from2 == 'E') {
                if (to1 == 'N' && (to2 == 'W' || to2 == 'S')) return false;
                else return to1 != 'W' || to2 != 'S';
            }
        } else if (from1 == 'W') {
            if (from2 == 'N') {
                if (to1 == 'N' && (to2 == 'S' || to2 == 'E')) return false;
                else return to1 != 'E' || to2 != 'S';
            } else if (from1 == 'E') {
                if (to1 == 'N' && to2 == 'W') return false;
                else return to1 != 'E' || to2 != 'S';
            } else if (from2 == 'S') {
                if (to1 == 'N' && to2 == 'W') return false;
                else return to1 != 'E' || (to2 != 'W' && to2 != 'N');
            }
        }

        return true;
    }

    private boolean check(List<char[]> from_to) {
        int fn = from_to.size();
        for (int i = 0; i < fn; i++) {
            for (int j = i + 1; j < fn; j++) {
                if (!check2(from_to.get(i), from_to.get(j)))
                    return false;
            }
        }
        return true;
    }

    private int dfs(int a, int b, int c, int d) {
        if (memo[a][b][c][d] != -1) {
            return memo[a][b][c][d];
        }
        if (a == directions[0].length()
                && b == directions[1].length()
                && c == directions[2].length()
                && d == directions[3].length()) {
            return 0;
        }
        int[] dir_now = new int[]{a, b, c, d};

        int res = Integer.MAX_VALUE - 10;
        List<char[]> from_to = new ArrayList<>();
        int[] go = new int[4];
        for (int state = 1; state < 16; state++) {
            boolean ok = true;
            from_to.clear();
            Arrays.fill(go, 0);

            //----解析state（从哪几个方向出发）
            for (int di = 0; di < 4; di++) {
                if (((state >> di) & 1) == 1) {
                    if (dir_now[di] == directions[di].length()) {
                        ok = false;
                        break;
                    }
                    from_to.add(new char[]{DIR[di], directions[di].charAt(dir_now[di])});
                    go[di] = 1;
                }
            }
            if (ok && check(from_to)) {
                int tmp_res = dfs(a + go[0], b + go[1], c + go[2], d + go[3]);
                res = Math.min(res, tmp_res + 1);
            }
        }
        memo[a][b][c][d] = res;
        return res;
    }
}
/*
LCP 43. 十字路口的交通
https://leetcode.cn/problems/Y1VbOX/

LCCUP 力扣杯 2021 秋季编程大赛个人赛 T5。

前往「力扣挑战赛」场馆的道路上，有一个拥堵的十字路口，该十字路口由两条双向两车道的路交叉构成。由于信号灯故障，交警需要手动指挥拥堵车辆。假定路口没有新的来车且一辆车从一个车道驶入另一个车道所需的时间恰好为一秒钟，长度为 4 的一维字符串数组 directions 中按照 东、南、西、北 顺序记录了四个方向从最靠近路口到最远离路口的车辆计划开往的方向。其中：
- "E" 表示向东行驶；
- "S" 表示向南行驶；
- "W" 表示向西行驶；
- "N" 表示向北行驶。
交警每秒钟只能指挥各个车道距离路口最近的一辆车，且每次指挥需要满足如下规则：
- 同一秒钟内，一个方向的车道只允许驶出一辆车；
- 同一秒钟内，一个方向的车道只允许驶入一辆车；
- 同一秒钟内，车辆的行驶路线不可相交。
请返回最少需要几秒钟，该十字路口等候的车辆才能全部走完。
各个车道驶出的车辆可能的行驶路线如图所示：
注意：
- 测试数据保证不会出现掉头行驶指令，即某一方向的行驶车辆计划开往的方向不会是当前车辆所在的车道的方向;
- 表示堵塞车辆行驶方向的字符串仅用大写字母 "E"，"N"，"W"，"S" 表示。
提示：
directions.length = 4
0 <= directions[i].length <= 20
 */