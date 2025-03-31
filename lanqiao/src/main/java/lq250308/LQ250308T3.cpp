#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

void solve() {
    int n;
    cin >> n;
    string s;
    cin >> s;

    for (int i = 0; i < n; ++i) {
        if (s[i] == '0') {
            int ans = -1;
            for (int j = i - 1; j >= 0; --j) {
                if (s[j] == '1') {
                    ans = i - j;
                    break;
                }
            }
            for (int j = i + 1; j < n; ++j) {
                if (s[j] == '1' && (ans == -1 || (j - i) < ans)) {
                    ans = j - i;
                    break;
                }
            }
            cout << ans << ' ';
        }
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
社区服务【算法赛】
 */