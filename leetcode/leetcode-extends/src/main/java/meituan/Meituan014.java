package meituan;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Meituan014 {
    static Scanner scanner;
    static PrintWriter out;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        out = new PrintWriter(System.out);
        int t = 1;
        // t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int[] lines = new int[x + y];
        for (int i = 0; i < x + y; i++) {
            lines[i] = scanner.nextInt();
        }

        String res;
        if (x == y) {
            res = "A".repeat(Math.max(0, x)) + "B".repeat(Math.max(0, y));
        } else {
            // 大顶堆
            PriorityQueue<int[]> maxHeap = new PriorityQueue<>((o1, o2) -> Integer.compare(o2[1], o1[1]));
            for (int i = 0; i < x + y; i++) {
                maxHeap.add(new int[]{i, lines[i]});
            }
            char[] cs = new char[x + y];
            if (x < y) {
                Arrays.fill(cs, 'B');
                while (!maxHeap.isEmpty() && x > 0) {
                    int[] poll = maxHeap.poll();
                    cs[poll[0]] = 'A';
                    x--;
                }
            } else {
                Arrays.fill(cs, 'A');
                while (!maxHeap.isEmpty() && y > 0) {
                    int[] poll = maxHeap.poll();
                    cs[poll[0]] = 'B';
                    y--;
                }
            }
            res = new String(cs);
        }

        out.print(res);
    }
}
/*
meituan-014. 小团的 AB 队
https://leetcode.cn/problems/LMkFuT/

小团要组织一只队伍参加 MT 杯竞赛，某媒体赛前要对各参赛队伍实力进行评估，已知这个比赛要求每一个参赛方组织一支由 x 个人组成的 A 队，
和 y 个人组成的 B 队，这个媒体在评估时会把 A 队的人员的平均实力值和 B 队人员的平均实力值相加，从而得到一个参赛方的综合实力评估。
小团可选的人手有限，只有 x+y 个人可以供他选择，但是显然不同的人员安排会有不同的综合实力评估，他希望他的综合实力评估尽可能高，请你帮助他完成分队。
格式：
输入：
- 输入第一行包含两个正整数x，y，分别表示 AB 队的人数。
- 输入第二行包含 x+y 个正整数，中间用空格隔开，第i个数字表示第i个人的实力值，每个人的实力值不会超过20000，保证任意两个人都不会有相同的实力值。
输出：
- 输出包含一个长度为 x+y 的字符串，每个字符是 'A'或 'B'，表示某人应该被分在 A 或 B 队。如果存在多种答案，则输出字典序最小的字符串。
示例：
输入：
4 4
5 6 4 2 3 8 1 7
输出：AAAABBBB
提示：
1 <= x, y <= 20000
 */