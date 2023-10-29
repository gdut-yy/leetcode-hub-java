package p1867;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1867D {
    static int n, k;
    static int[] b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            k = scanner.nextInt();
            b = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        if (k == 1) {
            for (int j = 0; j < n; j++) {
                if (b[j] != j + 1) {
                    return "NO";
                }
            }
            return "YES";
        }

        int[] vis = new int[n];
        int[] num = new int[n];
        int tgr = 1;
        for (int j = 0; j < n; ++j) {
            if (vis[j] == 0) {
                int idx = j;
                int cnum = 0;
                while (vis[idx] == 0) {
                    vis[idx] = tgr;
                    num[idx] = cnum++;
                    idx = b[idx] - 1;
                }
                if (vis[idx] != tgr) {
                    tgr++;
                    continue;
                }
                if (cnum - num[idx] != k) {
                    return "NO";
                }
                tgr++;
            }
        }
        return "YES";
    }
}
/*
D. Cyclic Operations
https://codeforces.com/contest/1867/problem/D

题目大意：
Egor 有一个长度为 n 的数组 a，最初由 0 组成。然而，他想把它变成另一个长度为 n 的数组 b。
由于 Egor 不采用简单的路径，因此只能使用以下操作(可能为零或多次):
- 选择长度为 k 的数组 l(1≤li≤n，所有 li 不重复)，将每个元素 a[li] 改为 l[(i%k)+1](1≤i≤k)。
他开始感兴趣的是，是否有可能只使用这些操作就得到数组 b。由于 Egor 还是一个初级程序员，他请您帮助他解决这个问题。
运算%表示取余数，即 a%b 等于数 a 除以数 b 的余数。

rating 1800
https://codeforces.com/blog/entry/120353
如果 k=1，那么我们可以把 bi 变成 i，所以只有当 bi=i 时答案是 YES，否则答案是 NO。
否则，让我们构建一个有 n 个顶点和边(i,bi)的无向图。这个图的任何组件看起来都像一个循环(可能大小为 1)，每个顶点都连接着一个树(可能是空的)。
现在，如果每个组件的循环大小正好是 k，那么答案是肯定的，否则是否定的。
时间复杂度:每个测试用例 O(n)。
======

input
6
5 3
2 3 5 3 4
4 2
2 4 3 1
1 1
1
3 1
1 2 3
5 3
5 4 3 2 1
6 1
1 2 3 1 5 6
output
YES
NO
YES
YES
NO
NO
 */
