package p1749;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.TreeMap;

public class CF1749C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve(n, a));
        }
    }

    private static String solve(int n, int[] a) {
        int ans = 0;
        for (int k = 1; k <= n; k++) {
            TreeMap<Integer, Integer> treeMap = new TreeMap<>();
            for (int x : a) {
                treeMap.put(x, treeMap.getOrDefault(x, 0) + 1);
            }
            int sz = n;

            for (int i = 1; i <= k; i++) {
                // alice 去掉 x <= k-i+1 的最大元素
                Integer x = treeMap.floorKey(k - i + 1);
                if (x == null) break;
                int cntX = treeMap.get(x);
                if (cntX == 1) treeMap.remove(x);
                else treeMap.put(x, cntX - 1);
                sz--;

                // bob 选择最小的数加上 k-i+1
                if (treeMap.isEmpty()) continue;
                Integer y = treeMap.firstKey();
                int cntY = treeMap.get(y);
                if (cntY == 1) treeMap.remove(y);
                else treeMap.put(y, cntY - 1);

                int z = y + k - i + 1;
                treeMap.put(z, treeMap.getOrDefault(z, 0) + 1);
            }
            if (sz + k == n) {
                ans = k;
            }
        }
        return String.valueOf(ans);
    }
}
/*
C. Number Game
https://codeforces.com/contest/1749/problem/C

题目大意：
给定整数 n, k 和长度为 n 的数组 a。
在开始游戏之前，Alice 选择了一个整数 k≥0。游戏持续 k 个阶段，阶段从 1 到 k 编号。在第 i 阶段，Alice 必须从数组中删除一个小于或等于 k-i+1 的元素。
之后，如果数组不是空的，Bob 必须向数组中的任意元素添加 k−i+1。注意，Alice 的移动和 Bob 的移动都是游戏的同一阶段的两个部分。如果 Alice 不能在某个阶段删除一个元素，她就输了。
如果第 k 阶段结束，爱丽丝还没有输，她就赢了。你的任务是确定 k 的最大值，这样如果两个玩家都玩得最优，爱丽丝就能赢。
求 k 的最大值。

贪心+枚举。
每个回合，Alice 总是去掉 x <= k-i+1 的最大元素。Bob 总是选择最小的数加上 k-i+1
======

input
4
3
1 1 2
4
4 4 4 4
1
1
5
1 3 2 1 1
output
2
0
1
3
 */
