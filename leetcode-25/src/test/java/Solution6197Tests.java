import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6197Tests {
    @Test
    public void example1() {
        // 初始化 4个视频的上传流
        Solution6197.LUPrefix server = new Solution6197.LUPrefix(4);

        // 上传视频 3 。
        server.upload(3);

        // 由于视频 1 还没有被上传，最长上传前缀是 0 。
        Assertions.assertEquals(0, server.longest());

        // 上传视频 1 。
        server.upload(1);

        // 前缀 [1] 是最长上传前缀，所以我们返回 1 。
        Assertions.assertEquals(1, server.longest());

        // 上传视频 2 。
        server.upload(2);

        // 前缀 [1,2,3] 是最长上传前缀，所以我们返回 3 。
        Assertions.assertEquals(3, server.longest());
    }
}
