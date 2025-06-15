import java.util.ArrayList;
import java.util.List;

public class Solution3576 {
    public boolean canMakeEqual(int[] nums, int k) {
        int n = nums.length;
        List<Integer> pos0 = new ArrayList<>();
        List<Integer> pos1 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] == -1) pos0.add(i);
            else pos1.add(i);
        }
        return check(k, pos0) || check(k, pos1);
    }

    private boolean check(int k, List<Integer> pos) {
        int sz = pos.size();
        if (sz % 2 != 0) return false;
        for (int i = 0; i < sz; i += 2) {
            k -= pos.get(i + 1) - pos.get(i);
            if (k < 0) return false;
        }
        return true;
    }
}
/*
3576. 数组元素相等转换
https://leetcode.cn/problems/transform-array-to-all-equal-elements/description/

第 453 场周赛 T1。

给你一个大小为 n 的整数数组 nums，其中只包含 1 和 -1，以及一个整数 k。
你可以最多进行 k 次以下操作：
选择一个下标 i（0 <= i < n - 1），然后将 nums[i] 和 nums[i + 1] 同时 乘以 -1。
注意：你可以在 不同 的操作中多次选择相同的下标 i。
如果在最多 k 次操作后可以使数组的所有元素相等，则返回 true；否则，返回 false。
提示：
1 <= n == nums.length <= 10^5
nums[i] 的值为 -1 或 1。
1 <= k <= n

分类讨论，两种情况：都变成 1 或者都变成 -1
 */