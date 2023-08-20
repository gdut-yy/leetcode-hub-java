package p1851;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CF1851C {
    static int n, k;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            k = scanner.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        List<Integer> firstList = new ArrayList<>();
        List<Integer> lastList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (a[i] == a[0]) firstList.add(i);
            else if (a[i] == a[n - 1]) lastList.add(i);
        }

        if (a[0] == a[n - 1]) {
            return firstList.size() >= k ? "YES" : "NO";
        }

        if (firstList.size() < k || lastList.size() < k) {
            return "NO";
        }
        int l = firstList.get(k - 1);
        int r = lastList.get(lastList.size() - k);
        return l < r ? "YES" : "NO";
    }
}
/*
C. Tiles Comeback
https://codeforces.com/contest/1851/problem/C

题目大意：
弗拉德记得他有一组 n 张牌和一个数字 k。瓷砖从左到右编号，第 i 个瓷砖的颜色是 ci。
如果你站在第一个贴图上并开始向右跳跃任意数量的贴图，你就可以得到一条长度为 p 的路径。路径的长度是你站在瓷砖的数量。
Vlad 想看看是否有可能得到一个长度为 p 的路径，使得:
- 它以索引为 n 的 tile 结束;
- p 能被 k 整除
- 路径被分成长度为 k 的块;
- 每个块中的瓷砖颜色相同，相邻块中的颜色不一定不同。例如，设 n=14, k=3。
瓷砖的颜色包含在数组 c =[1,2,1,1,2,2,3,3,1,3,4,4,2,4]。然后我们可以构造一个长度为 6 的路径，包含两个块:
c1→c3→c4→c11→c12→c14
第 1 个方块中的所有贴图的颜色为 1，第 2 个方块中的所有贴图的颜色为 4。
在这个例子中，也可以构造一个长度为 9 的路径，其中第 1 个块的所有瓷砖的颜色为 1，第 2 个块的颜色为 3，第 3 个块的颜色为 4。

分类讨论
首尾字符相同：看能否分成 p = k
首尾字符不同：看能否分成 p = 2k
======

input
10
4 2
1 1 1 1
14 3
1 2 1 1 7 5 3 3 1 3 4 4 2 4
3 3
3 1 3
10 4
1 2 1 2 1 2 1 2 1 2
6 2
1 3 4 1 6 6
2 2
1 1
4 2
2 1 1 1
2 1
1 2
3 2
2 2 2
4 1
1 1 2 2
output
YES
YES
NO
NO
YES
YES
NO
YES
YES
YES
 */
