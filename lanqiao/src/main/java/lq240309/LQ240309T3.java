package lq240309;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LQ240309T3 {
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
        List<Integer>[] oe = new ArrayList[2];
        Arrays.setAll(oe, e -> new ArrayList<>());
        for (int v : a) {
            oe[v & 1].add(v);
        }
        oe[0].sort(null);
        oe[1].sort(null);
        oe[1].addAll(oe[0]);
        return oe[1].stream().map(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
奇偶排序【算法赛】

模拟。
 */