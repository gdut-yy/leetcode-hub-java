import java.util.HashMap;
import java.util.Map;

public class Solution3960 {
    public int getLength(int[] nums) {
        int n = nums.length;
        int ans = 1;
        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> freq = new HashMap<>();
            Map<Integer, Integer> freqCnt = new HashMap<>();
            int maxFreq = 0, distinct = 0;
            for (int j = i; j < n; j++) {
                int v = nums[j];
                int oldF = freq.getOrDefault(v, 0);
                int newF = oldF + 1;
                freq.put(v, newF);
                if (oldF == 0) {
                    distinct++;
                } else {
                    freqCnt.put(oldF, freqCnt.get(oldF) - 1);
                    if (freqCnt.get(oldF) == 0) {
                        freqCnt.remove(oldF);
                    }
                }
                freqCnt.put(newF, freqCnt.getOrDefault(newF, 0) + 1);
                if (newF > maxFreq) {
                    maxFreq = newF;
                }
                if (distinct == 1 ||
                        (maxFreq % 2 == 0 && freqCnt.size() == 2 && freqCnt.containsKey(maxFreq / 2))) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
        return ans;
    }
}
/*
3960. 频率平衡子数组
https://leetcode.cn/problems/frequency-balance-subarray/description/

第 506 场周赛 T2。

给你一个整数数组 nums。
定义 频率平衡 子数组 如下：
- 如果子数组只包含 一种 元素，则它是频率平衡的。
- 否则，必然存在一个正整数 f，使得子数组中的每个不同值出现的次数要么是 f，要么是 2 * f，并且这两种 频率 都在不同值中出现。
返回一个整数，表示 最长 频率平衡子数组的长度。
提示：
1 <= nums.length <= 10^3
1 <= nums[i] <= 10^9

维护出现次数的出现次数。
时间复杂度 O(n^2)。
 */