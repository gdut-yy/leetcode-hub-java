import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution888 {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int aliceSum = Arrays.stream(aliceSizes).sum();
        int bobSum = Arrays.stream(bobSizes).sum();
        int sum = (aliceSum + bobSum) / 2;
        // 总和差值
        int diff = sum - aliceSum;
        Map<Integer, Integer> idxMap = new HashMap<>();
        for (int i = 0; i < bobSizes.length; i++) {
            idxMap.put(bobSizes[i], i);
        }
        int[] ans = new int[2];
        for (int aliceSize : aliceSizes) {
            // 单个差值。类 "两数之和"
            int bobSize = aliceSize + diff;
            if (idxMap.containsKey(bobSize)) {
                ans[0] = aliceSize;
                ans[1] = bobSize;
                return ans;
            }
        }
        return ans;
    }
}
/*
888. 公平的糖果棒交换
https://leetcode-cn.com/problems/fair-candy-swap/

第 98 场周赛 T1。
类 "两数之和"
 */
