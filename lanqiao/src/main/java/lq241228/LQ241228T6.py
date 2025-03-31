"""
排序题目【算法赛】
"""


def prep(p):
    pi = [0] * len(p)
    j = 0
    for i in range(1, len(p)):
        while j != 0 and p[j] != p[i]:
            j = pi[j - 1]
        if p[j] == p[i]:
            j += 1
        pi[i] = j
    return pi


def solve():
    n = int(input())
    nums = list(map(int, input().split()))

    flg = True
    for i in range(1, n):
        if nums[i] < nums[i - 1]:
            flg = False
    if flg:
        print('0')
        return

    st = sorted(nums)

    diff_idx = 0
    for i in range(n):
        if nums[i] != st[i]:
            diff_idx = i

    tmp = st[:diff_idx + 1] + [-1] + nums[:diff_idx + 1] * 2

    if diff_idx + 1 in prep(tmp):
        print(diff_idx + 1)
    else:
        print(diff_idx + 3)


if __name__ == '__main__':
    solve()