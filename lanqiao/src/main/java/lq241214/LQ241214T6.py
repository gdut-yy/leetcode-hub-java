"""
估算分数【算法赛】
"""
if __name__ == '__main__':
    a, b, c = map(int, input().split())
    val = (c - 1) // b


    def check(v):
        x = -a // v + c
        if x % b:
            return False
        x //= b
        return 1 <= x <= val


    ans = val
    for i in range(1, 10 ** 5 + 1):
        if a % i == 0:
            if check(i):
                ans -= 1
            if i * i != a and check(a // i):
                ans -= 1
        if i * i >= a:
            break
    print(ans)