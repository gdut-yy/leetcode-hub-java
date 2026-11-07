import java.util.Arrays;

public class Solution4091 {
    public long countMagicalPairs(String s) {
        int n = s.length();
        int[] size = new int[26];
        for (int i = 0; i < n; i++) {
            size[s.charAt(i) - 'a']++;
        }
        int[][] occ = new int[26][];
        for (int c = 0; c < 26; c++) {
            occ[c] = new int[size[c]];
        }
        int[] fill = new int[26];
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            occ[c][fill[c]++] = i;
        }
        int[] ptr = new int[26];
        for (int c = 0; c < 26; c++) {
            while (ptr[c] < size[c] && occ[c][ptr[c]] < 1) {
                ptr[c]++;
            }
        }
        int[] lastPos = new int[26];
        Arrays.fill(lastPos, -1);
        int[] leftCount = new int[27];
        int[] rightCount = new int[27];
        int[] leftPos = new int[26];
        int[] rightPos = new int[26];

        long ans = 0;
        for (int j = 0; j < n - 1; j++) {
            lastPos[s.charAt(j) - 'a'] = j;
            int leftSize = 0;
            for (int c = 0; c < 26; c++) {
                if (lastPos[c] >= 0) {
                    leftPos[leftSize++] = lastPos[c];
                }
            }
            Arrays.sort(leftPos, 0, leftSize);
            Arrays.fill(leftCount, 0, leftSize + 1, 0);
            for (int d = 1; d <= leftSize; d++) {
                int upper = leftPos[leftSize - d];
                int lower = d < leftSize ? leftPos[leftSize - d - 1] : -1;
                leftCount[d] = upper - lower;
            }
            int rightSize = 0;
            for (int c = 0; c < 26; c++) {
                if (ptr[c] < size[c]) {
                    rightPos[rightSize++] = occ[c][ptr[c]];
                }
            }
            Arrays.sort(rightPos, 0, rightSize);
            Arrays.fill(rightCount, 0, rightSize + 1, 0);
            for (int d = 1; d <= rightSize; d++) {
                int upper = d < rightSize ? rightPos[d] : n;
                rightCount[d] = upper - rightPos[d - 1];
            }
            int maxDistinct = Math.min(leftSize, rightSize);
            for (int d = 1; d <= maxDistinct; d++) {
                ans += (long) leftCount[d] * rightCount[d];
            }
            int c = s.charAt(j + 1) - 'a';
            if (ptr[c] < size[c] && occ[c][ptr[c]] == j + 1) {
                ptr[c]++;
            }
        }
        return ans;
    }
}
/*
4091. 统计神奇子字符串对 II
https://leetcode.cn/problems/count-magical-substring-pairs-ii/description/

第 194 场双周赛 T4。

给你一个长度为 n 且仅由小写英文字母组成的字符串 s。
对于满足 0 <= i <= j < k < n 的每一个下标三元组 (i, j, k)，定义：
- s1 = s[i..j]
- s2 = s[j + 1..k]
如果 s1 中 不同 字符的数量 等于 s2 中 不同 字符的数量，则称这对 子字符串 (s1, s2) 是 神奇 的。
返回满足 (s1, s2) 是 神奇 对的 三元组 (i, j, k) 的数量。
子字符串 是字符串中连续的 非空 字符序列。
示例 1：
输入： s = "aba"
输出： 2
示例 2：
输入： s = "kkk"
输出： 4
示例 3：
输入： s = "abcac"
输出： 7
提示：
2 <= s.length <= 10^5
s 仅由小写英文字母组成。

最近字母位置。
如果要求子数组的最小值恰好等于 minK 且最大值恰好等于 maxK 呢？
相似题目: 2444. 统计定界子数组的数目
https://leetcode.cn/problems/count-subarrays-with-fixed-bounds/
 */