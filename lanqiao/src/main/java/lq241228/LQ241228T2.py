"""
开赛主题曲【算法赛】
"""
from string import ascii_lowercase

if __name__ == '__main__':
    n = int(input())
    s = input()
    to_compare = 'lanqiobe'

    ans = -2
    chosen = ''

    d = dict(zip(ascii_lowercase, list(range(1, 27))))

    for i in range(n):
        st = set()
        cur = 0

        for j in range(i, n):
            if s[j] in st:
                break
            st.add(s[j])
            cur += d[s[j]]

            res = -1
            for start in range(i, j + 1):
                for step in range(8):
                    if start + step > j or start + step >= n or s[start + step] != to_compare[step]:
                        break
                    res = max(res, step)
            res = (res + 1) * 10 + cur
            if res == ans:
                chosen = min(chosen, s[i:j + 1])
            elif res > ans:
                ans = res
                chosen = s[i:j + 1]

    print(chosen)