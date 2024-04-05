package lq240210;

import java.util.Scanner;

public class LQ240210T6 {
    static int n, k;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            k = scanner.nextInt();
            System.out.println(solve());
        }
    }

    static final int MOD = (int) (1e9 + 7);

    private static String solve() {
        if (n == 1) return String.valueOf(k);
        n--;
        long[][] res = {{1, 0}, {0, 1}};
        long[][] a = {{k, 1}, {-1, 0}};
        while (n > 0) {
            if (n % 2 == 1) {
                res = matMulti(res, a);
            }
            n >>= 1;
            a = matMulti(a, a);
        }
        long ans = res[0][0] * k + 2 * res[1][0];
        ans = (ans % MOD + MOD) % MOD;
        return String.valueOf(ans);
    }

    // res = a * b
    static long[][] matMulti(long[][] a, long[][] b) {
        int n = a.length;
        long[][] res = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    res[i][j] += a[i][k] * b[k][j] % MOD;
                    res[i][j] %= MOD;
                }
            }
        }
        return res;
    }
}
/*
方程【算法赛】

#include <bits/stdc++.h>
using namespace std;
const int MOD = 1e9 + 7;
void mutl(int c[2][2], const int a[2][2], const int b[2][2]) {
    int x[2][2] = {0};
    for (int i = 0; i < 2; ++i) {
        for (int j = 0; j < 2; ++j) {
            for (int k = 0; k < 2; ++k) {
                x[i][j] += 1ll * a[i][k] * b[k][j] % MOD;
                x[i][j] %= MOD;
            }
        }
    }
    for (int i = 0; i < 2; ++i) {
        for (int j = 0; j < 2; ++j) {
            c[i][j] = x[i][j];
        }
    }
}
int a[2][2], b[2][2];
int get(int n, int k) {
    if (n == 1) return k;
    n --;
    int res[2][2] = {0};
    res[0][0] = res[1][1] = 1;
    a[0][0] = k; a[0][1] = 1;
    a[1][0] = -1; a[1][1] = 0;
    while (n > 0) {
        if (n % 2 == 1) mutl(res, res, a);
        n >>= 1;
        mutl(a, a, a);
    }
    return (1ll * res[0][0] * k + 2ll * res[1][0]) % MOD;
}
int main() {
    int T, n, k;
    cin >> T;
    while (T --) {
        cin >> n >> k;
        cout << (get(n, k) + MOD) % MOD << '\n';
    }
    return 0;
}
@DownFuFu
 */