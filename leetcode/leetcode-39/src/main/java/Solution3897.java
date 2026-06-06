import java.util.Arrays;

public class Solution3897 {
    private static final int MOD = (int) (1e9 + 7);

    public int maxValue(int[] nums1, int[] nums0) {
        int n = nums1.length;
        Integer[] ids = new Integer[n];
        for (int i = 0; i < n; i++) ids[i] = i;

        Arrays.sort(ids, (i, j) -> {
            int a1 = nums1[i], a0 = nums0[i];
            int b1 = nums1[j], b0 = nums0[j];
            int lenA = a1 + a0;
            int lenB = b1 + b0;
            int lim = lenA + lenB;
            for (int k = 0; k < lim; k++) {
                int ca, cb;
                if (k < a1) {
                    ca = 1;
                } else if (k < a1 + a0) {
                    ca = 0;
                } else if (k < a1 + a0 + b1) {
                    ca = 1;
                } else {
                    ca = 0;
                }
                if (k < b1) {
                    cb = 1;
                } else if (k < b1 + b0) {
                    cb = 0;
                } else if (k < b1 + b0 + a1) {
                    cb = 1;
                } else {
                    cb = 0;
                }
                if (ca != cb) {
                    return cb - ca;
                }
            }
            return 0;
        });

        long ans = 0;
        for (int i : ids) {
            int ones = nums1[i];
            int zeros = nums0[i];
            for (int k = 0; k < ones; k++) {
                ans = ((ans << 1) + 1) % MOD;
            }
            for (int k = 0; k < zeros; k++) {
                ans = (ans << 1) % MOD;
            }
        }
        return (int) ans;
    }
}
/*
3897. 连接二进制片段得到的最大值
https://leetcode.cn/problems/maximum-value-of-concatenated-binary-segments/description/

第 180 场双周赛 T4。

给你两个整数数组 nums1 和 nums0，每个数组的大小均为 n。
- nums1[i] 表示第 i 个片段中 '1' 的数量。
- nums0[i] 表示第 i 个片段中 '0' 的数量。
对于每个下标 i，构造一个由以下组成的二进制片段：
- nums1[i] 个 '1'，后跟
- nums0[i] 个 '0'。
你可以以任何方式 重新排列 这些 片段 的先后顺序。重新排列后，将所有片段 连接 起来形成一个单一的二进制字符串。
返回连接后的二进制字符串可能表示的 最大 整数值。
由于结果可能非常大，请返回对 10^9 + 7 取余 后的结果。
提示：
1 <= n == nums1.length == nums0.length <= 10^5
0 <= nums1[i], nums0[i] <= 10^4
nums1[i] + nums0[i] > 0
nums1 和 nums0 中所有元素的总和不超过 2 * 10^5。

https://chat.deepseek.com/a/chat/s/76d940f7-011c-47e3-9cfc-51906ba809f9
相似题目: 179. 最大数
https://leetcode.cn/problems/largest-number/
 */