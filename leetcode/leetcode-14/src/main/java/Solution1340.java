import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Solution1340 {
    public int maxJumps(int[] arr, int d) {
        int n = arr.length;

        // arr.emplace_back(1e9);
        List<Integer> a = new ArrayList<>();
        for (int v : arr) a.add(v);
        a.add((int) 1e9);
        arr = a.stream().mapToInt(Integer::intValue).toArray();

        // dp[i] 存储从下标 i 开始最多能跳几次
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);
        Deque<Integer> st = new ArrayDeque<>(); // st是单调不增的栈

        for (int i = 0; i < n + 1; ++i) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                List<Integer> tp = new ArrayList<>();
                tp.add(st.pop());
                // arr中所有和当前栈顶相等的值都要一起弹出
                while (!st.isEmpty() && arr[st.peek()] == arr[tp.getFirst()]) {
                    tp.add(st.pop());
                }
                for (int j : tp) {
                    if (i - j <= d) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                    if (!st.isEmpty() && j - st.peek() <= d) {
                        dp[st.peek()] = Math.max(dp[st.peek()], dp[j] + 1);
                    }
                }
            }
            st.push(i);
        }
        // return *max_element(dp.begin(), dp.end() - 1);
        return Arrays.stream(dp).limit(n).max().orElseThrow();
    }
}
/*
1340. 跳跃游戏 V
https://leetcode.cn/problems/jump-game-v/description/

给你一个整数数组 arr 和一个整数 d 。每一步你可以从下标 i 跳到：
- i + x ，其中 i + x < arr.length 且 0 < x <= d 。
- i - x ，其中 i - x >= 0 且 0 < x <= d 。
除此以外，你从下标 i 跳到下标 j 需要满足：arr[i] > arr[j] 且 arr[i] > arr[k] ，其中下标 k 是所有 i 到 j 之间的数字（更正式的，min(i, j) < k < max(i, j)）。
你可以选择数组的任意下标开始跳跃。请你返回你 最多 可以访问多少个下标。
请注意，任何时刻你都不能跳到数组的外面。
提示：
1 <= arr.length <= 1000
1 <= arr[i] <= 10^5
1 <= d <= arr.length

单调栈 O(n) https://leetcode.cn/problems/jump-game-v/solutions/3059779/dan-diao-zhan-on-by-utopiainbuaa-0k5c/
相似题目: 907. 子数组的最小值之和
https://leetcode.cn/problems/sum-of-subarray-minimums/
 */