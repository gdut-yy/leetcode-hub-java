import java.util.HashSet;
import java.util.Set;

public class Solution6049 {
    public int countDistinct(int[] nums, int k, int p) {
        int len = nums.length;

        Set<String> hashSet = new HashSet<>();
        for (int i = 0; i < len; i++) {
            // 子数组中有 cnt 个可被 p 整除的元素
            int cnt = 0;
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = i; j < len; j++) {
                if (nums[j] % p == 0) {
                    cnt++;
                }
                if (cnt <= k) {
                    stringBuilder.append(nums[j]).append(",");
                    hashSet.add(stringBuilder.toString());
                } else {
                    break;
                }
            }
        }
        return hashSet.size();
    }
}
/*
6049. 含最多 K 个可整除元素的子数组
https://leetcode-cn.com/contest/weekly-contest-291/problems/k-divisible-elements-subarrays/

第 291 场周赛 T3。

给你一个整数数组 nums 和两个整数 k 和 p ，找出并返回满足要求的不同的子数组数，要求子数组中最多 k 个可被 p 整除的元素。
如果满足下述条件之一，则认为数组 nums1 和 nums2 是 不同 数组：
- 两数组长度 不同 ，或者
- 存在 至少 一个下标 i 满足 nums1[i] != nums2[i] 。
子数组 定义为：数组中的连续元素组成的一个 非空 序列。
提示：
1 <= nums.length <= 200
1 <= nums[i], p <= 200
1 <= k <= nums.length

模拟。数据范围 nums.length <= 200，可以两层 for 循环直接模拟，再利用 Set 集合进行去重。
时间复杂度: O(n^3)，每个 O(n^2) 内额外需要 O(n) 拼接字符串。
 */