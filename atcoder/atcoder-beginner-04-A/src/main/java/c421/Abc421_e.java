package c421;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Abc421_e {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int[] L = new int[6];
        for (int i = 0; i < 6; i++) {
            L[i] = scanner.nextInt();
        }

        int[] fact = {1, 1, 2, 6, 24, 120};

        // 生成所有可能的状态（6个非负整数，总和不超过5）
        List<List<Integer>> states = new ArrayList<>();
        for (int s0 = 0; s0 < 6; s0++) {
            for (int s1 = 0; s1 < 6; s1++) {
                if (s0 + s1 > 5) continue;
                for (int s2 = 0; s2 < 6; s2++) {
                    if (s0 + s1 + s2 > 5) continue;
                    for (int s3 = 0; s3 < 6; s3++) {
                        if (s0 + s1 + s2 + s3 > 5) continue;
                        for (int s4 = 0; s4 < 6; s4++) {
                            if (s0 + s1 + s2 + s3 + s4 > 5) continue;
                            for (int s5 = 0; s5 < 6; s5++) {
                                if (s0 + s1 + s2 + s3 + s4 + s5 > 5) continue;
                                states.add(Arrays.asList(s0, s1, s2, s3, s4, s5));
                            }
                        }
                    }
                }
            }
        }

        // 计算E3：每个状态的期望值
        Map<List<Integer>, Double> E3 = new HashMap<>();
        for (List<Integer> s : states) {
            int n = s.stream().mapToInt(Integer::intValue).sum();
            if (n == 5) {
                Map<Integer, Integer> cnt = new HashMap<>();
                for (int i = 0; i < 6; i++) {
                    int d = L[i];
                    cnt.put(d, cnt.getOrDefault(d, 0) + s.get(i));
                }
                int scoreVal = 0;
                for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
                    int val = entry.getKey() * entry.getValue();
                    if (val > scoreVal) scoreVal = val;
                }
                E3.put(s, (double) scoreVal);
            } else {
                int m = 5 - n;
                double totalVal = 0.0;
                for (int t0 = 0; t0 <= m; t0++) {
                    for (int t1 = 0; t1 <= m - t0; t1++) {
                        for (int t2 = 0; t2 <= m - t0 - t1; t2++) {
                            for (int t3 = 0; t3 <= m - t0 - t1 - t2; t3++) {
                                for (int t4 = 0; t4 <= m - t0 - t1 - t2 - t3; t4++) {
                                    int t5 = m - t0 - t1 - t2 - t3 - t4;
                                    List<Integer> T = Arrays.asList(t0, t1, t2, t3, t4, t5);
                                    int coef = fact[m];
                                    for (int tVal : T) {
                                        coef /= fact[tVal];
                                    }
                                    double prob = coef * Math.pow(1.0 / 6.0, m);
                                    List<Integer> U = new ArrayList<>();
                                    for (int i = 0; i < 6; i++) {
                                        U.add(s.get(i) + T.get(i));
                                    }
                                    Map<Integer, Integer> cntU = new HashMap<>();
                                    for (int i = 0; i < 6; i++) {
                                        int d = L[i];
                                        cntU.put(d, cntU.getOrDefault(d, 0) + U.get(i));
                                    }
                                    int scoreU = 0;
                                    for (Map.Entry<Integer, Integer> entry : cntU.entrySet()) {
                                        int val = entry.getKey() * entry.getValue();
                                        if (val > scoreU) scoreU = val;
                                    }
                                    totalVal += prob * scoreU;
                                }
                            }
                        }
                    }
                }
                E3.put(s, totalVal);
            }
        }

        // 计算E2：考虑第二次掷骰子后的最优决策
        Map<List<Integer>, Double> E2 = new HashMap<>();
        for (List<Integer> s : states) {
            int n = s.stream().mapToInt(Integer::intValue).sum();
            if (n == 5) {
                E2.put(s, E3.get(s));
            } else {
                int m = 5 - n;
                double totalVal = 0.0;
                for (int t0 = 0; t0 <= m; t0++) {
                    for (int t1 = 0; t1 <= m - t0; t1++) {
                        for (int t2 = 0; t2 <= m - t0 - t1; t2++) {
                            for (int t3 = 0; t3 <= m - t0 - t1 - t2; t3++) {
                                for (int t4 = 0; t4 <= m - t0 - t1 - t2 - t3; t4++) {
                                    int t5 = m - t0 - t1 - t2 - t3 - t4;
                                    List<Integer> T = Arrays.asList(t0, t1, t2, t3, t4, t5);
                                    int coef = fact[m];
                                    for (int tVal : T) {
                                        coef /= fact[tVal];
                                    }
                                    double prob = coef * Math.pow(1.0 / 6.0, m);
                                    double bestVal = -1.0;
                                    for (int k0 = 0; k0 <= T.get(0); k0++) {
                                        for (int k1 = 0; k1 <= T.get(1); k1++) {
                                            for (int k2 = 0; k2 <= T.get(2); k2++) {
                                                for (int k3 = 0; k3 <= T.get(3); k3++) {
                                                    for (int k4 = 0; k4 <= T.get(4); k4++) {
                                                        for (int k5 = 0; k5 <= T.get(5); k5++) {
                                                            List<Integer> newState = Arrays.asList(
                                                                    s.get(0) + k0,
                                                                    s.get(1) + k1,
                                                                    s.get(2) + k2,
                                                                    s.get(3) + k3,
                                                                    s.get(4) + k4,
                                                                    s.get(5) + k5
                                                            );
                                                            if (E3.containsKey(newState)) {
                                                                double val = E3.get(newState);
                                                                if (val > bestVal) bestVal = val;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    totalVal += prob * bestVal;
                                }
                            }
                        }
                    }
                }
                E2.put(s, totalVal);
            }
        }

        // 计算E1：第一次掷骰子的期望值
        double E1 = 0.0;
        for (int t0 = 0; t0 <= 5; t0++) {
            for (int t1 = 0; t1 <= 5 - t0; t1++) {
                for (int t2 = 0; t2 <= 5 - t0 - t1; t2++) {
                    for (int t3 = 0; t3 <= 5 - t0 - t1 - t2; t3++) {
                        for (int t4 = 0; t4 <= 5 - t0 - t1 - t2 - t3; t4++) {
                            int t5 = 5 - t0 - t1 - t2 - t3 - t4;
                            List<Integer> T = Arrays.asList(t0, t1, t2, t3, t4, t5);
                            int coef = fact[5];
                            for (int tVal : T) {
                                coef /= fact[tVal];
                            }
                            double prob = coef * Math.pow(1.0 / 6.0, 5);
                            double bestVal = -1.0;
                            for (int r0 = 0; r0 <= T.get(0); r0++) {
                                for (int r1 = 0; r1 <= T.get(1); r1++) {
                                    for (int r2 = 0; r2 <= T.get(2); r2++) {
                                        for (int r3 = 0; r3 <= T.get(3); r3++) {
                                            for (int r4 = 0; r4 <= T.get(4); r4++) {
                                                for (int r5 = 0; r5 <= T.get(5); r5++) {
                                                    List<Integer> R = Arrays.asList(r0, r1, r2, r3, r4, r5);
                                                    if (E2.containsKey(R)) {
                                                        double val = E2.get(R);
                                                        if (val > bestVal) bestVal = val;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            E1 += prob * bestVal;
                        }
                    }
                }
            }
        }

        out.printf("%.10f\n", E1);
    }
}
/*
E - Yacht
https://atcoder.jp/contests/abc421/tasks/abc421_e

题目大意：
有五个六面骰子。每个骰子的面上都写着数字 A1,...,A6，每个面出现的概率为 1/6。
你将用这些骰子玩一个单人游戏，游戏过程如下：
1.掷出所有五颗骰子，观察结果，并保留任意数量（可能是零）的骰子。
2.重新掷出所有未保留的骰子，观察结果，并保留重新掷出的骰子中的任意数目（可能为零）。上一步保留的骰子继续保留。
3.重新掷所有未保留的骰子，观察结果。
4.选择任意一个数字 X。让 n 成为五个骰子中显示 X 的骰子数。这个游戏的得分是 nX 点。
求最大化游戏分数的期望值。
Ai 是介于 1 和 100 (含)之间的整数。

https://chat.deepseek.com/a/chat/s/addff147-dea4-401e-af30-5d4590428364
======

Input 1
1 2 3 4 5 6
Output 1
14.6588633742

Input 2
1 1 1 1 1 1
Output 2
5.0000000000

Input 3
31 41 59 26 53 58
Output 3
159.8253021021
 */
