import os
import datetime

def count_leetcode(cwd):
    cnt_lc_solutions = 0
    cnt_lc_tests = 0
    mp = set()
    exclude_paths = ['algo-core', 'atcoder', 'codeforces', 'lanqiao',
                     'leetcode-extends', 'leetcode-lcp', 'luogu', 'nowcoder']
    for dirpath, dirnames, filenames in os.walk(cwd):
        ok = True
        for exclude_path in exclude_paths:
            if exclude_path in dirpath:
                ok = False
                break
        if ok:
            if '\src\main\java' in dirpath:
                for filename in filenames:
                    if 'Solution' in filename:
                        key = filename.replace('SolutionP', '').replace('Solution', '').replace('.java', '')
                        mp.add(key)
                        cnt_lc_solutions += 1
            if '\src\\test\java' in dirpath:
                for filename in filenames:
                    if 'Tests' in filename:
                        key = filename.replace('SolutionP', '').replace('Solution', '').replace('.java', '').replace(
                            'Tests', '')
                        mp.discard(key)
                        cnt_lc_tests += 1
    return cnt_lc_solutions, cnt_lc_tests, mp

def count_codeforces(cwd):
    cnt_cf_mains = 0
    cnt_cf_tests = 0
    mp = set()
    for dirpath, dirnames, filenames in os.walk(cwd):
        if "codeforces" in dirpath:
            if '\src\main\java' in dirpath:
                for filename in filenames:
                    if 'CF' in filename:
                        key = filename.replace('.java', '')
                        mp.add(key)
                        cnt_cf_mains += 1
            if '\src\\test\java' in dirpath:
                for filename in filenames:
                    if 'CF' in filename and 'Tests' in filename:
                        key = filename.replace('Tests.java', '')
                        mp.discard(key)
                        cnt_cf_tests += 1
    return cnt_cf_mains, cnt_cf_tests, mp

def count_atcoder(cwd):
    cnt_at_mains = 0
    cnt_at_tests = 0
    for dirpath, dirnames, filenames in os.walk(cwd):
        if "atcoder" in dirpath:
            if '\src\main\java' in dirpath:
                for filename in filenames:
                    if '_' in filename:
                        cnt_at_mains += 1
            if '\src\\test\java' in dirpath:
                for filename in filenames:
                    if 'Tests' in filename:
                        cnt_at_tests += 1
    return cnt_at_mains, cnt_at_tests

if __name__ == '__main__':
    start = datetime.datetime(2021, 7, 4)
    today = datetime.datetime.today()
    between = today - start
    print(between.days, 'days')

    cwd = os.getcwd()

    cnt_lc_solutions, cnt_lc_tests, mp = count_leetcode(cwd)
    print('leetcode:')
    print(cnt_lc_solutions)
    print(cnt_lc_tests)
    print(mp)

    cnt_cf_mains, cnt_cf_tests, mp = count_codeforces(cwd)
    print('codeforces:')
    print(cnt_cf_mains)
    print(cnt_cf_tests)
    print(mp)

    cnt_at_mains, cnt_at_tests = count_atcoder(cwd)
    print('atcoder:')
    print(cnt_at_mains)
    print(cnt_at_tests)