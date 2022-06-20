public class SfTech220619T3 {
    public int findMaxCI(int[] nums) {
        int len = nums.length;

        int cnt = 0;
        int max = 0;
        int pre = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] > pre) {
                cnt++;
                max = Math.max(max, cnt);
            } else {
                cnt = 0;
            }
            pre = nums[i];
        }
        return max + 1;
    }
}
/*
顺丰03. 收件节节高
https://leetcode.cn/contest/sf-tech/problems/8oimK4/

背景
夏天就来了，天气越来越热了，顺丰小哥收派快递非常辛苦。为了鼓励小哥，我们设置了各种有奖竞赛活动。这其中就有一个叫收件节节高的竞赛，该竞赛比较的是小哥日收件数连续增长的天数，连续增长天数越大排名越高。
问题
小哥人数较多，请帮忙设计一个可以快速算出小哥日收件最大连续增长天数的算法。
输入: 一维数组nums[n]
输出: 连续递增天数长度
示例：
输入：[54,42,62,75,82,86,86]
输出：5
解释:
小哥A最近一周的收件数分别是：54,42,62,75,82,86,86，那么小哥A在这周的日收件最大连续增长天数是5
- 小哥A在这周第2天开始到第6天的日收件数都是在增长
- 第7天与第6天收件数一样，不算增长
提示：
0 <= nums.length < 200000

线性遍历，贪心。
 */