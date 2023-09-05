package p1849;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class CF1849B {
    static int n, k;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            k = scanner.nextInt();
            a = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        // %k余数, 下标
        TreeMap<Integer, List<Integer>> remainMap = new TreeMap<>(Comparator.reverseOrder());
        for (int i = 1; i <= n; i++) {
            int modk = a[i] % k;
            if (modk == 0) {
                modk = k;
            }
            remainMap.computeIfAbsent(modk, key -> new ArrayList<>()).add(i);
        }

        List<Integer> ans = new ArrayList<>();
        for (List<Integer> val : remainMap.values()) {
            ans.addAll(val);
        }
        return ans.stream().map(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
B. Monsters
https://codeforces.com/contest/1849/problem/B

题目大意：
Monocarp 正在玩另一款电脑游戏。再一次，他的角色杀死了一些怪物。游戏中有 n 个怪物，编号从 1 到 n，第 i 个怪物最初拥有 ai 生命值。
独果的角色有一个技能，对当前生命值最高的怪物造成 k 点伤害。如果有几个，则选择索引较小的那个。如果怪物的生命值在 Monocarp 使用技能后小于等于 0，那么它就会死亡。
独角兽使用他的能力，直到所有的怪物死亡。你的任务是决定怪物死亡的顺序。

按余数分组，贪心
---
https://codeforces.com/blog/entry/118752
让我们模拟游戏过程，直到每个怪物的生命值变为 k 或更少。然后我们可以认为怪物的生命值是 aimodk，而不是 ai(除非 ai 可以被 k 整除，那么剩余的生命值是 k，而不是 0)。
现在，所有怪物的生命值从 1 到 k，所以每次我们伤害一个怪物，我们就杀死它。因此，拥有 k 点生命值的怪物将首先死亡，然后是拥有 k - 1 点生命值的怪物，以此类推。所以，让我们按照剩余生命值降序对怪物进行排序(不要忘记，如果两个怪物拥有相同的生命值，那么它们应该通过指数进行比较)。排序后得到的顺序就是问题的答案。
======

input
3
3 2
1 2 3
2 3
1 1
4 3
2 8 3 5
output
2 1 3
1 2
3 1 2 4

1
2 3
1 2
2 1
 */
