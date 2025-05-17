#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

void solve() {
    int n, d;
    ll lim;
    cin >> n >> lim >> d;
    vector<int> a(n);
    for (int i = 0; i < n; ++i) {
        cin >> a[i];
    }

    int ans = d;
    ll sd = 0;
    for (int i = 0; i < d; i++) {
        sd += a[i];
    }
    deque<pair<int, long> > dq; // l, s
    dq.push_back({0, sd});
    ll s = sd;
    int left = 0;
    for (int i = d; i < n; i++) {
        sd += a[i] - a[i - d];
        while (!dq.empty() && sd >= dq.back().second) {
            dq.pop_back();
        }
        dq.push_back({i - d + 1, sd});

        s += a[i];
        while (s - dq.front().second > lim) {
            s -= a[left];
            left++;
            while (dq.front().first < left) {
                dq.pop_front();
            }
        }

        ans = max(ans, i - left + 1);
    }
    cout << ans;
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
https://www.luogu.com.cn/problem/P3594
 */
