package p1881;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class CF1881G {
    static int n, m;
    static char[] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            s = scanner.next().toCharArray();
            // 预处理
            pretreatment();

            for (int i = 0; i < m; i++) {
                int op = scanner.nextInt();
                int l = scanner.nextInt() - 1;
                int r = scanner.nextInt();
                if (op == 1) {
                    int x = scanner.nextInt();
                    update(l, r, x);
                } else {
                    System.out.println(query(l, r) ? "YES" : "NO");
                }
            }
        }
    }

    static final int L = 26;
    static final int MAX_N = 200200;
    static TreeSet<Integer> M2, M3;
    static long[] fen = new long[MAX_N];

    static void pretreatment() {
        M2 = new TreeSet<>();
        M3 = new TreeSet<>();
        Arrays.fill(fen, 0);
        fenadd(0, s[0] - 'a');
        for (int i = 1; i < n; ++i) {
            fenadd(i, s[i] - s[i - 1] + L);
        }
        for (int i = 0; i + 1 < n; ++i) {
            if (s[i] == s[i + 1]) M2.add(i);
            if (i + 2 < n && s[i] == s[i + 2]) M3.add(i);
        }
    }

    static void fenadd(int i, int x) {
        x = (x % L + L) % L;
        for (; i < n; i |= (i + 1)) {
            fen[i] = (fen[i] + x) % L;
        }
    }

    static long fenget(int i) {
        long ans = 0;
        for (; i >= 0; i = (i & (i + 1)) - 1) {
            ans = (ans + fen[i]) % L;
        }
        return ans;
    }

    static void relax(int l, int r) {
        l = Math.max(l, 0);
        r = Math.min(r, n);
        for (int i = l; i + 1 < r; ++i) {
            long c1 = fenget(i);
            long c2 = fenget(i + 1);

            if (c1 == c2) M2.add(i);
            else M2.remove(i);

            if (i + 2 >= r) continue;

            long c3 = fenget(i + 2);
            if (c1 == c3) M3.add(i);
            else M3.remove(i);
        }
    }

    static void update(int l, int r, int x) {
        fenadd(l, x);
        relax(l - 5, l + 5);
        fenadd(r, L - x);
        relax(r - 5, r + 5);
    }

    static boolean query(int l, int r) {
        // auto it = M2.lower_bound(l);
        // if (it != M2.end() && *it + 1 < r) return false;
        Integer it = M2.ceiling(l);
        if (it != null && it + 1 < r) return false;
        it = M3.ceiling(l);
        if (it != null && it + 2 < r) return false;
        return true;
    }
}
/*
G. Anya and the Mysterious String
https://codeforces.com/contest/1881/problem/G

题目大意：
安雅收到了从罗马带来的长度为 n 的字符串。字符串 s 由小写拉丁字母组成，乍一看不会引起任何怀疑。一条指令附在字符串上。
指令开始。
回文是一个从左到右和从右到左读取相同的字符串。例如，字符串“anna”，“aboba”，“level”是回文，而字符串“gorilla”，“banan”，“off”不是回文。
字符串 s 的子字符串[l…r]是字符串 slsl+1...sr−1sr。例如，字符串"generation"的子字符串[4…6]是字符串"era"。
如果字符串不包含长度至少为 2 的回文子字符串，则称为漂亮字符串。例如，字符串“fox”、“abcdef”和“yioy”是漂亮的，而字符串“xyxx”、“yikjkitrb”则不是。
当一个整数 x 被添加到字符 si 时，它会被字母表中的下一个字符替换 x 次，其中“z”被替换为“a”。
当将整数 x 添加到字符串 s 的子字符串[l,r]中时，它变成字符串 s1s2...sl−1(sl+x)(sl+1+x)...(sr−1+x)(sr+x)sr+1...sn。例如，当字符串“abazaba”的子字符串[2,4]与数字 6 相加时，得到的字符串是“ahgfaba”。
指令结束。
看完说明后，安雅接受了必须回答我的问题的事实。查询可以有两种类型:
1、将数字 x 添加到字符串 s 的子字符串[l...r]中。
2、判断字符串 s 的子字符串[l...r]是否美观。

rating 2000
https://codeforces.com/blog/entry/121327
让我们对长度至少为 2 的回文做两个明显的观察:
- 长度为 2n 的回文包含一个回文子串[n...n+1];
- 长度为 2n+1 的回文包含一个回文子串[n...n+2]。
现在我们需要学习如何只跟踪长度为 2 和 3 的回文。如果长度为 2 的回文从它开始，我们称它为坏索引，如果长度为 3 的回文从它开始，我们称它为坏索引。我们将把坏索引和坏索引存储在一对 std::set 中。
让我们假设没有修改查询，我们需要检查子字符串[l...r]是否美观。如果存在坏索引 i (l≤i≤r−1)或坏索引 j (l≤j≤r−2)，则子串不美观;否则，它是美丽的。这可以在集合上使用二分搜索来检查。
现在让我们学习如何修改。请注意，回文不会在段内出现或消失，但它们可以在其边界出现或消失。让我们使用一个数据结构，它可以在段上添加值并在点上检索值。如果存在这样的结构，我们将把 xmod26 添加到段[l...r]中，然后处理离 l 最近的 10 个索引和离 r 最近的 10 个索引。我们可以更精确地描述哪些坏的和糟糕的指标应该被处理，但作者是懒惰的，它不影响解，因为这样的指标的数量仍然是 O(1)。在处理索引时，在 std::set 中使用点查询和插入/删除操作。
现在我们需要实现这样一个数据结构。作者建议在差分数组上使用 Fenwick 树。具有延迟传播的段树也可以工作。这给出了一个具有 O((n+q)logn)时间复杂度的解决方案。
======

input
5
12 8
tedubcyyxopz
2 2 5
1 4 8 2
2 1 7
1 3 5 40
1 9 11 3
1 10 10 9
2 4 10
2 10 12
10 4
ubnxwwgzjt
2 4 10
2 10 10
1 6 10 8
2 7 7
11 3
hntcxfxyhtu
1 4 6 1
2 4 10
1 4 10 21
13 2
yxhlmzfhqctir
1 5 9 3
1 8 13 15
2 3
bp
1 1 2 15
1 1 2 18
1 2 2 1000000000
output
YES
NO
NO
YES
NO
YES
YES
YES
 */
