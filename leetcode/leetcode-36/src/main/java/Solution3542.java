import java.util.ArrayDeque;
import java.util.Deque;

public class Solution3542 {
    static class V1 {
        public int minOperations(int[] nums) {
            int ans = 0;
            Deque<Integer> st = new ArrayDeque<>();
            for (int x : nums) {
                while (!st.isEmpty() && x < st.peek()) {
                    st.pop();
                    ans++;
                }
                // 如果 x 与栈顶相同，那么 x 与栈顶可以在同一次操作中都变成 0，x 无需入栈
                if (st.isEmpty() || x != st.peek()) {
                    st.push(x);
                }
            }
            return ans + st.size() - (st.getLast() == 0 ? 1 : 0); // 0 不需要操作
        }
    }

    static class V2 {
        public int minOperations(int[] nums) {
            int ans = 0;
            int top = -1; // 栈顶下标（把 nums 当作栈）
            for (int x : nums) {
                while (top >= 0 && x < nums[top]) {
                    top--; // 出栈
                    ans++;
                }
                // 如果 x 与栈顶相同，那么 x 与栈顶可以在同一次操作中都变成 0，x 无需入栈
                if (top < 0 || x != nums[top]) {
                    nums[++top] = x; // 入栈
                }
            }
            return ans + top + (nums[0] > 0 ? 1 : 0);
        }
    }
}
/*
3542. 将所有元素变为 0 的最少操作次数
https://leetcode.cn/problems/minimum-operations-to-convert-all-elements-to-zero/description/

第 156 场双周赛 T2。

给你一个大小为 n 的 非负 整数数组 nums 。你的任务是对该数组执行若干次（可能为 0 次）操作，使得 所有 元素都变为 0。
在一次操作中，你可以选择一个子数组 [i, j]（其中 0 <= i <= j < n），将该子数组中所有 最小的非负整数 的设为 0。
返回使整个数组变为 0 所需的最少操作次数。
一个 子数组 是数组中的一段连续元素。
提示:
1 <= n == nums.length <= 10^5
0 <= nums[i] <= 10^5

赛时没做出来。。
单调栈。
https://leetcode.cn/problems/minimum-operations-to-convert-all-elements-to-zero/solutions/3673804/cong-fen-zhi-dao-dan-diao-zhan-jian-ji-x-mzbl/
rating 1822 (clist.by)
 */