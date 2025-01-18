#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

const ll inf = 1e18;
const int maxn = 1e5 + 5;

struct DATA {
    // 分别表示 [l,r] 区间：前缀最大子段和，后缀最大子段和，最大子段和，区间和
    ll maxL, maxR, maxSum, sum;
};
vector<DATA> tr;

DATA mergeInfo(DATA &ls, DATA &rs) {
    ll maxL = max(ls.maxL, ls.sum + rs.maxL);
    ll maxR = max(rs.maxR, rs.sum + ls.maxR);
    // max(l.maxSum, r.maxSum, l.maxR + r.maxL)
    ll maxSum = max(max(ls.maxSum, rs.maxSum), ls.maxR + rs.maxL);
    ll sum = ls.sum + rs.sum;
    return DATA{maxL, maxR, maxSum, sum};
}

void maintain(int p) {
    tr[p] = mergeInfo(tr[p << 1], tr[p << 1 | 1]);
}

void build(vector<int> &a, int p, int l, int r) {
    if (l == r) {
        int val = a[l - 1];
        tr[p].maxL = tr[p].maxR = tr[p].maxSum = tr[p].sum = val;
        return;
    }
    int m = (l + r) >> 1;
    build(a, p << 1, l, m);
    build(a, p << 1 | 1, m + 1, r);
    maintain(p);
}

void modify(int p, int l, int r, int i, int val) {
    if (l > i || r < i) {
        return;
    }
    if (l == i && r == i) {
        tr[p].maxL = tr[p].maxR = tr[p].maxSum = tr[p].sum = val;
        return;
    }
    int m = (l + r) >> 1;
    modify(p << 1, l, m, i, val);
    modify(p << 1 | 1, m + 1, r, i, val);
    maintain(p);
}

DATA query(int p, int l, int r, int ql, int qr) {
    if (l > qr || r < ql) {
        return DATA{-inf, -inf, -inf, 0};
    }
    if (ql <= l && r <= qr) {
        return tr[p];
    }
    int m = (l + r) >> 1;
    DATA ls = query(p << 1, l, m, ql, qr);
    DATA rs = query(p << 1 | 1, m + 1, r, ql, qr);
    return mergeInfo(ls, rs);
}

void solve() {
    int n, m;
    cin >> n >> m;

    vector<int> a(n);
    for (int i = 0; i < n; ++i) {
        cin >> a[i];
    }

    tr.resize(4 * n);
    build(a, 1, 1, n);
    for (int i = 0; i < m; ++i) {
        int k;
        cin >> k;
        if (k == 1) {
            int l, r;
            cin >> l >> r;
            if (l > r) swap(l, r);
            cout << query(1, 1, n, l, r).maxSum << endl;
        } else {
            int p, s;
            cin >> p >> s;
            modify(1, 1, n, p, s);
        }
    }
}

signed main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int t = 1;
//    cin >> t;
    while (t--) {
        solve();
    }
    return 0;
}
/*
https://www.luogu.com.cn/problem/P4513
 */