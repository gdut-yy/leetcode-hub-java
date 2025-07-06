#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

void solve() {
    ll n, m;
    cin >> n >> m;

    int ans = 0;
    ll sum = 0;
    vector<int> a(n);
    for (int i = 0; i < n; ++i) {
        cin >> a[i];
        sum += a[i];
        if (sum >= m) {
            ans++;
            sum = 0;
        }
    }
    if (ans == 0) {
        cout << -1 << endl;
    } else {
        cout << n - ans << endl;
    }
}

signed main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int t = 1;
    // cin >> t;
    while (t--) solve();
    return 0;
}

/*
守护射手座【算法赛】
 */