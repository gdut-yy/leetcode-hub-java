"""
能量晶石【算法赛】

考虑逆向思维
去一次矿脉相当于让自己的晶石数量 -1
"""
if __name__ == '__main__':
    n = int(input())
    nums = list(map(int, input().split()))
    print(sum(nums) - min(nums) * n)