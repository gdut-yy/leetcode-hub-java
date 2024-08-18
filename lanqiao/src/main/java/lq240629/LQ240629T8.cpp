#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

const int N = 1e5 + 5, Log = 18, pot = (1 << Log), maxm = 8e6;
const ll inf = 1e18;

struct node {
    __int128 val;
    node *l, *d;
};

node cvorovi[maxm];
node *root[N * 2];
int curr;

ll getval(node *p) {
    if (p == nullptr) {
        return 0;
    }
    return p->val;
}

node *update(int L, int D, node *p, int &l, int &d, ll &val) {
    if (p != nullptr) {
        cvorovi[curr] = *p;
    }
    p = &cvorovi[curr++];
    if (L >= l && D <= d) {
        p->val += val;
        return p;
    }
    if ((L + D) / 2 >= l) {
        p->l = update(L, (L + D) / 2, p->l, l, d, val);
    }
    if ((L + D) / 2 + 1 <= d) {
        p->d = update((L + D) / 2 + 1, D, p->d, l, d, val);
    }
    return p;
}

__int128 query(int L, int D, node *p, int &x) {
    if (p == nullptr) {
        return 0;
    }
    if (L == x && D == x) {
        return p->val;
    }
    if ((L + D) / 2 >= x) {
        return query(L, (L + D) / 2, p->l, x) + p->val;
    } else {
        return query((L + D) / 2 + 1, D, p->d, x) + p->val;
    }
}

int n;
vector<pair<int, int >> ms[N];
int pa[N][Log];
int dep[N];

void precompute() {
    for (int i = 1; i < Log; ++i) {
        for (int j = 0; j < n; ++j) {
            pa[j][i] = pa[pa[j][i - 1]][i - 1];
        }
    }
}

void digni(int &x, int &y) {
    int raz = dep[x] - dep[y];
    for (int i = 0; i < Log; ++i) {
        if ((1 << i) & raz) {
            x = pa[x][i];
        }
    }
}

int lca(int x, int y) {
    if (dep[x] < dep[y]) {
        swap(x, y);
    }
    digni(x, y);
    if (x == y) return x;
    for (int i = Log - 1; i >= 0; --i) {
        if (pa[x][i] != pa[y][i]) {
            x = pa[x][i];
            y = pa[y][i];
        }
    }
    return pa[x][0];
}

int rev[N];
pair<int, int> itr[N];
int tren;

int v[N], c[N], o[N];
int pos[N];

bool cmp(int x, int y) {
    return v[x] < v[y];
}

void dfs(int x, int fa, int d) {
    pa[x][0] = fa;
    dep[x] = d;
    itr[x].first = tren++;
    for (int i = 0; i < (int) ms[x].size(); ++i) {
        if (ms[x][i].first != fa) {
            rev[ms[x][i].second] = ms[x][i].first;
            dfs(ms[x][i].first, x, d + 1);
        }
    }
    itr[x].second = tren - 1;
}

int binary(int x, int y, ll val) {
    int z = lca(x, y);
    int lo = 0, hi = n * 2 - 3, mid;
    while (lo < hi) {
        mid = (lo + hi) / 2;
        __int128 sum_xy = query(0, pot - 1, root[mid], itr[x].first) + query(0, pot - 1, root[mid], itr[y].first);
        if (sum_xy - query(0, pot - 1, root[mid], itr[z].first) * 2 <= val) {
            lo = mid + 1;
        } else {
            hi = mid;
        }
    }
    return lo - 1;
}

vector<pair<int, pair<int, ll>>> event;

int main() {
    cin >> n;
    int a, b, q;
    for (int i = 0; i < n - 1; ++i) {
        cin >> a >> b >> v[i] >> c[i] >> o[i];
        a--;
        b--;

        ms[a].push_back({b, i});
        ms[b].push_back({a, i});
        event.push_back({v[i], {i, c[i]}});
        event.push_back({o[i], {i, inf}});
    }
    dfs(0, 0, 0);
    precompute();
    std::sort(event.begin(), event.end());

    ll vv, x;
    for (int i = 0; i < n * 2 - 2; ++i) {
        a = rev[event[i].second.first];
        vv = event[i].second.second;
        root[i + 1] = update(0, pot - 1, root[i], itr[a].first, itr[a].second, vv);
    }

    cin >> q;
    for (int i = 0; i < q; ++i) {
        cin >> a >> b >> x;
        a--;
        b--;

        cout << event[binary(a, b, x)].first << endl;
    }
    return 0;
}