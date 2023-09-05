package p1862;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class CF1862G {
    static int n;
    static int[] a;
    static int q;
    static int[][] qix;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            q = scanner.nextInt();
            qix = new int[q][2];
            for (int i = 0; i < q; i++) {
                qix[i][0] = scanner.nextInt();
                qix[i][1] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        if (n == 1) {
            int[] ans = new int[q];
            for (int i = 0; i < q; i++) {
                ans[i] = qix[i][1];
            }
            return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(" "));
        }

        TreeMap<Integer, Integer> aset = new TreeMap<>();
        for (int v : a) {
            aset.put(v, aset.getOrDefault(v, 0) + 1);
        }

        Integer[] ids = new Integer[n];
        for (int i = 0; i < n; i++) ids[i] = i;
        Arrays.sort(ids, Comparator.comparingInt(o -> a[o]));

        TreeMap<Integer, Integer> deltas = new TreeMap<>();
        for (int i = 1; i < n; i++) {
            insert(deltas, a[ids[i]] - a[ids[i - 1]]);
        }

        int[] ans = new int[q];
        for (int i = 0; i < q; i++) {
            int pos = qix[i][0] - 1, val = qix[i][1];
            Map.Entry<Integer, Integer> it = aset.floorEntry(a[pos]);
            Map.Entry<Integer, Integer> prev = aset.lowerEntry(a[pos]);
            Map.Entry<Integer, Integer> nxt = (it.getValue() > 1) ? it : aset.higherEntry(a[pos]);
            if (prev == null) {
                erase(deltas, nxt.getKey() - it.getKey());
            } else if (nxt == null) {
                erase(deltas, it.getKey() - prev.getKey());
            } else {
                erase(deltas, nxt.getKey() - it.getKey());
                erase(deltas, it.getKey() - prev.getKey());
                insert(deltas, nxt.getKey() - prev.getKey());
            }
            erase(aset, a[pos]);
            insert(aset, val);

            it = aset.floorEntry(val);
            prev = aset.lowerEntry(val);
            nxt = (it.getValue() > 1) ? it : aset.higherEntry(val);
            if (prev == null) {
                insert(deltas, nxt.getKey() - it.getKey());
            } else if (nxt == null) {
                insert(deltas, it.getKey() - prev.getKey());
            } else {
                insert(deltas, nxt.getKey() - it.getKey());
                insert(deltas, it.getKey() - prev.getKey());
                erase(deltas, nxt.getKey() - prev.getKey());
            }
            a[pos] = val;

            ans[i] = aset.lastKey() + deltas.lastKey();
        }
        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }

    private static void erase(TreeMap<Integer, Integer> map, int v) {
        map.put(v, map.getOrDefault(v, 0) - 1);
        if (map.get(v) == 0) map.remove(v);
    }

    private static void insert(TreeMap<Integer, Integer> map, int v) {
        map.put(v, map.getOrDefault(v, 0) + 1);
    }
}
/*
G. The Great Equalizer
https://codeforces.com/contest/1862/problem/G

题目大意：
特玛买了一台旧设备，屏幕很小，侧面写着破旧的“伟大的均衡器”字样。
卖家说，设备需要输入一个整数数组 a，之后“伟大的均衡器”将按照以下方式工作:
1、对当前数组按非递减顺序排序，并删除重复元素，每个元素只出现一次。
2、如果阵列的当前长度为 1，则设备停止工作，输出阵列输出值中的单个数字。
3、在当前数组中添加等差数列{n, n−1,n−2,...,1}，其中 n 为当前数组的长度。换句话说，当从 0 开始索引时，将 n - i 添加到数组的第 i 个元素。
4、迈出第一步。
为了测试设备的操作，Tema 提出了一个特定的整数数组 a，然后想对数组 a 执行 q 次操作，数组 a 的类型如下:
1、将值 x(1≤x≤109)赋给元素 ai(1≤i≤n)。
2、将数组 a 作为设备的输入，找出设备运行的结果，而数组 a 在设备运行期间保持不变。
帮助 Tema 了解每次操作后设备的输出值。

https://codeforces.com/blog/entry/119715
让我们看一下排序序列中相邻数之间的最大差值。每循环减少 1。这有助于我们理解主要观察结果:序列的答案是序列中的最大值+相邻数之间排序顺序的最大差值。
要回答查询，维护这两个值就足够了。
为了维护最大数目，我们将这些数字存储在 std::multiset 中。为了保持最大差值，我们将保持 std::multiset。
当替换一个数字时，我们将删除旧的数字，并用邻居之间的差值替换它与邻居之间的差值。然后我们将添加新数字，并用添加的数字与每个邻居之间的差来替换它的邻居之间的差。
所有这些都是通过使用 std::multiset 实现的，例如，您可以在作者的解决方案中看到。
======

input
4
3
2 4 8
3
1 6
2 10
3 1
5
1 2 2 2 2
1
5 3
2
5 6
7
1 2
1 7
1 7
2 5
1 2
2 7
2 2
5
2 5 1 10 6
10
1 7
4 8
2 5
1 4
2 8
3 4
1 9
3 7
3 4
3 1
output
10 12 15
4
10 8 8 9 8 12 2
14 12 12 11 11 10 11 10 11 14
 */
