"""
录入成绩【算法赛】

枚举
"""
if __name__ == '__main__':
    s = input()
    n = len(s)

    dp = [[-n] * (n + 1) for _ in range(256)]
    dp[0][0] = 0

    msks = {}
    msks['G'] = 1
    msks['G1'] = 2
    msks['G2'] = 4
    msks['G3'] = 8
    msks['GG'] = 16
    msks['1'] = 32
    msks['2'] = 64
    msks['3'] = 128

    for i in range(n):
        for msk in range(256):
            if dp[msk][i] >= 0:
                for d in range(1, 3):
                    if i + d <= n and s[i:i + d] in msks:
                        nmsk = msks[s[i:i + d]]
                        if nmsk != 1 or nmsk & msk == 0:
                            v = nmsk | msk
                            dp[v][i + d] = max(dp[v][i + d], dp[msk][i] + (nmsk == 2))
    print(dp[-1][-1])