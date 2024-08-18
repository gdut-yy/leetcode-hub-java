class UnionFind:
    def __init__(self, n):
        self.parent = list(range(n))

    def find(self, a):
        a = self.parent[a]
        acopy = a
        while a != self.parent[a]:
            a = self.parent[a]
        while acopy != a:
            self.parent[acopy], acopy = a, self.parent[acopy]
        return a

    def merge(self, a, b):
        pa, pb = self.find(a), self.find(b)
        if pa == pb: return False
        self.parent[pb] = pa
        return True


if __name__ == '__main__':
    t = int(input())
    outs = []
    for _ in range(t):
        us = []
        vs = []
        fs = []

        n, m, q = map(int, input().split())

        path = [[] for _ in range(n)]
        for i in range(m):
            u, v, f = map(int, input().split())
            u -= 1
            v -= 1

            path[u].append(i)
            path[v].append(i)

            us.append(u)
            vs.append(v)
            fs.append(f)

        used = [0] * m
        parent = [-1] * n
        depth = [-1] * n
        stack = [0]

        depth[0] = 0
        stack = [0]
        while stack:
            u = stack.pop()

            for i in path[u]:
                v = vs[i] if us[i] == u else us[i]
                if depth[v] == -1:
                    parent[v] = i
                    used[i] = 1
                    depth[v] = depth[u] + 1
                    stack.append(v)

        union = UnionFind(n)
        for i in range(m):
            if not used[i]:
                u, v = us[i], vs[i]
                u = union.find(u)
                v = union.find(v)
                while u != v:
                    if depth[u] < depth[v]:
                        u, v = v, u
                    p = vs[parent[u]] if us[parent[u]] == u else us[parent[u]]
                    union.merge(p, u)
                    u = union.find(u)

        col = [union.find(i) for i in range(n)]
        col_map = {v: i for i, v in enumerate(sorted(set(col)))}
        col = [col_map[g] for g in col]

        color = max(col) + 1
        nodes = [0] * (color + 1)
        npath = [[] for _ in range(color)]
        for u in range(n):
            for i in path[u]:
                v = vs[i] if us[i] == u else us[i]
                if col[u] == col[v]:
                    nodes[col[u]] |= fs[i]
                else:
                    if fs[i]:
                        npath[col[u]].append(~col[v])
                    else:
                        npath[col[u]].append(col[v])

        parent = [-1] * color
        depth = [0] * color
        stack = [0]
        edges = [0] * color
        while stack:
            u = stack.pop()
            for v in npath[u]:
                c = 0
                if v < 0:
                    v = ~v
                    c = 1
                if parent[u] != v:
                    parent[v] = u
                    depth[v] = depth[u] + 1
                    nodes[v] += nodes[u]
                    edges[v] += edges[u] + c
                    stack.append(v)


        # lca = LCA(depth, parent)
        def getLCA(x, y):
            if depth[x] > depth[y]:
                x, y = y, x
            while depth[y] - depth[x] >= 1:
                y = parent[y]
            while parent[y] != parent[x]:
                y, x = parent[y], parent[x]
            return x if x == y else parent[x]


        for _ in range(q):
            u, v = map(int, input().split())
            u -= 1
            v -= 1
            cu, cv = col[u], col[v]
            l = getLCA(cu, cv)
            cnt = nodes[cu] + nodes[cv] - nodes[l] - nodes[parent[l]]
            cnt += edges[cu] + edges[cv] - edges[l] * 2
            outs.append('Yes' if cnt else 'No')

    print('\n'.join(outs))