import java.util.Scanner;

public class LuoguP2871 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 有 N 件物品和一个容量为 M 的背包。
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        // 第 i 件物品的重量是 wi，价值是 vi
        int[] W = new int[N];
        int[] D = new int[N];
        for (int i = 0; i < N; i++) {
            W[i] = scanner.nextInt();
            D[i] = scanner.nextInt();
        }

        // 0-1 背包
        // f[j] 代表容量为 j 的背包能达到的最大价值
        int[] f = new int[M + 1];
        for (int i = 0; i < N; i++) {
            int wi = W[i];
            int vi = D[i];
            for (int j = M; j >= wi; j--) {
                f[j] = Math.max(f[j], f[j - wi] + vi);
            }
        }
        System.out.println(f[M]);
    }
}
/*
P2871 [USACO07DEC]Charm Bracelet S
https://www.luogu.com.cn/problem/P2871

4 6
1 4
2 6
3 12
2 7

23
 */