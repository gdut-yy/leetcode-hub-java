package lq240210;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LQ240210T9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        for (int j = B - 1; j >= 0; j--) {
            e[j] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            long w = in.nextLong();
            for (int j = B - 1; j >= 0; j--) {
                if ((w >> j & 1) == 1) {
                    e[j].add(new PII(u, v));
                }
            }
        }
        int INF = 0x3f3f3f3f;
        // 对 f 赋值无穷大
        Arrays.fill(f, INF);
        // 按位枚举建图 O(n log W) 复杂度
        // 跑图总复杂度也是每条边被访问的次数为 O(n log W)
        for (int i = B - 1; i >= 0; i--) {
            if (e[i].isEmpty()) {
                continue;
            }
            // 建立出图 Gi
            tot = 0;
            for (PII pii : e[i]) {
                int u = pii.u, v = pii.v;
                add(u, v);
                add(v, u);
            }
            // 计算所有连通块的最大直径
            diaMeter = 0;
            for (int j = tot; j >= 1; j--) {
                if (!vis[sta[j]]) { // 新的一个连通块
                    maxDis(sta[j], -1);
                }
            }
            f[diaMeter] = i; // 更新答案
            for (int j = 1; j <= tot; j++) { // 清空数组
                vis[sta[j]] = false;
                head[sta[j]] = 0;
            }
        }
        for (int i = n - 1; i >= 1; i--) { // 后缀 min，不难发现，边数越少答案越小
            f[i] = Math.min(f[i], f[i + 1]);
        }
        for (int i = 1; i < n; i++) {
            if (f[i] != INF) {
                System.out.println(1L << f[i]);
            } else {
                System.out.println(-1);
            }
        }
    }

    static final int N = (int) 1e5 + 10, M = 2 * N, B = 60;
    static int n;
    static List<PII>[] e = new ArrayList[B]; // e[w] 边权为 (1 << w) 所对应的边的集合
    static boolean[] vis = new boolean[N];
    static int[] head = new int[N], f = new int[N];
    static int[] to = new int[M], sta = new int[M], nex = new int[M];
    static int tot;

    static void add(int u, int v) {
        ++tot;
        to[tot] = v;
        sta[tot] = u;
        nex[tot] = head[u];
        head[u] = tot;
    }

    static int diaMeter;

    static int maxDis(int u, int fa) { // u 所在连通块的直径
        vis[u] = true;
        int mx = 0, sec = 0; // 距离最大值和次大值
        for (int i = head[u]; i > 0; i = nex[i]) {
            int v = to[i];
            if (v != fa) {
                int d = maxDis(v, u);
                if (d >= mx) {
                    sec = mx;
                    mx = d;
                } else if (d > sec) {
                    sec = d;
                }
            }
        }
        diaMeter = Math.max(diaMeter, mx + sec); // 更新连通块直径
        return mx + 1; // 走到 u 这个子树的最深处的距离，取最长链
    }


    static class PII {
        int u, v;

        public PII(int u, int v) {
            this.u = u;
            this.v = v;
        }
    }
}
/*
学《树论》的贝贝【算法赛】

容易知道只有一条链上，所有的边，位权都包含 2^i ，那么 V 在 2^i 这一位才会为 1。
于是我们将 w_i 按位拆分，最大位权 B=59 。
对每个位权建立一个图 G_i ：
* 若 w_j 在 2^i 这一位为 1 ，则激活原图中的这条边，也就是连接 u_j,v_j 。
* 这样我们就得到了一个森林 G_i 。
而一个森林又是由若干棵树组成的。
* 求出每个树的直径（此处指链包含的最大边数），取个 \max 就得到了森林的直径 d 。
  * 可以使用树形 dp 来维护每个节点到叶子节点最深的距离是多少；
  * 或者用 dfs 维护每个节点走到叶子的最大距离和次大距离，这个方法本质上等价于树形 dp 的做法；
  * 以及对每个连通块使用两次dfs 也可以求出。
* 也就说明了，存在长度为 1 \sim d 的链其幸运值为 2^i 。
我们对 f[d] 赋值 f[d]:=2^i 。
我们依次遍历图 G_{B},G_{B-1},\cdots,G_1 ，执行以上操作。
最后，还需要做一个后缀 \min ：
* 忽略掉 f(k)=-1 的情况，显然 f(n-1),f(n-2),\cdots,f(1) 是一个**递减**的数列；
  * 即当 f[k+1]\
e -1 时，让 f[k]=\min(f[k],f[k+1]) 。
* 链的长度越小，显然 f(k) 只会更小。因为直径为 d 的图里面，必然包含长度小于 d 的链。
当然，因为 G_i 求出的直径 d 可以更新 f[1]\sim f[d] ，每次区间 \min ，所以其实用线段树也是可以的。
最后这样求出的 f[k] 求恰好等于题目需要的 f(k) 了。
考虑下总复杂度，设 W =\max\{ w_i\} ，那么每条边被遍历的次数为 O(\log W) 。
故总时间复杂度为 O(n\log W) 。
若用线段树做区间最小值，则时间复杂度为 O(n\log n\log W)，也足以通过本题。
 */