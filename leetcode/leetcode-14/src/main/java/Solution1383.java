import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution1383 {
    static final int MOD = (int) (1e9 + 7);

    record Staff(int sp, int eff) {
    }

    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        List<Staff> list = new ArrayList<>();
        for (int i = 0; i < n; i++) list.add(new Staff(speed[i], efficiency[i]));
        list.sort(Comparator.comparingInt(staff -> -staff.eff));

        PriorityQueue<Staff> pq = new PriorityQueue<>(Comparator.comparingInt(staff -> staff.sp));
        long ans = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            Staff staff = list.get(i);
            long minE = staff.eff;
            long sumS = sum + staff.sp;
            ans = Math.max(ans, sumS * minE);
            pq.add(staff);
            sum += staff.sp;
            if (pq.size() == k) {
                sum -= pq.remove().sp;
            }
        }
        return (int) (ans % MOD);
    }
}
/*
1383. 最大的团队表现值
https://leetcode.cn/problems/maximum-performance-of-a-team/description/

给定两个整数 n 和 k，以及两个长度为 n 的整数数组 speed 和 efficiency。现有 n 名工程师，编号从 1 到 n。其中 speed[i] 和 efficiency[i] 分别代表第 i 位工程师的速度和效率。
从这 n 名工程师中最多选择 k 名不同的工程师，使其组成的团队具有最大的团队表现值。
团队表现值 的定义为：一个团队中「所有工程师速度的和」乘以他们「效率值中的最小值」。
请你返回该团队的最大团队表现值，由于答案可能很大，请你返回结果对 10^9 + 7 取余后的结果。
提示：
1 <= k <= n <= 10^5
speed.length == n
efficiency.length == n
1 <= speed[i] <= 10^5
1 <= efficiency[i] <= 10^8

堆。
时间复杂度 O(nlogn)。
 */