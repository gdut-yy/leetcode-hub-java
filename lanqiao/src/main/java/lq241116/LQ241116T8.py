class XorBase:
    n = 30

    def __init__(self):
        self.base = [0] * self.n

    def add(self, num):
        for i in range(num.bit_length() - 1, -1, -1):
            if (num >> i) & 1:
                if self.base[i] == 0:
                    self.base[i] = num
                    return True
                else:
                    num ^= self.base[i]
        return False

    def check(self, num):
        for i in range(num.bit_length() - 1, -1, -1):
            if (num >> i) & 1:
                if self.base[i] == 0:
                    return False
                num ^= self.base[i]
        return True


"""
战斗力评估【算法赛】

根据异或性质，在将序列 A 对于一个相同的数进行了两次异或操作后，序列 A 中元素的值不会改变。因此 B 只是 A 的一个排列
转换问题：转化为：求有多少种 A 的排列 B，存在一个整数 X，使得对于所有 i (1 <= i <= N-1)，都有
B_{i} xor X <= B_{i+1} xor X
"""
if __name__ == '__main__':
    n = int(input())
    nums = list(map(int, input().split()))
    base = XorBase()
    ans = 1
    for i in range(1, n):
        if base.add(nums[i] ^ nums[0]):
            ans *= 2
    print(ans)