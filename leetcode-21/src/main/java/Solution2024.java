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
https://leetcode-cn.com/problems/maximize-the-confusion-of-an-exam/

给你一个字符串 answerKey ，其中 answerKey[i] 是第 i 个问题的正确结果。除此以外，还给你一个整数 k ，表示你能进行以下操作的最多次数：
每次操作中，将问题的正确答案改为 'T' 或者 'F' （也就是将 answerKey[i] 改为 'T' 或者 'F' ）。
请你返回在不超过 k 次操作的情况下，最大 连续 'T' 或者 'F' 的数目。

第 62 场双周赛 T3。

相似题目: 1004. 最大连续1的个数 III
 */