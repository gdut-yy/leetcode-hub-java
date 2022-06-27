import java.util.HashMap;
import java.util.Map;

public class Solution219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 如果存在重复元素 并且 下标距离至多为 k
            if (map.containsKey(nums[i]) && (i - map.get(nums[i]) <= k)) {
                return true;
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }
}
/*
219. 存在重复元素 II
https://leetcode.cn/problems/contains-duplicate-ii/

难度增加，多了个下标距离至多为 k 的约束。
使用 Map。key 记录数值 value 记录下标。
 */