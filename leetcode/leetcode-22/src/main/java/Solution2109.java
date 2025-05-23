public class Solution2109 {
    public String addSpaces(String s, int[] spaces) {
        int n = spaces.length;
        StringBuilder ans = new StringBuilder();
        ans.append(s, 0, spaces[0]).append(" "); // 也可以加 0 和 s.length() 两个哨兵
        for (int i = 1; i < n; i++) {
            ans.append(s, spaces[i - 1], spaces[i]).append(" ");
        }
        ans.append(s, spaces[n - 1], s.length());
        return ans.toString();
    }
}
/*
2109. 向字符串添加空格
https://leetcode.cn/problems/adding-spaces-to-a-string/

第 272 场周赛 T2。

给你一个下标从 0 开始的字符串 s ，以及一个下标从 0 开始的整数数组 spaces 。
数组 spaces 描述原字符串中需要添加空格的下标。每个空格都应该插入到给定索引处的字符值 之前 。
例如，s = "EnjoyYourCoffee" 且 spaces = [5, 9] ，那么我们需要在 'Y' 和 'C' 之前添加空格，这两个字符分别位于下标 5 和下标 9 。因此，最终得到 "Enjoy Your Coffee" 。
请你添加空格，并返回修改后的字符串。

java 字符串是不可变类型，因此不用考虑在原字符串上插入空格导致下标变化问题，直接新开一个 StringBuilder 模拟即可。
StringBuilder#append(CharSequence s, int start, int end) 等价于 StringBuilder#append(s[start:end])
 */