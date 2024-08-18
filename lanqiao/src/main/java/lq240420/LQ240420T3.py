import bisect
from cmath import inf
from itertools import accumulate

if __name__ == '__main__':
    t = int(input())
    outs = []
    for _ in range(t):
        n, k = map(int, input().split())
        xs = []
        ys = []
        for _ in range(n - 1):
            x, y = map(int, input().split())
            xs.append(x)
            ys.append(y)

        x, y = map(int, input().split())
        ans = inf if k < n else (k - n) * min(*ys, y) + sum(xs) + x

        n -= 1
        sorted_range = sorted(range(n), key=lambda x: xs[x])
        xs = [xs[i] for i in sorted_range]
        ys = [ys[i] for i in sorted_range]

        xs_acc = list(accumulate(xs, initial=0))
        for i in range(n):
            p = min(k, bisect.bisect_right(xs, ys[i]))
            if i < p:
                ans = min(ans, xs_acc[p] + ys[i] * (k - p))
            else:
                p = min(p, k - 1)
                ans = min(ans, xs_acc[p] + xs[i] + ys[i] * (k - p - 1))

        outs.append(ans)
    print('\n'.join(map(str, outs)))