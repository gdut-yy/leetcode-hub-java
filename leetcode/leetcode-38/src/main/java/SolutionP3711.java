import java.util.PriorityQueue;

public class SolutionP3711 {
    public int maxTransactions(int[] transactions) {
        int ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long total = 0;
        for (int tr : transactions) {
            if (tr < 0) {
                pq.offer(tr);
            }
            total += tr;
            if (total >= 0) {
                ans++;
            } else {
                total -= pq.poll();
            }
        }
        return ans;
    }
}
/*
$3711. 不出现负余额的最大交易额
https://leetcode.cn/problems/maximum-transactions-without-negative-balance/description/

给定一个整数数组 transactions，其中 transactions[i] 表示第 i 笔交易的总额：
- 正值表示 收到 的钱。
- 负值表示 支付 的钱。
账户初始余额为 0，且余额 必须始终保持非负。交易必须按照给定的顺序进行处理，但你可以跳过一些交易。
返回一个整数，表示在不使余额变为负数的情况下可以执行的 最大交易次数。
提示：
1 <= transactions.length <= 10^5
-10^9 <= transactions[i] <= 10^9

贪心+最大堆。
时间复杂度 O(nlogn)。
 */