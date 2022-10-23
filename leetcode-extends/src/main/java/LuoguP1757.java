import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class LuoguP1757 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        // 物品的重量，利用价值，所属组数
        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            b[i] = scanner.nextInt();
            c[i] = scanner.nextInt();
        }
        System.out.println(solve(m, n, a, b, c));
    }

    private static String solve(int m, int n, int[] a, int[] b, int[] c) {
        // 分组
        Map<Integer, List<Integer>> idListMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            idListMap.computeIfAbsent(c[i], key -> new ArrayList<>()).add(i);
        }

        // 分组背包
        // f[j] 代表容量为 j 的背包能达到的最大价值
        int[] f = new int[m + 1];

        // 循环每一组
        for (Map.Entry<Integer, List<Integer>> entry : idListMap.entrySet()) {
            List<Integer> idList = entry.getValue();
            // 循环背包容量
            for (int i = m; i >= 0; i--) {
                for (int id : idList) {
                    if (i >= a[id]) {
                        f[i] = Math.max(f[i], f[i - a[id]] + b[id]);
                    }
                }
            }
        }
        return String.valueOf(f[m]);
    }
}
/*
P1757 通天之分组背包
https://www.luogu.com.cn/problem/P1757

45 3
10 10 1
10 5 1
50 400 2

10
 */