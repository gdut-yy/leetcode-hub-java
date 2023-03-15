import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SolutionLCP48 {
    public String gobang(int[][] pieces) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] piece : pieces) {
            map.putIfAbsent(piece[0], new HashMap<>());
            map.get(piece[0]).put(piece[1], piece[2]);
        }

        if (howManyWins(map, 0).size() > 0) {
            return "Black";
        }
        Set<String> whiteWins = howManyWins(map, 1);
        if (whiteWins.size() > 0) {
            if (whiteWins.size() > 1) {
                return "White";
            }
            int[] onlyPosition = new int[2];
            for (String s : whiteWins) {
                onlyPosition[0] = Integer.parseInt(s.split(";")[0]);
                onlyPosition[1] = Integer.parseInt(s.split(";")[1]);
            }
            if (check(map, onlyPosition[0], onlyPosition[1]).size() > 1) {
                return "Black";
            } else {
                return "None";
            }
        }

        Set<String> emptyPositions = threeInFive(map);

        for (String p : emptyPositions) {
            int p0 = Integer.parseInt(p.split(";")[0]);
            int p1 = Integer.parseInt(p.split(";")[1]);
            if (check(map, p0, p1).size() > 1) {
                return "Black";
            }
        }
        return "None";
    }

    private Set<String> threeInFive(Map<Integer, Map<Integer, Integer>> map) {
        Set<String> set = new HashSet<>();
        for (Integer x : map.keySet()) {
            for (Integer y : map.get(x).keySet()) {
                if (map.get(x).get(y) == 0) {

                    for (int[] dir : DIRECTIONS8) {
                        List<Integer> left = new ArrayList<>();
                        int step = 1;
                        while (step <= 4) {
                            int nx = x + dir[0] * step;
                            int ny = y + dir[1] * step;
                            if (!map.containsKey(nx)) {
                                if (left.size() > 1) {
                                    break;
                                }
                                left.add(step);
                            } else if (!map.get(nx).containsKey(ny)) {
                                if (left.size() > 1) {
                                    break;
                                }
                                left.add(step);
                            } else if (map.get(nx).get(ny) != 0) {
                                break;
                            }
                            step++;
                        }
                        if (step != 5) {
                            continue;
                        }
                        for (int l : left) {
                            set.add((x + dir[0] * l) + ";" + (y + dir[1] * l));
                        }
                    }
                }
            }
        }
        return set;
    }

    private static final int[][] DIRECTIONS8 = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {-1, -1}, {1, 1}, {-1, 1}, {1, -1}};

    private Set<String> check(Map<Integer, Map<Integer, Integer>> map, int x, int y) {
        Set<String> set = new HashSet<>();
        for (int[] dir : DIRECTIONS8) {
            for (int i = 0; i < 5; ++i) {
                int j = 0;
                int left = -10;
                for (j = 0; j < 5; ++j) {
                    if (i == j) {
                        continue;
                    }
                    int xPos = x + dir[0] * (i - j);
                    int yPos = y + dir[1] * (i - j);
                    if (!map.containsKey(xPos)) {
                        if (left != -10) {
                            break;
                        }
                        left = i - j;
                    } else if (!map.get(xPos).containsKey(yPos)) {
                        if (left != -10) {
                            break;
                        }
                        left = i - j;
                    } else if (map.get(xPos).get(yPos) != 0) {
                        break;
                    }
                }
                if (j != 5) {
                    continue;
                }
                if (left != -10) {
                    String s = (x + dir[0] * left) + ";" + (y + dir[1] * left);
                    set.add(s);
                }
            }
        }
        return set;
    }

    private Set<String> howManyWins(Map<Integer, Map<Integer, Integer>> map, int color) {
        Set<String> set = new HashSet<>();
        for (Integer x : map.keySet()) {
            for (Integer y : map.get(x).keySet()) {
                if (map.get(x).get(y) == color) {
                    for (int[] dir : DIRECTIONS8) {
                        int step = 1;
                        int left = 0;
                        while (step <= 4) {
                            int nx = x + dir[0] * step;
                            int ny = y + dir[1] * step;
                            if (!map.containsKey(nx)) {
                                if (left != 0) {
                                    break;
                                }
                                left = step;
                            } else if (!map.get(nx).containsKey(ny)) {
                                if (left != 0) {
                                    break;
                                }
                                left = step;
                            } else if (map.get(nx).get(ny) != color) {
                                break;
                            }
                            step++;
                        }
                        if (step != 5) {
                            continue;
                        }
                        String s = (x + dir[0] * left) + ";" + (y + dir[1] * left);
                        set.add(s);
                    }
                }
            }
        }
        return set;
    }
}
/*
LCP 48. 无限棋局
https://leetcode.cn/problems/fsa7oZ/

LCCUP 力扣杯 2021 秋季编程大赛战队赛 T5。

小力正在通过残局练习来备战「力扣挑战赛」中的「五子棋」项目，他想请你能帮他预测当前残局的输赢情况。
棋盘中的棋子分布信息记录于二维数组 pieces 中，其中 pieces[i] = [x,y,color] 表示第 i 枚棋子的横坐标为 x，纵坐标为 y，棋子颜色为 color(0 表示黑棋，1 表示白棋)。
假如黑棋先行，并且黑棋和白棋都按最优策略落子，请你求出当前棋局在三步（按 黑、白、黑 的落子顺序）之内的输赢情况（三步之内先构成同行、列或对角线连续同颜色的至少 5 颗即为获胜）：
- 黑棋胜, 请返回 "Black"
- 白棋胜, 请返回 "White"
- 仍无胜者, 请返回 "None"
注意：
- 和传统的五子棋项目不同，「力扣挑战赛」中的「五子棋」项目 不存在边界限制，即可在 任意位置 落子；
- 黑棋和白棋均按 3 步内的输赢情况进行最优策略的选择
- 测试数据保证所给棋局目前无胜者；
- 测试数据保证不会存在坐标一样的棋子。
提示：
0 <= pieces.length <= 1000
pieces[i].length = 3
-10^9 <= pieces[i][0], pieces[i][1] <=10^9
0 <= pieces[i][2] <=1
 */