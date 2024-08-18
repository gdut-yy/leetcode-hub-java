package lq240531;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LQ240531T6 {
    static int n, q;
    static int[] perm;
    static int[][] xy;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        q = scanner.nextInt();
        perm = new int[n];
        for (int i = 0; i < n; i++) {
            perm[i] = scanner.nextInt() - 1;
        }
        xy = new int[q][2];
        for (int i = 0; i < q; i++) {
            xy[i][0] = scanner.nextInt() - 1;
            xy[i][1] = scanner.nextInt() - 1;
        }
        System.out.println(solve());
    }

    private static String solve() {
        int[] c1 = new int[n];
        int[] c2 = new int[n];
        int[] pos = new int[n];

        for (int i = 0; i < n; i++) {
            c1[(i + perm[i]) % n] += 1;
//            c2[(i - perm[i]) % n] += 1;
            c2[Math.floorMod(i - perm[i], n)] += 1;
            pos[perm[i]] = i;
        }

        boolean f1 = Arrays.stream(c1).max().orElseThrow() == n;
        boolean f2 = Arrays.stream(c2).max().orElseThrow() == n;

        List<String> output = new ArrayList<>();
        for (int[] p : xy) {
            int x = p[0], y = p[1];
            int u = pos[x], v = pos[y];
            int[] uv = {u, v};

            for (int i : uv) {
                if (c1[(i + perm[i]) % n] == n) f1 = false;
                c1[(i + perm[i]) % n] -= 1;

//                if (c2[(i - perm[i]) % n] == n) f2 = false;
//                c2[(i - perm[i]) % n] -= 1;
                if (c2[Math.floorMod(i - perm[i], n)] == n) f2 = false;
                c2[Math.floorMod(i - perm[i], n)] -= 1;
            }

            int t = perm[u];
            perm[u] = perm[v];
            perm[v] = t;

            t = pos[x];
            pos[x] = pos[y];
            pos[y] = t;

            for (int i : uv) {
                c1[(i + perm[i]) % n] += 1;
                if (c1[(i + perm[i]) % n] == n) f1 = true;

//                c2[(i - perm[i]) % n] += 1;
//                if (c2[(i - perm[i]) % n] == n) f2 = true;
                c2[Math.floorMod(i - perm[i], n)] += 1;
                if (c2[Math.floorMod(i - perm[i], n)] == n) f2 = true;
            }

            output.add((f1 || f2) ? "Yes" : "No");
        }
        return String.join(System.lineSeparator(), output);
    }
}
/*
六一手拉手【算法赛】

用一个数据特征表示当前条件的满足情况
方法 1、我们统计相邻的相差为 1 的对的数量，n-1 的话就是对的，否则就是错的
方法 2、[5,6,1,2,3,4]
(y - x) % n 是常数，只需要銃汁 (y - x) % n 的最大频率是否是 n
[4,3,2,1,5,6]
(x + y) % n 是常数，统计 (x + y) % n 的最大频率是否是 n
@小羊肖恩Yawn_Sean
 */