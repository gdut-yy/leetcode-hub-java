package lq240406;

import java.util.Scanner;

public class LQ240406T3 {
    static long n, k;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextLong();
            k = scanner.nextLong();
            System.out.println(solve());
        }
    }

    private static String solve() {
        long ans = Math.max((n - 2) / k, 1);
        return String.valueOf(ans);
    }
}
/*
学《树论》的贝贝 2.0【算法赛】

任意两条长度为 k 的链均有交集，也就说明树的层数不会超过 2k+1。
于是我们开始构造，我们发现没有分叉的结构可以让结点尽可能的利用。
也就是类似“菊花图”，我们先考虑以根节点为菊花图的中心：
- 就让根的每个儿子子树均为长度为 k-1 的链（k 个节点），当然最后一个儿子子树可能长度凑不到这个值。
- 所以答案也就是为 ceil((n-1)/k).
但是我们发现，根不为中心，为一条链的端点会更优。
因为根为链的端点的话，并不会对叶子节点产生贡献。
- 所以此时答案为 max(1, ceil((n-k-1)/k))，其中 -k 表示根对应的那条链，-1 表示减去中心节点，剩下的节点就是像上一步以根为交点的情况那样分配，可以 O(1) 计算。
@小羊肖恩Yawn_Sean
 */