package p1837;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class CF1837F {
    static int n, k;
    static int[] a;

    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            k = scanner.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve1());
        }
    }

    private static int[][] xs;
    private static int[] lstpr, lstsu, pr, su, prv, nxt;

    // java 堆 TLE？
    // https://codeforces.com/contest/1837/submission/207203613 Time limit exceeded on test 20
    // https://codeforces.com/contest/1837/submission/207500993 Time limit exceeded on test 27
    private static String solve() {
        pr = new int[n + 1];
        su = new int[n + 1];

        long left = 0;
        long right = (long) 1e15;
        while (left < right) {
            long mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (checkMid(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return String.valueOf(left);
    }

    private static boolean checkMid(long mx) {
        for (int _i = 0; _i < 2; _i++) {
            PriorityQueue<Integer> cur = new PriorityQueue<>(Comparator.reverseOrder());
            pr[0] = 0;
            long cursum = 0;
            for (int i = 0; i < n; i++) {
                cur.add(a[i]);
                cursum += a[i];
                while (cursum > mx) {
                    cursum -= cur.remove();
                }
                pr[i + 1] = cur.size();
            }
            reverse(a);
            swap(pr, su);
        }
        reverse(su);
        for (int i = 0; i < n + 1; i++) {
            if (pr[i] + su[i] >= k) {
                return true;
            }
        }
        return false;
    }

    // 3837 ms
    private static String solve1() {
        xs = new int[n][2];
        for (int i = 0; i < n; i++) {
            xs[i] = new int[]{a[i], i};
        }
        Arrays.sort(xs, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o1[1], o2[1]);
            }
            return Integer.compare(o1[0], o2[0]);
        });
        for (int i = 0; i < n; i++) {
            // a[i] = lower_bound(xs.begin(), xs.end(), make_pair(a[i], i)) - xs.begin();
            a[i] = lowerBound(xs, new int[]{a[i], i});
        }
        lstpr = new int[n];
        lstsu = new int[n];
        for (int _i = 0; _i < 2; _i++) {
            TreeSet<Integer> cur = new TreeSet<>();
            for (int i = 0; i < n; i++) {
                cur.add(a[i]);
                Integer it = cur.lower(a[i]);
                if (it == null) {
                    lstpr[i] = n;
                } else {
                    lstpr[i] = it;
                }
            }
            swap(lstpr, lstsu);
            reverse(a);
        }

        pr = new int[n + 1];
        su = new int[n + 1];
        prv = new int[n + 2];
        nxt = new int[n + 2];

        long left = 0;
        long right = (long) 1e15;
        while (left < right) {
            long mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (checkMid1(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return String.valueOf(left);
    }

    private static boolean checkMid1(long mx) {
        for (int _i = 0; _i < 2; _i++) {
            int cnt = 0;
            prv[n + 1] = n;
            nxt[n] = n + 1;
            pr[0] = 0;
            int mn = (int) 1e9;
            long cursum = 0;
            for (int i = 0; i < n; i++) {
                if (mn < a[i]) {
                    pr[i + 1] = cnt;
                    continue;
                }
                nxt[a[i]] = nxt[lstpr[i]];
                prv[nxt[a[i]]] = a[i];
                prv[a[i]] = lstpr[i];
                nxt[prv[a[i]]] = a[i];
                cursum += xs[a[i]][0];
                ++cnt;
                while (cursum > mx) {
                    mn = Math.min(mn, prv[n + 1]);
                    cursum -= xs[prv[n + 1]][0];
                    prv[n + 1] = prv[prv[n + 1]];
                    nxt[prv[n + 1]] = n + 1;
                    --cnt;
                }
                pr[i + 1] = cnt;
            }
            reverse(a);
            swap(lstpr, lstsu);
            swap(pr, su);
        }
        reverse(su);
        for (int i = 0; i < n + 1; i++) {
            if (pr[i] + su[i] >= k) {
                return true;
            }
        }
        return false;
    }

    private static void reverse(int[] nums) {
        for (int l = 0, r = nums.length - 1; l < r; l++, r--) {
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
        }
    }

    // 第一个值大于 x
    // 第一个值等于 x，第二个值大于等于y。
    private static int lowerBound(int[][] pairs, int[] pair) {
        int left = 0;
        int right = pairs.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (pairs[mid][0] > pair[0] || pairs[mid][0] == pair[0] && pairs[mid][1] >= pair[1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static void swap(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            int tmp = a[i];
            a[i] = b[i];
            b[i] = tmp;
        }
    }

    private static class FastReader {
        private final BufferedReader bufferedReader;
        private StringTokenizer stringTokenizer;

        public FastReader() {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            while (stringTokenizer == null || !stringTokenizer.hasMoreElements()) {
                try {
                    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return stringTokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
            String str = "";
            try {
                if (stringTokenizer.hasMoreTokens()) {
                    str = stringTokenizer.nextToken("\n");
                } else {
                    str = bufferedReader.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
/*
F. Editorial for Two
https://codeforces.com/contest/1837/problem/F

题目大意：
伯兰校际比赛刚刚结束。Monocarp 和 Polycarp，作为陪审团，将发表一篇社论。不幸的是，时间有限，因为他们必须在闭幕式前完成。
比赛中没有任何问题。题目从 1 到 n 编号。这个问题的社论花了 11 分钟。Monocarp 和 Polycarp 将针对其中的 k 个问题发表一篇社论。
社论内容如下。他们面前有整整 n 个问题，按顺序排列。它们在不改变剩余 k 个问题的顺序的情况下解决了 n - k 个问题。然后，Monocarp 取这 k 个问题的某个前缀(可能是一个空问题或所有问题)。Polycarp 取剩下的后缀。之后，他们去不同的房间，同时针对各自的问题发表社论。所以，这篇社论花的时间和这两篇中较长的那篇一样多。
请帮助 Monocarp 和 Polycarp 选择问题和分裂的方式，使社论尽早完成。打印社论的持续时间。

二分答案 + 反悔堆
双向链表 优化
https://codeforces.com/blog/entry/116752
在这个问题中，我们被要求首先选择 k 个问题，然后将其拆分为前缀和后缀。但没有什么能阻止我们反过来去做。让我们首先修复整个问题集的分裂，然后在分裂的左边选择 l(0≤l≤k)和 l 个问题，在它的右边选择剩下的 k−l 个问题。
这样我们就可以得到多项式解了。在确定了分割和 l 之后，我们只需要找到 l 个最短的左侧编辑和 k−l 个最短的右侧编辑。证明它是最优的很简单。
这很容易在 O(n^2logn)或者 O(n^2)中完成。这个解决方案对完整的问题没有帮助，所以我就不详细说明了。
---
接下来，当我们看到“最小化最大值”时，我们会想到二分查找。
我们试着把它应用到这里。二分搜索答案-现在我们想要分割的左右部分之和小于或等于某个固定的 x。
更具体地说，应该存在一个 l，左边最小的 l 个元素的和 ≤x，右边最小的 k−l 个元素的和 ≤x。我们换个说法吧。左边至少有 l 个元素，它们的和 ≤x，右边也一样。再来一次。向左求和 ≤x 的最大集合，其大小至少为 l，向右相同。
但这并不需要 l，对吧?从左到右求和 ≤x 的最大集合。它们的大小之和至少为 k。
让我们计算数组中所有前缀和后缀的最大集合的大小。然后我们就可以在 O(n)中检验条件了。
您可以在 0 (nlogn)中预先计算所有前缀的大小。思路如下。取前缀 i 的集合。加上第(i+1)个元素。如果它的和 ≤x，那么它就是新集合。否则，继续从其中移除最大的元素，直到总和 ≤x。
这个解是 O(nlogAlogn)，其中 A 是数组的和，所以你应该小心常数因子。例如，对 multiset 或段树执行此操作可能不会通过。不过 Priority_queue 已经足够快了。
---
然而，我们可以做得更快。想象一下使用 multiset 的解决方案。让我们用一个双链表来代替它。
具体来说，我们需要以下操作:
在其中插入一个元素;检查并删除最后一个元素。如果不删除任何元素，则可以确定在哪里插入每个元素。我们可以在 O(nlogn)的二分查找之前预先计算一下。对于每个元素，找出小于或等于它并在它左边的最大元素。这将是插入这个元素时的前一个元素。
当我们删除元素时，当我们试图插入新元素时，可能会发生前一个元素已经被删除的情况。我们可以利用问题的特殊性来避免这个问题。注意，如果我们删除一个小于或等于当前元素的元素，那么当前元素永远不可能在最优 multiset 中。所以我们可以跳过这个元素。
为了实现这样一个列表，我们可以将所有元素重新定义为从 0 到 n - 1 的值(按照(value,i)的顺序)。然后，对于每个 i 存储列表中存在的前一个和下一个元素的值。为方便起见，还可以添加节点 n 和 n+1，分别表示列表的尾部和头部。
然后插入和删除只是重新安排一些链接到前一个和下一个元素。
总体复杂度:每个测试用例 0 (nlogA)，其中 A 是数组的和。
======

input
6
5 4
1 10 1 1 1
5 3
1 20 5 15 3
5 3
1 20 3 15 5
10 6
10 8 20 14 3 8 6 4 16 11
10 5
9 9 2 13 15 19 4 9 13 12
1 1
1
output
2
6
5
21
18
1
 */
