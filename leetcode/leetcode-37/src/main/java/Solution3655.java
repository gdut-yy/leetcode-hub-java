import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3655 {
    private static final int MOD = (int) (1e9 + 7);
    static final int MX = 100000;
    static final long[] INV;

    static {
        INV = new long[MX + 1];
        for (int i = 1; i <= MX; i++) {
            INV[i] = quickPow(i, MOD - 2);
        }
    }

    static long quickPow(long a, long b) {
        long res = 1L;
        while (b > 0) {
            if ((b & 1) != 0) res = res * a % MOD;
            a = a * a % MOD;
            b >>= 1;
        }
        return res;
    }

    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        int q = queries.length;

        long[] totalMul = new long[n];
        Arrays.fill(totalMul, 1);

        int T = (int) Math.sqrt(n);

        List<int[]> bigStep = new ArrayList<>();
        List<int[]> smallStep = new ArrayList<>();
        for (int[] query : queries) {
            if (query[2] > T) {
                bigStep.add(query);
            } else {
                smallStep.add(query);
            }
        }

        for (int[] qry : bigStep) {
            int l = qry[0], r = qry[1], k = qry[2], v = qry[3];
            int idx = l;
            while (idx <= r) {
                totalMul[idx] = (totalMul[idx] * v) % MOD;
                idx += k;
            }
        }

        List<int[]>[] smallByStep = new ArrayList[T + 1];
        for (int i = 1; i <= T; i++) {
            smallByStep[i] = new ArrayList<>();
        }
        for (int[] qry : smallStep) {
            int k = qry[2];
            if (k <= T) {
                smallByStep[k].add(qry);
            }
        }

        for (int k = 1; k <= T; k++) {
            List<int[]> qList = smallByStep[k];
            if (qList.isEmpty()) continue;

            for (int r = 0; r < k; r++) {
                int size = (n - 1 - r) / k + 1;
                if (size <= 0) continue;

                long[] diff = new long[size];
                Arrays.fill(diff, 1);

                for (int[] qry : qList) {
                    int li = qry[0], ri = qry[1], vVal = qry[3];
                    if (li % k != r) continue;

                    int L_index = (li - r) / k;
                    int R_index = (ri - r) / k;
                    if (L_index >= size) continue;
                    if (R_index >= size) R_index = size - 1;
                    if (R_index < L_index) continue;

                    diff[L_index] = (diff[L_index] * vVal) % MOD;
                    if (R_index + 1 < size) {
                        diff[R_index + 1] = (diff[R_index + 1] * INV[vVal]) % MOD;
                    }
                }

                long cur = 1;
                for (int i = 0; i < size; i++) {
                    cur = (cur * diff[i]) % MOD;
                    int idx0 = r + i * k;
                    totalMul[idx0] = (totalMul[idx0] * cur) % MOD;
                }
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            long val = (long) nums[i] * totalMul[i] % MOD;
            nums[i] = (int) val;
            res ^= nums[i];
        }
        return res;
    }
}
/*
3655. 区间乘法查询后的异或 II
https://leetcode.cn/problems/xor-after-range-multiplication-queries-ii/description/

第 463 场周赛 T4。

给你一个长度为 n 的整数数组 nums 和一个大小为 q 的二维整数数组 queries，其中 queries[i] = [li, ri, ki, vi]。
对于每个查询，需要按以下步骤依次执行操作：
- 设定 idx = li。
- 当 idx <= ri 时：
  - 更新：nums[idx] = (nums[idx] * vi) % (10^9 + 7)。
  - 将 idx += ki。
在处理完所有查询后，返回数组 nums 中所有元素的 按位异或 结果。
提示：
1 <= n == nums.length <= 10^5
1 <= nums[i] <= 10^9
1 <= q == queries.length <= 10^5
queries[i] = [li, ri, ki, vi]
0 <= li <= ri < n
1 <= ki <= n
1 <= vi <= 10^5

根号分解算法
https://chat.deepseek.com/a/chat/s/d9048532-726c-4883-bbc1-b9ff25256029
时间复杂度 O(n*sqrt(q) + qlogM)。
rating 2450 (clist.by)
 */