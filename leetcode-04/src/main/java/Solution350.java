import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> cntMap1 = new HashMap<>();
        Map<Integer, Integer> cntMap2 = new HashMap<>();
        for (int num : nums1) {
            cntMap1.put(num, cntMap1.getOrDefault(num, 0) + 1);
        }
        for (int num : nums2) {
            cntMap2.put(num, cntMap2.getOrDefault(num, 0) + 1);
        }
        List<Integer> resList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : cntMap1.entrySet()) {
            int key = entry.getKey();
            if (cntMap2.containsKey(key)) {
                int min = Math.min(entry.getValue(), cntMap2.get(key));
                for (int i = 0; i < min; i++) {
                    resList.add(key);
                }
            }
        }
        return resList.stream().mapToInt(i -> i).toArray();
    }
}
/*
350. 两个数组的交集 II
https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/

给定两个数组，编写一个函数来计算它们的交集。
 */