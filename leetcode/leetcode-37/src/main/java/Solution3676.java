import java.util.ArrayDeque;
import java.util.Deque;

public class Solution3676 {
    public long bowlSubarrays(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Deque<Integer> st = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] <= nums[i]) {
                st.pop();
            }
            left[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] <= nums[i]) {
                st.pop();
            }
            right[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            if (left[i] != -1 && right[i] != n) {
                ans++;
            }
        }
        return ans;
    }
}
/*
3676. 碗子数组的数目
https://leetcode.cn/problems/count-bowl-subarrays/description/

第 466 场周赛 T3。

给你一个整数数组 nums，包含 互不相同 的元素。
nums 的一个子数组 nums[l...r] 被称为 碗（bowl），如果它满足以下条件：
- 子数组的长度至少为 3。也就是说，r - l + 1 >= 3。
- 其两端元素的 最小值 严格大于 中间所有元素的 最大值。也就是说，min(nums[l], nums[r]) > max(nums[l + 1], ..., nums[r - 1])。
返回 nums 中 碗 子数组的数量。
子数组 是数组中连续的元素序列。
提示:
3 <= nums.length <= 10^5
1 <= nums[i] <= 10^9
nums 由不同的元素组成。

单调栈。统计合法下标。返回值 long 是迷惑性质。
时间复杂度 O(n)。
https://yuanbao.tencent.com/chat/naQivTmsDa/0f153432-97c4-4f12-972f-bae0f4f6d805
rating 2223 (clist.by)
 */