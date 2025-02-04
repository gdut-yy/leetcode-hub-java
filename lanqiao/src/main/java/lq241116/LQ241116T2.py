"""
消灭卡片【算法赛】
"""
if __name__ == '__main__':
    t = int(input())
    outs = []

    for _ in range(t):
        n = int(input())
        for i in range(5):
            if (n - 3 * i) % 5 == 0:
                outs.append(-1 if 3 * i > n else ((n - 3 * i) // 5 + i))
    print(*outs, sep='\n')