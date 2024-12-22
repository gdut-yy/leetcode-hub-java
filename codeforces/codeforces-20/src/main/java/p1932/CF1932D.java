package p1932;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CF1932D {
    static int n;
    static String trump;
    static String[] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            trump = scanner.next();
            s = new String[n * 2];
            for (int i = 0; i < n * 2; i++) {
                s[i] = scanner.next();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        Map<String, List<Integer>> CDHS = new HashMap<>();
        for (String v : s) {
            String suit = v.substring(1);
            int rank = v.charAt(0) - '0';
            CDHS.computeIfAbsent(suit, e -> new ArrayList<>()).add(rank);
        }
        for (List<Integer> list : CDHS.values()) {
            list.sort(null);
        }

        List<String> ans = new ArrayList<>();
        List<Integer> trumpSuit = CDHS.getOrDefault(trump, new ArrayList<>());
        CDHS.remove(trump);
        // 非王牌内部配对
        for (Map.Entry<String, List<Integer>> entry : CDHS.entrySet()) {
            String suit = entry.getKey();
            List<Integer> list = entry.getValue();

            for (int i = 0; i + 1 < list.size(); i += 2) {
                ans.add(list.get(i) + suit + " " + list.get(i + 1) + suit);
            }
        }
        // 非王牌配对不了的 与 王牌 配对
        int j = 0;
        for (Map.Entry<String, List<Integer>> entry : CDHS.entrySet()) {
            String suit = entry.getKey();
            List<Integer> list = entry.getValue();

            int sz = list.size();
            if (sz % 2 == 1) {
                if (j < trumpSuit.size()) {
                    ans.add(list.get(sz - 1) + suit + " " + trumpSuit.get(j++) + trump);
                } else {
                    return "IMPOSSIBLE";
                }
            }
        }
        // 王牌内部配对
        for (int i = j; i + 1 < trumpSuit.size(); i += 2) {
            ans.add(trumpSuit.get(i) + trump + " " + trumpSuit.get(i + 1) + trump);
        }
        return String.join(System.lineSeparator(), ans);
    }
}
/*
D. Card Game
https://codeforces.com/contest/1932/problem/D

题目大意：
两个玩家正在玩在线纸牌游戏。游戏使用 32 张牌。每张牌都有花色和 rank。有四种花色:梅花、方片、红心和黑桃。我们将分别用字符“C”、“D”、“H”和“S”对它们进行编码。有 8 个等级,增加顺序:' 2 ',' 3 ',' 4 ',' 5 ',' 6 ',' 7 ',' 8 ',' 9 '。
每张牌用两个字母表示:它的秩和花色。例如，红心 8 表示为 8H。
在游戏开始时，选择一种花色作为王牌花色。
在每一轮中，玩家的行动是这样的:第一个玩家将自己的一张牌放在桌子上，第二个玩家必须用自己的一张牌击败这张牌。之后，两张牌被移到弃牌堆。
如果两张牌的花色相同，且第一张牌的等级高于第二张牌，那么一张牌就可以打败另一张牌。例如，8S 可以击败 4S。此外，一张王牌可以击败任何一张非王牌，而不管牌的秩，例如，如果王牌花色是梅花('C')，那么 3C 可以击败 9D。注意，王牌只能被更高等级的王牌打败。
游戏进行了 n 轮，所以弃牌堆现在包含 2n 张牌。你想要重建游戏中的回合，但是弃牌堆中的牌被洗牌。找出游戏中可能进行的 n 轮的任何可能序列。

构造
======

Input
8
3
S
3C 9S 4C 6D 3S 7S
2
C
3S 5D 9S 6H
1
H
6C 5D
1
S
7S 3S
1
H
9S 9H
1
S
9S 9H
1
C
9D 8H
2
C
9C 9S 6H 8C
Output
3C 4C
6D 9S
3S 7S
IMPOSSIBLE
IMPOSSIBLE
3S 7S
9S 9H
9H 9S
IMPOSSIBLE
6H 9C
9S 8C
 */
