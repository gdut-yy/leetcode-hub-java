"""
灵活区间【算法赛】

将区间内所有元素都变为相同值的最小操作次数，等价于将所有元素调整到区间的中位数的操作次数。
"""
from collections import Counter
from heapq import heappop, heappush

if __name__ == '__main__':
    def solve():
        n, m = map(int, input().split())
        nums = list(map(int, input().split()))

        l = r = 0

        lpq = []
        rpq = []
        ldel = Counter()
        rdel = Counter()
        lsz = 0
        rsz = 0
        ltot = 0
        rtot = 0

        def lclear():
            while lpq and ldel[lpq[0]]:
                ldel[lpq[0]] -= 1
                heappop(lpq)

        def rclear():
            while rpq and rdel[rpq[0]]:
                rdel[rpq[0]] -= 1
                heappop(rpq)

        def adj():
            nonlocal lsz, rsz, ltot, rtot
            lclear()
            while lsz > rsz + 1:
                lclear()
                x = -heappop(lpq)
                heappush(rpq, x)
                ltot -= x
                lsz -= 1
                rtot += x
                rsz += 1

            while lsz < rsz:
                rclear()
                x = heappop(rpq)
                heappush(lpq, -x)
                rtot -= x
                rsz -= 1
                ltot += x
                lsz += 1

        ans = 0
        while l < n:
            adj()
            while r < n:
                cur = rtot - ltot
                if lsz > rsz:
                    cur -= lpq[0]
                if cur > m:
                    break

                if lsz == 0 or -lpq[0] >= nums[r]:
                    heappush(lpq, -nums[r])
                    ltot += nums[r]
                    lsz += 1
                else:
                    heappush(rpq, nums[r])
                    rtot += nums[r]
                    rsz += 1
                adj()
                r += 1

            cur = rtot - ltot
            if lsz > rsz:
                cur -= lpq[0]
            ans += r - l
            if cur > m:
                ans -= 1

            if nums[l] <= -lpq[0]:
                ltot -= nums[l]
                lsz -= 1
                ldel[-nums[l]] += 1
            else:
                rtot -= nums[l]
                rsz -= 1
                rdel[nums[l]] += 1

            l += 1
        print(ans)


    solve()