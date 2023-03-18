package p1754;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1754C1 {
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
        for (int i = 0; i < n / 2; i++) {
            if (a[i * 2] == a[i * 2 + 1]) {
                int r = (i * 2 + 1) + 1;
                if (resList.isEmpty()) {
                    resList.add(new int[]{1, 2});
                }
                resList.getLast()[1] = r;
            } else {
                int l = (i * 2) + 1;
                int r = (i * 2 + 1) + 1;
                resList.add(new int[]{l, l});
                resList.add(new int[]{r, r});
            }
        }

        return resList.size()
                + System.lineSeparator()
                + resList.stream().map(o -> o[0] + " " + o[1]).collect(Collectors.joining(System.lineSeparator()));
    }
}
/*
C1. Make Nonzero Sum (easy version)
https://codeforces.com/contest/1754/problem/C1

题目大意：
给定一个数组 [a1,a2,...,an]，由整数 −1 和 1 组成。你必须建立这个数组的一个分区到段的集合 [l1,r1],[l2,r2],...,[lk,rk] 具有以下属性:
- 定义第 i 段所有元素的交替和为 si: si = ali−ali+1+ali+2−ali+3+…±ari。例如，数组 [1,0，−1,1,1] 中段 [2,4] 的元素的交替和等于 0−(−1)+1=2。
- 所有分割段的 si 和应该等于零。
注意，每个 si 不一定等于零，这个性质是关于 si 对所有分割段的和。
段集合 [l1,r1],[l2,r2],...,[lk,rk] 被称为长度为 n 的数组 a 的一个分区，如果 1=l1≤r1,l2≤r2，…，lk≤rk=n 并且对于所有 i=1,2，…k−1,ri+1=li+1。换句话说，数组的每个元素必须恰好属于一个段。
您必须使用上述属性为给定数组构建一个分区，或者确定这样的分区不存在。
注意，不需要最小化分区中的段数。

constructive algorithms
如果数组中所有元素的和是奇数，则分区不存在，因为分区不影响和的奇偶校验。否则答案是存在的。
让我们建造这样的建筑。因为所有元素的和是偶数，所以 n 也是偶数。考虑具有索引(1,2)，(3,4)，…， (n−1,n)。考虑对(2i−1,2i)。如果 a[2i−1]=a[2i]，则在答案后加上[2i−1,2i]段。在这种情况下，这段元素的交替和将等于 a[2i−1]−a[2i]=0。
否则，我们将在答案中增加两个段:[2i−1,2i−1]和[2i,2i]。第一个段的和为 a[2i−1]，第二个段的和为 a[2i]。两个和的和等于零。所以所有交替和的和将等于零。
======

input
4
4
1 1 1 1
6
-1 1 1 1 1 1
3
1 -1 1
1
1
output
1
1 4
2
1 3
4 6
-1
-1

1
7
-1 -1 -1 1 1 1 -1
 */
