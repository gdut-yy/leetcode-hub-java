import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Solution2276 {
    static class CountIntervals {
        private final TreeMap<Integer, Integer> intervalMap;
        private int cnt;

        public CountIntervals() {
            intervalMap = new TreeMap<>();
            cnt = 0;
        }

        public void add(int left, int right) {
            int newLeft = left;
            int newRight = right;

            Map.Entry<Integer, Integer> interval = intervalMap.floorEntry(right);
            while (interval != null && interval.getValue() >= newLeft) {
                cnt -= interval.getValue() - interval.getKey() + 1;
                newLeft = Math.min(newLeft, interval.getKey());
                newRight = Math.max(newRight, interval.getValue());
                intervalMap.remove(interval.getKey());
                interval = intervalMap.floorEntry(right);
            }
            intervalMap.put(newLeft, newRight);
            cnt += newRight - newLeft + 1;
        }

        public int count() {
            return cnt;
        }
    }

    static class CountIntervals2 {
        private List<int[]> intervals;
        int cnt;

        public CountIntervals2() {
            intervals = new ArrayList<>();
            cnt = 0;
        }

        public void add(int left, int right) {
            int toAdd = right - left + 1;
            int originLeft = left;
            int originRight = right;

            List<int[]> resList = new ArrayList<>();
            boolean placed = false;
            for (int[] interval : intervals) {
                if (right < interval[0]) {
                    // 置于所有区间的左侧
                    if (!placed) {
                        placed = true;
                        resList.add(new int[]{left, right});
                    }
                    resList.add(interval);
                } else if (interval[1] < left) {
                    // 置于所有区间的右侧
                    resList.add(interval);
                } else {
                    // 存在交集，取并集
                    left = Math.min(left, interval[0]);
                    right = Math.max(right, interval[1]);

                    toAdd -= Math.min(originRight, interval[1]) - Math.max(originLeft, interval[0]) + 1;
                }
            }
            if (!placed) {
                resList.add(new int[]{left, right});
            }
            intervals = resList;

            cnt += toAdd;
        }

        public int count() {
            return cnt;
        }
    }
}
/*
2276. 统计区间中的整数数目
https://leetcode.cn/problems/count-integers-in-intervals/

第 293 场周赛 T4。

给你区间的 空 集，请你设计并实现满足要求的数据结构：
- 新增：添加一个区间到这个区间集合中。
- 统计：计算出现在 至少一个 区间中的整数个数。
实现 CountIntervals 类：
- CountIntervals() 使用区间的空集初始化对象
- void add(int left, int right) 添加区间 [left, right] 到区间集合之中。
- int count() 返回出现在 至少一个 区间中的整数个数。
注意：区间 [left, right] 表示满足 left <= x <= right 的所有整数 x 。
提示：
1 <= left <= right <= 10^9
最多调用  add 和 count 方法 总计 10^5 次
调用 count 方法至少一次

相似题目: 57. 插入区间
https://leetcode.cn/problems/insert-interval/
352. 将数据流变为多个不相交区间
https://leetcode-cn.com/problems/data-stream-as-disjoint-intervals/
 */