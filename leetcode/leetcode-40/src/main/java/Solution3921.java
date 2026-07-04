public class Solution3921 {
    public int[] scoreValidator(String[] events) {
        int score = 0;
        int counter = 0;
        for (String s : events) {
            if ("W".equals(s)) {
                counter++;
                if (counter == 10) {
                    break;
                }
            } else if (s.length() > 1) { // "WD" "NB"
                score++;
            } else { // 数字
                score += s.charAt(0) - '0';
            }
        }
        return new int[]{score, counter};
    }
}
/*
3921. 分数验证器
https://leetcode.cn/problems/score-validator/description/

第 182 场双周赛 T1。

给你一个字符串数组 events。
一开始，score = 0 且 counter = 0。events 中的每个元素为以下之一：
- "0", "1", "2", "3", "4", "6"：将该值加到总得分中。
- "W"：计数器加 1。不增加得分。
- "WD"：总得分加 1。
- "NB"：总得分加 1。
从左到右处理数组。当满足以下任一条件时停止处理：
- events 中的所有元素都已处理完毕，或
- 计数器变为 10。
返回一个整数数组 [score, counter]，其中：
- score 是最终的总得分。
- counter 是最终的计数器值。
提示：
1 <= events.length <= 1000
events[i] 是 "0"、"1"、"2"、"3"、"4"、"6"、"W"、"WD" 或 "NB" 之一。

中国时间 2026-05-09 周六 22:30
深圳·雪竹径公园。
模拟。
时间复杂度 O(n)。
 */