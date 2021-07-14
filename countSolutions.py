import os

cntsolution = 0
cntsolutiontests = 0
cwd = os.getcwd()
for dirpath, dirnames, filenames in os.walk(cwd):
    # 统计 Solution*.java
    if('\src\main\java' in dirpath):
        for filename in filenames:
            if('.java' in filename):
                cntsolution+=1
    # 统计 Solution*Tests.java
    if('\src\\test\java' in dirpath):
        for filename in filenames:
            if('Tests.java' in filename):
                cntsolutiontests+=1
print(cntsolution)
print(cntsolutiontests)