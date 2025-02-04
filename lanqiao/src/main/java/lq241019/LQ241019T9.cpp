#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

template<class Info, class Tag>
struct LazySegmentTree {
    const int n;
    vector<Info> info;
    vector<Tag> tag;

    LazySegmentTree(int n) : n(n), info(4 << (int) log2(n)), tag(4 << (int) log2(n)) {}

    LazySegmentTree(vector<Info> init) : LazySegmentTree(init.size()) {
        function<void(int, int, int)> build = [&](int p, int l, int r) {
            if (r - l == 1) {
                info[p] = init[l];
                return;
            }
            int m = (l + r) / 2;
            build(2 * p, l, m);
            build(2 * p + 1, m, r);
            pull(p);
        };
        build(1, 0, n);
    }

    void pull(int p) {
        info[p] = info[p * 2] + info[p * 2 + 1];
    }

    void apply(int p, const Tag &v) {
        info[p].apply(v);
        tag[p].apply(v);
    }

    void push(int p) {
        apply(2 * p, tag[p]);
        apply(2 * p + 1, tag[p]);
        tag[p] = Tag();
    }

    void modify(int p, int l, int r, int x, const Info &v) {
        if (r - l == 1) {
            info[p] = v;
            return;
        }
        push(p);
        int m = (l + r) / 2;
        if (x < m) {
            modify(2 * p, l, m, x, v);
        } else {
            modify(2 * p + 1, m, r, x, v);
        }
        pull(p);
    }

    // 修改下标为 p 的值的为 v
    void modify(int p, const Info &v) {
        modify(1, 0, n, p, v);
    }

    Info rangeQuery(int p, int l, int r, int x, int y) {
        if (l >= y || r <= x) {
            return Info();
        }
        if (l >= x && r <= y) {
            return info[p];
        }
        int m = (l + r) / 2;
        push(p);
        return rangeQuery(2 * p, l, m, x, y) +
               rangeQuery(2 * p + 1, m, r, x, y);
    }

    // 查询区间 [l,r)
    Info rangeQuery(int l, int r) {
        return rangeQuery(1, 0, n, l, r);
    }

    void rangeApply(int p, int l, int r, int x, int y, const Tag &v) {
        if (l >= y || r <= x) {
            return;
        }
        if (l >= x && r <= y) {
            apply(p, v);
            return;
        }
        int m = (l + r) / 2;
        push(p);
        rangeApply(2 * p, l, m, x, y, v);
        rangeApply(2 * p + 1, m, r, x, y, v);
        pull(p);
    }

    void rangeApply(int l, int r, const Tag &v) {
        rangeApply(1, 0, n, l, r, v);
    }

    template<class F>
    int findFirst(int p, int l, int r, int x, int y, F pred) {
        if (l >= y || r <= x || !pred(info[p])) {
            return -1;
        }
        if (r - l == 1) {
            return l;
        }
        int m = (l + r) / 2;
        push(p);
        int res = findFirst(2 * p, l, m, x, y, pred);
        if (res == -1) {
            res = findFirst(2 * p + 1, m, r, x, y, pred);
        }
        return res;
    }

    // 从区间 [l,r) 找到第一个符合条件 pred 的下标，没找到返回 -1
    template<class F>
    int findFirst(int l, int r, F pred) {
        return findFirst(1, 0, n, l, r, pred);
    }
};

struct Tag {
    ll add;

    Tag(int _rev = 0) : add{_rev} {}

    void apply(const Tag &t) {
        add += t.add;
    }
};

struct Info {
    int len = 0;
    ll sum;
    ll mx;

    Info() : len(1), sum(0), mx(0) {}

    Info(ll v, int x) : len(x), sum(v), mx(v) {}

    void apply(const Tag &t) {
        sum += t.add * len;
        mx += t.add;
    }
};

Info operator+(Info a, Info b) {
    Info c;
    c.len = a.len + b.len;
    c.sum = a.sum + b.sum;
    c.mx = max(a.mx, b.mx);
    return c;
}

void solve() {
    int n, d;
    cin >> n >> d;

    string s;
    cin >> s;

    vector<Info> init(n);
    int c = 0;
    for (int i = 0; i < n; ++i) {
        c += (s[i] == '1');
        if (i >= d) {
            c -= (s[i - d] == '1');
        }
        init[i] = {c, i};
    }
    LazySegmentTree<Info, Tag> seg(init);

    int q;
    cin >> q;
    while (q--) {
        int op, x;
        cin >> op >> x;

        if (op == 1) {
            x--;
            if (s[x] == '1') {
                int r = min(x + d - 1, n - 1);
                seg.rangeApply(x, r + 1, -1);
                s[x] = '0';
            } else {
                int r = min(x + d - 1, n - 1);
                seg.rangeApply(x, r + 1, 1);
                s[x] = '1';
            }
        } else {
            int mx = seg.rangeQuery(0, n).mx;
            if (mx <= x) {
                cout << -1 << endl;
                continue;
            }

            auto pred = [&](const Info &node) {
                return node.mx > x;
            };
            int j = seg.findFirst(0, n, pred);
            cout << j + 1 << endl;
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
宝玉出行【算法赛】
 */