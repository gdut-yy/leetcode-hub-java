#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

int n;

vector<int> f(vector<int> &a) {
    int m = 0;
    map<int, int> mp;
    for (const auto &v: a) mp[v] = 1;
    for (auto &p: mp) p.second = m++;
    vector<int> A(m);
    // for (auto &p: mp) A[p.second] = p.first;
    for (int i = 0; i < n; ++i) A[i] = mp[a[i]];
    return A;
}

ll mergeCount(vector<int> &a) {
    int n = a.size();
    if (n <= 1) {
        return 0;
    }
    vector<int> left = vector(a.begin(), a.begin() + n / 2);
    vector<int> right = vector(a.begin() + n / 2, a.end());
    ll cnt = mergeCount(left) + mergeCount(right);
    int l = 0, r = 0;
    for (int i = 0; i < n; i++) {
        if (l < left.size() && (r == right.size() || left[l] <= right[r])) {
            a[i] = left[l];
            l++;
        } else {
            cnt += n / 2 - l;
            a[i] = right[r];
            r++;
        }
    }
    return cnt;
}

void solve() {
    cin >> n;
    vector<int> a(n), b(n);
    for (int i = 0; i < n; ++i) cin >> a[i];
    for (int i = 0; i < n; ++i) cin >> b[i];

    a = f(a);
    vector<int> p(n);
    for (int i = 0; i < n; ++i) p[a[i]] = i;
    b = f(b);
    for (int i = 0; i < n; ++i) b[i] = p[b[i]];

    int mod = 1e8 - 3;
    ll ans = mergeCount(b) % mod;
    cout << ans << endl;
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
https://www.luogu.com.cn/problem/P1966
 */
