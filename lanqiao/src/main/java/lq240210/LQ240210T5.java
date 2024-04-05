package lq240210;

import java.util.Scanner;

public class LQ240210T5 {
    static long n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextLong();
        System.out.println(solve());
    }

    private static String solve() {
        long ans = 0;
        long st = (long) Math.sqrt(n);
        for (int i = -15; i <= 15; ++i) {
            if (st - i <= 0 || st - i > n) continue;
            long a = st - i;
            long b = n / a;
            long tmp = 2 * (a + b);
            if (a * b != n) tmp += 2;
            ans = Math.max(4 * n - tmp, ans);
        }
        return String.valueOf(ans);
    }
}
/*
下棋的贝贝【算法赛】

#include <bits/stdc++.h>
using namespace std;
int main() {
    long long x, st, a, b, ans = 0, tmp;
    cin >> x;
    st = sqrt(x);
    for (int i = -15; i <= 15; ++i) {
        if (st - i <= 0 || st - i > x) continue;
        a = st - i;
        b = x / a;
        tmp = 2 * (a + b);
        if (a * b != x) tmp += 2;
        ans = max(4 * x - tmp, ans);
    }
    cout << ans << '\n';
    return 0;
}
@DownFuFu
 */