public class Solution1358 {
    public int numberOfSubstrings(String s) {
        int len = s.length();

        int[] cntArr = new int[3];
        int res = 0;
        // 双指针
        int left = 0;
        int right = 0;
        while (right < len) {
            int rIdx = s.charAt(right) - 'a';
            cntArr[rIdx] += 1;
            right++;

            while (cntArr[0] > 0 && cntArr[1] > 0 && cntArr[2] > 0) {
                res += len - right + 1;
                int lIdx = s.charAt(left) - 'a';
                cntArr[lIdx] -= 1;
                left++;
            }
        }
        return res;
    }
}
/*
1358. 包含所有三种字符的子字符串数目
https://leetcode.cn/problems/number-of-substrings-containing-all-three-characters/

给你一个字符串 s ，它只包含三种字符 a, b 和 c 。
请你返回 a，b 和 c 都 至少 出现过一次的子字符串数目。
提示：
3 <= s.length <= 5 x 10^4
s 只包含字符 a，b 和 c 。

双指针。
时间复杂度 O(n)
 */