from cmath import inf

if __name__ == '__main__':
    n, w = map(int, input().split())
    nums = list(map(int, input().split()))
    parent = [-1]
    parent_val = [0]
    for _ in range(n - 1):
        p, v = map(int, input().split())
        parent.append(p - 1)
        parent_val.append(v)

    tree = [[] for _ in range(n)]
    for i in range(1, n):
        tree[parent[i]].append(i)

    order = []
    stack = [0]
    while stack:
        u = stack.pop()
        for v in tree[u]:
            stack.append(v)
        order.append(u)

    dp = [[0] for _ in range(n)]
    size = [1] * n
    for i in reversed(order):
        dp[i][-1] = min(dp[i][-1], nums[i])
        if i:
            p = parent[i]
            dp[i].append(parent_val[i])

            if len(dp[i]) > len(dp[p]):
                dp[i], dp[p] = dp[p], dp[i]

            ndp = [inf] * (len(dp[i]) + len(dp[p]) - 1)

            for a in range(len(dp[i])):
                for b in range(len(dp[p])):
                    ndp[a + b] = min(ndp[a + b], dp[i][a] + dp[p][b])

            size[p] += size[i]
            dp[i] = None
            dp[p] = ndp

    for j in range(n - 1, -1, -1):
        if dp[0][j] <= w:
            print(j)
            break