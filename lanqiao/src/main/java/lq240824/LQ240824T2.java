package lq240824;

import java.util.Arrays;
import java.util.Scanner;

public class LQ240824T2 {
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
        Arrays.sort(a);
        int A = 0;
        int B = 0;
        int i = 0, j = n - 1;
        while (i <= j) {
            A += a[j--];
            if (i < j) B -= a[i++];
        }
        return String.valueOf(A - B);
    }
}
/*
北伐军费【算法赛】
 */