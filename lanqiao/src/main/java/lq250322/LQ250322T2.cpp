#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

void solve() {
    string s;
    cin >> s;

    int n = s.size();
    ll ans = 0;
    vector<ll> l(n), r(n);

    // 统计每个位置之前 'l' 的数量
    int pc = 0;
    for (int i = 0; i < n; ++i) {
        if (s[i] == 'l') {
            pc++;
        }
        l[i] = pc;
    }
    // 统计每个位置之后 'n' 的数量
    int nc = 0;
    for (int i = n - 1; i >= 0; --i) {
        if (s[i] == 'n') {
            nc++;
        }
        r[i] = nc;
    }
    // 枚举 'a' 的位置，累加答案
    for (int i = 1; i < n - 1; ++i) {
        if (s[i] == 'a') {
            ans += l[i - 1] * r[i + 1];
        }
    }
    cout << ans << endl;
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
蓝桥字符【算法赛】
 */