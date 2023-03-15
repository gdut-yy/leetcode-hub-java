import java.util.HashMap;
import java.util.Map;

public class SolutionI1718 {
    public int[] shortestSeq(int[] big, int[] small) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        Map<Integer, Integer> smallMap = new HashMap<>();
        for (int x : small) {
            smallMap.put(x, smallMap.getOrDefault(x, 0) + 1);
        }

        int minLen = Integer.MAX_VALUE;
        int[] res = new int[0];
        int left = 0;
        int right = 0;
        while (right < big.length) {
            cntMap.put(big[right], cntMap.getOrDefault(big[right], 0) + 1);
            right++;

            while (cntMapContainsSmallMap(cntMap, smallMap)) {
                if (right - left < minLen) {
                    minLen = right - left;
                    res = new int[]{left, right - 1};
                }

                cntMap.put(big[left], cntMap.getOrDefault(big[left], 0) - 1);
                left++;
            }
        }
        return res;
    }

    private boolean cntMapContainsSmallMap(Map<Integer, Integer> cntMap, Map<Integer, Integer> smallMap) {
        for (Map.Entry<Integer, Integer> entry : smallMap.entrySet()) {
            if (cntMap.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }
}
/*
面试题 17.18. 最短超串
https://leetcode.cn/problems/shortest-supersequence-lcci/

假设你有两个数组，一个长一个短，短的元素均不相同。找到长数组中包含短数组所有的元素的最短子数组，其出现顺序无关紧要。
返回最短子数组的左端点和右端点，如有多个满足条件的子数组，返回左端点最小的一个。若不存在，返回空数组。
提示：
big.length <= 100000
1 <= small.length <= 100000

滑动窗口
相似题目: 76. 最小覆盖子串
https://leetcode.cn/problems/minimum-window-substring/
 */