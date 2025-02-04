"""
铠甲合体【算法赛】

1、基于能力值存在倍数关系，可通过贪心策略，将能量值从小到大排序后从最大的开始尝试组合，
以此求解最小合体次数，且这样不会导致程序超时，因为能量值种类数与最大值存在对数关系。
2、具体操作上，先对铠甲勇士能量值去重，排序并记录对应数量，再针对每个暗影护法，从能量值最大的铠甲勇士开始，
尽可能用其进行合体，按能量值从大到小依次处理，直至凑出目标战斗力或无法凑出。
"""
from collections import Counter

if __name__ == '__main__':
    n, m = map(int, input().split())
    num1 = list(map(int, input().split()))
    cnt = Counter(num1)
    vals = sorted(cnt, reverse=True)

    num2 = list(map(int, input().split()))
    ans = [-1] * m

    for i in range(m):
        x = num2[i]
        res = 0
        for v in vals:
            c = min(cnt[v], x // v)
            res += c
            x -= v * c
        if x == 0:
            ans[i] = res
    print(*ans, sep=' ')