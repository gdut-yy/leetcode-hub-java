import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Solution127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue1 = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();

        Set<String> notVisited = new HashSet<>(wordList);
        int length = 1;
        queue1.add(beginWord);

        while (!queue1.isEmpty()) {
            String word = queue1.remove();
            if (word.equals(endWord)) {
                return length;
            }

            List<String> neighbors = getNeighbors(word);
            for (String neighbor : neighbors) {
                if (notVisited.contains(neighbor)) {
                    queue2.add(neighbor);
                    notVisited.remove(neighbor);
                }
            }

            if (queue1.isEmpty()) {
                length++;
                queue1 = queue2;
                queue2 = new LinkedList<>();
            }
        }
        return 0;
    }

    private List<String> getNeighbors(String word) {
        List<String> neighbors = new ArrayList<>();
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char old = chars[i];
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (old != ch) {
                    chars[i] = ch;
                    neighbors.add(new String(chars));
                }
            }
            chars[i] = old;
        }
        return neighbors;
    }
}
/*
127. 单词接龙
https://leetcode-cn.com/problems/word-ladder/

字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列 beginWord -> s1 -> s2 -> ... -> sk：
- 每一对相邻的单词只差一个字母。
- 对于 1 <= i <= k 时，每个 si 都在 wordList 中。注意， beginWord 不需要在 wordList 中。
- sk == endWord
给你两个单词 beginWord 和 endWord 和一个字典 wordList ，返回 从 beginWord 到 endWord 的 最短转换序列 中的 单词数目 。如果不存在这样的转换序列，返回 0 。
提示：
1 <= beginWord.length <= 10
endWord.length == beginWord.length
1 <= wordList.length <= 5000
wordList[i].length == beginWord.length
beginWord、endWord 和 wordList[i] 由小写英文字母组成
beginWord != endWord
wordList 中的所有字符串 互不相同

两个队列实现广度优先搜索。
 */