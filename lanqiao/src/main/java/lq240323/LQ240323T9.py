from collections import Counter

if __name__ == '__main__':
    def pos(x, y):
        return x * 10 + y


    def matrix_mul(A, B, mod=10 ** 9 + 7):
        n, m = 10, 10
        p = 10
        # ans = [[0] * p for _ in range(n)]
        ans = [0] * n * m
        for i in range(n):
            for j in range(m):
                for k in range(p):
                    ans[pos(i, k)] += A[pos(i, j)] * B[pos(j, k)]
                    ans[pos(i, k)] %= mod
        return ans


    t, x = map(int, input().split())
    idle = [0] * 100
    grid = [0] * 100
    for i in range(10):
        cnt = Counter(str(i + x))
        idle[pos(i, i)] = 1
        for j in range(10):
            grid[pos(i, j)] = cnt[str(j)]


    def calc():
        ans = [idle]
        for i in range(1, msk):
            ans.append(matrix_mul(ans[i // 2], ans[i // 2]))
            if i % 2: ans[-1] = matrix_mul(ans[-1], grid)
        return ans


    msk = 1001
    tmp3 = calc()

    grid = matrix_mul(tmp3[-1], grid)
    tmp2 = calc()

    grid = matrix_mul(tmp2[-1], grid)
    tmp1 = calc()

    mod = 10 ** 9 + 7
    res = []
    for _ in range(t):
        n, k = map(int, input().split())

        k, z = divmod(k, msk)
        x, y = divmod(k, msk)

        tmp = matrix_mul(tmp1[x], matrix_mul(tmp2[y], tmp3[z]))
        vals = [sum(tmp[pos(i, j)] for j in range(10)) % mod for i in range(10)]
        ans = 0
        while n:
            ans += vals[n % 10]
            n //= 10
        res.append(ans % mod)
    print('\n'.join(map(str, res)))