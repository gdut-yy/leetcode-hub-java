package c273;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Abc273_e {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);

        // 不能写成 root = new Node(root, -1);
        root = new Node(-1);
        root.fa = root;
        Node cur = root;
        Map<Integer, Node> nodes = new HashMap<>();

        int q = scanner.nextInt();
        int[] ans = new int[q];
        for (int i = 0; i < q; i++) {
            String query = scanner.next();
            if (query.equals("ADD")) {
                int x = scanner.nextInt();
                cur = new Node(cur, x);
            } else if (query.equals("DELETE")) {
                cur = cur.fa;
            } else if (query.equals("SAVE")) {
                int x = scanner.nextInt();
                nodes.put(x, cur);
            } else {
                int x = scanner.nextInt();
                Node o = nodes.get(x);
                if (o != null) {
                    cur = o;
                } else {
                    cur = root;
                }
            }
            ans[i] = cur.val;
        }
        String output = Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(" "));
        System.out.println(output);
    }

    static Node root;

    static class Node {
        Node fa;
        int val;

        public Node(int val) {
            this.val = val;
        }

        public Node(Node fa, int val) {
            this.fa = fa;
            this.val = val;
        }
    }
}
/*
E - Notebook
https://atcoder.jp/contests/abc273/tasks/abc273_e

灵茶の试炼 2022-12-22
题目大意：
一开始你有一个空数组 a 和一个 1e9 页的笔记本，每页上都记录着一个空数组。
有四种类型的操作：
ADD x：在 a 的末尾添加元素 x (1≤x≤1e9)。
DELETE：如果 a 不为空，删除 a 的最后一个元素。
SAVE y：把 a 记在第 y 页上（覆盖原来的数组）。
LOAD z：把 a 替换为第 z 页上的数组。
输入 q(≤5e5) 和 q 个操作。
在每个操作结束后，你需要输出 a 的最后一个元素（数组为空时输出 -1）。

https://atcoder.jp/contests/abc273/submissions/37430977
提示：用类似字典树 Trie 的结构来模拟。具体见代码。
======

Input 1
11
ADD 3
SAVE 1
ADD 4
SAVE 2
LOAD 1
DELETE
DELETE
LOAD 2
SAVE 1
LOAD 3
LOAD 1
Output 1
3 3 4 4 3 -1 -1 4 4 -1 4

Input 2
21
ADD 4
ADD 3
DELETE
ADD 10
LOAD 7
SAVE 5
SAVE 5
ADD 4
ADD 4
ADD 5
SAVE 5
ADD 2
DELETE
ADD 1
SAVE 5
ADD 7
ADD 8
DELETE
ADD 4
DELETE
LOAD 5
Output 2
4 3 4 10 -1 -1 -1 4 4 5 5 2 5 1 1 7 8 7 4 7 1
 */