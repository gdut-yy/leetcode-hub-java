package p1721;

import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class CF1721D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = scanner.nextInt();
            }
            System.out.println(solve2(n, a, b));
        }
    }

//    private static String solve(int n, int[] a, int[] b) {
//        List<Integer> aList = Arrays.stream(a).boxed().toList();
//        List<Integer> bList = Arrays.stream(b).boxed().toList();
//
//        int ans = 0;
//        Queue<List<List<Integer>>> queue = new ArrayDeque<>();
//        queue.add(List.of(aList, bList));
//        o:
//        for (int k = 29; k >= 0; k--) {
//            Queue<List<List<Integer>>> tmp = new ArrayDeque<>(queue);
//            queue.clear();
//            for (List<List<Integer>> p : tmp) {
//                List<List<Integer>> f = List.of(new ArrayList<>(), new ArrayList<>());
//                List<List<Integer>> g = List.of(new ArrayList<>(), new ArrayList<>());
//
//                for (int v : p.get(0)) {
//                    f.get(v >> k & 1).add(v);
//                }
//                for (int v : p.get(1)) {
//                    g.get(v >> k & 1).add(v);
//                }
//                if (f.get(0).size() != g.get(1).size()) {
//                    queue = tmp;
//                    continue o;
//                }
//                if (!f.get(0).isEmpty()) {
//                    queue.add(List.of(f.get(0), g.get(1)));
//                }
//                if (!f.get(1).isEmpty()) {
//                    queue.add(List.of(f.get(1), g.get(0)));
//                }
//            }
//            ans |= 1 << k;
//        }
//        return String.valueOf(ans);
//    }
//
//    private static int ans;
//    private static Queue<List<List<Integer>>> queue;
//
//    // 消掉 continue label
//    private static String solve1(int n, int[] a, int[] b) {
//        List<Integer> aList = Arrays.stream(a).boxed().toList();
//        List<Integer> bList = Arrays.stream(b).boxed().toList();
//        queue = new LinkedList<>();
//        queue.add(List.of(aList, bList));
//
//        ans = 0;
//        dfs(29);
//        return String.valueOf(ans);
//    }
//
//    private static void dfs(int start) {
//        for (int k = start; k >= 0; k--) {
//            Queue<List<List<Integer>>> tmp = new LinkedList<>(queue);
//            queue.clear();
//            for (List<List<Integer>> p : tmp) {
//                List<List<Integer>> f = List.of(new ArrayList<>(), new ArrayList<>());
//                List<List<Integer>> g = List.of(new ArrayList<>(), new ArrayList<>());
//
//                for (int v : p.get(0)) {
//                    f.get(v >> k & 1).add(v);
//                }
//                for (int v : p.get(1)) {
//                    g.get(v >> k & 1).add(v);
//                }
//                if (f.get(0).size() != g.get(1).size()) {
//                    queue = tmp;
//                    dfs(k - 1);
//                    return;
//                }
//                if (!f.get(0).isEmpty()) {
//                    queue.add(List.of(f.get(0), g.get(1)));
//                }
//                if (!f.get(1).isEmpty()) {
//                    queue.add(List.of(f.get(1), g.get(0)));
//                }
//            }
//            ans |= 1 << k;
//        }
//    }

    // https://codeforces.com/contest/1721/submission/189697507
    private static String solve2(int n, int[] a, int[] b) {
        Arrays.sort(a);
        reverseSort(b);

        int ans = 0;
        for (int i = 29; i >= 0; i--) {
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if ((a[j] >> i & 1) == (b[j] >> i & 1)) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                ans |= 1 << i;
            } else {
                for (int j = 0; j < n; j++) {
                    a[j] |= 1 << i;
                    b[j] |= 1 << i;
                }
                Arrays.sort(a);
                reverseSort(b);
            }
        }
        return String.valueOf(ans);
    }

    // 由大到小排序
    private static void reverseSort(int[] nums) {
        Arrays.sort(nums);
        for (int l = 0, r = nums.length - 1; l < r; l++, r--) {
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
        }
    }
}
/*
D. Maximum AND
https://codeforces.com/contest/1721/problem/D

灵茶の试炼 2023-01-19
题目大意：
输入 t(≤1e4) 表示 t 组数据，每组数据输入 n(≤1e5) 和两个长为 n 的数组 a b，元素范围在 [0,2^30)。所有数据的 n 之和不超过 1e5。
数组 b 可以随意打乱。
输出 (a[1] XOR b[1]) AND (a[2] XOR b[2]) AND ... AND (a[n] XOR b[n]) 的最大值。

rating 1800
https://codeforces.com/contest/1721/submission/189632358
提示 1：从最高位往最低位一位一位思考。
提示 2：a 中的 0 需要和 b 中的 1 匹配，a 中的 1 需要和 b 中的 0 匹配。
提示 3：如果可以匹配，则分组，问题规模缩小，可以用递归来思考更低位的匹配。
但是，如果当前位的任意一个子问题匹配失败，则对于这个位，所有匹配都是无效的（因为算的是 AND）。此时应该跳过这个位上的所有匹配，直接计算下一个更低位的匹配。
提示 4：用 BFS+双数组，从而能实现这个跳过的逻辑。
匹配失败时，直接还原回原来的数组。具体见代码。
======

input
3
5
1 0 0 3 3
2 3 2 1 0
3
1 1 1
0 0 3
8
0 1 2 3 4 5 6 7
7 6 5 4 3 2 1 0
output
2
0
7
 */
