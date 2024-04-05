package lq240224;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LQ240224T2 {
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
        int[] ans = new int[n];
        ans[0] = a[n - 1] + a[1];
        ans[n - 1] = a[n - 2] + a[0];
        for (int i = 1; i < n - 1; i++) {
            ans[i] = a[i - 1] + a[i + 1];
        }
        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
猜灯谜【算法赛】

模拟。
 */