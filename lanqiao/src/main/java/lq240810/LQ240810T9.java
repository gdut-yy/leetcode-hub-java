package lq240810;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LQ240810T9 {
    static int n;
    static char[][] S;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        S = new char[n][];
        for (int i = 0; i < n; i++) {
            S[i] = scanner.next().toCharArray();
        }
        System.out.println(solve());
    }

    private static String solve() {
        char[] mi = new char[1];
        mi[0] = (char) ('z' + 1);
        int x = 0;
        for (int i = 0; i < n; i++) {
            cal(S[i]);
            if (Arrays.compare(mi, S[i]) > 0) {
                mi = S[i];
                x = 1;
            } else if (Arrays.equals(mi, S[i])) {
                x++;
            }
        }
        return String.valueOf(x);
    }

    static void cal(char[] t) {
        int n = t.length;

        List<Integer>[] pos = new ArrayList[26];
        Arrays.setAll(pos, e -> new ArrayList<>());
        for (int i = 0; i < n; i++) pos[t[i] - 'a'].add(i);

        for (int i = 0; i < n; i++) {
            for (int c = 0; c < t[i] - 'a'; c++) {
                int back = pos[c].size() - 1;
                if (!pos[c].isEmpty() && i < pos[c].get(back)) {
//                    swap(t[i], t[pos[c].back()]);
                    char tmp = t[i];
                    t[i] = t[pos[c].get(back)];
                    t[pos[c].get(back)] = tmp;
                    return;
                }
            }
        }

        for (int c = 0; c < 26; c++) {
            if (pos[c].size() >= 2) return;
        }
//        swap(t[n - 2], t[n - 1]);
        char tmp = t[n - 2];
        t[n - 2] = t[n - 1];
        t[n - 1] = tmp;
    }
}
/*
花魁之争【算法赛】

试想一下，鹊桥长度为 $1$，仙女们只能进行一次花朵交换操作。在这种情况下，谁能获胜就取决于谁的花环在经过一次交换后能够达到最小的字典序。
更进一步地，如果我们能确定在鹊桥长度为 $1$ 时哪些仙女可以获胜，那么我们就能推断出最终会有多少仙女成为“花魁”。这是因为，
所有在鹊桥长度为 $1$ 时能够获胜的仙女，都可以通过选择长度为 $1$ 的鹊桥来确保自己成为“花魁”。而其他仙女，无论选择什么长度，都无法阻止这些“潜在花魁”的胜利。
于是，我们的目标就可转变为：**找到在鹊桥长度为 $1$ 时能够获胜的仙女**。
对于第 $i$ 位仙女的花环（记为 $S$），我们只需要找到进行一次交换操作后能够得到的字典序最小的字符串。为了实现这一点，我们需要找到符合以下条件的两个位置 $(i, j)$：
1、$S_i > S_j$ 且 $i < j$：为了使字典序变小，我们需要交换一个较大的字符和一个较小的字符。并且，较大的字符必须在较小的字符之前。
2、$i$ 尽可能小:  在满足条件 $1$ 的前提下，我们希望交换的位置尽可能靠前，这样才能最大程度地降低字典序。
3、在满足条件 $1$ 和 $2$ 的情况下，$S_j$ 尽可能小:  相同位置的较大字符与更小的字符交换，能获得更小的字典序。
4、在满足条件 $1$，$2$ 和 $3$ 的情况下，$j$ 尽可能大:  将较小的字符尽量往后移动，可以使字典序更小。这是因为，较小字符的位置越靠后，对字典序的影响就越小。
如果找不到符合上述所有条件的位置对 $(i, j)$，则说明该花环无法通过一次交换操作变得更小。即无论如何交换，字符串的字典序要么不变要么变大，因此选择对字典序影响最小的交换。
在找到所有仙女经过一次交换操作后能够得到的字典序最小的字符串后，我们只需要**比较这些字符串的字典序**，即可计算出“花魁”的数量。
 */