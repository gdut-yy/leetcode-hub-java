#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

int mod;

template<class Info, class Tag>
struct LazySegmentTree {
    const int n;
    vector<Info> info;
    vector<Tag> tag;

    LazySegmentTree(int n) : n(n), info(4 << (int) log2(n)), tag(4 << (int) log2(n)) {
    }

    LazySegmentTree(vector<Info> init) : LazySegmentTree(init.size()) {
        function<void(int, int, int)> build = [&](int p, int l, int r) {
            if (l == r) {
                info[p] = init[l - 1];
                return;
            }
            int m = (l + r) / 2;
            build(2 * p, l, m);
            build(2 * p + 1, m + 1, r);
            pull(p);
        };
        build(1, 1, n);
    }

    void pull(int p) {
        info[p] = info[p * 2] + info[p * 2 + 1];
    }

    void apply(int p, int l, int r, const Tag &v) {
        info[p].apply(l, r, v);
        tag[p].apply(v);
    }

    void push(int p, int l, int r) {
        int m = (l + r) / 2;
        apply(2 * p, l, m, tag[p]);
        apply(2 * p + 1, m + 1, r, tag[p]);
        tag[p] = Tag();
    }

    Info rangeQuery(int p, int l, int r, int ql, int qr) {
        if (ql <= l && r <= qr) {
            return info[p];
        }
        int m = (l + r) / 2;
        push(p, l, r);
        if (qr <= m) return rangeQuery(2 * p, l, m, ql, qr);
        if (ql > m) return rangeQuery(2 * p + 1, m + 1, r, ql, qr);
        return rangeQuery(2 * p, l, m, ql, qr) +
               rangeQuery(2 * p + 1, m + 1, r, ql, qr);
    }

    // 查询区间 [l,r)
    Info rangeQuery(int l, int r) {
        return rangeQuery(1, 1, n, l, r);
    }

    void rangeApply(int p, int l, int r, int ql, int qr, const Tag &v) {
        if (ql <= l && r <= qr) {
            apply(p, l, r, v);
            return;
        }
        int m = (l + r) / 2;
        push(p, l, r);
        if (ql <= m) rangeApply(2 * p, l, m, ql, qr, v);
        if (qr > m) rangeApply(2 * p + 1, m + 1, r, ql, qr, v);
        pull(p);
    }

    void rangeApply(int l, int r, const Tag &v) {
        rangeApply(1, 1, n, l, r, v);
    }
};

struct Tag {
    ll add;
    ll mul;

    Tag(int _add = 0, int _mul = 1) : add{_add}, mul{_mul} {
    }

    void apply(const Tag &t) {
        if (t.mul != 1) {
            mul = (mul * t.mul) % mod;
            add = (add * t.mul) % mod;
        }
        if (t.add != 0) {
            add = (add + t.add) % mod;
        }
    }
};

struct Info {
    ll sm = 0;

    void apply(int l, int r, const Tag &t) {
        ll sz = r - l + 1;
        // 先乘后加
        if (t.mul != 1) {
            sm = (sm * t.mul) % mod;
        }
        if (t.add != 0) {
            sm = (sm + sz * t.add) % mod;
        }
    }
};

Info operator+(Info a, Info b) {
    Info c;
    c.sm = (a.sm + b.sm) % mod;
    return c;
}

void solve() {
    int n, q;
    cin >> n >> q >> mod;

    // vector<int> a(n);
    vector<Info> init(n);
    for (int i = 0; i < n; ++i) {
        cin >> init[i].sm;
    }

    LazySegmentTree<Info, Tag> seg(init);
    for (int i = 0; i < q; ++i) {
        int op, x, y, k;
        cin >> op >> x >> y;

        if (op == 1) {
            cin >> k;
            seg.rangeApply(x, y, {0, k});
        } else if (op == 2) {
            cin >> k;
            seg.rangeApply(x, y, {k, 1});
        } else {
            cout << seg.rangeQuery(x, y).sm << endl;
        }
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
https://www.luogu.com.cn/problem/P3373
 */
