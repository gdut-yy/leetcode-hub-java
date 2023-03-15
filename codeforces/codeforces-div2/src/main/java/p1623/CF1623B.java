package p1623;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class CF1623B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[][] lr = new int[n][2];
            for (int j = 0; j < n; j++) {
                lr[j][0] = scanner.nextInt();
                lr[j][1] = scanner.nextInt();
            }

            List<String> res = solve(n, lr);
            for (String re : res) {
                System.out.println(re);
            }
        }
    }

    private static List<String> solve(int n, int[][] lr) {
        Arrays.sort(lr, Comparator.comparingInt(o -> o[1] - o[0]));
        BitSet bitSet = new BitSet(1001);
        List<String> resList = new ArrayList<>();
        for (int[] tuple : lr) {
            int left = tuple[0];
            int right = tuple[1];
            for (int i = left; i <= right; i++) {
                // 可选
                if (!bitSet.get(i)) {
                    resList.add(left + " " + right + " " + i);
                    bitSet.set(i);
                }
            }
        }
        return resList;
    }
}
/*
B. Game on Ranges
https://codeforces.com/contest/1623/problem/B

题目大意：
给出整数 n, 以及 n 组 (l,r)，[l,r] 闭区间为猜数范围，没猜对的放回原数组，求每组 (l,r) 对应猜对的数。（1 ≤ n ≤ 1000）
可以按任何顺序打印这些行。可以证明答案是唯一的。

贪心，先排序，从最有把握的开始推，标记当前已经用过的数值即可。
两层循环 时间复杂度 O(n^2)
======

input
4
1
1 1
3
1 3
2 3
2 2
6
1 1
3 5
4 4
3 6
4 5
1 6
5
1 5
1 2
4 5
2 2
4 4

output
1 1 1

1 3 1
2 2 2
2 3 3

1 1 1
3 5 3
4 4 4
3 6 6
4 5 5
1 6 2

1 5 3
1 2 1
4 5 5
2 2 2
4 4 4
 */
