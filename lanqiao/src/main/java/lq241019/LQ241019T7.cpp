#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
ll UP = 1e18;

ll calc(int n) {
    ll res = 1, x = n;
    for (ll i = 2; i * i <= n; ++i) {
        if (n % i == 0) {
            int cnt = 0;
            while (n % i == 0) {
                n /= i;
                cnt++;
            }
            if (UP / (cnt * x + 1) <= res) return UP;
            res = res * (cnt * x + 1);
        }
    }
    if (n > 1) {
        if (UP / (x + 1) <= res) return UP;
        res = res * (x + 1);
    }
    return res;
}

set<ll> s;
map<ll, int> mp;

void init() {
    ll MA = -1;
    for (int i = 1; i <= 30030; ++i) {
        ll cnt = calc(i);
        if (cnt > MA) {
            MA = cnt;
            s.insert(cnt);
            mp[cnt] = i;
        }
    }
}

void solve() {
    ll k;
    cin >> k;

    auto n = *s.lower_bound(k);
    cout << mp[n] << endl;
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
小鸡变鸡腿【算法赛】

根据唯一分解定理，我们可以将 n 进行质因数分解。
考虑 m = 6, n = 2 * 3 * 5 * 7 * 11 * 13 = 30030
d(n^n) = (n+1)^6 = 30031^6 > 10^18
 */