#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

const int N = 1e5 + 10;
int n, t;
vector<int> a(N), b(N);

bool check(int x) {
    if (a[1] > x) return false;
    int cnt = 1, s = x - a[1];
    for (int i = 2; i <= n; ++i) {
        if (a[i] > x) return false;
        if (b[i - 1] + a[i] <= s) {
            s -= b[i - 1] + a[i];
        } else {
            if (s >= b[i - 1]) {
                cnt++;
                s = x - a[i];
            } else {
                int d = b[i - 1] - s;
                if (d > x) {
                    cnt += d / x + (d % x != 0);
                    d = d % x;
                    s = x - d;
                } else {
                    cnt++;
                    s = x - d;
                }
                if (a[i] > s) {
                    cnt++;
                    s = x - a[i];
                } else {
                    s -= a[i];
                }
            }
        }
    }
    return cnt <= t;
}

void solve() {
    cin >> n >> t;
    for (int i = 1; i <= n; ++i) cin >> a[i];
    for (int i = 1; i <= n; ++i) cin >> b[i];

    int l = 1, r = 3600, res = -1;
    while (l <= r) {
        int mid = (l + r) >> 1;
        if (check(mid)) {
            r = mid - 1, res = mid;
        } else {
            l = mid + 1;
        }
    }
    cout << res << endl;
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
备份比赛数据【算法赛】
 */