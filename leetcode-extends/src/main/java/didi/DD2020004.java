package didi;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class DD2020004 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] a = new int[m];
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            a[i] = scanner.nextInt();
            b[i] = scanner.nextInt();
        }
        System.out.println(solve(n, m, a, b));
    }

    private static String solve(int n, int m, int[] a, int[] b) {
        int res = n;
        // 我们为垃圾袋标了号，分别是 1-n
        DSU dsu = new DSU(n * 2 + 1);
        for (int i = 0; i < m; i++) {
            // 如果 a b 已经分开两辆垃圾车
            if (dsu.find(a[i]) == dsu.find(b[i])) {
                res--;
            }
            dsu.union(a[i], b[i] + n);
            dsu.union(a[i] + n, b[i]);
        }
        return String.valueOf(res / 2 * 2);
    }

    private static class DSU {
        int[] fa;

        public DSU(int n) {
            fa = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
            }
        }

        int find(int x) {
            // 路径压缩
            if (x != fa[x]) {
                fa[x] = find(fa[x]);
            }
            return fa[x];
        }

        void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            }
            fa[rootQ] = rootP;
        }
    }
}
/*
DD-2020004. 垃圾分类
https://leetcode.cn/problems/8vaa1X/

最近很多城市都搞起了垃圾分类，已知有一个小区有 n 堆垃圾需要丢弃，这些垃圾都打包了，我们并不知道这是什么垃圾，要知道有些垃圾如果丢在一起是会影响环境的。
这个小区一共只有两辆垃圾车，我们希望在不影响环境的情况下，每次让垃圾车载走最多的垃圾，但是因为两位司机师傅有矛盾，所以两辆车装的垃圾数目一定要相同，
不然其中一位司机师傅就会不开心。
我们为垃圾袋标了号，分别是 1-n，有 m 个约束，每个约束表示为“a b”，意思是第a堆垃圾与第b堆垃圾不能装在一辆垃圾车上。(每堆垃圾最多有两个约束条件)
请问两辆垃圾车一次最多可以带走多少堆垃圾呢?
格式：
输入：
- 输入第一行包含两个正整数 n，m，表示共有 n 堆垃圾，m 个约束条件。
- 接下来有 m 行，每行有两个正整数，a，b，表示第 a 堆垃圾和第 b 堆垃圾不能放在一辆垃圾车上。
输出：
- 输出仅包含一个正整数，表示两辆垃圾车一次最多带走的垃圾的数量。
示例：
输入：
5 2
1 4
3 4
输出：4
提示：
1 <= n, m <= 500
1 <= a, b <= n
 */