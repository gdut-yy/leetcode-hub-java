import java.util.PriorityQueue;

public class SolutionP3506 {
    public long minEliminationTime(int[] timeReq, int splitTime) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (long time : timeReq) {
            pq.add(time);
        }
        while (pq.size() > 1) {
            pq.remove();
            long secondMin = pq.remove();
            pq.offer(secondMin + splitTime);
        }
        return pq.remove();
    }
}
/*
$3506. 查找消除细菌菌株所需时间
https://leetcode.cn/problems/find-time-required-to-eliminate-bacterial-strains/description/

给定一个整数数组 timeReq 和一个整数 splitTime。
在人体微观世界中，免疫系统面临着一项非凡的挑战：对抗快速繁殖的细菌群落，这对身体的生存构成威胁。
最初，只部署一个 白细胞（WBC）来消除细菌。然而，单独的白细胞很快意识到它无法跟上细菌的生长速度。
WBC制定了一种巧妙的策略来对抗细菌：
- 第 i 个细菌菌株需要 timeReq[i] 个时间单位来被消除。
- 单个白细胞只能消除 一个 细菌菌株。之后，白细胞耗尽，无法执行任何其他任务。
- 一个白细胞可以将自身分裂为两个白细胞，但这需要 splitTime 单位时间。一旦分裂，两个白细胞就可以 并行 消灭细菌。
- 一个白细胞仅可以攻击一个细菌菌株。多个白细胞不能同时攻击一个菌株。
您必须确定消除所有细菌菌株所需的 最短 时间。
注意，细菌菌株可以按任何顺序消除。
提示：
2 <= timeReq.length <= 10^5
1 <= timeReq[i] <= 10^9
1 <= splitTime <= 10^9

相似题目: $1199. 建造街区的最短时间
https://leetcode.cn/problems/minimum-time-to-build-blocks/
 */