"""
铺设地砖【算法赛】
"""


def matrix_mul(A, B, mod=10 ** 9 + 7):
    n, m = len(A), len(A[0])
    p = len(B[0])
    ans = [[0] * p for _ in range(n)]
    for i in range(n):
        for j in range(m):
            for k in range(p):
                ans[i][k] += A[i][j] * B[j][k]
                ans[i][k] %= mod
    return ans


def matrix_pow(x, n, mod):
    if n == 1: return x
    if n == 2: return matrix_mul(x, x, mod)
    v = matrix_pow(x, n // 2, mod)
    ans = matrix_mul(v, v, mod)
    if n % 2 == 0:
        return ans
    return matrix_mul(ans, x, mod)


if __name__ == '__main__':
    t = int(input())
    outs = []
    mod = 10 ** 9 + 7

    grid = [[1, 1, 0], [1, 0, 1], [0, 1, 1]]

    for _ in range(t):
        n = int(input())
        outs.append(sum(matrix_pow(grid, n, mod)[0][1:]) % mod)

    print(*outs, sep='\n')