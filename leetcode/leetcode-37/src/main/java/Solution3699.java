public class Solution3699 {
    private static final int MOD = (int) (1e9 + 7);

    public int zigZagArrays(int n, int l, int r) {
        int len = r - l + 1;
        if (len <= 0) {
            return 0;
        }

        int[] pre0 = new int[len];
        int[] pre1 = new int[len];

        for (int i = 0; i < len; i++) {
            int j = l + i;
            pre0[i] = r - j;
            pre1[i] = j - l;
        }

        if (n == 2) {
            int ans = 0;
            for (int i = 0; i < len; i++) {
                ans = (ans + pre0[i]) % MOD;
                ans = (ans + pre1[i]) % MOD;
            }
            return ans;
        }

        for (int i = 3; i <= n; i++) {
            int[] sum1 = new int[len];
            sum1[0] = pre1[0] % MOD;
            for (int j = 1; j < len; j++) {
                sum1[j] = (sum1[j - 1] + pre1[j]) % MOD;
            }

            int[] sum0 = new int[len];
            sum0[0] = pre0[0] % MOD;
            for (int j = 1; j < len; j++) {
                sum0[j] = (sum0[j - 1] + pre0[j]) % MOD;
            }

            int[] cur0 = new int[len];
            int[] cur1 = new int[len];

            for (int idx = 0; idx < len; idx++) {
                if (idx < len - 1) {
                    cur0[idx] = (sum1[len - 1] - sum1[idx] + MOD) % MOD;
                } else {
                    cur0[idx] = 0;
                }

                if (idx > 0) {
                    cur1[idx] = sum0[idx - 1];
                } else {
                    cur1[idx] = 0;
                }
            }

            pre0 = cur0;
            pre1 = cur1;
        }

        int ans = 0;
        for (int i = 0; i < len; i++) {
            ans = (ans + pre0[i]) % MOD;
            ans = (ans + pre1[i]) % MOD;
        }
        return ans;
    }
}
/*
3699. 锯齿形数组的总数 I
https://leetcode.cn/problems/number-of-zigzag-arrays-i/description/

第 469 场周赛 T3。

给你 三个整数 n、l 和 r。
长度为 n 的锯齿形数组定义如下：
- 每个元素的取值范围为 [l, r]。
- 任意 两个 相邻的元素都不相等。
- 任意 三个 连续的元素不能构成一个 严格递增 或 严格递减 的序列。
返回满足条件的锯齿形数组的总数。
由于答案可能很大，请将结果对 10^9 + 7 取余数。
序列 被称为 严格递增 需要满足：当且仅当每个元素都严格大于它的前一个元素（如果存在）。
序列 被称为 严格递减 需要满足，当且仅当每个元素都严格小于它的前一个元素（如果存在）。
提示：
3 <= n <= 2000
1 <= l < r <= 2000

1.动态规划状态定义：使用两个数组pre0和pre1，其中pre0[j]表示以数字j结尾且最后两个元素递减的数组数量，pre1[j]表示以数字j结尾且最后两个元素递增的数组数量。
2.初始化：对于长度为2的数组，初始化pre0和pre1。pre0[j]表示第一个数字大于j的数量，pre1[j]表示第一个数字小于j的数量。
3.状态转移：对于长度从3到n的数组，使用前缀和优化状态转移：
cur0[j]（递减结束）是所有大于j的数字对应的pre1[k]的和。
cur1[j]（递增结束）是所有小于j的数字对应的pre0[k]的和。
4.结果计算：最终结果是所有以[l, r]范围内数字结尾的pre0和pre1值的总和。
时间复杂度 O((r-l) * n)。
https://yuanbao.tencent.com/chat/naQivTmsDa/e0201c91-6e09-4ddc-aa39-b7260d3f34ea
 */