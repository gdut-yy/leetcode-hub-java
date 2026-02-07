public class SolutionP3706 {
    public int maxDistance(String[] words) {
        int ans = 0;
        int n = words.length;
        String first = words[0], last = words[n - 1];
        if (!first.equals(last)) {
            return n;
        }
        for (int i = 1; i <= n - 2; i++) {
            if (!words[i].equals(first)) {
                ans = Math.max(ans, Math.max(i + 1, n - i));
            }
        }
        return ans;
    }
}
/*
$3706. 不同单词间的最大距离 II
https://leetcode.cn/problems/maximum-distance-between-unequal-words-in-array-ii/description/

给你一个字符串数组 words。
找到两个 不同 下标 i 和 j 之间的 最大距离 ，且满足以下条件：
- words[i] != words[j]，并且
- 距离定义为 j - i + 1。
返回所有满足条件的下标对中最大的距离。如果不存在有效的下标对，返回 0。
提示：
1 <= words.length <= 10^5
1 <= words[i].length <= 10
words[i] 由小写英文字母组成。

遍历。
时间复杂度 O(nm)。
 */