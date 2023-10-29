package c279;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc279_f {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int q = scanner.nextInt();

        DSU dsu = new DSU(n + q + 1);
        int ballNum = n;
        int emptyBox = n + q;

        for (int i = 0; i < q; i++) {
            int op = scanner.nextInt();
            int x = scanner.nextInt();
            if (op == 1) {
                int y = scanner.nextInt();
                // 无需 find，因为每个盒子用完就换新的了
                dsu.fa[dsu.newBox[y]] = dsu.newBox[x];
                // 找一个新的编号当作「空盒子」
                dsu.newBox[y] = emptyBox;
                // 为了操作 3 能正确输出答案
                dsu.oriBox[emptyBox] = y;
                emptyBox--;
            } else if (op == 2) {
                ballNum++;
                dsu.fa[ballNum] = dsu.newBox[x];
            } else {
                System.out.println(dsu.oriBox[dsu.find(x)]);
            }
        }
    }

    private static class DSU {
        int[] fa;
        int[] newBox;
        int[] oriBox;

        public DSU(int n) {
            fa = new int[n];
            newBox = new int[n];
            oriBox = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
                newBox[i] = i;
                oriBox[i] = i;
            }
        }

        int find(int x) {
            if (x != fa[x]) {
                fa[x] = find(fa[x]);
            }
            return fa[x];
        }
    }
}
/*
F - BOX
https://atcoder.jp/contests/abc279/tasks/abc279_f

灵茶の试炼 2023-10-05
题目大意：
输入 n(2≤n≤3e5) 表示有 n 个盒子，编号从 1 到 n。
每个盒子都放了一个小球，其中编号为 i 的盒子放了编号为 i 的小球。
然后输入 q(1≤q≤3e5) 和 q 个操作，格式如下：
"1 x y"：把编号为 y 的盒子中的小球全部放入编号为 x 的盒子中。保证 x≠y。
"2 x"：设所有盒子中一共有 k 个小球，现在把一个新的编号为 k+1 的小球放入编号为 x 的盒子中。
"3 x"：输出编号为 x 的小球所在盒子的编号。保证 x 一定在某个盒子中。

看上去是个并查集模板，但是把盒子 y 中的小球倒入盒子 x 后，盒子 y 是可以继续放入小球的。
这要怎么办？y 已经合并到 x 中了。
我们可以为 y 创建一个（大于 n 的）新的编号 z，表示一个新的空盒子。后续放入 y 的小球，就改为放在盒子 z 中。
但是这样做，要怎么输出小球所在的盒子编号呢？
记录编号为 z 的盒子的【原始盒子编号】为 y 即可。
具体细节见代码。
https://atcoder.jp/contests/abc279/submissions/46217952
======

Input 1
5 10
3 5
1 1 4
2 1
2 4
3 7
1 3 1
3 4
1 1 4
3 7
3 6
Output 1
5
4
3
1
3
 */