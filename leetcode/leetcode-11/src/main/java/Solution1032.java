import java.util.LinkedList;
import java.util.Queue;

public class Solution1032 {
    // https://leetcode.cn/problems/stream-of-characters/solutions/2186583/zi-fu-liu-by-leetcode-solution-b9yo/
    static class StreamChecker {
        TrieNode root, temp;

        public StreamChecker(String[] words) {
            root = new TrieNode();
            for (String word : words) {
                TrieNode cur = root;
                for (int i = 0; i < word.length(); i++) {
                    int index = word.charAt(i) - 'a';
                    if (cur.child[index] == null) {
                        cur.child[index] = new TrieNode();
                    }
                    cur = cur.child[index];
                }
                cur.isEnd = true;
            }
            root.fail = root;
            Queue<TrieNode> q = new LinkedList<>();
            for (int i = 0; i < 26; i++) {
                if (root.child[i] != null) {
                    root.child[i].fail = root;
                    q.add(root.child[i]);
                } else {
                    root.child[i] = root;
                }
            }
            while (!q.isEmpty()) {
                TrieNode node = q.poll();
                node.isEnd = (node.isEnd || node.fail.isEnd);
                for (int i = 0; i < 26; i++) {
                    if (node.child[i] != null) {
                        node.child[i].fail = node.fail.child[i];
                        q.offer(node.child[i]);
                    } else {
                        node.child[i] = node.fail.child[i];
                    }
                }
            }
            temp = root;
        }

        public boolean query(char letter) {
            temp = temp.child[letter - 'a'];
            return temp.isEnd;
        }

        static class TrieNode {
            TrieNode[] child;
            boolean isEnd;
            TrieNode fail;

            public TrieNode() {
                child = new TrieNode[26];
            }
        }
    }
}
/*
1032. 字符流
https://leetcode.cn/problems/stream-of-characters/description/

设计一个算法：接收一个字符流，并检查这些字符的后缀是否是字符串数组 words 中的一个字符串。
例如，words = ["abc", "xyz"] 且字符流中逐个依次加入 4 个字符 'a'、'x'、'y' 和 'z' ，你所设计的算法应当可以检测到 "axyz" 的后缀 "xyz" 与 words 中的字符串 "xyz" 匹配。
按下述要求实现 StreamChecker 类：
- StreamChecker(String[] words) ：构造函数，用字符串数组 words 初始化数据结构。
- boolean query(char letter)：从字符流中接收一个新字符，如果字符流中的任一非空后缀能匹配 words 中的某一字符串，返回 true ；否则，返回 false。
示例：
输入：
["StreamChecker", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query"]
[[["cd", "f", "kl"]], ["a"], ["b"], ["c"], ["d"], ["e"], ["f"], ["g"], ["h"], ["i"], ["j"], ["k"], ["l"]]
输出：
[null, false, false, false, true, false, true, false, false, false, false, false, true]
解释：
StreamChecker streamChecker = new StreamChecker(["cd", "f", "kl"]);
streamChecker.query("a"); // 返回 False
streamChecker.query("b"); // 返回 False
streamChecker.query("c"); // 返回n False
streamChecker.query("d"); // 返回 True ，因为 'cd' 在 words 中
streamChecker.query("e"); // 返回 False
streamChecker.query("f"); // 返回 True ，因为 'f' 在 words 中
streamChecker.query("g"); // 返回 False
streamChecker.query("h"); // 返回 False
streamChecker.query("i"); // 返回 False
streamChecker.query("j"); // 返回 False
streamChecker.query("k"); // 返回 False
streamChecker.query("l"); // 返回 True ，因为 'kl' 在 words 中
提示：
1 <= words.length <= 2000
1 <= words[i].length <= 200
words[i] 由小写英文字母组成
letter 是一个小写英文字母
最多调用查询 4 * 10^4 次
 */