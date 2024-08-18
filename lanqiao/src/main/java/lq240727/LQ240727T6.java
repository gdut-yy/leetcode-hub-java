package lq240727;

import java.util.Arrays;
import java.util.Scanner;

public class LQ240727T6 {
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

    static int[] b;

    private static String solve() {
        b = new int[n];
        for (int i = 0; i < n; i++) {
            if (a[i] <= k) {
                b[i] = a[i];
            } else {
                if (a[i] % 2 != 0) b[i] = -1;
            }
        }

        reverseSort(b);

        long ans = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) ans += b[i];
            else ans -= b[i];
            ans += a[i];
        }
        return String.valueOf(ans / 2);
    }

    static void reverseSort(int[] nums) {
        Arrays.sort(nums);
        for (int l = 0, r = nums.length - 1; l < r; l++, r--) {
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
        }
    }
}
/*
真假美猴王的幽谷纷争【算法赛】

对于第 i 株零花：
当 ai < k 时，行动者可以直接将其吸纳。因此，先手选择第 i 株灵花对自身有利。
当 ai > k 时，如果先手选取它，那么只能将其进行拆分，而后手则能根据先手的拆分选择最优的一部分。
因此，尽可能后手选择将对自身有利。
由于灵力的总数是固定的，所以孙悟空和六耳猕猴的目标就是尽可能多地选取对自己有利的灵花，同时尽可能减少对方选取的灵力数量。
为了更好地理解这个问题，我们先定义一些概念：
- 灵花价值：对于一个灵力为 ai 的灵花，我们定义它的价值 v(a) 如下：
  - 当 a <= k 时，灵花的价值等于灵力点数，即 v(a) = a。
  - 当 a > k 且 a 是偶数时，灵花的价值为 0，即 v(a) = 0。
  - 当 a > k 且 a 是奇数时，灵花的价值为 -1，即 v(a) = -1。
- 局面：我们将幽谷剩余的灵花大小集合表示为 M，例如 M = a1,a2,...,an，其中 ai 表示第 i 株灵花的灵力点数。
- 先手收益：定义 P(M) 为从局面 M 开始游戏时，先手行动者（孙悟空）所能获得的最大收益，即孙悟空获取的灵力总数减去六耳猕猴获取的灵力总数。
接着，我们可以用一个公式来计算先手收益：
P(M) = \sum_{i=1}^{|M|}(-1)^{i-1}v(s_i)
这个公式的含义是：将所有的灵花替换为它们的价值，然后按照从大到小的顺序依次选取，基数位置的灵花由孙悟空选取，偶数位置的灵花由六耳猕猴选取。
最终孙悟空选取的灵力总数减去六耳猕猴选取的灵力总数就是先手收益。
例如，假设 k=3，幽谷中有三株灵花，对应的灵力点分别为 5、2 和 4。那么，M = 5,2,4，v(5) = -1, v(2) = 2, v(4) = 0。
根据公式，P(M) = -1 + 2 - 0 = 1。
最终，孙悟空获取的灵力总数为
\frac{p(M)+\sum(M)}{2}
其中 \sum(M) 表示 M 中所有灵力之和。
这个公式的计算可以在 O(NlogN) 的时间复杂度内完成。其中 N 为灵花的数量。我们只需要将灵花按照价值从大到小排序，然后依次计算每株灵花的价值，
并累加到先手收益中即可。
 */