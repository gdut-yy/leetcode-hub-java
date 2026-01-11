import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class P5322 {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int s = scanner.nextInt();
        int n = scanner.nextInt();
        int mx = scanner.nextInt();

        List<List<Integer>> groups = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            groups.add(new ArrayList<>());
        }

        for (int i = 0; i < s; i++) {
            for (int j = 0; j < n; j++) {
                int v = scanner.nextInt();
                v = v * 2 + 1;
                if (v <= mx) {
                    groups.get(j).add(v);
                }
            }
        }

        int[] f = new int[mx + 1];

        for (int i = 0; i < n; i++) {
            List<Integer> g = groups.get(i);
            Collections.sort(g);

            List<int[]> ps = new ArrayList<>();
            for (int j = 0; j < g.size(); j++) {
                int w = g.get(j);
                if (j == g.size() - 1 || w != g.get(j + 1)) {
                    ps.add(new int[]{(j + 1) * (i + 1), w});
                }
            }

            for (int j = mx; j >= 0; j--) {
                for (int[] p : ps) {
                    if (p[1] > j) {
                        break;
                    }
                    f[j] = Math.max(f[j], f[j - p[1]] + p[0]);
                }
            }
        }

        out.print(f[mx]);
    }
}
/*
https://www.luogu.com.cn/problem/P5322

灵茶の试炼 2025-12-02
输入 s(1≤s≤100) n(1≤n≤100) m(1≤m≤2e4)。
然后输入 s 个长度都为 n 的非负整数数组 a[1],a[2],...,a[s]，每个 a[i] 都满足 sum(a[i]) <= m。
你需要构造一个长为 n 的非负整数数组 b，满足 sum(b) <= m。
然后遍历 a[i][j]，如果 b[j] > a[i][j] * 2，那么得到 j 分。
输出你的最大总得分。
注：O(snm) 可过。

把 m 视作背包容量，分配给 b[j] 的数视作物品体积，b[j] 在每个 a[i][j] 上得到的分数之和视作物品价值，本题是一个分组背包模型。
对于第 j 组（竖着看 a[i][j]），枚举分配给 b[j] 的数为 w=1,2,3,...,m。每个数有对应的价值。
比如分配 b[j]=7，那么价值就是在 a[i][j] 中的满足 a[i][j] * 2 < 7 的元素个数，乘以 j。
定义 f[x][s] 表示前 x 组分配元素和至多为 s 时的最大得分。
枚举第 x 组分配 w，那么问题变成前 x-1 组分配元素和至多为 s-w 时的最大得分，即 f[x-1][s-w]，加上对应的得分，更新 f[x][s] 的最大值。
代码实现时，可以只枚举 w=a[i][j]*2+1（b[j] 刚好比 a[i][j]*2 大一点），比如 a[i][j]*2+1 有 3,7,9，那么就没必要枚举 w 为其他的数，比如 1,2,4,5,6 等等（其实偶数都不需要枚举）。
代码 https://paste.ubuntu.com/p/SqWm4Rkrdm/
======
# P5322 [BJOI2019] 排兵布阵

## 题目描述

小 C 正在玩一款排兵布阵的游戏。在游戏中有 $n$ 座城堡，每局对战由两名玩家来争夺这些城堡。每名玩家有 $m$ 名士兵，可以向第 $i$ 座城堡派遣 $a_i$ 名士兵去争夺这个城堡，使得总士兵数不超过 $m$。

如果一名玩家向第 $i$ 座城堡派遣的士兵数**严格**大于对手派遣士兵数的两倍，那么这名玩家就占领了这座城堡，获得 $i$ 分。

现在小 C 即将和其他 $s$ 名玩家两两对战，这 $s$ 场对决的派遣士兵方案必须相同。小 C 通过某些途径得知了其他 $s$ 名玩家即将使用的策略，他想知道他应该使用什么策略来最大化自己的总分。

由于答案可能不唯一，你只需要输出小 C 总分的最大值。

## 输入格式

输入第一行包含三个正整数 $s,n,m$，分别表示除了小 C 以外的玩家人数、城堡数和每名玩家拥有的士兵数。
接下来 $s$ 行，每行 $n$ 个非负整数，表示一名玩家的策略，其中第 $i$ 个数 $a_i$ 表示这名玩家向第 $i$ 座城堡派遣的士兵数。

## 输出格式

输出一行一个非负整数，表示小 C 获得的最大得分。

## 输入输出样例 #1

### 输入 #1

```
1 3 10
2 2 6
```

### 输出 #1

```
3
```

## 输入输出样例 #2

### 输入 #2

```
2 3 10
2 2 6
0 0 0
```

### 输出 #2

```
8
```

## 说明/提示

**样例1解释：**
小 C 的最佳策略为向第 $1$ 座城堡和第 $2$ 座城堡各派遣 $5$ 名士兵。

**样例2解释：**
小 C 的最佳策略之一为向第 $1$ 座城堡派遣 $2$ 名士兵，向第 $2$ 座城堡派遣 $5$ 名士兵，向第 $3$ 座城堡派遣 $1$ 名士兵。

**数据范围：**
对于 $10\%$ 的数据： $s=1,n \le 3,m \le 10$
对于 $20\%$ 的数据： $s=1,n \le 10,m \le 100$
对于 $40\%$ 的数据： $n\le 10,m\le 100$
对于另外 $20\%$ 的数据： $s=1$
对于 $100\%$ 的数据：
$1\le s \le 100$
$1\le n \le 100$
$1\le m \le 20000$
对于每名玩家 $a_i \ge 0$，$\sum\limits_{i=1}^n a_i \le m$
 */