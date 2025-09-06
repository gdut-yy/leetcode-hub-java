import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP2254Tests {
    @Test
    public void example1() {
        SolutionP2254.VideoSharingPlatform videoSharingPlatform = new SolutionP2254.VideoSharingPlatform();

        // 最小的可用 videoId 是 0，所以返回 0。
        Assertions.assertEquals(0, videoSharingPlatform.upload("123"));

        // 最小的可用 videoId 是 1，所以返回 1。
        Assertions.assertEquals(1, videoSharingPlatform.upload("456"));

        // 没有与 videoId 4 相关联的视频，所以什么都不做。
        videoSharingPlatform.remove(4);

        // 删除与 videoId 0 关联的视频。
        videoSharingPlatform.remove(0);

        // 由于与 videoId 0 相关联的视频被删除，
        // 0 是最小的可用 videoId，所以返回 0。
        Assertions.assertEquals(0, videoSharingPlatform.upload("789"));

        // 与 videoId 1 关联的视频为 "456"。
        // 从分钟 0 到分钟 min(5,3 - 1)= 2 的视频为 "456"，因此返回 "456"。
        Assertions.assertEquals("456", videoSharingPlatform.watch(1, 0, 5));

        // 与 videoId 1 关联的视频为 "456"。
        // 从分钟 0 到分钟 min(1,3 - 1)= 1 的视频为 "45"，因此返回 "45"。
        Assertions.assertEquals("45", videoSharingPlatform.watch(1, 0, 1));

        // 增加与 videoId 1 相关的视频的点赞数。
        videoSharingPlatform.like(1);

        // 增加与 videoId 1 相关联的视频的不喜欢的数量。
        videoSharingPlatform.dislike(1);

        // 增加与 videoId 1 相关联的视频的不喜欢的数量。
        videoSharingPlatform.dislike(1);

        // 在与 videoId 1 相关的视频中有 1 个喜欢和 2 个不喜欢，因此返回[1,2]。
        Assertions.assertArrayEquals(new int[]{1, 2}, videoSharingPlatform.getLikesAndDislikes(1));

        // 与 videoId 1 相关联的视频有 2 个观看数，因此返回2。
        Assertions.assertEquals(2, videoSharingPlatform.getViews(1));
    }

    @Test
    public void example2() {
        SolutionP2254.VideoSharingPlatform videoSharingPlatform = new SolutionP2254.VideoSharingPlatform();

        // 没有与 videoId 0 相关联的视频，所以什么都不做。
        videoSharingPlatform.remove(0);

        // 没有与 videoId 0 相关联的视频，因此返回 "-1"。
        Assertions.assertEquals("-1", videoSharingPlatform.watch(0, 0, 1));

        // 没有与 videoId 0 相关联的视频，所以什么都不做。
        videoSharingPlatform.like(0);

        // 没有与 videoId 0 相关联的视频，所以什么都不做。
        videoSharingPlatform.dislike(0);

        // 没有与 videoId 0 相关联的视频，因此返回 [-1]。
        Assertions.assertArrayEquals(new int[]{-1}, videoSharingPlatform.getLikesAndDislikes(0));

        // 没有视频与 videoId 0 相关联，因此返回 -1。
        Assertions.assertEquals(-1, videoSharingPlatform.getViews(0));
    }
}