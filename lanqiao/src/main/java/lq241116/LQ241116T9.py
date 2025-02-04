class Factorial:
    def __init__(self, N, mod) -> None:
        N += 1
        self.mod = mod
        self.f = [1 for _ in range(N)]
        self.g = [1 for _ in range(N)]
        for i in range(1, N):
            self.f[i] = self.f[i - 1] * i % self.mod
        self.g[-1] = pow(self.f[-1], mod - 2, mod)
        for i in range(N - 2, -1, -1):
            self.g[i] = self.g[i + 1] * (i + 1) % self.mod

    def fac(self, n):
        return self.f[n]

    def fac_inv(self, n):
        return self.g[n]

    def combi(self, n, m):
        if n < m or m < 0 or n < 0: return 0
        return self.f[n] * self.g[m] % self.mod * self.g[n - m] % self.mod


"""
幸福饺子馆【算法赛】

数学推导
"""
if __name__ == '__main__':
    t = int(input())
    outs = []

    mod = 998244353
    rev2 = (mod + 1) // 2
    fact = Factorial(2 * 10 ** 5, mod)

    for _ in range(t):
        n, l, r = map(int, input().split())
        outs.append(n * fact.combi(r - l + n - 2, n - 2) % mod * (l + r) % mod * rev2 % mod)

    print(*outs, sep='\n')