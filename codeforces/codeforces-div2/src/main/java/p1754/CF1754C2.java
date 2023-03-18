package p1754;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1754C2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve(n, a));
        }
    }

    private static String solve(int n, int[] a) {
        int sum = Arrays.stream(a).sum();
        if ((sum & 1) == 1) {
            return "-1";
        }

        LinkedList<int[]> resList = new LinkedList<>();
        int tmp = sum > 0 ? 1 : -1;
        for (int i = 0; i < n; i++) {
            if (i + 1 < n && a[i + 1] == tmp && sum != 0) {
                resList.add(new int[]{i + 1, i + 2});
                sum -= 2 * tmp;
                i++;
            } else {
                resList.add(new int[]{i + 1, i + 1});
            }
        }
        return resList.size()
                + System.lineSeparator()
                + resList.stream().map(o -> o[0] + " " + o[1]).collect(Collectors.joining(System.lineSeparator()));
    }
}
/*
C2. Make Nonzero Sum (hard version)
https://codeforces.com/contest/1754/problem/C2

题目大意：
这是这个问题的困难版本。不同之处在于，在这个版本中数组包含0。只有两个版本的问题都解决了，才能进行hack。

如果数组中所有数字的和都是奇数，那么分裂是不可能的，因为分裂并不影响和的均匀性。否则，我们将建设性地构建答案。假设我们考虑了某种数组前缀。一直算下去，直到得到两个非零数。
我们想让这两个非零数加起来等于 0。如果最后一段的和已经等于 0，那就把它当作答案。否则，考虑以下几种情况:
- 如果线段的长度是偶数，那么我们只需将最后一个数字(它将是非零)分离到一个单独的线段中。那么它的符号就会改变这两个数加起来都是 0。
- 如果线段的长度是奇数，但它的第一个元素等于 0，也可以这样做。分离这个 0 并重复上面的算法。
- 如果线段的长度是奇数，并且第一个元素不等于 0，那么我们将它分离。那么第一个元素的值不变，最后一个元素的值相反，然后它们的和将等于 0。
======

input
5
4
0 0 0 0
7
-1 1 0 1 0 1 0
5
0 -1 1 0 1
3
1 0 1
1
1
output
4
1 1
2 2
3 3
4 4
4
1 1
2 2
3 5
6 7
-1
2
1 1
2 3
-1
 */
