import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution212 {
    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private int M;
    private int N;

    public List<String> findWords(char[][] board, String[] words) {
        M = board.length;
        N = board[0].length;

        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        Set<String> resSet = new HashSet<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                dfs(board, trie, i, j, resSet);
            }
        }
        return new ArrayList<>(resSet);
    }

    private void dfs(char[][] board, Trie trie, int i, int j, Set<String> resSet) {
        char ch = board[i][j];
        if (trie.children[ch - 'a'] == null) {
            return;
        }
        trie = trie.children[ch - 'a'];
        if (!"".equals(trie.word)) {
            resSet.add(trie.word);
        }
        // ascii码序 排在 'z' 后的一个字符是 '{'
        board[i][j] = '{';
        for (int[] dir : DIRECTIONS) {
            int nextI = i + dir[0];
            int nextJ = j + dir[1];
            if (nextI >= 0 && nextI < M && nextJ >= 0 && nextJ < N) {
                dfs(board, trie, nextI, nextJ, resSet);
            }
        }
        board[i][j] = ch;
    }

    private static class Trie {
        Trie[] children;
        String word;

        public Trie() {
            children = new Trie[27];
            word = "";
        }

        public void insert(String word) {
            Trie node = this;
            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';
                if (node.children[idx] == null) {
                    node.children[idx] = new Trie();
                }
                node = node.children[idx];
            }
            node.word = word;
        }
    }
}
/*
212. 单词搜索 II
https://leetcode.cn/problems/word-search-ii/

给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words， 返回所有二维网格上的单词 。
单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
提示：
m == board.length
n == board[i].length
1 <= m, n <= 12
board[i][j] 是一个小写英文字母
1 <= words.length <= 3 * 10^4
1 <= words[i].length <= 10
words[i] 由小写英文字母组成
words 中的所有字符串互不相同

前缀树 + DFS
 */