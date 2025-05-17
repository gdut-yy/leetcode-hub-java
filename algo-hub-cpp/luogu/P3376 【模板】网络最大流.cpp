#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

const int inf = 1 << 29, N = 50010, M = 300010;
int head[N], ver[M], edge[M], Next[M], d[N];
int n, m, s, t, tot;
ll maxflow;
queue<int> q;

void add(int x, int y, int z) {
    ver[++tot] = y, edge[tot] = z, Next[tot] = head[x], head[x] = tot;
    ver[++tot] = x, edge[tot] = 0, Next[tot] = head[y], head[y] = tot;
}

bool bfs() {
    // 在残量网络上构造分层图
    memset(d, 0, sizeof(d));
    while (!q.empty()) q.pop();
    q.push(s);
    d[s] = 1;
    while (!q.empty()) {
        int x = q.front();
        q.pop();
        for (int i = head[x]; i; i = Next[i]) {
            if (edge[i] && !d[ver[i]]) {
                q.push(ver[i]);
                d[ver[i]] = d[x] + 1;
                if (ver[i] == t) return true;
            }
        }
    }
    return false;
}

int dinic(int x, int flow) {
    // 在当前分层图上增广
    if (x == t) return flow;
    int rest = flow, k;
    for (int i = head[x]; i && rest; i = Next[i]) {
        if (edge[i] && d[ver[i]] == d[x] + 1) {
            k = dinic(ver[i], min(rest, edge[i]));
            if (!k) d[ver[i]] = 0; // 剪枝，去掉增广完毕的点
            edge[i] -= k;
            edge[i ^ 1] += k;
            rest -= k;
        }
    }
    return flow - rest;
}

signed main() {
    cin >> n >> m;
    cin >> s >> t;
    tot = 1;
    for (int i = 1; i <= m; ++i) {
        int x, y, c;
        scanf("%d%d%d", &x, &y, &c);
        add(x, y, c);
    }
    ll flow = 0;
    while (bfs()) {
        while ((flow = dinic(s, inf))) maxflow += flow;
    }
    cout << maxflow << endl;
    return 0;
}

/*
https://www.luogu.com.cn/problem/P3376
 */
