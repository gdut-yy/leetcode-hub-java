"""
BlueAI【算法赛】
"""
if __name__ == '__main__':
    n = int(input())
    grid = [list(input()) for _ in range(n)]

    dirs = [(i, j) for i in [-1, 1] for j in [-1, 1]]


    def dfs(i, j):
        res = 0
        for di, dj in dirs:
            if 0 <= i + 2 * di < n and 0 <= j + 2 * dj < n \
                    and grid[i + di][j + dj] == 'Q' and grid[i + 2 * di][j + 2 * dj] == '.':
                grid[i][j] = '.'
                grid[i + di][j + dj] = '.'
                grid[i + 2 * di][j + 2 * dj] = 'L'
                res = max(res, dfs(i + 2 * di, j + 2 * dj) + 1)
                grid[i][j] = 'L'
                grid[i + di][j + dj] = 'Q'
                grid[i + 2 * di][j + 2 * dj] = '.'
        return res


    ans = 0
    for i in range(n):
        for j in range(n):
            if grid[i][j] == 'L':
                ans = max(ans, dfs(i, j))

    print(ans)