#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

void solve() {
    string n;
    cin >> n;
    set<string> s;

    for (int i = 0; i <= n.size(); ++i) {
        for (char j = (i ? '0' : '1'); j <= '9'; ++j) {
            s.insert(n.substr(0, i) + j + n.substr(i));
        }
    }
    cout << s.size() << endl;
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
插入数字【算法赛】
 */