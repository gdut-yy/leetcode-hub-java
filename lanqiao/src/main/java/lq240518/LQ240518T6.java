package lq240518;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LQ240518T6 {
    static int n, k;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        Set<Integer> set = new HashSet<>();
        int p = n - 1, ans = -1;
        for (int i = 0; i <= n / 2; i++) {
            set.add(a[i]);
            set.add(a[p]);
            if (set.contains(k - a[i]) && a[i] != k - a[i]) {
                ans = i + 1;
                break;
            }
            if (set.contains(k - a[p]) && a[p] != k - a[p]) {
                ans = n - p;
                break;
            }
            p--;
        }
        return String.valueOf(ans);
    }
}
/*
矿石样本分析【算法赛】

枚举，双指针。
从数组中选择两个数 i,j，满足 ai + aj = k，其中第 i 个数的花销为 min(1+i, n-i)。
 */