import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SolutionP3930 {
    public List<Integer> powerUpdate(int[] nums, int p, int[][] queries) {
        List<Integer> ans = new ArrayList<>();
        Set<Integer> allNums = new HashSet<Integer>();
        for (int num : nums) {
            allNums.add(num);
        }
        for (int[] query : queries) {
            allNums.add(query[0]);
        }
        int m = allNums.size();
        List<Integer> sortedNums = new ArrayList<>(allNums);
        Collections.sort(sortedNums);
        Map<Integer, Integer> valueToIndex = new HashMap<>();
        for (int i = 0; i < m; i++) {
            valueToIndex.put(sortedNums.get(i), i);
        }
        BIT bit = new BIT(m);
        int total = 0;
        for (int num : nums) {
            bit.insert(valueToIndex.get(num));
            total++;
        }
        for (int[] query : queries) {
            int val = query[0], k = query[1];
            bit.insert(valueToIndex.get(val));
            total++;
            int index = bit.kth(total - k + 1);
            int x = sortedNums.get(index);
            p = Math.toIntExact(quickPow(p, x));
            ans.add(p);
        }
        return ans;
    }

    static final int MOD = (int) (1e9 + 7);

    // 快速幂 res = a^b % mod
    private long quickPow(long a, long b) {
        long res = 1L;
        while (b > 0) {
            if ((b & 1) != 0) res = res * a % MOD;
            a = a * a % MOD;
            b >>= 1;
        }
        return res;
    }

    static class BIT {
        int n;
        long[] tree;

        public BIT(int n) {
            this.n = n;
            tree = new long[n + 1];
        }

        int lb(int x) {
            return x & -x;
        }

        void add(int pos, long val) {
            for (; pos <= n; pos += lb(pos)) tree[pos] += val;
        }

        void insert(int pos) {
            add(pos + 1, 1);
        }

        long pre(int pos) {
            long ret = 0;
            for (; pos > 0; pos -= lb(pos)) ret += tree[pos];
            return ret;
        }

        long query(int l, int r) {
            return pre(r) - pre(l - 1);
        }

        int kth(long k) {
            int res = 0;
            for (int b = 1 << 17; b > 0; b >>= 1) {
                int nxt = res | b;
                if (nxt <= n && tree[nxt] < k) {
                    k -= tree[nxt];
                    res = nxt;
                }
            }
            return res;
        }
    }

}
/*
$3930. 插入后第 K 大更新的幂 II
https://leetcode.cn/problems/power-update-after-k-th-largest-insertion-ii/description/

给定一个整数数组 nums 和一个整数 p。
同时给定一个二维整数数组 queries，其中每个 queries[i] = [vali, ki]。
对于每次查询：
- 将 vali 插入到 nums。
- 令 x 为当前 nums 中第 ki 个 最大 的元素。
- 将 p 更新 为 px % (10^9 + 7)。
返回数组 ans，其中 ans[i] 表示在第 i 次查询后 p 的值。
示例 1：
输入：nums = [2], p = 4, queries = [[3,1],[1,2]]
输出：[64,4096]
示例 2：
输入：nums = [7,5], p = 6, queries = [[4,3],[7,2]]
输出：[1296,220296870]
提示：
1 <= nums.length <= 2 * 10^4
1 <= nums[i] <= 10^9
1 <= p <= 10^9
1 <= queries.length <= 2 * 10^4
1 <= vali <= 10^9
1 <= ki <= n + i + 1
 */