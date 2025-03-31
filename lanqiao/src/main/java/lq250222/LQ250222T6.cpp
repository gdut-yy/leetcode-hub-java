#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

const int MAXN = 1e5 + 10;
int n;

struct P {
    int x, y;
} a[MAXN];

void solve() {
    cin >> n;
    for (int i = 1; i <= n; ++i) cin >> a[i].x;
    for (int i = 1; i <= n; ++i) cin >> a[i].y;

    priority_queue<pair<int, int> > q1, q2;
    q1.push({a[1].x + a[1].y, 1});
    q2.push({a[1].x - a[1].y, 1});

    ll ans = 0;

    for (int l = 1, r = 2; l <= n; ++r) {
        while (!q1.empty()) {
            auto c = q1.top();
            if (a[r].x + a[r].y <= c.first) {
                q1.pop();
                l = max(l, c.second + 1);
            } else {
                break;
            }
        }
        q1.push({a[r].x + a[r].y, r});

        while (!q2.empty()) {
            auto c = q2.top();
            if (a[r].x - a[r].y <= c.first) {
                q2.pop();
                l = max(l, c.second + 1);
            } else {
                break;
            }
        }
        q2.push({a[r].x - a[r].y, r});

        ans += r - l;
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
灯笼大乱斗【算法赛】
 */