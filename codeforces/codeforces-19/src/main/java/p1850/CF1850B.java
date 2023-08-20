package p1850;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CF1850B {
    static int n;
    static int[][] ab;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            ab = new int[n][2];
            for (int i = 0; i < n; i++) {
                ab[i][0] = scanner.nextInt();
                ab[i][1] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (ab[i][0] <= 10) {
                list.add(new Node(ab[i][0], ab[i][1], i + 1));
            }
        }
        list.sort((o1, o2) -> Integer.compare(o2.bi, o1.bi));
        return String.valueOf(list.get(0).id);
    }

    private static class Node {
        int ai, bi, id;

        public Node(int ai, int bi, int id) {
            this.ai = ai;
            this.bi = bi;
            this.id = id;
        }
    }
}
/*
B. Ten Words of Wisdom
https://codeforces.com/contest/1850/problem/B

题目大意：
在“十句至理名言”游戏节目中，有 n 个参与者，编号从 1 到 n，每人提交一个答案。i -这个回复有 ai 字长，质量为 bi。没有两个回复具有相同的质量，并且至少一个回复的长度不超过 10。
在所有不超过 10 个单词的回答中，质量最高的回答将成为本次节目的获胜者。哪种反应是赢家?

筛选。排序后取最大值。
======

input
3
5
7 2
12 5
9 3
9 4
10 1
3
1 2
3 4
5 6
1
1 43
output
4
3
1
 */
