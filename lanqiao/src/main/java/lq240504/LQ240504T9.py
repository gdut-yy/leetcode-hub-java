import math

if __name__ == '__main__':
    v1 = 22472
    mod1 = v1 // 2
    tmp1 = [[] for _ in range(v1)]
    for i in range(mod1):
        tmp1[i * i % v1].append(i)

    pairs1 = set()
    for i in range(mod1 + 1):
        if tmp1[i] and tmp1[-i]:
            for x in tmp1[i]:
                for y in tmp1[-i]:
                    pairs1.add((x, y))
                    pairs1.add((y, x))

    pairs1 = {(x, y) for x, y in pairs1 if x <= y}

    v2 = 1000003 * 9


    def f(x):
        x //= v2 ** 2
        cnt = 0
        for a, b in pairs1:
            if a < b: a, b = b, a
            res = 0
            ca = a
            while True:
                if ca * ca + b * b > x: break
                res += (math.isqrt(x - ca * ca) - b) // mod1 + 1
                ca += mod1
            if a != b: res *= 2
            cnt += res
        return cnt


    l, r = map(int, input().split())
    print(f(r) - f(l - 1))