#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

void solve() {
    int n, k;
    cin >> n >> k;

    vector<int> a(n + 1);
    for (int i = 1; i <= n; ++i) {
        int x;
        cin >> x;
        a[x] = i;
    }

    vector<int> cnt(n + 2);
    for (int i = 1; i < n; ++i) {
        int l = a[i], r = a[i + 1];
        if (l > r) swap(l, r);
        cnt[l]++;
        cnt[r]--;
    }
    for (int i = 1; i <= n; ++i) {
        cnt[i] += cnt[i - 1];
    }
    std::sort(cnt.rbegin(), cnt.rend());

    int ans = 0;
    for (const auto &v: cnt) {
        ans++;
        k -= v;
        if (k <= 0) break;
    }
    cout << (k > 0 ? -1 : ans) << endl;
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
净化王胖子【算法赛】
 */