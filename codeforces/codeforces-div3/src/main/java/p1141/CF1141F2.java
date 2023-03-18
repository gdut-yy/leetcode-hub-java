package p1141;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1141F2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve(n, a));
    }

    private static String solve(int n, int[] a) {
        int[] preSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + a[i];
        }

        // 暴力预处理
        Map<Integer, List<int[]>> sumRangesMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = preSum[j + 1] - preSum[i];
                sumRangesMap.computeIfAbsent(sum, key -> new ArrayList<>()).add(new int[]{i + 1, j + 1});
            }
        }

        int maxCnt = 0;
        List<int[]> resList = new ArrayList<>();
        for (List<int[]> ranges : sumRangesMap.values()) {
            ranges.sort(Comparator.comparingInt(o -> o[1]));
            int sz = ranges.size();

            List<int[]> list = new ArrayList<>();
            list.add(ranges.get(0));

            int preR = ranges.get(0)[1];
            for (int i = 1; i < sz; i++) {
                if (ranges.get(i)[0] > preR) {
                    list.add(ranges.get(i));
                    preR = ranges.get(i)[1];
                }
            }
            if (maxCnt < list.size()) {
                maxCnt = list.size();
                resList = list;
            }
        }
        return maxCnt
                + System.lineSeparator()
                + resList.stream().map(o -> o[0] + " " + o[1]).collect(Collectors.joining(System.lineSeparator()));
    }
}
/*
F2. Same Sum Blocks (Hard)
https://codeforces.com/contest/1141/problem/F2

灵茶の试炼 2023-02-09
题目大意：
输入 n(≤1500) 和长为 n 的数组 a(-1e5≤a[i]≤1e5)，下标从 1 开始。
你需要从 a 中选出尽量多的非空连续子数组，这些子数组不能重叠，且元素和相等。
输出子数组的个数 k，然后输出 k 行，每行两个数表示子数组的左右端点。
可以按任意顺序输出，多种方案可以输出任意一种。

https://codeforces.com/contest/1141/submission/192610240
暴力统计每个子数组的和，用哈希表把和相同的子数组左右端点记录下来。
对于每一组，问题变成最多不重叠线段个数。
这是个经典贪心，按照右端点从小到大排序+遍历，一旦遇到左端点大于上一个记录的右端点，答案加一，更新右端点。
相似题目: 435. 无重叠区间
https://leetcode.cn/problems/non-overlapping-intervals/
646. 最长数对链
https://leetcode.cn/problems/maximum-length-of-pair-chain/
======

input
7
4 1 2 2 1 5 3
output
3
7 7
2 3
4 5

input
11
-5 -4 -3 -2 -1 0 1 2 3 4 5
output
2
3 4
1 1

input
4
1 1 1 1
output
4
4 4
1 1
2 2
3 3
 */
