import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution269 {
    public String alienOrder(String[] words) {
        // 1 <= words.length <= 100
        // 1 <= words[i].length <= 100
        // 拓扑排序
        Map<Character, Set<Character>> outGraph = new HashMap<>();
        Map<Character, Set<Character>> inGraph = new HashMap<>();
        for (int i = 1; i < words.length; i++) {
            String preWord = words[i - 1];
            String curWord = words[i];
            // 字符串 s 字典顺序小于 字符串 t
            // t 不能为 s 的前缀
            if (preWord.startsWith(curWord) && !preWord.equals(curWord)) {
                return "";
            }
            for (int j = 0; j < preWord.length() && j < curWord.length(); ) {
                if (preWord.charAt(j) == curWord.charAt(j)) {
                    j++;
                } else {
                    char preCh = preWord.charAt(j);
                    char curCh = curWord.charAt(j);

                    Set<Character> outSet = outGraph.getOrDefault(preCh, new HashSet<>());
                    outSet.add(curCh);
                    outGraph.put(preCh, outSet);

                    Set<Character> inSet = inGraph.getOrDefault(curCh, new HashSet<>());
                    inSet.add(preCh);
                    inGraph.put(curCh, inSet);
                    break;
                }
            }
        }
        // 记录 words 出现过的字母
        Set<Character> seenChar = new HashSet<>();
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                seenChar.add(ch);
            }
        }

        // 入度为 0 进队列
        Queue<Character> queue = new LinkedList<>();
        for (char ch : seenChar) {
            if (inGraph.getOrDefault(ch, new HashSet<>()).size() == 0) {
                queue.add(ch);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                char cur = queue.remove();
                stringBuilder.append(cur);
                for (char nextCh : outGraph.getOrDefault(cur, new HashSet<>())) {
                    inGraph.get(nextCh).remove(cur);
                    if (inGraph.get(nextCh).size() == 0) {
                        queue.add(nextCh);
                    }
                }
            }
        }
        if (stringBuilder.length() == seenChar.size()) {
            return stringBuilder.toString();
        }
        return "";
    }
}
/*
$269. 火星词典
https://leetcode-cn.com/problems/alien-dictionary/

现有一种使用英语字母的火星语言，这门语言的字母顺序与英语顺序不同。
给你一个字符串列表 words ，作为这门语言的词典，words 中的字符串已经 按这门新语言的字母顺序进行了排序 。
请你根据该词典还原出此语言中已知的字母顺序，并 按字母递增顺序 排列。若不存在合法字母顺序，返回 "" 。若存在多种可能的合法字母顺序，返回其中 任意一种 顺序即可。

字符串 s 字典顺序小于 字符串 t 有两种情况：
在第一个不同字母处，如果 s 中的字母在这门外星语言的字母顺序中位于 t 中字母之前，那么 s 的字典顺序小于 t 。
如果前面 min(s.length, t.length) 字母都相同，那么 s.length < t.length 时，s 的字典顺序也小于 t 。

拓扑排序。
 */