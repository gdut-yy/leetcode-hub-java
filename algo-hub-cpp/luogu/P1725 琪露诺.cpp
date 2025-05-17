#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

void solve() {
    int n, l, r;
    cin >> n >> l >> r;

    vector<int> a(n + 1);
    for (int i = 0; i < n + 1; ++i) {
        cin >> a[i];
    }

    vector<ll> f(n + 1);
    for (int i = 1; i < l; i++) {
        f[i] = -1e18;
    }
    deque<int> dq;
    for (int i = l; i <= n; i++) {
        while (!dq.empty() && f[i - l] >= f[dq.back()]) {
            dq.pop_back();
        }
        dq.push_back(i - l);
        if (dq.front() < i - r) {
            dq.pop_front();
        }
        f[i] = f[dq.front()] + a[i];
    }
    ll ans = f[n - r + 1];
    for (int i = n - r + 1; i < f.size(); i++) {
        ans = max(ans, f[i]);
    }
    cout << ans << endl;
}

signed main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int t = 1;
    //    cin >> t;
    while (t--) solve();
    return 0;
}

/*
https://www.luogu.com.cn/problem/P1725
 */
