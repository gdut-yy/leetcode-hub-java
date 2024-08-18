package lq240727;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class LQ240727T3 {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve1());
    }

    private static String solve() {
        PriorityQueue<Integer> pos = new PriorityQueue<>();
        PriorityQueue<Integer> neg = new PriorityQueue<>(Comparator.reverseOrder());
        for (int v : a) {
            if (v > 0) pos.add(v);
            else if (v < 0) neg.add(v);
        }
        while (!pos.isEmpty() && !neg.isEmpty()) {
            int sum = pos.remove() + neg.remove();
            if (sum > 0) pos.add(sum);
            else if (sum < 0) neg.add(sum);
        }
        return pos.size() + neg.size() <= 1 ? "Y" : "N";
    }

    private static String solve1() {
        int sum = Arrays.stream(a).sum();
        if (sum == 0) return "Y";

        int mx = Arrays.stream(a).max().orElseThrow();
        int mn = Arrays.stream(a).min().orElseThrow();
        if (sum > 0) {
            if (sum - mx < 0) return "Y";
        } else {
            if (sum - mn > 0) return "Y";
        }
        return "N";
    }
}
/*
老君炼丹【算法赛】

可以发现，数组的总和不会改变，我们假设数组的和为 sum。
假设数组总和为 0，显然一定可行。因为如果存在不可行的状态，最后肯定会剩 x（x > 1）个数字，这 x 个数字均为正数或负数，显然总和不为 0。
接下来分两种情况讨论，首先 sum 大于 0 时，说明我们不缺正数，缺负数。如果抛开数组的最大值可以使得剩下的数非正，说明我们可以完成。
sum < 0 时讨论同理。
 */