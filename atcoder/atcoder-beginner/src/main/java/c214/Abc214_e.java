package c214;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Abc214_e {
    static int n;
    static int[][] lr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            lr = new int[n][2];
            for (int i = 0; i < n; i++) {
                lr[i][0] = scanner.nextInt();
                lr[i][1] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        Arrays.sort(lr, Comparator.comparingInt(o -> o[0]));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int i = 0, left = 1;
        while (i < n || !minHeap.isEmpty()) {
            while (i < n && lr[i][0] == left) {
                minHeap.add(lr[i][1]);
                i++;
            }
            if (minHeap.isEmpty()) {
                left = lr[i][0];
                continue;
            }
            if (minHeap.remove() < left) {
                return "No";
            }
            left++;
        }
        return "Yes";
    }
}
/*
E - Packing Under Range Regulations
https://atcoder.jp/contests/abc214/tasks/abc214_e

灵茶の试炼 2022-12-16
题目大意：
输入 t(≤2e5) 表示 t 组数据，每组数据输入 n(≤2e5) 和 n 个区间 [L,R]，范围在 [1,1e9]。
所有数据的 n 之和不超过 2e5。
你有 n 个球，第 i 个球需要放在区间 [L,R] 内的整数位置上。
但每个整数位置上至多能放一个球。
如果可以做到，输出 Yes，否则输出 No

https://atcoder.jp/contests/abc214/submissions/37293686
按左端点排序。
遍历区间，把左端点相同的区间的右端点放到一个最小堆中，每次优先选一个右端点最小的。
======

Input 1
2
3
1 2
2 3
3 3
5
1 2
2 3
3 3
1 3
999999999 1000000000
Output 1
Yes
No
 */