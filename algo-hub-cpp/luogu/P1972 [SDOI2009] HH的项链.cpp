#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

const int maxn = 1e6 + 5;
vector<int> a;

struct QUE {
    int l, r, i;
};

vector<QUE> qs;

struct BIT {
    int n;
    vector<ll> tree;

    BIT(int n) {
        this->n = n;
        tree.resize(n + 1);
    }

    ll lb(int x) {
        return x & -x;
    }

    void add(int pos, int val) {
        for (; pos <= n; pos += lb(pos)) tree[pos] += val;
    }

    ll query(int pos) {
        ll ret = 0;
        for (; pos > 0; pos -= lb(pos)) ret += tree[pos];
        return ret;
    }
};

void solve() {
    int n, m;
    cin >> n;
    a.resize(n + 1);
    for (int i = 1; i <= n; ++i) {
        cin >> a[i];
    }
    cin >> m;
    qs.resize(m);
    for (int i = 0; i < m; ++i) {
        cin >> qs[i].l >> qs[i].r;
        qs[i].i = i;
    }

    std::sort(qs.begin(), qs.end(), [](auto &a, auto &b) {
        return a.r < b.r;
    });

    vector<int> ans(m);
    int pow = 1;
    vector<int> vis(maxn);
    BIT tr = BIT(maxn);
    for (int i = 0; i < m; i++) {
        for (int j = pow; j <= qs[i].r; j++) {
            if (vis[a[j]] != 0) {
                tr.add(vis[a[j]], -1);
            }
            tr.add(j, 1);
            vis[a[j]] = j;
        }
        pow = qs[i].r + 1;

        ans[qs[i].i] = tr.query(qs[i].r) - tr.query(qs[i].l - 1);
    }

    for (int i = 0; i < m; ++i) {
        cout << ans[i] << endl;
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
https://www.luogu.com.cn/problem/P1972
 */
