import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution271Tests {
    @Test
    public void example1() {
        Solution271.Codec codec = new Solution271.Codec();
        List<String> strs = new ArrayList<>(List.of("", ""));
        String encode = codec.encode(strs);
        List<String> actual = codec.decode(encode);
        List<String> expected = new ArrayList<>(List.of("", ""));
        Assertions.assertEquals(expected, actual);
    }
}
