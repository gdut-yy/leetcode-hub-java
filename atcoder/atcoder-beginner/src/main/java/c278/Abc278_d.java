package c278;

import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Abc278_d {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int N = scanner.nextInt();
        long[] A = new long[N];
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }
        int Q = scanner.nextInt();

        int lazy = -1;
        Set<Integer> lazySet = new HashSet<>();
        for (int q = 0; q < Q; q++) {
            int op = scanner.nextInt();
            if (op == 1) {
                int x = scanner.nextInt();
                lazy = x;
                lazySet.clear();
//                Arrays.fill(A, x);
            } else if (op == 2) {
                int i = scanner.nextInt() - 1;
                int x = scanner.nextInt();
                if (lazy > -1 && !lazySet.contains(i)) {
                    lazySet.add(i);
                    A[i] = lazy;
                }
                A[i] += x;
            } else {
                int i = scanner.nextInt() - 1;
                if (lazy > -1 && !lazySet.contains(i)) {
                    lazySet.add(i);
                    A[i] = lazy;
                }
                System.out.println(A[i]);
            }
        }
    }
}
/*
D - All Assign Point Add
https://atcoder.jp/contests/abc278/tasks/abc278_d

1 xq : assign xq to every element of A.
2 iq xq : add xq to Aiq.
3 iq : print the value of Aiq.
 */