import java.util.Arrays;

public class SolutionP3631 {
    public int[][] sortThreats(int[][] threats) {
        Arrays.sort(threats, (o1, o2) -> {
            long id1 = o1[0], sev1 = o1[1], exp1 = o1[2], score1 = 2 * sev1 + exp1;
            long id2 = o2[0], sev2 = o2[1], exp2 = o2[2], score2 = 2 * sev2 + exp2;
            if (score1 != score2) return Long.compare(score2, score1);
            return Long.compare(id1, id2);
        });
        return threats;
    }
}
/*
$3631. 按严重性和可利用性排序威胁
https://leetcode.cn/problems/sort-threats-by-severity-and-exploitability/description/

给定一个二维整数数组 threats，其中 threats[i] = [IDi, sevi, expi]。
- IDi：威胁的唯一标识。
- sevi：表示威胁的严重程度。
- expi：表示威胁的可利用性。
威胁 i 的 分数 定义为：score = 2 × sevi + expi
你的任务是按 分数降序 返回 threats。
如果多个威胁具有相同的分数，则按 ID 升序 排序。
提示：
1 <= threats.length <= 10^5
threats[i] == [IDi, sevi, expi]
1 <= IDi <= 10^6
1 <= sevi <= 10^9
1 <= expi <= 10^9
所有 IDi 互不相同。

自定义排序。
时间复杂度 O(nlogn)。
 */