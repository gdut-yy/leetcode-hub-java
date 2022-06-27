import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * meituan-003. 小美的跑腿代购
 * https://leetcode.cn/problems/GXV5dX/
 */
public class Meituan003 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8));
        // input
        String[] line0 = reader.readLine().split(" ");
        int n = Integer.parseInt(line0[0]);
        int m = Integer.parseInt(line0[1]);
        int[][] lineN = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] line = reader.readLine().split(" ");
            lineN[i][0] = Integer.parseInt(line[0]);
            lineN[i][1] = Integer.parseInt(line[1]);
        }

        // solution
        int[] res = solution(m, lineN);
        // output
        StringBuilder stringBuilder = new StringBuilder();
        for (int re : res) {
            stringBuilder.append(re).append(" ");
        }
        writer.write(stringBuilder.toString().trim());
        writer.close();
        reader.close();
    }

    private static int[] solution(int m, int[][] line) {
        // 重量升序 价格升序
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((x, y) -> x[1] == y[1] ? y[0] - x[0] : x[1] - y[1]);
        for (int i = 0; i < line.length; i++) {
            // 总价 = 跑腿价格 v ，商品重量 w kg，商品每重 1kg ，代购费用要加 2 元
            int totalPrice = line[i][0] + line[i][1] * 2;
            if (priorityQueue.size() < m) {
                priorityQueue.add(new int[]{i, totalPrice});
            } else if (!priorityQueue.isEmpty() && totalPrice > priorityQueue.peek()[1]) {
                priorityQueue.poll();
                priorityQueue.add(new int[]{i, totalPrice});
            }
        }
        List<Integer> list = new ArrayList<>();
        while (m > 0 && !priorityQueue.isEmpty()) {
            list.add(priorityQueue.poll()[0]);
        }
        Collections.sort(list);
        return list.stream().mapToInt(i -> i + 1).toArray();
    }
}
/*
小美的一个兼职是美团的一名跑腿代购员，她有 n 个订单可以接，订单编号是 1~n ，但是因为订单的时效性，他只能选择其中 m 个订单接取，
精明的小美当然希望自己总的获利是最大的，已知，一份订单会提供以下信息，跑腿价格 v ，商品重量 w kg，商品每重 1kg ，代购费用要加 2 元，
而一份订单可以赚到的钱是跑腿价格和重量加价之和。小美可是开兰博基尼送货的人，所以自然不会在意自己会累这种事情。请问小美应该选择哪些订单，
使得自己获得的钱最多。

请你按照选择的订单编号的从小到大顺序，如果存在多种方案，输出订单编号字典序较小的方案。

格式：
输入：
- 输入第一行包含两个正整数 n，m，表示订单的数量和小美可以接的订单数量。
- 接下来有 n 行，第 i 行表示 i-1 号订单的信息。每行有两个正整数 v 和 w  ，表示一个订单的跑腿价格和商品重量。
输出：
- 输出包含 m 个 1~n 之间的正整数，中间用空格隔开，表示选择的订单编号。

示例：
输入：
5 2
5 10
8 9
1 4
7 9
6 10
输出：2 5

提示：
1 <= n, m <= 10000
1 <= v, w <= 1000
 */