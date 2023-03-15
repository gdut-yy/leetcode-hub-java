package didi;

import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DD2019010 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        String[] lines = new String[n];
        for (int i = 0; i < n; i++) {
            lines[i] = scanner.next();
        }
        System.out.println(solve(n, lines));
    }

    private static String solve(int n, String[] lines) {
        Trie trie = new Trie();
        for (String word : lines) {
            char[] chars = word.toCharArray();
            for (int i = 0; i < word.length(); i++) {
                trie.insert(chars, i);
            }
        }
        return trie.bfs();
    }

    private static class Trie {
        private final Trie[] children;

        public Trie() {
            children = new Trie[10];
        }

        public void insert(char[] chars, int beginIndex) {
            Trie node = this;
            for (int i = beginIndex; i < chars.length; i++) {
                int idx = chars[i] - '0';
                if (node.children[idx] == null) {
                    node.children[idx] = new Trie();
                }
                node = node.children[idx];
            }
        }

        public boolean startsWith(String prefix) {
            Trie node = this;
            for (char ch : prefix.toCharArray()) {
                int idx = ch - '0';
                if (node.children[idx] == null) {
                    return false;
                }
                node = node.children[idx];
            }
            return true;
        }

        public String bfs() {
            Queue<String> queue = new LinkedList<>();
            for (int i = 0; i < 10; i++) {
                queue.add("" + i);
            }
            while (!queue.isEmpty()) {
                String cur = queue.remove();
                if (!startsWith(cur)) {
                    return cur;
                }

                for (int i = 0; i < 10; i++) {
                    queue.add(cur + i);
                }
            }
            return null;
        }
    }
}
/*
DD-2019010. 破译密码
https://leetcode.cn/problems/lJDUTU/

有一种数字串的加密方法，原文是一个数字串，密文是若干个数字串。
已知解密的方法是:找到在密文各个数字串中都没有出现过的最短子串，若有多个，选字典序最小的。现在给定密文，请你帮忙破译。
格式：
输入：
- 第一行包含一个正整数 n，表示密文数字串的个数。
- 之后 n 行，每行一个仅包含数字的字符串。
输出：
- 解密后的原文。
示例：
输入：
2
9527
0012345678
输出：02
提示：
1 ≤ n ≤ 100
字符串长度不大于 200

字典树 + BFS
 */