import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionP642Tests {
    @Test
    public void example1() {
        String[] sentences = {"i love you", "island", "iroman", "i love leetcode"};
        int[] times = {5, 3, 2, 2};
        SolutionP642.AutocompleteSystem obj = new SolutionP642.AutocompleteSystem(sentences, times);

        // 返回 ["i love you", "island", "i love leetcode"]。有四个句子以"i"开头。其中，"ironman"和"i love leetcode"的热度相同。由于空格的 ASCII 码是 32，而 r 的 ASCII 码是 114，所以“i love leetcode”应排在“ironman”前面。同时我们只需要输出前三句热门句子，因此“ironman”会被忽略。
        Assertions.assertEquals(List.of("i love you", "island", "i love leetcode"), obj.input('i'));

        // 返回 ["i love you", "i love leetcode"]。只有两个句子以“i ”为前缀。
        Assertions.assertEquals(List.of("i love you", "i love leetcode"), obj.input(' '));

        // 返回 []。没有以“i a”为前缀的句子。
        Assertions.assertEquals(List.of(), obj.input('a'));

        // 返回 []。用户完成输入，句子 "i a" 应该被保存为系统中的历史句子。接下来的输入将被视为新的搜索。
        Assertions.assertEquals(List.of(), obj.input('#'));
    }
}
