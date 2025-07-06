#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

struct pair1 {
    int f, i;
};

void solve() {
    int n;
    cin >> n;
    vector<int> a(n);
    for (int i = 0; i < n; ++i) {
        cin >> a[i];
    }

    int t;
    cin >> t;
    while (t-- > 0) {
        int k;
        cin >> k;
        deque<pair1> dq; // f, i
        dq.push_back({0, 0});
        for (int i = 1; i < n; i++) {
            if (dq.front().i < i - k) {
                dq.pop_front();
            }
            int f = dq.front().f;
            if (a[i] >= a[dq.front().i]) {
                f++;
            }
            while (!dq.empty() && f < dq.back().f || f == dq.back().f && a[i] >= a[dq.back().i]) {
                dq.pop_back();
            }
            dq.push_back({f, i});
        }
        cout << dq.back().f << endl;
    }
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

 */