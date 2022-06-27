public class Solution2024 {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int len = answerKey.length();
        char[] chars = answerKey.toCharArray();
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = (chars[i] == 'T') ? 1 : 0;
        }
        int longestT = longestOnes(nums, k);
        for (int i = 0; i < len; i++) {
            nums[i] = (chars[i] == 'F') ? 1 : 0;
        }
        int longestF = longestOnes(nums, k);
        return Math.max(longestT, longestF);
    }

    private int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int left = 0;
        int leftSum = 0;
        int rightSum = 0;
        int ans = 0;
        for (int right = 0; right < n; right++) {
            rightSum += 1 - nums[right];
            while (leftSum < rightSum - k) {
                leftSum += 1 - nums[left];
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
/*
2024. 考试的最大困扰度
https://leetcode.cn/problems/maximize-the-confusion-of-an-exam/

第 62 场双周赛 T3。

一位老师正在出一场由 n 道判断题构成的考试，每道题的答案为 true （用 'T' 表示）或者 false （用 'F' 表示）。
老师想增加学生对自己做出答案的不确定性，方法是 最大化 有 连续相同 结果的题数。（也就是连续出现 true 或者连续出现 false）。
给你一个字符串 answerKey ，其中 answerKey[i] 是第 i 个问题的正确结果。除此以外，还给你一个整数 k ，表示你能进行以下操作的最多次数：
- 每次操作中，将问题的正确答案改为 'T' 或者 'F' （也就是将 answerKey[i] 改为 'T' 或者 'F' ）。
请你返回在不超过 k 次操作的情况下，最大 连续 'T' 或者 'F' 的数目。
提示：
n == answerKey.length
1 <= n <= 5 * 10^4
answerKey[i] 要么是 'T' ，要么是 'F'
1 <= k <= n

滑动窗口。
时间复杂度 O(n)
空间复杂度 O(1)
相似题目: 1004. 最大连续1的个数 III
https://leetcode.cn/problems/max-consecutive-ones-iii/
 */