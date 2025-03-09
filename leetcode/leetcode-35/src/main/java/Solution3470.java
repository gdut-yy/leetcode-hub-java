import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3470 {
    // 预处理交替排列的方案数
    private static final List<Long> F = new ArrayList<>();

    static {
        F.add(1L);
        for (int i = 1; F.getLast() < 1e15; i++) {
            F.add(F.getLast() * i);
            F.add(F.getLast() * i);
        }
    }

    public int[] permute(int n, long k) {
        // k 改成从 0 开始，方便计算
        k--;
        if (n < F.size() && k >= F.get(n) * (2 - n % 2)) { // n 是偶数的时候，方案数乘以 2
            return new int[0];
        }

        // cand 表示剩余未填入 ans 的数字
        // cand[0] 保存偶数，cand[1] 保存奇数
        List<Integer>[] cand = new ArrayList[2];
        Arrays.setAll(cand, e -> new ArrayList<>());
        for (int i = 1; i <= n; i++) {
            cand[i % 2].add(i);
        }

        int[] ans = new int[n];
        int parity = 1; // 当前要填入 ans[i] 的数的奇偶性
        for (int i = 0; i < n; i++) {
            int j = 0;
            if (n - 1 - i < F.size()) {
                // 比如示例 1，按照第一个数分组，每一组的大小都是 size=2
                // 知道 k 和 size 就知道我们要去哪一组
                long size = F.get(n - 1 - i);
                j = (int) (k / size); // 去第 j 组
                k %= size;
                // n 是偶数的情况，第一个数既可以填奇数又可以填偶数，要特殊处理
                if (n % 2 == 0 && i == 0) {
                    parity = 1 - j % 2;
                    j /= 2;
                }
            } // else j=0，在 n 很大的情况下，只能按照 1,2,3,... 的顺序填
            ans[i] = cand[parity].remove(j);
            parity ^= 1; // 下一个数的奇偶性
        }
        return ans;
    }
}
/*
3470. 全排列 IV
https://leetcode.cn/problems/permutations-iv/description/

第 151 场双周赛 T4。

给你两个整数 n 和 k，一个 交替排列 是前 n 个正整数的排列，且任意相邻 两个 元素不都为奇数或都为偶数。
返回第 k 个 交替排列 ，并按 字典序 排序。如果有效的 交替排列 少于 k 个，则返回一个空列表。
提示：
1 <= n <= 100
1 <= k <= 10^15

从左往右构造。
时间复杂度 O(n^2)。
相似题目: 60. 排列序列
https://leetcode.cn/problems/permutation-sequence/
rating 2496 (clist.by)
 */