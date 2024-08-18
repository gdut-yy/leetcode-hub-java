package lq240323;

import java.util.Arrays;
import java.util.Scanner;

public class LQ240323T2 {
    static int n;
    static String[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(solve());
    }

    private static String solve() {
        Arrays.sort(a, (o1, o2) -> (o1 + o2).compareTo(o2 + o1));
        return String.join("", a);
    }
}
/*
二进制王国【算法赛】

2
10
1001
 */