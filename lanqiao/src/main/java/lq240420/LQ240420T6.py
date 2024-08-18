import heapq

if __name__ == '__main__':
    t = int(input())
    outs = []
    for _ in range(t):
        n, k = map(int, input().split())
        path = [[] for _ in range(n)]
        for _ in range(n - 1):
            u, v, w = map(int, input().split())
            u -= 1
            v -= 1
            path[u].append((v, w))
            path[v].append((u, w))

        parent = [-1] * n
        order = []
        parent_weight = [-1] * n

        stack = [0]
        while stack:
            u = stack.pop()
            for v, w in path[u]:
                if parent[u] != v:
                    parent[v] = u
                    parent_weight[v] = w
                    stack.append(v)
                    order.append(v)

        size = [1] * n
        for i in reversed(order):
            size[parent[i]] += size[i]

        ans = sum(size[i] * parent_weight[i] for i in range(1, n))

        hpq = []
        for i in range(1, n):
            if parent_weight[i] > 1:
                hpq.append((-(parent_weight[i] // 2 * size[i]), i))

        heapq.heapify(hpq)
        while hpq and k:
            x, i = heapq.heappop(hpq)
            ans += x
            parent_weight[i] -= parent_weight[i] // 2
            if parent_weight[i] > 1:
                heapq.heappush(hpq, (-(parent_weight[i] // 2 * size[i]), i))
            k -= 1

        outs.append(ans)
    print('\n'.join(map(str, outs)))