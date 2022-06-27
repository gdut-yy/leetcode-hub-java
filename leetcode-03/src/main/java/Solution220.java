import java.util.HashMap;
import java.util.Map;

public class Solution220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        Map<Integer, Integer> buckets = new HashMap<>();
        int bucketSize = t + 1;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int id = getBucketId(num, bucketSize);

            if (buckets.containsKey(id)
                    || (buckets.containsKey(id - 1) && buckets.get(id - 1) + t >= num)
                    || (buckets.containsKey(id + 1) && buckets.get(id + 1) - t <= num)) {
                return true;
            }
            buckets.put(id, num);
            if (i >= k) {
                buckets.remove(getBucketId(nums[i - k], bucketSize));
            }
        }
        return false;
    }

    private int getBucketId(int num, int bucketSize) {
        if (num >= 0) {
            return num / bucketSize;
        }
        return (num + 1) / bucketSize - 1;
    }
}
/*
220. 存在重复元素 III
https://leetcode.cn/problems/contains-duplicate-iii/

难度增加，多了 t
桶。时间复杂度 O(n)
 */