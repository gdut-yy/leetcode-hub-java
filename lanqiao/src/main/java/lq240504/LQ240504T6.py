import math

if __name__ == '__main__':
    n, x = map(int, input().split())
    nums1 = list(map(int, input().split()))
    m, y = map(int, input().split())
    nums2 = list(map(int, input().split()))

    cost = [0] * (1 << 17)
    for i in range(1 << 17):
        for j in range(17):
            if i >> j & 1:
                cost[i] = cost[i ^ (1 << j)] + j + 1

    tmp = [[] for _ in range(17)]
    for j in range(17):
        cur = []
        for i in range(1 << 17):
            if cost[i] <= j:
                cur.append(i)

        for v1 in cur:
            for v2 in cur:
                if v1 == v1 & v2 and v1 != v2:
                    break
            else:
                tmp[j].append(v1)


    def solve(nums, val):
        dp = [0] * (1 << 16)
        dp[0] = 1
        for num in nums:
            for i in range((1 << 16) - 1, -1, -1):
                if dp[i]:
                    for x in tmp[num]:
                        dp[i | x] = 1

        ans = 0
        for i in range(1 << 16):
            if dp[i]:
                res = 0
                cur = val
                for j in range(16):
                    if i >> j & 1:
                        res += 1
                    elif cur >= j + 1:
                        cur -= j + 1
                        res += 1
                ans = max(ans, res + (math.isqrt(cur * 8 + 33 * 33) - 33) // 2)
        return ans


    a = solve(nums1, x)
    b = solve(nums2, y)
    if a > b:
        print('Clrlss')
    elif a < b:
        print('Yaya')
    else:
        print('Draw')