package p1914;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CF1914D {
    static int n;
    static int[] a, b, c;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            a = new int[n];
            b = new int[n];
            c = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            for (int i = 0; i < n; i++) {
                b[i] = scanner.nextInt();
            }
            for (int i = 0; i < n; i++) {
                c[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        Integer[][] ids = new Integer[3][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                ids[j][i] = i;
            }
        }
        Arrays.sort(ids[0], Comparator.comparingInt(o -> -a[o]));
        Arrays.sort(ids[1], Comparator.comparingInt(o -> -b[o]));
        Arrays.sort(ids[2], Comparator.comparingInt(o -> -c[o]));

        // [[0, 1, 2], [0, 2, 1], [1, 0, 2], [1, 2, 0], [2, 1, 0], [2, 0, 1]]
        int[][] permutation = {{0, 1, 2}, {0, 2, 1}, {1, 0, 2}, {1, 2, 0}, {2, 1, 0}, {2, 0, 1}};
        int ans = 0;
        for (int[] permute : permutation) {
            ans = Math.max(ans, getAns(ids, permute));
        }
        return String.valueOf(ans);
    }

    static int getAns(Integer[][] ids, int[] permute) {
        Set<Integer> vis = new HashSet<>();
        int res = 0;
        for (int j : permute) {
            for (Integer id : ids[j]) {
                if (!vis.contains(id)) {
                    vis.add(id);
                    if (j == 0) {
                        res += a[id];
                    } else if (j == 1) {
                        res += b[id];
                    } else {
                        res += c[id];
                    }
                    break;
                }
            }
        }
        return res;
    }
}
/*
D. Three Activities
https://codeforces.com/contest/1914/problem/D

题目大意：
寒假就要到了。它们将持续 n 天。
在假期里，Monocarp 想和他的朋友们一起尝试所有这些活动一次:
- 去滑雪;
- 在电影院看电影;
- 玩棋盘游戏。
Monocarp 知道，在第一天，正好有两个朋友会和他一起滑雪，两个朋友会和他一起看电影，三个朋友会和他一起玩棋盘游戏。
Monocarp 也知道他不能在一天内尝试一种以上的活动。
因此，他要求你帮助他选择三个不同的日子 x,y,z，以使参加他的活动(ax+by+cz)的朋友总数最大化。

排序后最多取 top 3 比较即可
======

input
4
3
1 10 1
10 1 1
1 1 10
4
30 20 10 1
30 5 15 20
30 25 10 10
10
5 19 12 3 18 18 6 17 10 13
15 17 19 11 16 3 11 17 17 17
1 17 18 10 15 8 17 3 13 12
10
17 5 4 18 12 4 11 2 16 16
8 4 14 19 3 12 6 7 5 16
3 4 8 11 10 8 10 2 20 3
output
30
75
55
56
 */
