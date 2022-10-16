import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Atcoder_abc247_e {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int N = scanner.nextInt();
        int X = scanner.nextInt();
        int Y = scanner.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }
        System.out.println(solve(N, X, Y, A));
    }

    private static String solve(int N, int X, int Y, int[] A) {
        int minI = -1;
        int maxI = -1;
        int preI = -1;

        long res = 0;
        for (int i = 0; i < N; i++) {
            if (A[i] == Y) {
                minI = i;
            }
            if (A[i] == X) {
                maxI = i;
            }
            if (A[i] < Y || A[i] > X) {
                preI = i;
            }
            res += Math.max(0, Math.min(minI, maxI) - preI);
        }
        return String.valueOf(res);
    }
}
/*
E - Max Min
https://atcoder.jp/contests/abc247/tasks/abc247_e

https://atcoder.jp/contests/abc247/editorial/3776
 */