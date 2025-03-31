#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

void solve() {
    int n;
    cin >> n;

    vector<int> v(n);
    for (int i = 0; i < n; ++i) {
        cin >> v[i];
    }
    std::sort(v.begin(), v.end());

    priority_queue<int, vector<int>, greater<int>> pq;
    pq.push(0);
    for (int i = 0; i < n; ++i) {
        int val = pq.top();
        if (val < v[i]) {
            pq.pop();
            pq.push(val + 1);
        } else {
            pq.push(1);
        }
    }
    cout << pq.size() << endl;
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
舞狮【算法赛】
 */