package p1237;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class CF1237D {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n * 3];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            a[i + n] = a[i + n + n] = a[i];
        }
        System.out.println(solve());
    }

    private static String solve() {
        List<String> output = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();
        int j = 0;
        for (int i = 0; i < n; i++) {
            for (; j < n * 3 && (dq.isEmpty() || a[j] * 2 >= a[dq.getFirst()]); j++) {
                while (!dq.isEmpty() && a[dq.getLast()] <= a[j]) {
                    dq.removeLast();
                }
                dq.addLast(j);
            }
            if (j == n * 3) {
                output.add("-1");
            } else {
                output.add(String.valueOf(j - i));
            }
            if (dq.getFirst() == i) {
                dq.removeFirst();
            }
        }
        return String.join(" ", output);
    }
}
/*
D. Balanced Playlist
https://codeforces.com/contest/1237/problem/D

灵茶の试炼 2024-06-13
题目大意：
输入 n(2≤n≤1e5) 和长为 n 的数组 a(1≤a[i]≤1e9)。
0x3F 的播放列表中有 n 首歌，列表中的第 i 首歌的好听度为 a[i]。
这 n 首歌按照【列表循环】模式播放。播放完第 n 首歌，就会播放第 1 首歌。
如果 0x3F 听到一首歌，发现它的好听度 * 2 小于之前听到的最好听的歌，那么 0x3F 就会立刻停止播放。
输出 n 个数，其中第 i 个数等于，从播放列表中的第 i 首歌开始听，到停止播放时，完整播放的歌曲数目（停止播放时的那首歌不算）。
对于同一首歌，如果它被完整播放 x 次，就会统计 x 次。见示例 2。
如果可以无限循环，输出 -1。

rating 2000
由于数组是环形的，为了方便计算，把 a 额外复制两份，即 a+a+a。
为什么要额外复制两份？例如 [4,9,7] 复制为 [4,9,7,4,9,7,4,9,7]，从第一个 7 开始的话，得遍历到第三份数组的 4 才发现有严格小于 9/2 的歌曲。
设停止播放的歌曲的下标为 j。
注意到，随着 i 的变大，j 不会变小。这可以用反证法证明：如果从 i 到 i+1，j 变小为 j2，那么对于 i 来说，应该在 j2 停止播放而不是在 j 停止播放，矛盾。
基于该性质，我们可以用双指针做。外层循环枚举 i，内层循环不断向右移动 j，如果满足 a[j]*2 >= max(a[i..j]) 就可以继续移动。
怎么知道是否满足 a[j]*2 >= max(a[i..j])？要计算的是「滑动窗口最大值」，这可以用单调队列实现，可以看我的 基础算法精讲
答案是 j-i。如果 j=n*3 则答案为 -1。
计算出答案后，如果队首等于 i，则弹出队首，枚举下一个 i。
时间复杂度：O(n)。
https://codeforces.com/problemset/submission/1237/264667560
======

Input
4
11 5 2 7
Output
1 1 3 2

Input
4
3 2 5 3
Output
5 4 3 6

Input
3
4 3 6
Output
-1 -1 -1
 */
