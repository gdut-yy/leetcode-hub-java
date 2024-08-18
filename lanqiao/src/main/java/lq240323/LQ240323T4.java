package lq240323;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LQ240323T4 {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n + 5];
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        int[] x = new int[n + 5];
        if (a[1] == 0) {
            f(x);
            return arr2str(x);
        }
        if (a[1] == 2) {
            x[1] = 1;
            x[2] = 1;
            f(x);
            return arr2str(x);
        }
        x[1] = 0;
        x[2] = 1;
        f(x);
        if (check(x)) return arr2str(x);
        x[1] = 1;
        x[2] = 0;
        f(x);
        return arr2str(x);
    }

    private static void f(int[] x) {
        for (int i = 3; i <= n + 1; i++) {
            // x4-x1 = a3-a2
            x[i] = x[i - 3] + a[i - 1] - a[i - 2];
        }
    }

    private static String arr2str(int[] x) {
        return Arrays.stream(Arrays.copyOfRange(x, 1, n + 1)).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }

    private static boolean check(int[] x) {
        for (int i = 1; i <= n; i++) {
            if (x[i - 1] + x[i] + x[i + 1] != a[i]) return false;
            if (x[i] != 0 && x[i] != 1) return false;
        }
        return true;
    }
}
/*
求解线性方程组【算法赛】

5
2 3 3 3 2

5
2 2 2 2 2
 */