import java.util.HashMap;
import java.util.Map;

public class Solution911 {
    static class TopVotedCandidate {
        int[] times;
        // 领先者
        int[] leading;
        // 统计票数
        Map<Integer, Integer> cntMap;

        public TopVotedCandidate(int[] persons, int[] times) {
            this.times = times;

            // times.length == persons.length
            int len = persons.length;
            leading = new int[len];
            cntMap = new HashMap<>();
            int max = 0;
            for (int i = 0; i < len; i++) {
                int nextVal = cntMap.getOrDefault(persons[i], 0) + 1;
                cntMap.put(persons[i], nextVal);
                // 在平局的情况下，最近获得投票的候选人将会获胜。
                if (nextVal >= max) {
                    max = nextVal;
                    leading[i] = persons[i];
                } else {
                    leading[i] = leading[i - 1];
                }
            }
        }

        public int q(int t) {
            // 右边界二分
            int idx = binarySearchRightBound(times, t);
            return leading[idx];
        }

        private int binarySearchRightBound(int[] nums, int target) {
            int left = 0;
            int right = nums.length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    left = mid + 1;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid;
                }
            }
            return left - 1;
        }
    }
}
/*
911. 在线选举
https://leetcode-cn.com/problems/online-election/

第 103 场周赛 T4。

给你两个整数数组 persons 和 times 。在选举中，第 i 张票是在时刻为 times[i] 时投给候选人 persons[i] 的。
对于发生在时刻 t 的每个查询，需要找出在 t 时刻在选举中领先的候选人的编号。
在 t 时刻投出的选票也将被计入我们的查询之中。在平局的情况下，最近获得投票的候选人将会获胜。
实现 TopVotedCandidate 类：
- TopVotedCandidate(int[] persons, int[] times) 使用 persons 和 times 数组初始化对象。
- int q(int t) 根据前面描述的规则，返回在时刻 t 在选举中领先的候选人的编号。

预处理结果，由于 times 并非线性，所以通过二分查找来获得时刻 t 结果。
 */