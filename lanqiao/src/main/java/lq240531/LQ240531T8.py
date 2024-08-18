if __name__ == '__main__':
    def f(x, y):
        return x * n + y


    n = int(input())
    nums = list(map(int, input().split()))
    for i in range(n):
        nums[i] -= 1
    dp = [0] * (n * n)

    left = [n] * n
    right = [-1] * n
    for i in range(n):
        left[nums[i]] = min(left[nums[i]], i)
        right[nums[i]] = max(right[nums[i]], i)

    for i in range(n):
        if left[nums[i]] == right[nums[i]] == i:
            dp[f(i, i)] = 1

    for length in range(2, n + 1):
        for l in range(n - length + 1):
            r = l + length - 1
            lscore = 1 if left[nums[l]] == l and right[nums[l]] <= r else 0
            rscore = 1 if right[nums[r]] == r and left[nums[r]] >= l else 0
            dp[f(l, r)] = max(lscore - dp[f(l + 1, r)], rscore - dp[f(l, r - 1)])

    tot = 0
    for i in range(n):
        if right[i] != -1:
            tot += 1

    ans = dp[f(0, n - 1)]
    print((tot + ans) // 2, (tot - ans) // 2)