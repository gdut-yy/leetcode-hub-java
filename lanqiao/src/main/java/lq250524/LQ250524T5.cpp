#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

int A[100007];

void solve() {
    int n;
    cin >> n;
    int ans = 0;
    for (int i = 1; i <= n; ++i) {
        cin >> A[i];
    }
    for (int i = 1; i <= n; ++i) {
        if (i - 1 >= 1 && !A[i - 1] && !A[i]) {
            ans++;
            A[i] = 1;
        }
        if (i - 2 >= 1 && !A[i - 2] && A[i - 1] && !A[i]) {
            ans++;
            A[i] = 1;
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
狮子座的试炼【算法赛】
 */