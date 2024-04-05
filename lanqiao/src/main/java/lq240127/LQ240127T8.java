package lq240127;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.TreeSet;

public class LQ240127T8 {
    static int n, k, m;
    static List<Integer>[] q;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            k = scanner.nextInt();
            m = scanner.nextInt();

            q = new ArrayList[k + 1];
            Arrays.setAll(q, e -> new ArrayList<>());
            for (int i = 0; i < m; i++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                q[x].add(y);
            }
            System.out.println(solve());
        }
    }

    static final int inf = (int) 1e9;

    private static String solve() {
        int[][] cost = new int[k + 1][];
        for (int i = 1; i <= k; ++i) {
            cost[i] = work(q[i]);
        }
        int[][] f = new int[k + 1][n + 1];
        for (int i = 0; i < k + 1; i++) {
            Arrays.fill(f[i], inf);
        }
        for (int j = 0; j <= n; ++j) f[0][j] = 0;
        for (int i = 1; i <= k; ++i) {
            for (int j = 0; j <= n; ++j) {
                for (int k0 = 0; k0 <= j && k0 <= q[i].size(); k0++) {
                    f[i][j] = Math.min(f[i][j], f[i - 1][j - k0] + cost[i][k0]);
                }
            }
        }
        return String.valueOf(f[k][n]);
    }

    static int cur_cost;
    static TreeSet<Note> pq;
    static Map<Integer, Integer> mp_page2t;

    static int[] work(List<Integer> q) {
        int[] nxt = new int[q.size()];
        Map<Integer, Integer> nxt_pos = new HashMap<>();
        for (int i = q.size() - 1; i >= 0; i--) {
            nxt[i] = nxt_pos.getOrDefault(q.get(i), inf);
            nxt_pos.put(q.get(i), i);
        }

        int[] cost = new int[q.size() + 1];
        for (int s = 0; s <= q.size(); s++) {
            cur_cost = cost[s];

            pq = new TreeSet<>((a1, a2) -> {
                if (a1.nxt_time == a2.nxt_time) {
                    return Integer.compare(a1.page_id, a2.page_id);
                }
                return Integer.compare(a1.nxt_time, a2.nxt_time);
            });
            mp_page2t = new HashMap<>();

            for (int i = 0; i < q.size(); i++) {
                if (s == 0) {
                    cur_cost += 1;
                } else {
                    insert(s, new Note(q.get(i), nxt[i]));
                }
            }
            cost[s] = cur_cost;
        }
        return cost;
    }

    static void insert(int s, Note page) {
        if (mp_page2t.containsKey(page.page_id)) {
            pq.remove(new Note(page.page_id, mp_page2t.get(page.page_id)));
        } else {
            cur_cost += 1;
            if (pq.size() == s) {
                mp_page2t.remove(pq.last().page_id);
                pq.remove(pq.last());
            }
        }
        pq.add(page);
        mp_page2t.put(page.page_id, page.nxt_time);
    }

    static class Note {
        int page_id, nxt_time;

        public Note(int page_id, int nxt_time) {
            this.page_id = page_id;
            this.nxt_time = nxt_time;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Note note = (Note) o;
            return page_id == note.page_id && nxt_time == note.nxt_time;
        }

        @Override
        public int hashCode() {
            return Objects.hash(page_id, nxt_time);
        }
    }
}
/*
缺页异常1【算法赛】

首先考虑一个用户，假设给这个用户一共发出了 m_i 条请求，则显然最多只需要给这个用户分配 m_i 的缓存空间（这样一定不会发生页面置换，页面一旦初始化进了缓存就可以永久存在）。
枚举给这个用户具体分配多少空间，假设分配了 s \in [0, m_i] 的空间，则下面需要计算这个用户在这样的空间下会发生多少次页面置换。
由于 OPT 算法置换的方式是通过选择未来最久才会被访问的，首先预处理出每一个请求页面的编号下一次出现的位置，作为该页面插入缓存后的权重。
每次寻找页面置换的时候，找出权重最大的也就是未来最久才会被访问的进行置换即可。我们在这里一共有 m_i 个请求，每个请求需要扫描 s 的空间，因此复杂度是
 {\textstyle \sum_{s\in [0,m_i]}^{} m_i \times s}  = O(m_i^3)
在总共只有一个用户的情况下，m_i <= 1000，因此总共复杂度是不可接受的。
---
考虑优化寻找权重最大的页面的过程，我们可以使用一个优先队列来维护缓存内权重最大的元素，每次置换队顶并塞入新页面即可。但是这样当遇到访问这个页面已经存在于优先队列里会出现问题，优先队列里原本这个页面的旧信息无法删除。
一个解决方案是，另外维护一个数组表示每个页面的真正权重，每次更新页面的时候只管往优先队列里塞，每次从优先队列中取出页面的时候，如果当前页面在优先队列里面存的权重不等于外面存的真实权重，说明这个优先队列的页面已经是过期的信息，直接丢掉重新取即可。这样复杂度降到了
{\textstyle \sum_{s\in [0,m_i]}^{} m_i \times log(s)} = O(m_i^2log(m_i))
对于 k 个用户，由于有
{\textstyle \sum_{i\in [1,k]}^{} m_i} = m \le 1000
则
{\textstyle \sum_{i\in [1,k]}^{} m_i^2log(m_i)} \le O(m^2log(m))
可以在时限范围内完成。
---
我们现在已经知道了对于第 i 个用户，我们分配 s \in [0,m_i] 的空间会造成的缺页次数，接下来使用动态规划解决多用户问题：
设 d[i][j] 表示对于前 i 个用户，一共分配的 j 个空间的最少缺页总数。
初始 d[0][0] = 0，其余均等于正无穷，对于下一个
d[i][j] = min_{k\in [0,min(m_i,j)]} d[i-1][j-k]
对于答案，取
min_{j=[0,m]} d[n][j]
即对于 n 个用户一共使用了若干的空间的最小代价。该动态规划复杂度为
O( {\textstyle \sum_{i=1}^{n} m_i \times m} ) = O(m^2)
因此可以在总共 O(m^2 log(m)) 的复杂度内完成。
 */