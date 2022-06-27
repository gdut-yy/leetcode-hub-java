public class Solution1946 {
    public String maximumNumber(String num, int[] change) {
        // 双指针
        int left = 0;
        for (int i = 0; i < num.length(); i++) {
            int cur = num.charAt(i) - '0';
            if (change[cur] > cur) {
                left = i;
                break;
            }
        }
        StringBuilder stringBuilder = new StringBuilder(num.substring(0, left));
        int right = left;
        while (right < num.length() && change[num.charAt(right) - '0'] >= num.charAt(right) - '0') {
            stringBuilder.append(change[num.charAt(right) - '0']);
            right++;
        }
        stringBuilder.append(num.substring(right));
        return stringBuilder.toString();
    }
}
/*
1946. 子字符串突变后可能得到的最大整数
https://leetcode.cn/problems/largest-number-after-mutating-substring/

第 251 场周赛 T2。

给你一个字符串 num ，该字符串表示一个大整数。另给你一个长度为 10 且 下标从 0  开始 的整数数组 change ，该数组将 0-9 中的每个数字映射到另一个数字。
更规范的说法是，数字 d 映射为数字 change[d] 。
你可以选择 突变  num 的任一子字符串。突变 子字符串意味着将每位数字 num[i] 替换为该数字在 change 中的映射（也就是说，将 num[i] 替换为 change[num[i]]）。
请你找出在对 num 的任一子字符串执行突变操作（也可以不执行）后，可能得到的 最大整数 ，并用字符串表示返回。
子字符串 是字符串中的一个连续序列。

双指针。其实单指针亦可。
先找到 change 数组中开始大于 num[i] 的下标，然后取一个区间进行替换即是可能得到的最大整数
 */