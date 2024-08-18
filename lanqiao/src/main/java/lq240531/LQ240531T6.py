if __name__ == '__main__':
    n, q = map(int, input().split())
    perm = list(map(int, input().split()))
    for i in range(n):
        perm[i] -= 1

    c1 = [0] * n
    c2 = [0] * n
    pos = [0] * n

    for i in range(n):
        c1[(i + perm[i]) % n] += 1
        c2[(i - perm[i]) % n] += 1
        pos[perm[i]] = i

    f1 = max(c1) == n
    f2 = max(c2) == n

    outs = []
    for _ in range(q):
        x, y = map(int, input().split())
        x -= 1
        y -= 1
        u, v = pos[x], pos[y]
        for i in (u, v):
            if c1[(i + perm[i]) % n] == n:
                f1 = False
            c1[(i + perm[i]) % n] -= 1

            if c2[(i - perm[i]) % n] == n:
                f2 = False
            c2[(i - perm[i]) % n] -= 1

        perm[u], perm[v] = perm[v], perm[u]
        pos[x], pos[y] = pos[y], pos[x]

        for i in (u, v):
            c1[(i + perm[i]) % n] += 1
            if c1[(i + perm[i]) % n] == n:
                f1 = True

            c2[(i - perm[i]) % n] += 1
            if c2[(i - perm[i]) % n] == n:
                f2 = True
        outs.append('Yes' if f1 or f2 else 'No')

    print('\n'.join(outs))