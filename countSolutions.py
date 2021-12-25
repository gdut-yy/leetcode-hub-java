import os
import datetime

# 统计天数
start = datetime.datetime(2021, 7, 4)
today = datetime.datetime.today()
between = today - start
print(between.days, 'days')

# 统计题量
cntsolution = 0
cntsolutiontests = 0
cwd = os.getcwd()
for dirpath, dirnames, filenames in os.walk(cwd):
    if("leetcode-extends" not in dirpath and "codeforces" not in dirpath):
        # 统计 Solution*.java
        if('\src\main\java' in dirpath):
            for filename in filenames:
                if('Solution' in filename):
                    cntsolution+=1
        # 统计 Solution*Tests.java
        if('\src\\test\java' in dirpath):
            for filename in filenames:
                if('Tests' in filename):
                    cntsolutiontests+=1
print(cntsolution)
print(cntsolutiontests)