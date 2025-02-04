"""
标记名字【算法赛】

答案就是 n 所对应的欧拉函数。
"""
if __name__ == '__main__':
    n = int(input())
    ans = n
    for i in range(2, 10 ** 5):
        if n % i == 0:
            ans = ans // i * (i - 1)
            while n % i == 0:
                n //= i
    if n > 1:
        ans = ans // n * (n - 1)
    print(ans)