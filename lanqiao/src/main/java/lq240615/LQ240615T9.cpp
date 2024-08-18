#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

const int N = 2e5 + 10, K = 22;

int n, q;
int st[K * N], L[K * N], R[K * N], idx = 1;

void build(int u = 1, int s = 0, int e = n - 1) {
    if (s == e) {
        st[u] = 0;
        return;
    }
    L[u] = idx++;
    R[u] = idx++;
    int m = (s + e) >> 1;
    build(L[u], s, m);
    build(R[u], m + 1, e);
}

int add(int i, int u, int s = 0, int e = n - 1) {
    int uu = idx++;
    if (s == e) {
        st[uu] = st[u] + 1;
        return uu;
    }
    int m = (s + e) >> 1;
    if (i <= m) {
        L[uu] = add(i, L[u], s, m);
        R[uu] = R[u];
    } else {
        L[uu] = L[u];
        R[uu] = add(i, R[u], m + 1, e);
    }
    st[uu] = st[L[uu]] + st[R[uu]];
    return uu;
}

int count(int l, int r, int ul, int ur, int s = 0, int e = n - 1) {
    if (e < l || r < s) return 0;
    if (l <= s && e <= r) {
        return st[ur] - st[ul];
    }
    int m = (s + e) >> 1;
    return count(l, r, L[ul], L[ur], s, m)
           + count(l, r, R[ul], R[ur], m + 1, e);
}

vector<int> discretize(vector<int> &vec) {
    vector<int> sorted_vec(vec);
    std::sort(sorted_vec.begin(), sorted_vec.end());
    sorted_vec.erase(std::unique(sorted_vec.begin(), sorted_vec.end()), sorted_vec.end());

    vector<int> result;
    result.reserve(vec.size());
    for (auto &v: vec) {
        int discrete_value = std::lower_bound(sorted_vec.begin(), sorted_vec.end(), v) - sorted_vec.begin();
        result.push_back(discrete_value);
    }
    return result;
}

int main() {
    cin >> n >> q;
    vector<int> a(n);
    for (auto &v: a) {
        cin >> v;
    }

    a = discretize(a);
    vector<int> root(n + 1);
    root[0] = 1;
    idx = 2;
    build();

    ll inv = 0;
    for (int i = 0; i < n; ++i) {
        inv += count(a[i] + 1, n - 1, root[0], root[i]);
        root[i + 1] = add(a[i], root[i]);
    }

    while (q--) {
        int i, j;
        cin >> i >> j;
        i--, j--;

        ll ans = inv;
        ans += count(a[i] + 1, n - 1, root[i + 1], root[j])
               - count(0, a[i] - 1, root[i + 1], root[j]);

        ans += count(0, a[j] - 1, root[i + 1], root[j])
               - count(a[j] + 1, n - 1, root[i + 1], root[j]);

        if (a[i] < a[j]) {
            ans++;
        } else if (a[i] > a[j]) {
            ans--;
        }
        cout << ans << endl;
    }

    return 0;
}