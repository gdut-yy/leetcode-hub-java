import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class SolutionLCP82 {
    private static final int N = 9, M0 = 205;
    private final int[] pow10 = new int[M0], pinv = new int[M0], l = new int[N], len = new int[1 << N];
    private int n, ans, p, r, B;
    private final Map<Integer, List<Integer>> c = new HashMap<>();
    private final Map<Integer, List<Node>> d = new HashMap<>();
    private final Map<Integer, Integer> hash = new HashMap<>();

    public int treeOfInfiniteSouls(int[] gem, int p, int target) {
        n = gem.length;
        ans = 0;
        B = (n + 2) / 3;
        this.p = p;
        this.r = target;

        if (p == 2 || p == 5) {
            return p == 2 && target == 1 || p == 5 && target == 4 ? (int) (C((n - 1) * 2, n - 1) / n * fac(n)) : 0;
        }
        pow10[0] = 1 % p;
        for (int i = 1; i < M0; ++i) {
            pow10[i] = (int) ((long) pow10[i - 1] * 10 % p);
        }
        for (int i = 0; i < M0; ++i) {
            pinv[i] = (int) inv(pow10[i], p);
        }
        for (int i = 0; i < n; ++i) {
            l[i] = log10(gem[i]);
        }
        for (int i = 1; i < (1 << n); ++i) {
            len[i] = (pop(i) * 2 - 1) * 2;
            for (int j = 0; j < n; ++j) {
                if ((i & (1 << j)) > 0) {
                    len[i] += l[j];
                }
            }
        }
        for (int i = 0; i < n; ++i) {
            c.computeIfAbsent(1 << i, key -> new ArrayList<>()).add((int) (((long) gem[i] * 10 + pow10[l[i] + 1] + 9) % p));
        }
        for (int i = 1; i < (1 << n); ++i) {
            if (pop(i) <= B * 2) {  //component below u
                int t = pow10[len[i] - 1] + 9;
                for (int j = (i - 1) & i; j != 0; j = (j - 1) & i) {
                    if (n == 9 || pop(i) < Math.max((n + 1) / 2, 2)
                            || Math.max(pop(j), pop(i - j)) <= Math.min(B, (n - 1) / 2)) {
                        for (Integer v1 : c.getOrDefault(j, new ArrayList<>())) {
                            long t1 = (long) v1 * pow10[len[i - j] + 1] + t;
                            for (Integer v2 : c.getOrDefault(i - j, new ArrayList<>())) {
                                c.computeIfAbsent(i, key -> new ArrayList<>()).add((int) (((long) v2 * 10 + t1) % p));
                            }
                        }
                    }
                }
            }
        }
        d.computeIfAbsent(1 << n, key -> new ArrayList<>()).add(new Node(0, 0, 0)); //component above u
        BiFunction<Integer, Integer, Boolean> yes = (x, y) -> true;
        BiFunction<Integer, Integer, Boolean> no = (x, y) -> false;
        if (n == 9) {
            calc(4, yes, no, (j) -> pop(j) != 6); //remove size 6
            calc(5, (i, j) -> j != (1 << n) || pop(i - j) >= 2, //remove size 5
                    no, (j) -> pop(j) != 5);
            calc(6, (i, j) -> j != (1 << n) || pop(i - j) == 3, //remove size 4
                    (i, j) -> j == (1 << n) && pop(i - j) == 4,
                    (j) -> pop(j) != 4);
        } else {
            calc(n / 2 + 1, yes,
                    (i, j) -> n % 2 == 0 && pop(j) == 1 && pop(i - j) == n / 2,
                    (j) -> pop(j) < (n + 1) / 2 || pop(j) > B * 2);
        }
        return ans;
    }

    private void calc(int t0, BiFunction<Integer, Integer, Boolean> f1,
                      BiFunction<Integer, Integer, Boolean> f2, Function<Integer, Boolean> f3) {
        for (int i = (1 << n) + 1; i < (1 << (n + 1)); ++i) {
            d.getOrDefault(i, new ArrayList<>()).clear();
        }
        for (int i = 1 << n; i < (1 << (n + 1)); ++i) {
            if (pop(i) <= t0) {
                boolean _f2;
                for (int j = (i - 1) & i; (j >> n) > 0; j = (j - 1) & i) {
                    if ((_f2 = f2.apply(i, j)) || f1.apply(i, j)) {
                        for (Node t : d.getOrDefault(j, new ArrayList<>())) {
                            int l1 = len[j - (1 << n)] - t.l + 2 * (j > (1 << n) ? 1 : 0);
                            for (Integer v2 : c.getOrDefault(i - j, new ArrayList<>())) {
                                d.computeIfAbsent(i, key -> new ArrayList<>()).add(new Node((t.v1 + pow10[l1]) % p,
                                        (int) (((long) t.v2 * pow10[len[i - j] + 1] + (long) v2 * 10 + 9) % p),
                                        t.l + len[i - j] + 1));
                                if (!_f2) {
                                    d.computeIfAbsent(i, key -> new ArrayList<>()).add(new Node(
                                            (int) ((t.v1 + pow10[l1 + len[i - j]] + (long) v2 * pow10[l1]) % p),
                                            (int) (((long) t.v2 * 10 + 9) % p), t.l + 1));
                                }
                            }
                        }
                    }
                }
                int j = (1 << (n + 1)) - 1 - i;
                hash.clear();
                if (f3.apply(j)) continue;
                for (Integer v : c.getOrDefault(j, new ArrayList<>())) {
                    hash.put(v, hash.getOrDefault(v, 0) + 1);
                }
                for (Node t : d.getOrDefault(i, new ArrayList<>())) {
                    int i1 = (int) ((((long) r - t.v2 - (long) t.v1 * pow10[len[j] + t.l]) % p + p) * pinv[t.l] % p);
                    ans += hash.getOrDefault(i1, 0);
                }
            }
        }
    }

    private static class Node {
        int v1, v2, l;

        public Node(int v1, int v2, int l) {
            this.v1 = v1;
            this.v2 = v2;
            this.l = l;
        }
    }

    private int pop(int x) {
        return Integer.bitCount(x);
    }

    private int log10(int n) {
        return n < 10 ? 1 : log10(n / 10) + 1;
    }

    private long inv(long a, long b) {
        x = 0;
        y = 0;
        exgcd(a, b);
        return (x % b + b) % b;
    }

    private long x, y;

    private long exgcd(long a, long b) {
        if (b == 0) {
            x = 1;
            y = 0;
            return a;
        }
        long d = exgcd(b, a % b);
        long tmp = x;
        x = y;
        y = tmp - a / b * y;
        return d;
    }

    private long fac(int n) {
        long res = 1;
        while (n > 0) res *= n--;
        return res;
    }

    private long C(int n, int m) {
        long res = 1L;
        for (int i = 1; i <= m; i++) res = res * (n - i + 1) / i;
        return res;
    }
}
/*
LCP 82. 万灵之树
https://leetcode.cn/problems/cnHoX6/

探险家小扣终于来到了万灵之树前，挑战最后的谜题。
已知小扣拥有足够数量的链接节点和 n 颗幻境宝石，gem[i] 表示第 i 颗宝石的数值。现在小扣需要使用这些链接节点和宝石组合成一颗二叉树，其组装规则为：
- 链接节点将作为二叉树中的非叶子节点，且每个链接节点必须拥有 2 个子节点；
- 幻境宝石将作为二叉树中的叶子节点，所有的幻境宝石都必须被使用。
能量首先进入根节点，而后将按如下规则进行移动和记录：
- 若能量首次到达该节点时：
  - 记录数字 1；
  - 若该节点为叶节点，将额外记录该叶节点的数值；
- 若存在未到达的子节点，则选取未到达的一个子节点（优先选取左子节点）进入；
- 若无子节点或所有子节点均到达过，此时记录 9，并回到当前节点的父节点（若存在）。
如果最终记下的数依序连接成一个整数 num，满足 num % p = target，则视为解开谜题。
请问有多少种二叉树的组装方案，可以使得最终记录下的数字可以解开谜题
注意：
- 两棵结构不同的二叉树，作为不同的组装方案
- 两棵结构相同的二叉树且存在某个相同位置处的宝石编号不同，也作为不同的组装方案
- 可能存在数值相同的两颗宝石
提示：
1 <= gem.length <= 9
0 <= gem[i] <= 10^9
1 <= p <= 10^9，保证 p 为素数。
0 <= target < p
存在 2 组 gem.length == 9 的用例

宫万题解 https://leetcode.cn/problems/cnHoX6/solution/gong-mo-ti-jie-by-hqztrue-q5a0/
1、魔鬼数字 1996090921 = 11 * 17 * 17 * 293 * 2143；初步看是蛙佬手写 hash 时的专属数字；
2、Function/BiFunction 是 Java 的函数编程接口
3、扩展欧几里得法（exgcd）求 逆元（inv）
4、阶乘函数（fac）
5、组合函数（C）
6、++T; 的作用就是清空 哈希表（妙啊）
 */