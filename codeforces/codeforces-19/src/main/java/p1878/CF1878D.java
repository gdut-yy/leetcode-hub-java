package p1878;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CF1878D {
    static int n, k;
    static String s;
    static int[] l, r;
    static int q;
    static int[] x;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            k = scanner.nextInt();
            s = scanner.next();
            l = new int[k];
            for (int i = 0; i < k; i++) {
                l[i] = scanner.nextInt();
            }
            r = new int[k];
            for (int i = 0; i < k; i++) {
                r[i] = scanner.nextInt();
            }
            q = scanner.nextInt();
            x = new int[q];
            for (int i = 0; i < q; i++) {
                x[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        Arrays.sort(x);

        StringBuilder ans = new StringBuilder();
        int j = 0;
        for (int i = 0; i < k; i++) {
            int li = l[i], ri = r[i];
            String sub = s.substring(li - 1, ri);
            List<Integer> list = new ArrayList<>();
            while (j < q) {
                if (li <= x[j] && x[j] <= ri) {
                    list.add(x[j] - li);
                } else {
                    break;
                }
                j++;
            }
            ans.append(getString(sub, list));
        }
        return ans.toString();
    }

    static String getString(String s, List<Integer> list) {
        int n = s.length();
        int[] diff = new int[n + 1];
        for (Integer i : list) {
            int j = n - 1 - i;
            int a = Math.min(i, j);
            int b = Math.max(i, j);
            diff[a] += 1;
            diff[b + 1] -= 1;
        }
        int[] res = new int[n];
        res[0] = diff[0];
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] + diff[i];
        }

        char[] cs = s.toCharArray();
        for (int i = 0; i < n / 2; i++) {
            if (res[i] % 2 == 1) {
                int j = n - 1 - i;
                // swap
                char tmp = cs[i];
                cs[i] = cs[j];
                cs[j] = tmp;
            }
        }
        return new String(cs);
    }
}
/*
D. Reverse Madness
https://codeforces.com/contest/1878/problem/D

题目大意:
给定一个长度为 n 的字符串 s，其中包含小写拉丁字母。
接下来你会得到一个正整数 k 和两个长度为 k 的数组，l 和 r。
可以保证以下条件对这两个数组成立:
- l1 = 1;
- rk = n;
- li≤ri，对于每一个正整数 i，使 1≤i≤k;
- li =r[i−1]+1，对于每一个正整数 i，使 2≤i≤k;
现在你会得到一个正整数 q，它代表了你需要对 s 进行修改的次数。
每次修改都用一个正整数 x 定义:
- 找到一个索引 i 使得 li≤x≤ri(注意这个 i 是唯一的)。
- 设 a=min(x,ri+li-x)，设 b=max(x,ri+li-x)。
- 将 s 的子字符串从索引 a 反转到索引 b。
反转字符串 s 的子字符串[a,b]意味着使 s 等于
s1,s2,…,sa−1, sb,sb−1,…,sa+1,sa, sb+1,sb+2,…,sn−1,sn .
最后一次修改完成后打印。

分组+差分模拟

======

input
5
4 2
abcd
1 3
2 4
2
1 3
5 3
abcde
1 2 3
1 2 5
3
1 2 3
3 1
gaf
1
3
2
2 2
10 1
aghcdegdij
1
10
5
1 2 3 4 2
1 1
a
1
1
1
1
output
badc
abedc
gaf
jihgedcdga
a
 */
