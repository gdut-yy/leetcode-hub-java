package lq240406;

import java.util.Scanner;

public class LQ240406T5 {
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
        int[] cnt = new int[30];
        long ans = 0;
        for (int v : a) {
            while (v > 0) {
                int x = v & -v;
                int i = bitsLen(x) - 1;
                ans += cnt[i];
                cnt[i]++;
                v -= x;
            }
        }
        return String.valueOf(ans);
    }

    // bits.Len:
    // Len returns the minimum number of bits required to represent x; the result is 0 for x == 0.
    static int bitsLen(long x) {
        if (x == 0) return 0;
        return Long.toBinaryString(x).length();
    }
}
/*
字典树考试【算法赛】

我们按位来考虑问题，考虑每个“位”对答案的贡献。
考虑这个数组的第 b 位对答案的贡献，显然只有第 b 位为 1 才可能对答案有贡献
任选两个第 b 位为 1 的，即可产生 1 的贡献。
假设有 t 个第 b 位为 1 的。故这一位的贡献为 C(t,2)，累加每一位的贡献即可。
@小羊肖恩Yawn_Sean
 */