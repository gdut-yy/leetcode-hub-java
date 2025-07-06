#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

void solve() {
    int n, m;
    cin >> n >> m;

    vector<int> A(n);
    for (auto &i: A) cin >> i;
    sort(A.begin(), A.end());
    if (A[0] <= m && m <= A[n - 1]) {
        cout << "YES" << endl;
    } else {
        cout << "NO" << endl;
    }
}

signed main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int t = 1;
    cin >> t;
    while (t--) solve();
    return 0;
}

/*
浓缩咖啡液【算法赛】
 */