import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution535Tests {
    @Test
    public void example1() {
        String url = "https://leetcode.com/problems/design-tinyurl";
        Solution535.Codec codec = new Solution535.Codec();
        String tiny = codec.encode(url);
        Assertions.assertNotNull(tiny);
        // 加密后可解密回原 URL
        Assertions.assertEquals(url, codec.decode(tiny));
        // 同一长链接重复加密应得到同一短链接
        Assertions.assertEquals(tiny, codec.encode(url));
    }
}
