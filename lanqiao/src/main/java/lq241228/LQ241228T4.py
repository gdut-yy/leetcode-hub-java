"""
秃头风险【算法赛】
"""
import math

if __name__ == '__main__':
    n = int(input())
    nums = list(map(int, input().split()))

    ans = 0
    for v in nums:
        if v % 2 == 0:
            ans += 1
        elif math.isqrt(v) ** 2 == v:
            ans += 1

    print(ans)