package p1846;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class CF1846C {
    static int n, m, h;
    static long[][] time;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            h = scanner.nextInt();
            time = new long[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    time[i][j] = scanner.nextInt();
                }
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            Arrays.sort(time[i]);
            for (int j = 1; j < m; j++) {
                time[i][j] += time[i][j - 1];
            }
            long po = 0, pe = 0;
            for (int j = 0; j < m; j++) {
                if (time[i][j] <= h) {
                    po += 1;
                    pe += time[i][j];
                }
            }
            nodes[i] = new Node(po, pe, i + 1);
        }

        Arrays.sort(nodes, (o1, o2) -> {
            if (o1.point == o2.point) {
                return Long.compare(o1.penalty, o2.penalty);
            }
            return Long.compare(o2.point, o1.point);
        });

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (nodes[i].id == 1) {
                ans = i + 1;
                break;
            }
        }
        return String.valueOf(ans);
    }

    private static class Node {
        long point, penalty, id;

        public Node(long point, long penalty, long id) {
            this.point = point;
            this.penalty = penalty;
            this.id = id;
        }
    }
}
/*
C. Rudolf and the Another Competition
https://codeforces.com/contest/1846/problem/C

题目大意：
鲁道夫已经报名参加了一个编程比赛，这个比赛将遵循 ICPC 的规则。规则意味着，每解决一个问题，参与者得 1 分，同时也会受到从比赛开始到解决问题的时间相等的惩罚。在最后的表格中，得分最多的参与者排名较高，如果得分相等，得分较低的参与者排名较高。
总共有 n 名参赛者报名参加了比赛。鲁道夫是索引 1 的参与者。据悉，本次会议将提出 m 个问题。比赛将持续 h 分钟。
一个强大的人工智能预测了 ti,j 的值，它代表了第 i 个参与者解决第 j 个问题所需的分钟数。
鲁道夫意识到解决问题的顺序会影响最终的结果。例如，h=120，求解问题的次数为[20,15,110]，则如果 Rudolf 求解问题的顺序为:
- 3,1,2，那么他只会解决第三个问题，得到 1 分和 110 分。
- 1,2,3，那么他将在 20 分钟后解决第一个问题，在 20+15=35 分钟后解决第二个问题，他将没有时间解决第三个问题。因此，他将得到 2 分和 20+35=55 的罚分。
- 2,1,3，那么他将在 15 分钟后解第二道题，15+20=35 分钟后解第一道题，他将没有时间解第三道题。因此，他将得到 2 分和 15+35=50 的罚分。
鲁道夫很感兴趣，如果每个参赛者都根据人工智能的预测以最优顺序解决问题，他将在比赛中占据什么位置。假设在得分和罚分相等的情况下，鲁道夫将占据最佳位置。

前缀和 + 枚举
注意爆 int
======

input
5
3 3 120
20 15 110
90 90 100
40 40 40
2 1 120
30
30
1 3 120
10 20 30
3 2 27
8 9
10 7
10 8
3 3 15
7 2 6
7 5 4
1 9 8
output
2
1
1
2
1
 */
