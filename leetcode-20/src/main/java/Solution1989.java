public class Solution1989 {
    public int catchMaximumAmountofPeople(int[] team, int dist) {
        int len = team.length;
        int left = 0;
        int right = 0;
        int res = 0;
        while (right < len) {
            if (team[right] == 1) {
                left = Math.max(left, right - dist);
                while (left < len && left <= right + dist && team[left] == 1) {
                    left++;
                }
                if (left < len && left <= right + dist) {
                    left++;
                    res++;
                }
            }
            right++;
        }
        return res;
    }
}
/*
$1989. Maximum Number of People That Can Be Caught in Tag
https://leetcode.cn/problems/maximum-number-of-people-that-can-be-caught-in-tag/

You are playing a game of tag with your friends. In tag, people are divided into two teams:
people who are "it", and people who are not "it". The people who are "it" want to catch as many people as possible who are not "it".
You are given a 0-indexed integer array team containing only zeros (denoting people who are not "it") and ones (denoting people who are "it"),
and an integer dist. A person who is "it" at index i can catch any one person whose index is in the range [i - dist, i + dist] (inclusive) and is not "it".
Return the maximum number of people that the people who are "it" can catch.
Constraints:
1 <= team.length <= 10^5
0 <= team[i] <= 1
1 <= dist <= team.length

很多 0 找 1。（误
抓人游戏，1 抓 0，每个 1 只能抓 1 个 0，且只能抓以它为中心 [i - dist, i + dist] 范围内的 0，问队伍 1 抓 0 的最优解。
双指针
 */