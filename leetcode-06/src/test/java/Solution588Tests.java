import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution588Tests {
    @Test
    public void example1() {
        Solution588.FileSystem fileSystem = new Solution588.FileSystem();

        // 返回 []
        Assertions.assertEquals(List.of(), fileSystem.ls("/"));

        fileSystem.mkdir("/a/b/c");

        fileSystem.addContentToFile("/a/b/c/d", "hello");

        // 返回 ["a"]
        Assertions.assertEquals(List.of("a"), fileSystem.ls("/"));

        // 返回 "hello"
        Assertions.assertEquals("hello", fileSystem.readContentFromFile("/a/b/c/d"));
    }
}