import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution2071 {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);
        int mn = Math.min(tasks.length, workers.length);

        // 二分查找
        int left = 1;
        int right = mn + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (!checkMid(tasks, workers, pills, strength, new ArrayDeque<>(), mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left - 1;
    }

    // 添加（能完成的）任务：往队尾插入数据。
    // 删除最简单的任务：去掉队首。
    // 删除（能完成的）最难的任务：去掉队尾。
    private boolean checkMid(int[] tasks, int[] workers, int pills, int strength, Deque<Integer> dq, int k) {
        // 贪心：用最强的 k 名工人，完成最简单的 k 个任务
        int i = 0;
        for (int j = workers.length - k; j < workers.length; j++) { // 枚举工人
            int w = workers[j];
            // 在吃药的情况下，把能完成的任务记录到 buf 中
            while (i < k && tasks[i] <= w + strength) {
                dq.addLast(tasks[i]);
                i++;
            }
            // 即使吃药也无法完成任务
            if (dq.isEmpty()) return false;
            // 无需吃药就能完成（最简单的）任务
            if (w >= dq.getFirst()) {
                dq.removeFirst();
                continue;
            }
            // 必须吃药
            if (pills == 0) { // 没药了
                return false;
            }
            pills--;
            // 完成（能完成的）最难的任务
            dq.removeLast();
        }
        return true;
    }
}
/*
2071. 你可以安排的最多任务数目
https://leetcode.cn/problems/maximum-number-of-tasks-you-can-assign/

第 65 场双周赛 T4。

给你 n 个任务和 m 个工人。每个任务需要一定的力量值才能完成，需要的力量值保存在下标从 0 开始的整数数组 tasks 中，
第 i 个任务需要 tasks[i] 的力量才能完成。每个工人的力量值保存在下标从 0 开始的整数数组 workers 中，第 j 个工人的力量值为 workers[j] 。
每个工人只能完成 一个 任务，且力量值需要 大于等于 该任务的力量要求值（即 workers[j] >= tasks[i] ）。
除此以外，你还有 pills 个神奇药丸，可以给 一个工人的力量值 增加 strength 。你可以决定给哪些工人使用药丸，但每个工人 最多 只能使用 一片 药丸。
给你下标从 0 开始的整数数组tasks 和 workers 以及两个整数 pills 和 strength ，请你返回 最多 有多少个任务可以被完成。
提示：
n == tasks.length
m == workers.length
1 <= n, m <= 5 * 10^4
0 <= pills <= m
0 <= tasks[i], workers[j], strength <= 10^9

二分前提：
- 若 k 个任务能被完成，则根据贪心，必然是 k 个要求最低的任务与 k 个力量最强的工人。
- 若 k-1 个任务能被完成，则必然是 k-1 个要求最低的任务与 k-1 个力量最强的工人也能完成。
贪心：由难到易枚举这 k 个任务：
- 如果有工人的值大于等于该任务的值，那么我们一定不需要使用药丸，并且一定让值最大的工人完成该任务。
- 如果所有工人的值都小于该任务的值，那么我们必须使用药丸让一名工人完成任务，并且一定让值最小的工人完成该任务。
 */