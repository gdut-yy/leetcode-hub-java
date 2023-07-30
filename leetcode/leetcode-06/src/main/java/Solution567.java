import java.util.Arrays;

public class Solution567 {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();

        // 特判
        if (len2 < len1) {
            return false;
        }

        // 统计长为 len1 的子串的字符频次
        int[] cntArr1 = new int[26];
        int[] cntArr2 = new int[26];
        for (int i = 0; i < len1; i++) {
            int idx1 = s1.charAt(i) - 'a';
            int idx2 = s2.charAt(i) - 'a';
            cntArr1[idx1]++;
            cntArr2[idx2]++;
        }
        if (Arrays.equals(cntArr1, cntArr2)) {
            return true;
        }

        // 滑动窗口-窗口大小固定为 s1.length() 注意是 <=
        for (int i = 1; i - 1 + len1 < len2; i++) {
            // 窗口往右移动 map 中加一个字符，减一个字符
            int addIdx = s2.charAt(i - 1 + len1) - 'a';
            int rmIdx = s2.charAt(i - 1) - 'a';
            cntArr2[addIdx]++;
            cntArr2[rmIdx]--;
            if (Arrays.equals(cntArr1, cntArr2)) {
                return true;
            }
        }
        return false;
    }
}
/*
567. 字符串的排列
https://leetcode.cn/problems/permutation-in-string/

给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
换句话说，s1 的排列之一是 s2 的 子串 。
提示：
1 <= s1.length, s2.length <= 10^4
s1 和 s2 仅包含小写字母

滑动窗口-固定窗口。由于是固定窗口，所以可以不用双指针，只用一个指针就 ok
相似题目: 438. 找到字符串中所有字母异位词
https://leetcode.cn/problems/find-all-anagrams-in-a-string/
 */