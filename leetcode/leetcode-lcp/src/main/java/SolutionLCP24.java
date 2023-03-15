import java.util.PriorityQueue;

public class SolutionLCP24 {
    private static final int MOD = (int) (1e9 + 7);

    // Slope Trick
    // https://codeforces.com/blog/entry/47821
    // https://codeforces.com/blog/entry/77298
    // https://leetcode.cn/problems/5TxKeK/solution/xie-lu-you-hua-by-fzldq-9wt4/
    // https://leetcode.cn/problems/make-array-non-decreasing-or-non-increasing/
    public int[] numsGame(int[] nums) {
//        n, minf, mod = len(nums), 0, 10 ** 9 + 7
//        res, L, R = [], [float("inf")], [float("inf")]
//        for i in range(n):
//        a = nums[i]
//        minf += max(0, -L[0] + i - a)
//        heapq.heappush(R, -heapq.heappushpop(L, -a + i))
//        minf += max(0, a - R[0] - i)
//        heapq.heappush(L, -heapq.heappushpop(R, a - i))
//        res.append(minf % mod)
//        return res
        int n = nums.length;
        long minf = 0;
        int[] res = new int[n];
        PriorityQueue<Integer> L = new PriorityQueue<>();
        PriorityQueue<Integer> R = new PriorityQueue<>();
        L.add(Integer.MAX_VALUE / 2);
        R.add(Integer.MAX_VALUE / 2);
        for (int i = 0; i < n; i++) {
            int a = nums[i];
            minf += Math.max(0, -L.element() + i - a);
            L.add(-a + i);
            R.add(-L.remove());
            minf += Math.max(0, a - R.element() - i);
            R.add(a - i);
            L.add(-R.remove());
            res[i] = (int) (minf % MOD);
        }
        return res;
    }
}
/*
LCP 24. 数字游戏
https://leetcode.cn/problems/5TxKeK/

小扣在秋日市集入口处发现了一个数字游戏。主办方共有 N 个计数器，计数器编号为 0 ~ N-1。每个计数器上分别显示了一个数字，
小扣按计数器编号升序将所显示的数字记于数组 nums。每个计数器上有两个按钮，分别可以实现将显示数字加一或减一。小扣每一次操作可以选择一个计数器，按下加一或减一按钮。
主办方请小扣回答出一个长度为 N 的数组，第 i 个元素(0 <= i < N)表示将 0~i 号计数器 初始 所示数字操作成满足所有条件 nums[a]+1 == nums[a+1],(0 <= a < i) 的最小操作数。回答正确方可进入秋日市集。
由于答案可能很大，请将每个最小操作数对 1,000,000,007 取余。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^3
 */