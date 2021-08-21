public class Solution338 {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            res[i] = res[i & (i - 1)] + 1;
        }
        return res;
    }
}
/*
338. 比特位计数
https://leetcode-cn.com/problems/counting-bits/

i & (i - 1) 计算 i 的二进制形式中 1 的个数
 */