public class Solution3747 {
    public long countDistinct(long n) {
        String s = String.valueOf(n);
        int L = s.length();
        long totalLess = 0;
        for (int i = 1; i < L; i++) {
            totalLess += pow9(i);
        }
        long ansEqual = 0;
        boolean complete = true;
        for (int i = 0; i < L; i++) {
            int d = s.charAt(i) - '0';
            if (d == 0) {
                complete = false;
                break;
            }
            if (d > 1) {
                ansEqual += (d - 1) * pow9(L - i - 1);
            }
        }
        if (complete) {
            ansEqual += 1;
        }
        return totalLess + ansEqual;
    }

    private long pow9(int exp) {
        long res = 1;
        for (int i = 0; i < exp; i++) {
            res *= 9;
        }
        return res;
    }
}
/*
3747. 统计移除零后不同整数的数目
https://leetcode.cn/problems/count-distinct-integers-after-removing-zeros/description/

第 476 场周赛 T3。

给你一个 正 整数 n。
对于从 1 到 n 的每个整数 x，我们记下通过移除 x 的十进制表示中的所有零而得到的整数。
返回一个整数，表示记下的 不同 整数的数量。
提示：
1 <= n <= 10^15

问题转化为统计所有由1到9组成的数字中，小于等于n的数字的个数。这些数字即为移除零后可能得到的不同结果。
位数少于n的数字：所有由1到9组成的、位数少于n的数字都小于n，直接计算其总数。
位数等于n的数字：使用数位动态规划的思想，逐位处理n的每一位，计算所有由1到9组成的、小于等于n的数字的个数。
https://yuanbao.tencent.com/chat/naQivTmsDa/170f605d-48f3-479a-aaa4-aa3171525f9f
 */