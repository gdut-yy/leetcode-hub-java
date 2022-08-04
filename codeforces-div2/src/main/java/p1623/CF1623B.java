package p1623;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Comparator;
import java.util.List;

public class CF1623B {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8));
        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(reader.readLine());
            int[][] nums = new int[n][2];
            for (int j = 0; j < n; j++) {
                String[] lines = reader.readLine().split(" ");
                nums[j][0] = Integer.parseInt(lines[0]);
                nums[j][1] = Integer.parseInt(lines[1]);
            }
            String[] res = solution(n, nums);
            for (int j = 0; j < n; j++) {
                writer.write(res[j].concat(System.lineSeparator()));
            }
            writer.write(System.lineSeparator());
        }
        writer.close();
        reader.close();
    }

    private static String[] solution(int n, int[][] nums) {
        Arrays.sort(nums, Comparator.comparingInt(o -> o[1] - o[0]));
        BitSet bitSet = new BitSet(1001);
        List<String> resList = new ArrayList<>();
        for (int[] num : nums) {
            int left = num[0];
            int right = num[1];
            for (int i = left; i <= right; i++) {
                // 可选
                if (!bitSet.get(i)) {
                    resList.add(left + " " + right + " " + i);
                    bitSet.set(i);
                }
            }
        }
        return resList.toArray(new String[0]);
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
