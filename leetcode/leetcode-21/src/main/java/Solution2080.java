import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2080 {
    static class RangeFreqQuery {
        static final int MAX_N = (int) (1e4 + 5);
        List<Integer>[] posMp;

        public RangeFreqQuery(int[] arr) {
            posMp = new ArrayList[MAX_N];
            Arrays.setAll(posMp, e -> new ArrayList<>());
            for (int i = 0; i < arr.length; i++) {
                posMp[arr[i]].add(i);
            }
        }

        public int query(int left, int right, int value) {
            int i = lowerBound(posMp[value], left);
            int j = lowerBound(posMp[value], right + 1);
            return j - i;
        }

        private int lowerBound(List<Integer> a, int key) {
            int l = 0, r = a.size();
            while (l < r) {
                int m = l + (r - l) / 2;
                if (a.get(m) >= key) r = m;
                else l = m + 1;
            }
            return l;
        }
    }
}
/*
2080. 区间内查询数字的频率
https://leetcode.cn/problems/range-frequency-queries/

第 268 场周赛 T3。

请你设计一个数据结构，它能求出给定子数组内一个给定值的 频率 。
子数组中一个值的 频率 指的是这个子数组中这个值的出现次数。
请你实现 RangeFreqQuery 类：
- RangeFreqQuery(int[] arr) 用下标从 0 开始的整数数组 arr 构造一个类的实例。
- int query(int left, int right, int value) 返回子数组 arr[left...right] 中 value 的 频率 。
一个 子数组 指的是数组中一段连续的元素。arr[left...right] 指的是 nums 中包含下标 left 和 right 在内 的中间一段连续元素。
提示：
1 <= arr.length <= 10^5
1 <= arr[i], value <= 10^4
0 <= left <= right < arr.length
调用 query 不超过 10^5 次。

HashMap 存每个 value 的下标，然后二分找下标边界即可。
 */