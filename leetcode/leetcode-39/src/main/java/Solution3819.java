import java.util.ArrayList;
import java.util.List;

public class Solution3819 {
    public int[] rotateElements(int[] nums, int k) {
        int n = nums.length;
        List<Integer> nonNegPos = new ArrayList<>();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            if (nums[i] >= 0) nonNegPos.add(i);
            else ans[i] = nums[i];
        }
        int sz = nonNegPos.size();
        if (sz == 0) return ans;
        k %= sz;
        for (int i = 0; i < sz; i++) {
            ans[nonNegPos.get(i)] = nums[nonNegPos.get((i + k) % sz)];
        }
        return ans;
    }
}
/*
3819. 非负元素轮替
https://leetcode.cn/problems/rotate-non-negative-elements/description/

第 486 场周赛 T2。

给你一个整数数组 nums 和一个整数 k。
将数组中 非负 元素以循环的方式 向左 轮替 k 个位置。
所有 负数 元素必须保持在它们原来的位置，不进行移动。
轮替后，将 非负 元素按照新的顺序放回数组中，仅填充原先包含 非负 值的位置，并 跳过所有负数 的位置。
返回处理后的数组。
提示：
1 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9
0 <= k <= 10^5

模拟。
时间复杂度 O(n)。
 */