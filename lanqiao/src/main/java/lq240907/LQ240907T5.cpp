#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

void solve() {
    int n;
    cin >> n;

    vector<int> a(2 * n), b(2 * n);
    for (int i = 0; i < 2 * n; ++i) {
        cin >> a[i];
    }
    for (int i = 0; i < 2 * n; ++i) {
        cin >> b[i];
    }

    vector<pair<int, int >> vp(2 * n);
    for (int i = 0; i < 2 * n; ++i) {
        vp[i] = {a[i] + b[i], i};
    }
    std::sort(vp.rbegin(), vp.rend());

    ll ans = 0;
    for (int i = 0; i < 2 * n; ++i) {
        ans += a[i];
        if (i % 2 == 0) {
            ans -= vp[i].first;
        }
    }
    cout << ans << endl;
}

signed main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int t = 1;
//    cin >> t;
    while (t--) {
        solve();
    }
    return 0;
}
/*
好汉身份【算法赛】

最优策略是始终选择总价最小的商品进行购买
 */