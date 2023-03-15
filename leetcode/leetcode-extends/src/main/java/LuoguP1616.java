import java.util.Scanner;

public class LuoguP1616 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 采药时间 t 和山洞草药数目 m
        int t = scanner.nextInt();
        int m = scanner.nextInt();

        // ai 采药时间，bi 草药价值
        int[] a = new int[m];
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            a[i] = scanner.nextInt();
            b[i] = scanner.nextInt();
        }

        // 完全背包
        // f[j] 代表容量为 j 的背包能达到的最大价值
        long[] f = new long[t + 1];
        for (int i = 0; i < m; i++) {
            int wi = a[i];
            int vi = b[i];
            for (int j = wi; j <= t; j++) {
                f[j] = Math.max(f[j], f[j - wi] + vi);
            }
        }
        System.out.println(f[t]);
    }
}
/*
P1616 疯狂的采药
https://www.luogu.com.cn/problem/P1616

70 3
71 100
69 1
1 2

140
 */