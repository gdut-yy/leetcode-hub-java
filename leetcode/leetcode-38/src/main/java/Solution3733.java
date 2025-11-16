import java.util.function.Function;

public class Solution3733 {
    public long minimumTime(int[] d, int[] r) {
        int d1 = d[0], d2 = d[1];
        int r1 = r[0], r2 = r[1];
        int l = getLCM(r1, r2);

        long left = d1 + d2;
        long right = (d1 + d2) * 2L - 1;
        return left + sortSearch(right - left, t -> {
            t += left;
            return d1 <= t - t / r1 && d2 <= t - t / r2 && d1 + d2 <= t - t / l;
        });
    }

    private long sortSearch(long n, Function<Long, Boolean> f) {
        long l = 0, r = n;
        while (l < r) {
            long mid = l + (r - l) / 2;
            if (f.apply(mid)) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    private int getLCM(int num1, int num2) {
        return num1 / getGCD(num1, num2) * num2;
    }

    private int getGCD(int num1, int num2) {
        return num1 == 0 ? num2 : getGCD(num2 % num1, num1);
    }
}
/*
3733. 完成所有送货任务的最少时间
https://leetcode.cn/problems/minimum-time-to-complete-all-deliveries/description/

第 474 场周赛 T3。

给你两个大小为 2 的整数数组：d = [d1, d2] 和 r = [r1, r2]。
两架送货无人机负责完成特定数量的送货任务。无人机 i 必须完成 di 次送货。
每次送货花费 正好 一小时，并且在任何给定小时内 只有一架 无人机可以送货。
此外，两架无人机都需要在特定时间间隔进行充电，在此期间它们不能送货。无人机 i 必须每 ri 小时充电一次（即在 ri 的倍数小时进行充电）。
返回完成所有送货所需的 最小 总时间（以小时为单位）的整数。
提示:
d = [d1, d2]
1 <= di <= 10^9
r = [r1, r2]
2 <= ri <= 3 * 10^4

二分答案。
时间复杂度 O(n log(max(r1,r2)) + log(d1+d2))。分别为求 lcm 时间，二分时间。
 */