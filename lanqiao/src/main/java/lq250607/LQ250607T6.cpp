#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

const int maxn = 100004;

struct SegTree {
    ll sum[maxn << 5];
    int ls[maxn << 5], rs[maxn << 5];
    int tcnt = 0;

    inline void push_up(int p) {
        sum[p] = sum[ls[p]] + sum[rs[p]];
    }

    inline int copy(int p) {
        // 将p复制，返回新节点编号
        int r = ++tcnt;
        sum[r] = sum[p];
        ls[r] = ls[p], rs[r] = rs[p];
        return r;
    }

    int build(int l, int r, int *a) {
        int p = ++tcnt;
        if (l == r) {
            sum[p] = a[l];
            return p;
        }
        int mid = (l + r) / 2;
        ls[p] = build(l, mid, a);
        rs[p] = build(mid + 1, r, a);
        push_up(p);
        return p;
    }

    int modify(int frm, int l, int r, int pos, int to) {
        // 返回新创建的节点编号，这样比较好写
        int p = copy(frm);
        if (l == r) {
            sum[p] = to;
            return p;
        }
        int mid = (l + r) / 2;
        if (pos <= mid) ls[p] = modify(ls[frm], l, mid, pos, to);
        else rs[p] = modify(rs[frm], mid + 1, r, pos, to);
        push_up(p);
        return p;
    }

    int query(int p, int l, int r, int pos) {
        if (l == r)return sum[p];
        int mid = (l + r) / 2;
        if (pos <= mid) return query(ls[p], l, mid, pos);
        else return query(rs[p], mid + 1, r, pos);
    }

    int query_index(int p, int l, int r, int pos) {
        if (l == r) return p;
        int mid = (l + r) / 2;
        if (pos <= mid) return query_index(ls[p], l, mid, pos);
        else return query_index(rs[p], mid + 1, r, pos);
    }
} segt;

int a[maxn];
int ver[maxn], branch[maxn];
vector<int> vp[maxn];
int fa[maxn][32], dep[maxn];

void update_fa(int p, int f) {
    fa[p][0] = f;
    for (int k = 1; k <= 20; ++k) {
        fa[p][k] = fa[fa[p][k - 1]][k - 1];
    }
}

int lca(int x, int y) {
    if (dep[x] > dep[y]) {
        swap(x, y);
    }
    for (int k = 20; k >= 0; --k) {
        int fy = fa[y][k];
        if (dep[fy] >= dep[x]) y = fy;
    }
    if (y == x) return x;
    for (int k = 20; k >= 0; --k) {
        int fx = fa[x][k], fy = fa[y][k];
        if (fx != fy) {
            x = fx;
            y = fy;
        }
    }
    return fa[x][0];
}

void solve() {
    int n, m;
    cin >> n >> m;
    for (int i = 1; i <= n; ++i) cin >> a[i];
    ver[1] = segt.build(1, n, a);
    branch[1] = 1;
    int curb = 1;
    int V = 1;
    fa[1][0] = fa[0][0] = 0;
    dep[1] = 1;

    for (int i = 1; i <= m; ++i) {
        string opt;
        cin >> opt;
        if (opt == "upd") {
            int x, y;
            cin >> x >> y;
            int curV = branch[curb];
            ver[++V] = segt.modify(ver[curV], 1, n, x, y);
            vp[curV].push_back(V);
            branch[curb] = V;
            dep[V] = dep[curV] + 1;
            update_fa(V, curV);
        } else if (opt == "branch") {
            int x;
            cin >> x;
            if (branch[x] == 0) {
                int curV = branch[curb];
                ver[++V] = segt.copy(ver[curV]);
                dep[V] = dep[curV] + 1;
                update_fa(V, curV);
                branch[x] = V;
            }
            curb = x;
        } else if (opt == "query") {
            int x, y;
            cin >> x >> y;
            int v = branch[x];
            cout << segt.query(ver[v], 1, n, y) << endl;
        } else {
            int x, y, k;
            cin >> x >> y >> k;
            int vx = branch[x], vy = branch[y];
            int vl = lca(vx, vy);

            int ix = segt.query_index(ver[vx], 1, n, k);
            int iy = segt.query_index(ver[vy], 1, n, k);
            int il = segt.query_index(ver[vl], 1, n, k);
            if (ix != il && iy != il) {
                cout << "NO\n";
            } else {
                cout << "YES\n";
            }
        }
    }
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
开发模拟宇宙【算法赛】
 */