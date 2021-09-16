public class Solution1318 {
    public int minFlips(int a, int b, int c) {
        int ans = 0;
        for (int i = 0; i < 31; ++i) {
            int bit_a = (a >> i) & 1;
            int bit_b = (b >> i) & 1;
            int bit_c = (c >> i) & 1;
            if (bit_c == 0) {
                ans += bit_a + bit_b;
            } else {
                ans += (bit_a + bit_b == 0) ? 1 : 0;
            }
        }
        return ans;
    }
}
/*
1318. 或运算的最小翻转次数
https://leetcode-cn.com/problems/minimum-flips-to-make-a-or-b-equal-to-c/
 */