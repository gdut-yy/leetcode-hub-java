import java.util.TreeMap;

public class Solution846 {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int len = hand.length;
        // 平均分不了的用例不用看了
        if (len % groupSize != 0) {
            return false;
        }
        // 统计频次
        TreeMap<Integer, Integer> cntTreeMap = new TreeMap<>();
        for (int han : hand) {
            cntTreeMap.put(han, cntTreeMap.getOrDefault(han, 0) + 1);
        }
        // 每次从最小的取
        while (cntTreeMap.size() > 0) {
            int firstKey = cntTreeMap.firstKey();
            // 取连续的
            for (int i = firstKey; i < firstKey + groupSize; i++) {
                // 取不到返回 false
                if (!cntTreeMap.containsKey(i)) {
                    return false;
                }
                // 用掉这张牌，若用完要把对应 key 也 remove 掉
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
846. 一手顺子
https://leetcode-cn.com/problems/hand-of-straights/

第 87 场周赛 T3。
此题目与 1296 重复：https://leetcode-cn.com/problems/divide-array-in-sets-of-k-consecutive-numbers/
TreeMap 很少登场，特性类似优先队列，根据 key 升序排序。
暴力模拟。从最小的牌开始取，连续取，若取完，即可以完成分组
注意 Map.replace(key, value) 与 Map.put(key, value) 区别：
replace 若 key 不存在不会往里放，put 不管是否存在都会往里放
 */