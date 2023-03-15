import sys
from operator import itemgetter

class UnionSet:
    def __init__(self, n: int):
        self.parent = [*range(n)]
        self.wcnt = [1] * n
        self.pcnt = [0] * n

    def find(self, x):
        while x != self.parent[x]:
            self.parent[x] = self.parent[self.parent[x]]
            x = self.parent[x]
        return x

    def check(self, x: int, y: int) -> bool:
        return self.find(x) == self.find(y)

    def union(self, x, y):
        x_0 = self.find(x)
        y_0 = self.find(y)

        if self.wcnt[x_0] + self.wcnt[y_0] <= self.pcnt[x_0] + self.pcnt[y_0]:
            return False

        if x_0 == y_0:
            self.pcnt[x_0] += 1
        else:
            if self.wcnt[x_0] < self.wcnt[y_0]:
                self.wcnt[y_0] += self.wcnt[x_0]
                self.pcnt[y_0] += self.pcnt[x_0] + 1
                self.parent[x_0] = y_0
            else:
                self.wcnt[x_0] += self.wcnt[y_0]
                self.pcnt[x_0] += self.pcnt[y_0] + 1
                self.parent[y_0] = x_0
        return True

input = lambda: sys.stdin.readline().rstrip("\r\n")
def read_int_tuple(): return tuple(map(int, input().split()))

try:
    n, m = read_int_tuple()
    us = UnionSet(m + 1)
    print(sum(w for u, v, w in sorted((read_int_tuple() for _ in range(n)),
                                      key=itemgetter(2),
                                      reverse=True)
              if us.union(u, v)))
except:
    print(0)