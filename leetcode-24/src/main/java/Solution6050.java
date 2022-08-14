public class Solution6050 {
    public String smallestNumber(String pattern) {
        int n = pattern.length();

        char[] chars = new char[n + 1];
        char num = '1';
        int idx = 0;
        while (idx < n) {
            if (idx > 0 && pattern.charAt(idx) == 'I') {
                idx++;
            }
            while (idx < n && pattern.charAt(idx) == 'I') {
                chars[idx] = num++;
                idx++;
            }
            int i0 = idx;
            while (idx < n && pattern.charAt(idx) == 'D') {
                idx++;
            }
            for (int j = idx; j >= i0; j--) {
                chars[j] = num++;
            }
        }
        return new String(chars);
    }
}
/*
6150. 根据模式串构造最小数字
https://leetcode.cn/problems/construct-smallest-number-from-di-string/

第 306 场周赛 T3。

给你下标从 0 开始、长度为 n 的字符串 pattern ，它包含两种字符，'I' 表示 上升 ，'D' 表示 下降 。
你需要构造一个下标从 0 开始长度为 n + 1 的字符串，且它要满足以下条件：
num 包含数字 '1' 到 '9' ，其中每个数字 至多 使用一次。
如果 pattern[i] == 'I' ，那么 num[i] < num[i + 1] 。
如果 pattern[i] == 'D' ，那么 num[i] > num[i + 1] 。
请你返回满足上述条件字典序 最小 的字符串 num。
提示：
1 <= pattern.length <= 8
pattern 只包含字符 'I' 和 'D' 。

IIIDIDDD 看成3段：II | ID | IDDD
II -> 123
ID -> 54
IDDD -> 9876
时间复杂度 O(n)
相似题目: $484. 寻找排列
https://leetcode.cn/problems/find-permutation/
 */