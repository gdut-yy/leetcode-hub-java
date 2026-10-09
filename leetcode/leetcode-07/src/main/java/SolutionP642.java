import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionP642 {
    static class AutocompleteSystem {
        private final Map<String, Integer> count = new HashMap<>();
        private final StringBuilder current = new StringBuilder();

        public AutocompleteSystem(String[] sentences, int[] times) {
            for (int i = 0; i < sentences.length; i++) {
                count.put(sentences[i], count.getOrDefault(sentences[i], 0) + times[i]);
            }
        }

        public List<String> input(char c) {
            if (c == '#') {
                String sentence = current.toString();
                count.put(sentence, count.getOrDefault(sentence, 0) + 1);
                current.setLength(0);
                return new ArrayList<>();
            }
            current.append(c);
            String prefix = current.toString();
            List<String> matched = new ArrayList<>();
            for (String sentence : count.keySet()) {
                if (sentence.startsWith(prefix)) {
                    matched.add(sentence);
                }
            }
            matched.sort((a, b) -> {
                int byCount = Integer.compare(count.get(b), count.get(a));
                return byCount != 0 ? byCount : a.compareTo(b);
            });
            return matched.size() > 3 ? new ArrayList<>(matched.subList(0, 3)) : matched;
        }
    }
}
/*
$642. 设计搜索自动补全系统
https://leetcode.cn/problems/design-search-autocomplete-system/description/

为搜索引擎设计一个搜索自动补全系统。用户会输入一条语句（最少包含一个字母，以特殊字符 '#' 结尾）。
给定一个字符串数组 sentences 和一个整数数组 times ，长度都为 n ，其中 sentences[i] 是之前输入的句子， times[i] 是该句子输入的相应次数。对于除 ‘#’ 以外的每个输入字符，返回前 3 个历史热门句子，这些句子的前缀与已经输入的句子的部分相同。
下面是详细规则：
- 一条句子的热度定义为历史上用户输入这个句子的总次数。
- 返回前 3 的句子需要按照热度从高到低排序（第一个是最热门的）。如果有多条热度相同的句子，请按照 ASCII 码的顺序输出（ASCII 码越小排名越前）。
- 如果满足条件的句子个数少于 3 ，将它们全部输出。
- 如果输入了特殊字符，意味着句子结束了，请返回一个空集合。
实现 AutocompleteSystem 类：
- AutocompleteSystem(String[] sentences, int[] times): 使用数组sentences 和 times 对对象进行初始化。
- List<String> input(char c) 表示用户输入了字符 c 。
  - 如果 c == '#' ，则返回空数组 [] ，并将输入的语句存储在系统中。
  - 返回前 3 个历史热门句子，这些句子的前缀与已经输入的句子的部分相同。如果少于 3 个匹配项，则全部返回。
示例 1：
输入
["AutocompleteSystem", "input", "input", "input", "input"]
[[["i love you", "island", "iroman", "i love leetcode"], [5, 3, 2, 2]], ["i"], [" "], ["a"], ["#"]]
输出
[null, ["i love you", "island", "i love leetcode"], ["i love you", "i love leetcode"], [], []]
解释
AutocompleteSystem obj = new AutocompleteSystem(["i love you", "island", "iroman", "i love leetcode"], [5, 3, 2, 2]);
obj.input("i"); // 返回 ["i love you", "island", "i love leetcode"]。有四个句子以"i"开头。其中，"ironman"和"i love leetcode"的热度相同。由于空格的 ASCII 码是 32，而 r 的 ASCII 码是 114，所以“i love leetcode”应排在“ironman”前面。同时我们只需要输出前三句热门句子，因此“ironman”会被忽略。
obj.input(" "); // 返回 ["i love you", "i love leetcode"]。只有两个句子以“i ”为前缀。
obj.input("a"); // 返回 []。没有以“i a”为前缀的句子。
obj.input("#"); // 返回 []。用户完成输入，句子 "i a" 应该被保存为系统中的历史句子。接下来的输入将被视为新的搜索。
提示:
n == sentences.length
n == times.length
1 <= n <= 100
1 <= sentences[i].length <= 100
1 <= times[i] <= 50
c 是小写英文字母， '#', 或空格 ' '
每个被测试的句子将是一个以字符 '#' 结尾的字符 c 序列。
每个被测试的句子的长度范围为 [1,200]
每个输入句子中的单词用单个空格隔开。
input 最多被调用 5000 次
 */