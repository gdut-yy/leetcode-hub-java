import java.util.HashMap;
import java.util.Map;

public class SolutionI1718 {
    public int[] shortestSeq(int[] big, int[] small) {
        int n = big.length;

        Map<Integer, Integer> bigMap = new HashMap<>();
        Map<Integer, Integer> smallMap = new HashMap<>();
        for (int x : small) {
            smallMap.merge(x, 1, Integer::sum);
        }

        int l = 0, r = 0;
        int minPos = -1;
        int minLen = n + 1;
        while (r < n) {
            bigMap.merge(big[r], 1, Integer::sum);
            while (check(bigMap, smallMap)) {
                if (minLen > r - l + 1) {
                    minLen = r - l + 1;
                    minPos = l;
                }

                bigMap.merge(big[l], -1, Integer::sum);
                l++;
            }
            r++;
        }
        return minPos == -1 ? new int[0] : new int[]{minPos, minPos + minLen - 1};
    }

    private boolean check(Map<Integer, Integer> bigMap, Map<Integer, Integer> smallMap) {
        for (Map.Entry<Integer, Integer> entry : smallMap.entrySet()) {
            if (bigMap.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
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

不定长滑动窗口（求最短/最小）
时间复杂度 O(n)
相似题目: 76. 最小覆盖子串
https://leetcode.cn/problems/minimum-window-substring/
 */