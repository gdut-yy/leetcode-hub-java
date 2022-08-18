public class Solution1024 {
    public int videoStitching(int[][] clips, int time) {
        // 预处理每个 start 的最长范围
        int[] maxRange = new int[time];
        for (int[] clip : clips) {
            int start = clip[0];
            if (start < time) {
                maxRange[start] = Math.max(maxRange[start], clip[1]);
            }
        }

        // 贪心
        int cnt = 0;
        int pre = 0;
        int last = 0;
        for (int i = 0; i < time; i++) {
            last = Math.max(last, maxRange[i]);
            if (i == last) {
                return -1;
            }
            if (i == pre) {
                pre = last;
                cnt++;
            }
        }
        return cnt;
    }
}
/*
1024. 视频拼接
https://leetcode.cn/problems/video-stitching/

你将会获得一系列视频片段，这些片段来自于一项持续时长为 time 秒的体育赛事。这些片段可能有所重叠，也可能长度不一。
使用数组 clips 描述所有的视频片段，其中 clips[i] = [starti, endi] 表示：某个视频片段开始于 starti 并于 endi 结束。
甚至可以对这些片段自由地再剪辑：
例如，片段 [0, 7] 可以剪切成 [0, 1] + [1, 3] + [3, 7] 三部分。
我们需要将这些片段进行再剪辑，并将剪辑后的内容拼接成覆盖整个运动过程的片段（[0, time]）。返回所需片段的最小数目，如果无法完成该任务，则返回 -1 。
提示：
1 <= clips.length <= 100
0 <= starti <= endi <= 100
1 <= time <= 100

针对每个起点，找到最右端点
每次尽可能找最长的区间延申，以达到所需片段的最小
时间复杂度 O(clips.length + time)
空间复杂度 O(time)
 */