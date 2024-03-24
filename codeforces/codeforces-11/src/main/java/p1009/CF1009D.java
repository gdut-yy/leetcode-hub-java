package p1009;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1009D {
    static int n, m;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        System.out.println(solve());
    }

    private static String solve() {
        if (m < n - 1) {
            return "Impossible";
        }

        List<int[]> ans = getAns();
        if (ans.size() < m) {
            return "Impossible";
        }
        return "Possible" + System.lineSeparator() +
                ans.stream().map(e -> e[0] + " " + e[1]).collect(Collectors.joining(System.lineSeparator()));
    }

    private static List<int[]> getAns() {
        List<int[]> ans = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (getGCD(i, j) == 1) {
                    ans.add(new int[]{i, j});
                    if (ans.size() == m) {
                        return ans;
                    }
                }
            }
        }
        return ans;
    }

    static int getGCD(int num1, int num2) {
        return num1 == 0 ? num2 : getGCD(num2 % num1, num1);
    }
}
/*
D. Relatively Prime Graph
https://codeforces.com/contest/1009/problem/D

灵茶の试炼 2022-07-01
题目大意：
定义互质图：图中每条边所连接的两个点必须是互质的（但互质的两个点之间不一定要有边）。
图中点的编号从 1 到 n。
输入两个整数 n 和 m（范围都在 [1,1e5]）。
请你构造一个有 n 个点 m 条边的无向连通互质图，图中不能有自环（自己连向自己）或重边（多条一样的边）。
如果无法构造，输出 "Impossible"；否则输出 "Possible" 和 m 条边（输出任意一种合法的构造方案）。

constructive algorithms
rating 1700
https://codeforces.com/contest/1009/submission/86186458
选择 m 个值不超过 n 的互质对，二重循环枚举即可，收集到 m 个时退出循环。
如果收集不到 m 个，输出 Impossible。否则输出答案。
注意判断 m<n-1 的情况，此时图不是连通的，应输出 Impossible。
======

input
5 6
output
Possible
2 5
3 2
5 1
3 4
4 1
5 4

input
6 12
output
Impossible
 */