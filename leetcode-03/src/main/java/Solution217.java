import java.util.HashSet;
import java.util.Set;

public class Solution217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            // 已有的元素中是否有重复
            if (!set.contains(num)) {
                set.add(num);
            } else {
                return true;
            }
        }
        return false;
    }
}
/*
217. 存在重复元素
https://leetcode-cn.com/problems/contains-duplicate/

给定一个整数数组，判断是否存在重复元素。
使用 Set 判断是否存在重复元素。
 */