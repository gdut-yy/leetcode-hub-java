public class Solution3849 {
    public String maximumXor(String s, String t) {
        int cnt_t1 = 0;
        for (char ch : t.toCharArray()) {
            cnt_t1 += ch - '0';
        }
        int[] left = new int[]{t.length() - cnt_t1, cnt_t1}; // t 中剩余的 0 和 1 的个数

        char[] ans = s.toCharArray();
        for (int i = 0; i < ans.length; i++) {
            int x = ans[i] - '0';
            // 如果 x 是 0，那就看还有没有剩下的 1
            // 如果 x 是 1，那就看还有没有剩下的 0
            if (left[x ^ 1] > 0) {
                left[x ^ 1]--;
                ans[i] = '1'; // x ^ (x ^ 1) = 1
            } else { // 只能让两个相同的数异或
                left[x]--;
                ans[i] = '0'; // x ^ x = 0
            }
        }
        return new String(ans);
    }
}
/*
3849. 重新排列后的最大按位异或值
https://leetcode.cn/problems/maximum-bitwise-xor-after-rearrangement/description/

第 490 场周赛 T3。

给你两个长度均为 n 的二进制字符串 s 和 t。
你可以按任意顺序 重新排列 t 中的字符，但 s 必须保持不变。
返回一个长度为 n 的 二进制字符串，表示将 s 与重新排列后的 t 进行按位 异或 (XOR) 运算所能获得的 最大 整数值。
提示:
1 <= n == s.length == t.length <= 2 * 10^5
s[i] 和 t[i] 不是 '0' 就是 '1'。

贪心。
时间复杂度 O(n)。
 */