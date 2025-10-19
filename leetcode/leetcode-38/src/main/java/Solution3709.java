import java.util.ArrayList;
import java.util.List;

public class Solution3709 {
    static class ExamTracker {
        List<Integer> times;
        List<Long> prefixSums;

        public ExamTracker() {
            times = new ArrayList<>();
            prefixSums = new ArrayList<>();
        }

        public void record(int time, int score) {
            times.add(time);
            if (prefixSums.isEmpty()) {
                prefixSums.add((long) score);
            } else {
                long lastSum = prefixSums.getLast();
                prefixSums.add(lastSum + score);
            }
        }

        public long totalScore(int startTime, int endTime) {
            if (times.isEmpty()) {
                return 0;
            }
            int l = lowerBound(times, startTime);
            int r = lowerBound(times, endTime + 1) - 1;
            if (l >= times.size() || r < 0 || l > r) {
                return 0;
            }
            long prevSum = (l == 0) ? 0 : prefixSums.get(l - 1);
            return prefixSums.get(r) - prevSum;
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
3709. 设计考试分数记录器
https://leetcode.cn/problems/design-exam-scores-tracker/description/

第 167 场双周赛 T3。

Alice 经常参加考试，并希望跟踪她的分数以及计算特定时间段内的总分数。
请实现 ExamTracker 类：
ExamTracker(): 初始化 ExamTracker 对象。
void record(int time, int score): Alice 在时间 time 参加了一次新考试，获得了分数 score。
long long totalScore(int startTime, int endTime): 返回一个整数，表示 Alice 在 startTime 和 endTime（两者都包含）之间参加的所有考试的 总 分数。如果在指定时间间隔内 Alice 没有参加任何考试，则返回 0。
保证函数调用是按时间顺序进行的。即，
对 record() 的调用将按照 严格递增 的 time 进行。
Alice 永远不会查询需要未来信息的总分数。也就是说，如果最近一次 record() 调用中的 time = t，那么 totalScore() 总是满足 startTime <= endTime <= t 。
提示:
1 <= time <= 10^9
1 <= score <= 10^9
1 <= startTime <= endTime <= t，其中 t 是最近一次调用 record() 时的 time 值。
对 record() 的调用将以 严格递增 的 time 进行。
在 ExamTracker() 之后，第一个函数调用总是 record()。
对 record() 和 totalScore() 的总调用次数最多为 10^5 次。

前缀和 + 二分。
时间复杂度 O(nlogn)。
 */