package p1846;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class CF1846F {
    static Scanner scanner;
    static int n;
    static int[] a;

    public static void main(String[] args) {
        scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            solve();
        }
    }

    private static void solve() {
        List<Integer> v = new ArrayList<>();
        Map<Integer, Integer> mp = new HashMap<>();
        for (int x : a) {
            v.add(x);
            mp.put(x, mp.getOrDefault(x, 0) + 1);
        }

        Set<Integer> elements_to_erase = new HashSet<>();
        int ans = 0;
        for (int i = 0; i < 5; i++) {
            if (v.size() - elements_to_erase.size() == 1) {
                System.out.println("! " + ans);
                break;
            }
            String s = "- " + elements_to_erase.size() + " "
                    + elements_to_erase.stream().map(String::valueOf).collect(Collectors.joining(" "));
            System.out.println(s);

            List<Integer> newV = new ArrayList<>();
            Map<Integer, Integer> newMp = new HashMap<>();
            for (int j = 0; j < v.size() - elements_to_erase.size(); j++) {
                int x = scanner.nextInt();
                newV.add(x);
                newMp.put(x, newMp.getOrDefault(x, 0) + 1);
            }
            elements_to_erase.clear();

            int tm = -1;
            for (Map.Entry<Integer, Integer> entry : newMp.entrySet()) {
                int key = entry.getKey(), val = entry.getValue();
                if (val > mp.getOrDefault(key, 0)) {
                    tm = key;
                }
            }
            if (tm != -1) {
                for (int j = 0; j < newV.size(); j++) {
                    if (newV.get(j) != tm) {
                        elements_to_erase.add(j + 1);
                    } else {
                        ans = j + 1;
                    }
                }
                mp.clear();
                mp.put(tm, newMp.get(tm));
            }
            v = newV;
        }
    }
}
/*
F. Rudolph and Mimic
https://codeforces.com/contest/1846/problem/F

题目大意：
这是一个交互式任务。
鲁道夫是一位研究外星生命形式的科学家。鲁道夫面前有一个房间，房间里散落着 n 个不同的物体。在这些物体中，有一种神奇的生物——一种可以变成任何物体的模仿者。他已经在这个房间里伪装了自己，鲁道夫需要通过实验找到他。
实验分几个阶段进行。在每个阶段，会发生以下情况:
- 鲁道夫看着房间里所有的物品，写下它们的类型。每个对象的类型用一个数字表示;可以有多个相同类型的对象。
- 在检查之后，鲁道夫可以指着一个他认为是模仿者的物体。之后，实验结束。鲁道夫只有一次尝试，所以如果它不确定模仿者的位置，它就会做下一步。
- 鲁道夫可以从房间里拿走任何数量的东西(可能是零)。然后鲁道夫离开房间，此时所有的物体，包括模仿者，彼此混合在一起，它们的顺序被改变，模仿者可以变成任何其他物体(甚至是不在房间里的物体)。
- 这之后，鲁道夫回到房间，重复了一遍。模仿者可能不会改变外观，但它不能在连续两个阶段以上保持同一物体。
鲁道夫的任务是用不超过五个阶段来识别模仿者。

https://codeforces.com/blog/entry/118044
策略是跟踪每种类型对象的数量。当某种类型的对象数量增加时，这意味着模仿者已经变成了该类型的对象。然后可以删除所有其他对象。在第一次这样的移除之后，所有的对象将变得相等。然后，在最多两个阶段之后，模仿者将被迫转变为其他东西，并且可以明确地识别它。
让我们考虑最坏的情况，即模仿者在第一阶段和第二阶段之间没有改变其外观。然后，我们不使用前两个请求删除任何元素。在第二步和第三步之间，模仿者将被迫进行转换，然后我们可以删除所有对象，除了那些与模仿者具有相同类型的对象。模仿者可能不会在第三和第四阶段之间改变，但将被迫在第四和第五阶段之间转变。然后我们将能够明确地确定模仿者，因为在转换之前所有对象都是相同的。
======

input
3
5
1 1 2 2 3

2 1 1 2

2 2 2

2

8
1 2 3 4 3 4 2 1

4 3 4 3 2 2 1 3

2 3 3 2

5 3 2

2 5

15
1 2 3 4 5 6 7 8 7 6 5 4 3 2 1

1 2 3 4 5 6 7 8 7 9 5 4 3 2 1
output


- 1 5

- 1 3

- 2 1 2

! 1


- 0

- 4 1 3 7 8

- 1 4

- 1 2

! 2


- 0

! 10
 */
