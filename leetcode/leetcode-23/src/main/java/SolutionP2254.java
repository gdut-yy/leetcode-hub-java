import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SolutionP2254 {
    static class VideoSharingPlatform {
        PriorityQueue<Integer> idPool = new PriorityQueue<>();
        Map<Integer, Video> videoById = new HashMap<>();

        public VideoSharingPlatform() {
        }

        public int upload(String video) {
            if (idPool.isEmpty()) idPool.add(videoById.size());
            int id = idPool.poll();
            videoById.put(id, new Video(video));
            return id;
        }

        public void remove(int videoId) {
            if (videoById.containsKey(videoId)) {
                videoById.remove(videoId);
                idPool.add(videoId);
            }
        }

        public String watch(int videoId, int startMinute, int endMinute) {
            if (!videoById.containsKey(videoId)) return "-1";
            Video video = videoById.get(videoId);
            video.view += 1;
            String content = video.content;
            return content.substring(startMinute, Math.min(endMinute + 1, content.length()));
        }

        public void like(int videoId) {
            if (videoById.containsKey(videoId)) {
                videoById.get(videoId).like += 1;
            }
        }

        public void dislike(int videoId) {
            if (videoById.containsKey(videoId)) {
                videoById.get(videoId).dislike += 1;
            }
        }

        public int[] getLikesAndDislikes(int videoId) {
            if (!videoById.containsKey(videoId)) return new int[]{-1};
            Video video = videoById.get(videoId);
            return new int[]{video.like, video.dislike};
        }

        public int getViews(int videoId) {
            if (!videoById.containsKey(videoId)) return -1;
            return videoById.get(videoId).view;
        }

        static class Video {
            String content;
            int id, view, like, dislike;

            public Video(String content) {
                this.content = content;
            }
        }
    }
}
/*
$2254. 设计视频共享平台
https://leetcode.cn/problems/design-video-sharing-platform/description/

你有一个视频分享平台，用户可以上传和删除视频。每个 video 都是 字符串 类型的数字，其中字符串的第 i 位表示视频中第 i 分钟的内容。例如，第一个数字表示视频中第 0 分钟的内容，第二个数字表示视频中第 1 分钟的内容，以此类推。视频的观众也可以喜欢和不喜欢视频。该平台会跟踪每个视频的 观看次数、点赞次数 和 不喜欢次数。
当视频上传时，它与最小可用整数 videoId 相关联，videoId 从 0 开始的。一旦一个视频被删除，与该视频关联的 videoId 就可以用于另一个视频。
实现 VideoSharingPlatform 类:
- VideoSharingPlatform() 初始化对象。
- int upload(String video) 用户上传一个 video. 返回与视频相关联的videoId 。
- void remove(int videoId) 如果存在与 videoId 相关联的视频，则删除该视频。
- String watch(int videoId, int startMinute, int endMinute) 如果有一个视频与 videoId 相关联，则将该视频的观看次数增加 1，并返回视频字符串的子字符串，从 startMinute 开始，以 min(endMinute, video.length - 1)(含边界) 结束。否则，返回 "-1"。
- void like(int videoId) 如果存在与 videoId 相关联的视频，则将与 videoId 相关联的视频的点赞数增加 1。
- void dislike(int videoId) 如果存在与 videoId 相关联的视频，则将与 videoId 相关联的视频上的不喜欢次数增加 1。
- int[] getLikesAndDislikes(int videoId) 返回一个长度为 2 ，下标从 0 开始 的整型数组，其中 values[0] 是与 videoId 相关联的视频上的点赞数，values[1] 是不喜欢数。如果没有与 videoId 相关联的视频，则返回 [-1]。
- int getViews(int videoId) 返回与 videoId 相关联的视频的观看次数，如果没有与 videoId 相关联的视频，返回 -1。
提示:
1 <= video.length <= 10^5
调用 upload 时所有 video.length 的总和不会超过 10^5
video 由数字组成
0 <= videoId <= 10^5
0 <= startMinute < endMinute < 10^5
startMinute < video.length
调用  watch 时所有 endMinute - startMinute 的总和不会超过 10^5。
所有函数 总共 最多调用 10^5 次。

哈希表模拟 + 优先队列
 */