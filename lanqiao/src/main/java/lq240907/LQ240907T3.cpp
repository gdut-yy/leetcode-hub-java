#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

void solve() {
    ll n, k;
    cin >> n >> k;
    ll m = n - k;

    set<int> cnt;
    for (int i = 1; i * i <= m; ++i) {
        if (m % i == 0) {
            if (i > k) {
                cnt.insert(i);
            }
            if (m / i > k) {
                cnt.insert(m / i);
            }
        }
    }
    cout << cnt.size() << endl;
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
村长分钱【算法赛】

可以知道在题目 0<=k<n 范围下，n%(n-k) 的余数必定是 k，那么我们只需要计算有多少个 n-k 的因子严格大于 k，也就知道了 x 的个数。
 */