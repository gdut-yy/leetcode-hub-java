import java.util.ArrayList;
import java.util.List;

public class Solution4065 {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] cnt = new int[101];
        for (int v : nums) {
            cnt[v]++;
        }

        List<Integer> ans = new ArrayList<>();
        int m = n;
        while (m > 0) {
            List<Integer> tmp = new ArrayList<>();
            for (int v = 1; v <= 100; v++) {
                if (cnt[v] > 0) {
                    --cnt[v];
                    m--;
                    tmp.add(v);
                }
            }
            ans.addAll(tmp);
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
/*
4065. 移除不同值重排数组
https://leetcode.cn/problems/rearrange-array-by-removing-distinct-values/description/

第 521 场周赛 T1。

给你一个整数数组 nums。
初始时，你有一个 空 数组 ans。重复执行以下操作，直到 nums 变为 空 ：
- 找出当前 nums 中 所有不同 的值。
- 将当前 nums 中每个 不同 的值各移除一个，并按 升序 将这些值依次添加到 ans 中。
返回数组 ans。
示例 1：
输入： nums = [3,1,3,2,1,3]
输出： [1,2,3,1,3,3]
示例 2：
输入： nums = [7,7,4,4,4]
输出： [4,7,4,7,4]
提示：
1 <= nums.length <= 100
1 <= nums[i] <= 100

模拟。
时间复杂度 O(nU)。
 */