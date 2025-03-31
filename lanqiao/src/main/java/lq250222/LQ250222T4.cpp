#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
const int mod = 1e9 + 7;
const int N = 1e6 + 5;
vector<ll> f(N);

void init() {
    f[1] = 1;
    f[2] = 2;
    for (int i = 3; i < N; ++i) {
        f[i] = (f[i - 1] + (i - 1) * f[i - 2]) % mod;
    }
}

void solve() {
    int n;
    cin >> n;
    cout << f[n] << endl;
}

signed main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    init();
    int t = 1;
    cin >> t;
    while (t--) solve();
    return 0;
}
/*
摆放汤圆【算法赛】
 */