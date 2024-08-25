package p1118;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class CF1118D2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve(n, m, a));
    }

    private static String solve(int n, int m, int[] a) {
        reverseSort(a);

        int left = 0;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (checkMid(n, m, a, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        int ans = left + 1;
        if (ans > n) {
            ans = -1;
        }
        return String.valueOf(ans);
    }

    private static boolean checkMid(int n, int m, int[] a, int mid) {
        mid++;
        for (int i = 0; i < n; i++) {
            int v = a[i];
            v -= i / mid;
            if (v <= 0) {
                break;
            }
            m -= v;
            if (m <= 0) {
                return true;
            }
        }
        return false;
    }

    // 由大到小排序
    private static void reverseSort(int[] nums) {
        Arrays.sort(nums);
        for (int l = 0, r = nums.length - 1; l < r; l++, r--) {
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
        }
    }
}
/*
D2. Coffee and Coursework (Hard Version)
https://codeforces.com/contest/1118/problem/D2

灵茶の试炼 2023-05-10
题目大意：
简单版本和困难版本之间的唯一区别是约束。（1≤n≤2⋅10^5, 1≤m≤10^9）（D1 1≤n≤100, 1≤m≤10^4）
波利卡普必须写一篇课程作业。这门课程有 m 页。
Polycarp 也有 n 杯咖啡。杯子里的咖啡没有咖啡因。波利卡鱼可以喝几杯咖啡(每次不超过一次)。他可以按任何顺序喝杯子。波利卡普立即喝完每一杯(也就是说，他不能把每一杯分成几天喝)。
当然，课程作业通常不会在一天内完成(至少在伯兰的完美世界中是这样)。其中一些需要数天的辛勤工作。
让我们考虑一下波利卡普一天的工作。考虑波利鲤鱼在这一天喝 k 杯咖啡，波利鲤鱼在这一天喝的咖啡的咖啡因剂量是 ai1,ai2，…，aik。然后他喝的第一杯给了他写 ai1 页课程作业的能量，第二杯给了他写 max(0,ai2−1)页的能量，第三杯给了他写 max(0,ai3−2)页的能量，…，第 k 杯给了他写最多(0,aik−k+1)页的能量。
如果波利卡普哪天不喝咖啡，他那一天就写不了作业。
波利卡普必须尽快完成他的课程(花最少的天数来完成它)。你的任务是找出这个天数，或者说这是不可能的。

rating 1700
https://codeforces.com/contest/1118/submission/205215714
二分答案 x。
优先用大的数字更优，放置方案为：a 倒序排，先把最大的 x 个数每个组放一个，然后剩下的 x 个最大的数每个组放一个，依此类推。
另一个启发思路是，很小的数字被减去的量也更小，比如 2 至多减去 2，所以把小的数字排在后面，整体减少的量更小。
======

input
5 8
2 3 1 1 2
output
4

input
7 10
1 3 4 2 1 4 2
output
2

input
5 15
5 5 5 5 5
output
1

input
5 16
5 5 5 5 5
output
2

input
5 26
5 5 5 5 5
output
-1


100 10000
100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100 100
100
 */
