package lq240406;

import java.util.PriorityQueue;
import java.util.Scanner;

public class LQ240406T7 {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        PriorityQueue<Integer> heap = new PriorityQueue<>(n);
        for (int v : a) heap.add(v);

        while (heap.size() > 1) {
            int v = heap.remove();
            if (heap.peek() != v) {
                return "2";
            }
            heap.remove();
            heap.add(v + 1);
        }
        return "1";
    }
}
/*
贝贝的集合【算法赛】

结论
首先将数组 ai 升序排序一下。
然后将原本的数组看成一个二进制数，也就是 {\textstyle \sum_{i=1}^{n}2^{a_i}} 。但是位权上的数可能比 1 大，所以我们需要不断进位。最后得到一个新的长度为 n' 的数组 bi，如果发现 n' 为 1，则直接输出 1。
否则集合大小的最小值就为 2。
@小羊肖恩Yawn_Sean
 */