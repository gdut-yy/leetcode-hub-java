package lq231125;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

public class LQ231125T6 {
    static int n, q;
    static int[] p, x;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        p = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            p[i] = scanner.nextInt();
        }
        q = scanner.nextInt();
        x = new int[q];
        for (int i = 0; i < q; i++) {
            x[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    static PriorityQueue<Integer> minH, maxH;

    private static String solve() {
        minH = new PriorityQueue<>();
        maxH = new PriorityQueue<>(Comparator.reverseOrder());

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < q; i++) {
            set.add(x[i]);
        }
        for (int i = 1; i <= n; i++) {
            if (!set.contains(i)) {
                add(p[i]);
            }
        }
        String[] ans = new String[q];
        for (int i = q - 1; i >= 0; i--) {
            ans[i] = String.format("%.1f", getMedian());
            add(p[x[i]]);
        }
        return String.join(" ", ans);
    }

    static void add(int num) {
        if (maxH.isEmpty() || num <= maxH.peek()) {
            maxH.add(num);
            if (minH.size() + 1 < maxH.size()) {
                minH.add(maxH.poll());
            }
        } else {
            minH.add(num);
            if (minH.size() > maxH.size()) {
                maxH.add(minH.poll());
            }
        }
    }

    static double getMedian() {
        if (maxH.size() > minH.size()) {
            return maxH.peek();
        }
        return (maxH.element() + minH.element()) / 2.0;
    }
}
/*
大风起兮【算法赛】

考察数据结构。
本题有很多解法。
首先要做的是离散化，之后我们考虑如下解法：
1、我们使用树状数组唯一第 i 大的数量，每次去除一个，我们的就更新树状数组，然后我们二分出中间值的位置，得到中位数。时间复杂度 O(n * logn * logn).
2、我们使用 multiset，维护中位数的位置迭代器，每次删除后维护一下迭代器的位置，复杂度 O((n+q) logn)。
3、我们使用链表，先排序，然后记录一下每个数的原始位置和排序后的位置，建立链表，维护一个中间指针，每次删除后改变指针的位置即可。O(nlogn + q)。
4、对顶堆，维护一个大根堆和小根堆，对顶都是中位数附近。
四种解法均可通过此题。
 */