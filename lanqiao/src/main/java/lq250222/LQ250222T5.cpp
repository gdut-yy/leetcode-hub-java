#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

void solve() {
    int n;
    cin >> n;
    vector<int> a(n);
    for (int i = 0; i < n; ++i) {
        cin >> a[i];
    }

    // 排序并去重
    sort(a.begin(), a.end());
    auto last = unique(a.begin(), a.end());
    a.erase(last, a.end());
    int m = a.size();

    // 对于每个 k，计算最大合集大小
    for (int k = 1; k <= n; ++k) {
        int ans = 1;
        int v = a[0];
        while (true) {
            int pos = lower_bound(a.begin(), a.end(), v + k) - a.begin();
            if (pos == m) {
                break;
            }
            v = a[pos];
            ans++;
        }
        cout << ans << " \n"[k == n];
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
元宵交友【算法赛】
 */