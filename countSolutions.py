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
exclude_paths = ['atcoder', 'codeforces', 'leetcode-core',
                 'leetcode-extends', 'leetcode-lcp']
for dirpath, dirnames, filenames in os.walk(cwd):
    ok = True
    for exclude_path in exclude_paths:
        if exclude_path in dirpath:
            ok = False
            break
    if ok:
        # 统计 Solution*.java
        if '\src\main\java' in dirpath:
            for filename in filenames:
                if 'Solution' in filename:
                    cnt_lc_solutions += 1
        # 统计 Solution*Tests.java
        if '\src\\test\java' in dirpath:
            for filename in filenames:
                if 'Tests' in filename:
                    cnt_lc_tests += 1
print('leetcode:')
print(cnt_lc_solutions)
print(cnt_lc_tests)

# 统计 codeforces 题量
cnt_cf_mains = 0
cnt_cf_tests = 0
cwd = os.getcwd()
for dirpath, dirnames, filenames in os.walk(cwd):
    if "codeforces" in dirpath:
        # 统计 CF*.java
        if '\src\main\java' in dirpath:
            for filename in filenames:
                if 'CF' in filename:
                    cnt_cf_mains += 1
        # 统计 CF*Tests.java
        if '\src\\test\java' in dirpath:
            for filename in filenames:
                if 'CF' in filename and 'Tests' in filename:
                    cnt_cf_tests += 1
print('codeforces:')
print(cnt_cf_mains)
print(cnt_cf_tests)

# 统计 atcoder 题量
cnt_at_mains = 0
cnt_at_tests = 0
cwd = os.getcwd()
for dirpath, dirnames, filenames in os.walk(cwd):
    if "atcoder" in dirpath:
        # 统计 CF*.java
        if '\src\main\java' in dirpath:
            for filename in filenames:
                if '_' in filename:
                    cnt_at_mains += 1
        # 统计 CF*Tests.java
        if '\src\\test\java' in dirpath:
            for filename in filenames:
                if 'Tests' in filename:
                    cnt_at_tests += 1
print('atcoder:')
print(cnt_at_mains)
print(cnt_at_tests)
