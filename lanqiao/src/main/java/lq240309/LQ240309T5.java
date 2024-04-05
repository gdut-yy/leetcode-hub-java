package lq240309;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class LQ240309T5 {
    static int k, n;
    static Node[] nodes;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        k = scanner.nextInt();
        n = scanner.nextInt();

        nodes = new Node[k];
        heap = new PriorityQueue<>(Comparator.comparingInt(o -> o.x));
        for (int i = 0; i < k; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            Node node = new Node(x, y, i);
            nodes[i] = node;
            if (i < k - 1) {
                heap.add(node);
            }
        }
        System.out.println(solve());
    }

    static PriorityQueue<Node> heap;

    private static String solve() {
        long sumX = 0;
        long minY = (long) 1e9;
        for (int i = 0; i < k; i++) {
            sumX += nodes[i].x;
            minY = Math.min(minY, nodes[i].y);
        }
        long ans = Long.MAX_VALUE;
        if (n >= k) {
            ans = Math.min(ans, sumX + minY * (n - k));
        }

        long ans1 = 0;
        for (int i = 0; i < n; i++) {
            Node top = heap.remove();
            ans1 += top.x;
            top.x = top.y;
            heap.add(top);
        }
        ans = Math.min(ans, ans1);
        return String.valueOf(ans);
    }

    static class Node {
        int x, y, i;

        public Node(int x, int y, int i) {
            this.x = x;
            this.y = y;
            this.i = i;
        }
    }
}
/*
兽之泪【算法赛】

考察分情况讨论与优先队列
1、攻击最后一只怪兽
2、不攻击最后一只怪兽
如果攻击最后一只怪兽，那么每只怪兽都要攻击至少一次，然后还剩下 n-k 次，只需要选择最小的一个攻击 n-k 次即可。
如果不攻击最后一只怪兽，那么只能攻击前 k-1 只怪兽，考虑优先队列，我们首先将前 k-1 只怪兽都入队，然后每次选择最小的那个，当他攻击过后，我们将第二次攻击的能量入队，持续 n 次即可。
时间复杂度 O(nlogk)。
 */