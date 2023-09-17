package c281;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class Abc281_c {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        long t = scanner.nextLong();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextLong();
        }
        System.out.println(solve(n, t, a));
    }

    private static String solve(int n, long t, long[] a) {
        long sum = Arrays.stream(a).sum();
        t %= sum;
        long s = 0L;
        for (int i = 0; i < n; i++) {
            if (s + a[i] <= t) {
                s += a[i];
            } else {
                return (i + 1) + " " + (t - s);
            }
        }
        return "-1";
    }
}
/*
C - Circular Playlist
https://atcoder.jp/contests/abc281/tasks/abc281_c

题目大意：
我们有一个播放列表，其中有 N 首歌曲，编号为 1，…，N。
第 1 首歌持续 1 秒。
播放播放列表时，歌曲 1、歌曲 2、…和歌曲 N 按此顺序播放。当第 N 首歌结束时，播放列表会重复播放，从第 1 首歌开始。当一首歌正在播放时，下一首歌不播放;当一首歌结束时，下一首歌立即开始。
正好在播放列表开始播放后的 T 秒，播放的是哪首歌?还有，从那首歌开始过了多少秒?没有输入，播放列表在开始播放后恰好 T 秒改变歌曲。

先对和取模。
======

Input 1
3 600
180 240 120
Output 1
1 60

Input 2
3 281
94 94 94
Output 2
3 93

Input 3
10 5678912340
1000000000 1000000000 1000000000 1000000000 1000000000 1000000000 1000000000 1000000000 1000000000 1000000000
Output 3
6 678912340
 */