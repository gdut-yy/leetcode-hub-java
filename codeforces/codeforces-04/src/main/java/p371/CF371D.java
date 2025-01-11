package p371;

import java.util.Scanner;

public class CF371D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] cp = new int[n];
        for (int i = 0; i < n; i++) {
            cp[i] = scanner.nextInt();
        }
        int[] water = new int[n];

        DSU dsu = new DSU(n);
        int m = scanner.nextInt();
        for (int qi = 0; qi < m; qi++) {
            int op = scanner.nextInt();
            int idx = scanner.nextInt() - 1;
            if (op == 1) {
                int x = scanner.nextInt();

                for (idx = dsu.find(idx); ; idx = dsu.find(idx)) {
                    if (water[idx] + x < cp[idx]) {
                        water[idx] += x;
                        break;
                    }
                    x -= cp[idx] - water[idx];
                    water[idx] = cp[idx];
                    idx++;
                    if (idx == n) {
                        break;
                    }
                    dsu.union(idx - 1, idx);
                }
            } else {
                System.out.println(water[idx]);
            }
        }
    }

    private static class DSU {
        int[] fa;

        public DSU(int n) {
            fa = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
            }
        }

        int find(int x) {
            if (x != fa[x]) fa[x] = find(fa[x]);
            return fa[x];
        }

        void union(int x, int y) {
            x = find(x);
            y = find(y);
            fa[x] = y;
        }
    }
}
/*
D. Vessels
https://codeforces.com/contest/371/problem/D

灵茶の试炼 2022-09-07
灵茶の试炼 2024-04-18
题目大意：
输入 n (≤2e5) 和一个长为 n 的数组 a (1≤a[i]≤1e9)，表示有 n 个盛水的容器，从上到下串起来（如下图），从上到下第 i 个容器的容量为 a[i]。初始时，所有容器都是空的。
然后输入 m (≤2e5) 个询问，每个询问的格式如下（i 从 1 开始）：
1 i x，表示往第 i 个容器倒 x (≤1e9) 单位的水。溢出的水会流到下一个容器，下一个容器溢出的水会流到下下一个容器，……，最后一个容器溢出的水会流到地板上。
2 i，输出第 i 个容器有多少单位的水。
相似题目：https://www.luogu.com.cn/problem/P7167

rating 1800
https://codeforces.com/contest/371/submission/125191890
提示 1：并查集
提示 2：并查集应当实现：每个容器指向当前或下一个没有装满的容器
https://codeforces.com/problemset/submission/371/257108107
======

input
2
5 10
6
1 1 4
2 1
1 2 5
1 1 4
2 1
2 2
output
4
5
8

input
3
5 10 8
6
1 1 12
2 2
1 1 6
1 3 2
2 2
2 3
output
7
10
5
 */