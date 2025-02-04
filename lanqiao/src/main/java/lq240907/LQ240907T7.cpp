#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

void solve() {
    int n, m;
    cin >> n >> m;

    vector<int> a(n), b(m);
    for (int i = 0; i < n; ++i) {
        cin >> a[i];
    }
    for (int i = 0; i < m; ++i) {
        cin >> b[i];
    }

    int c = a[0];
    for (int i = 0; i < n; ++i) {
        c = gcd(c, a[i]);
    }
    bool p = true;
    for (const auto &x: b) {
        if (x % c != 0) {
            p = false;
            break;
        }
    }
    cout << (p ? "YES" : "NO") << endl;
}

signed main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int t = 1;
    cin >> t;
    while (t--) {
        solve();
    }
    return 0;
}
/*
朝廷查账【算法赛】

从题目 10^99999 条金银交易记录可知，我们拥有无限的操作空间
我们可以通过无数次的根相减损术来获得一个数 c，只要保证 B 内的每一个数都是 c 的倍数，就输出 YES，反之输出 NO。
 */