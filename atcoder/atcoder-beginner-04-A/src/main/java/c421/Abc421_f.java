package c421;

import java.io.PrintWriter;
import java.util.Scanner;

public class Abc421_f {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static class Node {
        int val;
        Node prev;
        Node next;

        Node(int v) {
            val = v;
        }
    }

    static final int MAX_Q = (int) 5e5;
    static Node[] nodeMap = new Node[MAX_Q + 10];

    private static void solve() {
        int Q = scanner.nextInt();
        nodeMap[0] = new Node(0);
        final int LIMIT = 1000;

        for (int i = 1; i <= Q; i++) {
            int type = scanner.nextInt();
            if (type == 1) {
                int x = scanner.nextInt();
                Node nodeX = nodeMap[x];
                Node newNode = new Node(i);
                newNode.prev = nodeX;
                newNode.next = nodeX.next;
                if (nodeX.next != null) {
                    nodeX.next.prev = newNode;
                }
                nodeX.next = newNode;
                nodeMap[i] = newNode;
            } else {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                Node nx = nodeMap[x];
                Node ny = nodeMap[y];
                boolean found = false;
                boolean nxBeforeNy = false;

                if (x == 0) {
                    nxBeforeNy = true;
                } else {
                    Node cur = nx;
                    for (int steps = 0; steps < LIMIT && cur != null; steps++) {
                        if (cur == ny) {
                            found = true;
                            nxBeforeNy = true;
                            break;
                        }
                        cur = cur.next;
                    }
                    if (!found) {
                        cur = nx;
                        for (int steps = 0; steps < LIMIT && cur != null; steps++) {
                            if (cur == ny) {
                                found = true;
                                break;
                            }
                            cur = cur.prev;
                        }
                    }
                    if (!found) {
                        cur = nodeMap[0];
                        while (cur != null) {
                            if (cur == nx) {
                                nxBeforeNy = true;
                                break;
                            }
                            if (cur == ny) {
                                break;
                            }
                            cur = cur.next;
                        }
                    }
                }

                long sum = 0;
                if (nxBeforeNy) {
                    Node cur = nx.next;
                    while (cur != ny) {
                        sum += cur.val;
                        Node toDel = cur;
                        cur = cur.next;
                        toDel.prev = null;
                        toDel.next = null;
                    }
                    nx.next = ny;
                    ny.prev = nx;
                } else {
                    Node cur = ny.next;
                    while (cur != nx) {
                        sum += cur.val;
                        Node toDel = cur;
                        cur = cur.next;
                        toDel.prev = null;
                        toDel.next = null;
                    }
                    ny.next = nx;
                    nx.prev = ny;
                }
                out.println(sum);
            }
        }
    }
}
/*
F - Erase between X and Y
https://atcoder.jp/contests/abc421/tasks/abc421_f

题目大意：
有一个序列 A 。初始为 A=(0)。(即 A 是长度为 1 的序列，其中唯一的元素是 0）。
您要依次处理的查询有 Q 个。 i-th 查询 (1 <= i <= Q) 有以下形式之一：
- `1 x`:在 A 中 x 出现的位置后插入 i 。具体来说，假设 Aj 是当前 A 中的 j-th 元素， n 是 A 的长度。对于 p 这样的 Ap=x ，更新 A 为 (A1,...,Ap,i,A_{p+1},...,A_n) 。保证在处理此查询之前， A 立即包含 x 。
- `2 x y`：删除 A 中介于 x 和 y 之间的所有元素，并输出删除元素的值之和。具体来说，假设 Aj 是当前 A 中的第 j 个元素， n 是 A 的长度。对于 p 和 q ，即 A_p=x 和 A_q=y ，输出 A_{\min(p,q)+1} + ... + A_{\max(p,q)-1} 并更新 A 为 (A_1,...,A_{\min(p,q)},A_{\max(p,q)},...,A_n) 。在处理此查询之前，保证 A 同时包含 x 和 y 。
需要注意的是，对于任何查询序列，在处理查询的过程中，同一个值绝不会在 A 中出现多次，因此某个值在 A 中出现的位置是唯一的（如果存在的话）。

https://yuanbao.tencent.com/chat/naQivTmsDa/d88d7508-b883-4d68-b4c9-9fc6ed9169dd
======

Input 1
6
1 0
1 1
1 0
2 2 3
1 2
2 0 5
Output 1
1
5

Input 2
2
1 0
2 0 1
Output 2
0

Input 3
10
1 0
1 1
2 0 2
2 0 2
1 0
1 5
2 0 5
2 2 6
1 6
1 9
Output 3
1
0
0
0
 */
