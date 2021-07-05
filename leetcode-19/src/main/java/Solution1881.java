public class Solution1881 {
    public String maxValue(String n, int x) {
        // 负数
        if (n.charAt(0) == '-') {
            return "-" + caseNegative(n.substring(1), x);
        }
        // 正数
        return casePositive(n, x);
    }

    private String casePositive(String n, int x) {
        char[] chars = n.toCharArray();
        int len = chars.length;
        for (int i = 0; i < len; i++) {
            // 从左往右，如果大于后一个数，就置于其前
            if (x > chars[i] - '0') {
                return n.substring(0, i) + x + n.substring(i);
            }
        }
        // 如果均不符合，置于末位
        return n + x;
    }

    private String caseNegative(String n, int x) {
        char[] chars = n.toCharArray();
        int len = chars.length;
        for (int i = 0; i < len; i++) {
            // 从左往右，如果小于后一个数，就置于其前
            if (x < chars[i] - '0') {
                return n.substring(0, i) + x + n.substring(i);
            }
        }
        // 如果均不符合，置于末位
        return n + x;
    }
}
/*
1881. 插入后的最大值
https://leetcode-cn.com/problems/maximum-value-after-insertion/

题目给出一个大整数，问如何通过插入一个数字后达到数值最大化。
对于正数。不难想到：从左往右，如果大于后一个数，就置于其前即可；
负数同理：从左往右，如果小于后一个数，就置于其前即可。
 */
