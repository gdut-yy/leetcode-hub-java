public class Offer2Solution3 {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            res[i] = res[i & (i - 1)] + 1;
        }
        return res;
    }
}
/*
剑指 Offer II 003. 前 n 个数字二进制中 1 的个数
https://leetcode-cn.com/problems/w3tCBm/

时间复杂度 O(n)
 */