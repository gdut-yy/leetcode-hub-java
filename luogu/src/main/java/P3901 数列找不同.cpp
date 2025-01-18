#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

const int maxn = 1e5 + 5;
int n, q;
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
    std::sort(qs.begin(), qs.end(), [](auto &a, auto &b) {
        return a.r < b.r;
    });

    vector<string> ans(q);
    int pow = 1;
    vector<int> vis(maxn);
    BIT tr = BIT(maxn);
    for (int i = 0; i < q; i++) {
        for (int j = pow; j <= qs[i].r; j++) {
            if (vis[a[j]] != 0) {
                tr.add(vis[a[j]], -1);
            }
            tr.add(j, 1);
            vis[a[j]] = j;
        }
        pow = qs[i].r + 1;

        ans[qs[i].i] = (tr.query(qs[i].r) - tr.query(qs[i].l - 1) == qs[i].r - qs[i].l + 1) ? "Yes" : "No";
    }

    for (int i = 0; i < q; ++i) {
        cout << ans[i] << endl;
    }
}

signed main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> n >> q;
    a.resize(n + 1);
    for (int i = 1; i <= n; ++i) {
        cin >> a[i];
    }
    qs.resize(q);
    for (int i = 0; i < q; ++i) {
        cin >> qs[i].l >> qs[i].r;
        qs[i].i = i;
    }
    solve();
    return 0;
}
/*
https://www.luogu.com.cn/problem/P3901
 */