#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
const int N = 5e5 + 10;

int a[N];

struct info {
    ll mss, mpre, msuf, s;

    info() {}

    info(int a) : mss(a), mpre(a), msuf(a), s(a) {}
};

info operator+(const info &l, const info &r) {
    info a;
    a.mss = max({l.mss, r.mss, l.msuf + r.mpre});
    a.mpre = max({l.mpre, l.s + r.mpre});
    a.msuf = max({r.msuf, r.s + l.msuf});
    a.s = l.s + r.s;
    return a;
}

struct node {
    info val;
} seg[N * 4];

void update(int id) {
    seg[id].val = seg[id << 1].val + seg[id << 1 | 1].val;
}

void build(int id, int l, int r) {
    if (l == r) {
        seg[id].val = info(a[r]);
    } else {
        int mid = (l + r) >> 1;
        build(id << 1, l, mid);
        build(id << 1 | 1, mid + 1, r);
        update(id);
    }
}

void change(int id, int l, int r, int pos, int val) {
    if (l == r) {
        seg[id].val = info(val);
    } else {
        int mid = (l + r) >> 1;
        if (pos <= mid) {
            change(id << 1, l, mid, pos, val);
        } else {
            change(id << 1 | 1, mid + 1, r, pos, val);
        }
        update(id);
    }
}

info query(int id, int l, int r, int ql, int qr) {
    if (l == ql && r == qr) {
        return seg[id].val;
    }
    int mid = (l + r) >> 1;
    if (qr <= mid) {
        return query(id << 1, l, mid, ql, qr);
    } else if (ql > mid) {
        return query(id << 1 | 1, mid + 1, r, ql, qr);
    } else {
        // 注意
        return query(id << 1, l, mid, ql, mid) +
               query(id << 1 | 1, mid + 1, r, mid + 1, qr);
    }
}

void solve() {
    int n, m;
    cin >> n >> m;

    vector<vector<pair<int, int>>> add(n + 10);
    for (int i = 0; i < m; ++i) {
        int l, r, x;
        cin >> l >> r >> x;
        add[l].push_back({i + 1, x});
        add[r + 1].push_back({i + 1, 0});
    }

    int q;
    cin >> q;
    vector<vector<array<int, 3>>> qur(n + 10);
    for (int i = 0; i < q; ++i) {
        int k, s, t;
        cin >> k >> s >> t;
        qur[k].push_back({s, t, i});
    }

    vector<ll> ans(q);
    build(1, 1, m);

    for (int i = 1; i <= n; ++i) {
        for (const auto &[idx, val]: add[i]) {
            change(1, 1, m, idx, val);
        }
        for (const auto &Q: qur[i]) {
            ans[Q[2]] = query(1, 1, m, Q[0], Q[1]).mss;
        }
    }

    for (const auto &x: ans) {
        cout << x << endl;
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
商铺评分【算法赛】
 */