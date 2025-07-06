#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

void solve() {
    int a, b, c;
    cin >> a >> b >> c;

    vector<pair<int, char> > v = {{a, 'l'}, {b, 'q'}, {c, 'b'}};
    sort(v.begin(), v.end());

    if (v[2].first > v[0].first + v[1].first) {
        cout << v[2].second << endl;
    } else {
        cout << -1 << endl;
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
团队赛【算法赛】
 */