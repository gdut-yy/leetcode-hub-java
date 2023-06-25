package p1843;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CF1843F1 {
    static List<int[]> vxList, uvkList;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            vxList = new ArrayList<>();
            uvkList = new ArrayList<>();
            int n = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                String symbol = scanner.next();
                if (symbol.equals("+")) {
                    int v = scanner.nextInt();
                    int x = scanner.nextInt();
                    vxList.add(new int[]{v, x});
                } else {
                    int u = scanner.nextInt();
                    int v = scanner.nextInt();
                    int k = scanner.nextInt();
                    uvkList.add(new int[]{u, v, k});
                }
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        List<int[]> nodeList = new ArrayList<>();
        nodeList.add(new int[4]);
        // minS, maxS, min, max, 最小值为 0，最大值为 1
        nodeList.add(new int[]{0, 1, 0, 1});

        for (int[] p : vxList) {
            int v = p[0], x = p[1];

            int[] node = nodeList.get(v);
            int minS = node[0], maxS = node[1], min = node[2], max = node[3];
            minS = Math.min(x, minS + x);
            min = Math.min(min, minS);
            maxS = Math.max(x, maxS + x);
            max = Math.max(max, maxS);
            nodeList.add(new int[]{minS, maxS, min, max});
        }

        List<String> resList = new ArrayList<>();
        for (int[] p : uvkList) {
            int u = p[0], v = p[1], k = p[2];

            int[] node = nodeList.get(v);
            int min = node[2], max = node[3];
            resList.add(min <= k && k <= max ? "YES" : "NO");
        }
        return String.join(System.lineSeparator(), resList);
    }
}
/*
F1. Omsk Metro (simple version)
https://codeforces.com/contest/1843/problem/F1

题目大意：
这是这个问题的简单版本。简单版本和复杂版本之间的唯一区别是，在这个版本中 u=1。
众所周知，鄂木斯克是柏林的首府。和其他首都一样，鄂木斯克拥有发达的地铁系统。鄂木斯克地铁由一定数量的通过隧道连接的车站组成，并且在任何两个车站之间都有一条路径穿过每个隧道不超过一次。换句话说，地铁是一棵树。
为了发展地铁和吸引居民，鄂木斯克使用了以下系统。每个站都有自己的权值 x∈{−1,1}。如果车站的重量为 -1，那么当鄂木斯克居民访问车站时，将收取 1 burle 的费用。如果车站的重量为 1，那么鄂木斯克居民将获得 1 个 burle 奖励。
鄂木斯克地铁目前只有一个 1 号、重量 x=1 的车站。每天都会发生以下事件之一:
- 将权重为 x 的新站点添加到编号为 vi 的站点中，并为其分配一个比现有站点数量大 1 的数字。
- 住在鄂木斯克的亚历克斯想知道:在顶点 u 和 v 之间的路径上是否有一个子段(可能是空的)，使得沿着它旅行，正好可以获得 k 个洞(如果 k<0，这意味着必须在旅行中花费 k 个洞)。换句话说，Alex 感兴趣的是，路径中是否存在这样一个子段，使得其中所有顶点的权值之和等于 k。注意子段可以为空，然后求和等于 0。
你是 Alex 的朋友，所以你的任务是回答 Alex 的问题。

连续子段 最小和 最大和
======

input
1
8
+ 1 -1
? 1 1 2
? 1 2 1
+ 1 1
? 1 3 -1
? 1 1 1
? 1 3 2
? 1 1 0
output
NO
YES
NO
YES
YES
YES

input
1
10
+ 1 -1
+ 1 -1
+ 3 1
+ 3 -1
+ 3 1
? 1 6 -1
? 1 6 2
? 1 2 0
? 1 5 -2
? 1 4 3
output
YES
NO
YES
YES
NO
 */
