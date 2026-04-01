import java.util.ArrayList;
import java.util.List;

public class Solution3883 {
    private static final int MOD = (int) (1e9 + 7);
    private static final int MX = 5000;

    private int digitSum(int x) {
        int s = 0;
        while (x > 0) {
            s += x % 10;
            x /= 10;
        }
        return s;
    }

    public int countArrays(int[] digitSum) {
        List<Integer>[] buckets = new ArrayList[51];
        for (int i = 0; i <= 50; ++i) buckets[i] = new ArrayList<>();
        for (int x = 0; x <= MX; ++x) {
            int s = digitSum(x);
            buckets[s].add(x);
        }
        int n = digitSum.length;
        int firstSum = digitSum[0];
        if (buckets[firstSum].isEmpty()) return 0;
        int[] prev = new int[MX + 1];
        for (int x : buckets[firstSum]) {
            prev[x] = 1;
        }

        for (int i = 1; i < n; ++i) {
            int target = digitSum[i];
            List<Integer> curList = buckets[target];
            if (curList.isEmpty()) return 0;

            int[] prefix = new int[MX + 1];
            prefix[0] = prev[0];
            for (int x = 1; x <= MX; ++x) {
                prefix[x] = (prefix[x - 1] + prev[x]) % MOD;
            }
            int[] cur = new int[MX + 1];
            for (int x : curList) {
                cur[x] = prefix[x];
            }
            prev = cur;
        }
        int ans = 0;
        List<Integer> lastList = buckets[digitSum[n - 1]];
        for (int x : lastList) {
            ans = (ans + prev[x]) % MOD;
        }
        return ans;
    }
}
/*
3883. 统计满足数位和数组的非递减数组数目
https://leetcode.cn/problems/count-non-decreasing-arrays-with-given-digit-sums/description/

第 179 场双周赛 T4。

给你一个长度为 n 的整数数组 digitSum。
如果一个长度为 n 的数组 arr 满足以下条件，则认为它是 有效 的：
- 0 <= arr[i] <= 5000
- 它是 非递减 的。
- arr[i] 的 数位和 等于 digitSum[i]。
返回一个整数，表示 不同的有效数组 的数量。由于答案可能很大，请将其对 10^9 + 7 取模后返回。
如果一个数组的每个元素都大于或等于它的前一个元素（如果存在），则称该数组是 非递减 的。
提示：
1 <= digitSum.length <= 1000
0 <= digitSum[i] <= 50

动态规划/前缀和/枚举。
https://chat.deepseek.com/a/chat/s/521c294b-c134-4eb5-bdea-1f655f3d1443
 */