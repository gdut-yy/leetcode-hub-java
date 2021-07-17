import java.util.TreeMap;

public class Solution1296 {
    public boolean isPossibleDivide(int[] nums, int k) {
        int len = nums.length;
        if (len % k != 0) {
            return false;
        }
        TreeMap<Integer, Integer> cntTreeMap = new TreeMap<>();
        for (int han : nums) {
            cntTreeMap.put(han, cntTreeMap.getOrDefault(han, 0) + 1);
        }
        while (cntTreeMap.size() > 0) {
            int firstKey = cntTreeMap.firstKey();
            for (int i = firstKey; i < firstKey + k; i++) {
                if (!cntTreeMap.containsKey(i)) {
                    return false;
                }
                int cnt = cntTreeMap.get(i);
                if (cnt == 1) {
                    cntTreeMap.remove(i);
                } else {
                    cntTreeMap.replace(i, cnt - 1);
                }
            }
        }
        return true;
    }
}
/*
1296. 划分数组为连续数字的集合
https://leetcode-cn.com/problems/divide-array-in-sets-of-k-consecutive-numbers/

此题目与 846 重复：https://leetcode-cn.com/problems/hand-of-straights/
 */