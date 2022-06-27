import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1636 {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int num : nums) {
            cntMap.put(num, cntMap.getOrDefault(num, 0) + 1);
        }
        // map => List<int[]> [本身,频率]
        List<int[]> frequencyList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : cntMap.entrySet()) {
            frequencyList.add(new int[]{entry.getKey(), entry.getValue()});
        }
        // 按照每个值的频率 升序 排序。如果有多个值的频率相同，请你按照数值本身将它们 降序 排序
        frequencyList.sort((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o2[0] - o1[0];
            }
            return o1[1] - o2[1];
        });
        int[] resArr = new int[nums.length];
        int idx = 0;
        for (int[] frequency : frequencyList) {
            for (int i = 0; i < frequency[1]; i++) {
                resArr[idx] = frequency[0];
                idx++;
            }
        }
        return resArr;
    }
}
/*
1636. 按照频率将数组升序排序
https://leetcode.cn/problems/sort-array-by-increasing-frequency/

第 38 场双周赛 T1。

给你一个整数数组 nums ，请你将数组按照每个值的频率 升序 排序。如果有多个值的频率相同，请你按照数值本身将它们 降序 排序。
请你返回排序后的数组。

模拟。
 */