package p69;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class CF69E {
    static int n, k;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        Map<Integer, Integer> cnt = new HashMap<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int v = a[i];
            cnt.put(v, cnt.getOrDefault(v, 0) + 1);
            if (cnt.get(v) == 1) {
                heap.add(v);
            }
            if (i >= k - 1) {
                while (!heap.isEmpty() && cnt.get(heap.peek()) != 1) {
                    heap.remove();
                }
                if (!heap.isEmpty()) ans.add("" + heap.peek());
                else ans.add("Nothing");

                v = a[i - k + 1];
                cnt.put(v, cnt.get(v) - 1);
                if (cnt.get(v) == 1) {
                    heap.add(v);
                }
            }
        }
        return String.join(System.lineSeparator(), ans);
    }
}
/*
E. Subsegments
https://codeforces.com/contest/69/problem/E

灵茶の试炼 2023-11-23
题目大意：
输入 n k(1≤k≤n≤1e5) 和长为 n 的数组 a(-1e9≤a[i]≤1e9)。
对于每个长为 k 的连续子数组，输出子数组内的恰好出现一次的最大元素。如果不存在这样的元素，输出 Nothing。

rating 1800
定长滑动窗口。
用 map 维护窗口内的元素个数。
无论是移入窗口还是移出窗口，只要发现元素的出现次数等于 1，就把这个元素加到最大堆中。
输出答案之前，检查下堆顶元素的出现次数是否恰好为 1，如果不是则弹出堆顶（懒删除）。
https://codeforces.com/contest/69/submission/233292854
======

input
5 3
1
2
2
3
3
output
1
3
2

input
6 4
3
3
3
4
4
2
output
4
Nothing
3
 */