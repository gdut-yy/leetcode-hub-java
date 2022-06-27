public class Solution2217 {
    public long[] kthPalindrome(int[] queries, int intLength) {
        // “回文根” 长度
        int rootLen = (intLength + 1) / 2;
        int rootMin = (int) Math.pow(10, rootLen - 1);
        int rootMax = rootMin * 10 - 1;

        int len = queries.length;
        long[] res = new long[len];
        for (int i = 0; i < len; i++) {
            int newGen = rootMin + queries[i] - 1;
            if (newGen <= rootMax) {
                String newGenStr = String.valueOf(newGen);
                if (rootLen * 2 > intLength) {
                    String pre = newGenStr.substring(0, rootLen - 1);
                    String suf = new StringBuilder(newGenStr).reverse().toString();
                    res[i] = Long.parseLong(pre + suf);
                } else {
                    String suf = new StringBuilder(newGenStr).reverse().toString();
                    res[i] = Long.parseLong(newGenStr + suf);
                }
            } else {
                res[i] = -1;
            }
        }
        return res;
    }
}
/*
2217. 找到指定长度的回文数
https://leetcode.cn/problems/find-palindrome-with-fixed-length/

第 286 场周赛 T3。

给你一个整数数组 queries 和一个 正 整数 intLength ，请你返回一个数组 answer ，
其中 answer[i] 是长度为 intLength 的 正回文数 中第 queries[i] 小的数字，如果不存在这样的回文数，则为 -1 。
回文数 指的是从前往后和从后往前读一模一样的数字。回文数不能有前导 0 。
提示：
1 <= queries.length <= 5 * 10^4
1 <= queries[i] <= 10^9
1 <= intLength <= 15

打表？intLength <= 15 显然打不了表，考虑 “回文根”
相似题目: 866. 回文素数
https://leetcode.cn/problems/prime-palindrome/
 */
