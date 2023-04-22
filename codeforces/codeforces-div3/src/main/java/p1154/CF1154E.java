package p1154;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1154E {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve(n, k, a));
    }

    private static String solve(int n, int k, int[] a) {
        Map<Integer, Node> nodeMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Node node = new Node(i, a[i]);
            nodeMap.put(a[i], node);
            if (i - 1 >= 0) {
                node.prev = nodeMap.get(a[i - 1]);
                node.prev.next = node;
            }
        }

        int[] res = new int[n];
        int ans = 1;
        for (int v = n; v >= 1; v--) {
            if (!nodeMap.containsKey(v)) {
                continue;
            }

            Node node = nodeMap.get(v);
            res[node.idx] = ans;
            nodeMap.remove(v);

            for (int i = 0; i < k; i++) {
                if (node.prev == null) {
                    break;
                }
                Node prev = node.prev;
                res[prev.idx] = ans;
                nodeMap.remove(prev.val);
                delNode(prev);
            }
            for (int i = 0; i < k; i++) {
                if (node.next == null) {
                    break;
                }
                Node next = node.next;
                res[next.idx] = ans;
                nodeMap.remove(next.val);
                delNode(next);
            }

            delNode(node);

            // 1^3 = 2, 2^3 =
            ans ^= 3;
        }
        return Arrays.stream(res).mapToObj(String::valueOf).collect(Collectors.joining(""));
    }

    private static void delNode(Node node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
    }

    private static class Node {
        int idx;
        int val;
        Node prev;
        Node next;

        public Node(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }
}
/*
E. Two Teams
https://codeforces.com/contest/1154/problem/E

灵茶の试炼 2023-04-13
题目大意：
输入 n k(1≤k≤n≤2e5) 和一个 1~n 的排列 p。
每次操作，选择 p 中最大的数字，然后删除 p 及其左右各 k 个未被删除的元素。
对于每个 p[i]，如果它是第 1,3,5,… 次操作被删除的，输出 1；如果它是第 2,4,6,… 次操作被删除的，输出 2。

双向链表模拟。
https://codeforces.com/contest/1154/submission/201766208
由于数据范围是 1~n，可以用一个 pos 数组记录每个数的下标，然后用双向链表模拟。
从 n 开始倒着找这个数的位置，比如叫 i，如果它没有被删除，就在双向链表上删除 i 及其前后各 k 各节点。
双向链表可以用数组实现，维护 prev 和 next。
======

input
5 2
2 4 5 3 1
output
11111

input
5 1
2 1 3 5 4
output
22111

input
7 1
7 2 1 3 5 4 6
output
1121122

input
5 1
2 4 5 3 1
output
21112
 */
