import typing


class FenwickTree:
    def __init__(self, n, iter=None):
        self.n = n
        if iter is not None:
            self.bit = list(iter)

            for i in range(self.n):
                if i | (i + 1) < self.n:
                    self.bit[i | (i + 1)] += self.bit[i]
        else:
            self.bit = [0] * n
        length = (self.n + 1).bit_length() - 1
        self.powers = [1 << i for i in range(length, -1, -1)]
        self.tot = 0

    def sum(self, r):
        res = 0
        while r >= 0:
            res += self.bit[r]
            r = (r & (r + 1)) - 1
        return res

    def rsum(self, l, r):
        return self.sum(r) - self.sum(l - 1)

    def add(self, idx, delta):
        while idx < self.n:
            self.bit[idx] += delta
            idx = idx | (idx + 1)
        self.tot += delta

    def bisect_min_larger(self, num):
        if num <= 0: return -1
        note = -1
        tmp = 0
        for power in self.powers:
            if note + power >= self.n or \
                    tmp + self.bit[note + power] >= num: continue
            note += power
            tmp += self.bit[note]
        return note + 1

    def bisect_max_smaller(self, num):
        if num > self.tot: return self.n
        note = -1
        tmp = 0
        for power in self.powers:
            if note + power >= self.n or \
                    tmp + self.bit[note + power] >= num: continue
            note += power
            tmp += self.bit[note]
        return note


class SegTree:
    def __init__(self,
                 op: typing.Callable[[typing.Any, typing.Any], typing.Any],
                 e: typing.Any,
                 v: typing.Union[int, typing.List[typing.Any]]) -> None:
        self._op = op
        self._e = e

        if isinstance(v, int):
            v = [e] * v

        self._n = len(v)
        self._log = (self._n - 1).bit_length()
        self._size = 1 << self._log
        self._d = [e] * (2 * self._size)

        for i in range(self._n):
            self._d[self._size + i] = v[i]
        for i in range(self._size - 1, 0, -1):
            self._update(i)

    def set(self, p: int, x: typing.Any) -> None:
        assert 0 <= p < self._n

        p += self._size
        self._d[p] = x
        for i in range(1, self._log + 1):
            self._update(p >> i)

    def get(self, p: int) -> typing.Any:
        assert 0 <= p < self._n

        return self._d[p + self._size]

    def prod(self, left: int, right: int) -> typing.Any:
        assert 0 <= left <= right <= self._n
        sml = self._e
        smr = self._e
        left += self._size
        right += self._size

        while left < right:
            if left & 1:
                sml = self._op(sml, self._d[left])
                left += 1
            if right & 1:
                right -= 1
                smr = self._op(self._d[right], smr)
            left >>= 1
            right >>= 1

        return self._op(sml, smr)

    def all_prod(self) -> typing.Any:
        return self._d[1]

    def max_right(self, left: int,
                  f: typing.Callable[[typing.Any], bool]) -> int:
        assert 0 <= left <= self._n
        assert f(self._e)

        if left == self._n:
            return self._n

        left += self._size
        sm = self._e

        first = True
        while first or (left & -left) != left:
            first = False
            while left % 2 == 0:
                left >>= 1
            if not f(self._op(sm, self._d[left])):
                while left < self._size:
                    left *= 2
                    if f(self._op(sm, self._d[left])):
                        sm = self._op(sm, self._d[left])
                        left += 1
                return left - self._size
            sm = self._op(sm, self._d[left])
            left += 1

        return self._n

    def min_left(self, right: int,
                 f: typing.Callable[[typing.Any], bool]) -> int:
        assert 0 <= right <= self._n
        assert f(self._e)

        if right == 0:
            return 0

        right += self._size
        sm = self._e

        first = True
        while first or (right & -right) != right:
            first = False
            right -= 1
            while right > 1 and right % 2:
                right >>= 1
            if not f(self._op(self._d[right], sm)):
                while right < self._size:
                    right = 2 * right + 1
                    if f(self._op(self._d[right], sm)):
                        sm = self._op(self._d[right], sm)
                        right -= 1
                return right + 1 - self._size
            sm = self._op(self._d[right], sm)

        return 0

    def _update(self, k: int) -> None:
        self._d[k] = self._op(self._d[2 * k], self._d[2 * k + 1])


if __name__ == '__main__':
    n = int(input())
    nums = list(map(int, input().split()))

    inf = 10 ** 16
    fen = FenwickTree(n)
    for i in range(n):
        fen.add(i, 1)
    seg = SegTree(lambda x, y: x if x < y else y, inf, [nums[i] * n + i for i in range(n)])

    ans = sum(nums)

    q = int(input())
    for _ in range(q):
        l, r = map(int, input().split())
        p1, p2 = fen.bisect_min_larger(l), fen.bisect_min_larger(r)
        v, idx = divmod(seg.prod(p1, p2 + 1), n)
        ans -= v
        seg.set(idx, inf)
        fen.add(idx, -1)

    print(ans)