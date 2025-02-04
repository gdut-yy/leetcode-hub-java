"""
决出国特【算法赛】

第 n+1 个质数即为答案。
"""
if __name__ == '__main__':
    n = int(input())
    cur = 1
    for _ in range(n):
        flg = False
        while not flg:
            cur += 1
            for i in range(2, cur):
                if cur % i == 0: break
                if i * i > cur:
                    flg = True
                    break
    print(cur)