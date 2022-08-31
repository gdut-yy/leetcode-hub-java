import os
import datetime

# 统计天数
start = datetime.datetime(2021, 7, 4)
today = datetime.datetime.today()
between = today - start
print(between.days, 'days')

# 统计 leetcode 题量
cnt_lc_solutions = 0
cnt_lc_tests = 0
cwd = os.getcwd()
for dirpath, dirnames, filenames in os.walk(cwd):
    if("codeforces" not in dirpath and "leetcode-core" not in dirpath and "leetcode-extends" not in dirpath and "leetcode-lcp" not in dirpath):
        # 统计 Solution*.java
        if('\src\main\java' in dirpath):
            for filename in filenames:
                if('Solution' in filename):
                    cnt_lc_solutions+=1
        # 统计 Solution*Tests.java
        if('\src\\test\java' in dirpath):
            for filename in filenames:
                if('Tests' in filename):
                    cnt_lc_tests+=1
print('leetcode:')
print(cnt_lc_solutions)
print(cnt_lc_tests)

# 统计 codeforces 题量
cnt_cf_mains = 0
cnt_cf_tests = 0
cwd = os.getcwd()
for dirpath, dirnames, filenames in os.walk(cwd):
    if("codeforces" in dirpath):
        # 统计 CF*.java
        if('\src\main\java' in dirpath):
            for filename in filenames:
                if('CF' in filename):
                    cnt_cf_mains+=1
        # 统计 CF*Tests.java
        if('\src\\test\java' in dirpath):
            for filename in filenames:
                if('CF' in filename and 'Tests' in filename):
                    cnt_cf_tests+=1
print('codeforces:')
print(cnt_cf_mains)
print(cnt_cf_tests)