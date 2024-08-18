import math
import random


def miller_rabin(p):
    if p <= 4: return p in (2, 3)
    pow_2, tmp = 0, p - 1
    while tmp % 2 == 0:
        tmp //= 2
        pow_2 += 1
    for a in (2, 3, 5, 7, 11):
        basic = pow(a, tmp, p)
        if basic in (0, 1, p - 1): continue
        for _ in range(1, pow_2):
            basic = basic ** 2 % p
            if basic == 1: return False
            if basic == p - 1: break
        if basic != p - 1: return False
    return True


def pollard_rho(n):
    bias = random.randint(3, n - 1)
    update = lambda i: (i ** 2 + bias) % n
    x = random.randint(0, n - 1)
    y = update(x)
    while x != y:
        factor = math.gcd(abs(x - y), n)
        if factor != 1: return factor
        x = update(x)
        y = update(update(y))
    return n


class prime_factor(dict):
    def __init__(self, n):
        super(prime_factor, self).__init__()
        self.main(n, gain=1)

    def add(self, n, cnt):
        self.update({n: self.get(n, 0) + cnt})

    def count(self, n, fac):
        c = self.get(n, 0)
        if c == 0:
            c = 1
        return n // fac, c

    def main(self, n, gain):
        if n > 7e5:
            if miller_rabin(n):
                self.add(n, gain)
            else:
                fac = pollard_rho(n)
                n, cnt = self.count(n, fac)
                self.main(fac, gain=cnt * gain)
                if n > 1:   self.main(n, gain=gain)
        else:
            self.try_divide(n, gain=gain)

    def try_divide(self, n, gain=1):
        # 复杂度sqrt(n)。可以处理1e12
        i = 2
        while i * i <= n:
            if n % i == 0:
                self.add(i, gain)
                n = n // i
            else:
                i += 1
        if n > 1:
            self.add(n, gain)


if __name__ == '__main__':
    t = int(input())
    mod = 10 ** 9 + 7
    final = []
    # 若 n = p1^c1 * p2^c2 * ... * pt^ct
    # 我们求 f_k(n) = f_k(p1^c1) * ... * f_k(pt^ct)
    for _ in range(t):
        n, k = map(int, input().split())
        ans = 1
        primes = prime_factor(n)
        # print(primes)
        for p in primes:
            # 我们要求的是 p^0 + p^k + ... + p^vk
            # (p^k)^0 + (p^k)^1 + ... + (p^k)^v
            v = pow(p, k, mod)
            cur = tot = 1
            for _ in range(primes[p]):
                cur *= v
                cur %= mod
                tot += cur
            ans *= tot
            ans %= mod
        final.append(ans)
    print('\n'.join(map(str, final)))