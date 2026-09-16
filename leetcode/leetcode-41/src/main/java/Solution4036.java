public class Solution4036 {
    public String[] largestString(int[] nums) {
        int n = nums.length;
        int MX = 1 << 25;
        String[] ans = new String[n];
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int x = nums[i];
            while (x >= MX) {
                sb.append('z');
                x -= MX;
            }
            while (x > 0) {
                int k = 31 - Integer.numberOfLeadingZeros(x);
                sb.append((char) ('a' + k));
                x -= 1 << k;
            }
            ans[i] = sb.toString();
        }
        return ans;
    }
}
/*
4036. 字符对转换后字典序最大的字符串
https://leetcode.cn/problems/lexicographically-largest-string-after-pair-transformations/description/

第 190 场双周赛 T3。

给你一个整数数组 nums。
对于 nums 中的每个整数 x，首先生成一个由 x 个小写字母 'a' 组成的字符串。
你可以执行以下操作任意次（包括零次）：
- 选择两个 相邻且相同 的字母，并将它们替换为字母表中的下一个字母。
例如，"aa" 可以替换为 "b"，"bb" 可以替换为 "c"。对 "zz" 则无法进行替换。
对于每个 x，请你确定可以获得的 字典序最大 的字符串。
返回一个字符串数组，其中第 i 个字符串是 nums[i] 的答案。
在两个字符串不同处的第一个位置，如果字符串 a 包含的字母在字母表中的顺序晚于 b 中的相应字母，则字符串 a 字典序大于 字符串 b。如果前 min(a.length, b.length) 个字符相同，则较长的字符串字典序更大。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^8

位运算。
 */