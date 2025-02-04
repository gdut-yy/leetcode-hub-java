"""
抵御攻击【算法赛】
"""
if __name__ == '__main__':
    n, m = map(int, input().split())
    nums1 = [-10 ** 9] + list(map(int, input().split())) + [2 * 10 ** 9]
    nums2 = list(map(int, input().split()))
    nums1.sort()
    nums2.sort()

    ans = 0
    pt = 0
    for i in range(1, n + 2):
        l = pt
        r = pt
        while pt < m and nums2[pt] <= nums1[i]:
            pt += 1
            r = pt
        if l < r:
            res = max(nums2[l] - nums1[i - 1], nums1[i] - nums2[r - 1])
            for j in range(l, r - 1):
                res = max(res, nums2[j + 1] - nums2[j])
            ans += nums1[i] - nums1[i - 1] - res

    print(ans)