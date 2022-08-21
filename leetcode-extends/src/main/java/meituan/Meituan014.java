package meituan;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Meituan014 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8));
        // input
        String[] line0 = reader.readLine().split(" ");
        int x = Integer.parseInt(line0[0]);
        int y = Integer.parseInt(line0[1]);
        int[] lines = new int[x + y];
        String[] line1 = reader.readLine().split(" ");
        for (int i = 0; i < x + y; i++) {
            lines[i] = Integer.parseInt(line1[i]);
        }
        // solution
        String res = solution(x, y, lines);
        // output
        writer.write(res);
        writer.close();
        reader.close();
    }

    private static String solution(int x, int y, int[] lines) {
        if (x == y) {
            return "A".repeat(Math.max(0, x)) + "B".repeat(Math.max(0, y));
        }
        // 大顶堆
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        for (int i = 0; i < x + y; i++) {
            priorityQueue.add(new int[]{i, lines[i]});
        }
        char[] chars = new char[x + y];
        if (x < y) {
            Arrays.fill(chars, 'B');
            while (!priorityQueue.isEmpty() && x > 0) {
                int[] poll = priorityQueue.poll();
                chars[poll[0]] = 'A';
                x--;
            }
        } else {
            Arrays.fill(chars, 'A');
            while (!priorityQueue.isEmpty() && y > 0) {
                int[] poll = priorityQueue.poll();
                chars[poll[0]] = 'B';
                y--;
            }
        }
        return new String(chars);
    }
}
/*
输入：
4 4
5 6 4 2 3 8 1 7
输出：AAAABBBB

5 3
8 7 6 5 4 3 2 1
 */