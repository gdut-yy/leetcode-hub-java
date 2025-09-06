import java.util.ArrayList;
import java.util.List;

public class SolutionP3526 {
    static class Node {
        Node[] ch = new Node[2];
        int sz, key, sum;
        boolean flipTodo;

        Node(int key) {
            this.key = key;
            this.sum = key;
            this.sz = 1;
        }

        // 设置如下返回值是为了方便使用 node 中的 ch 数组
        int cmpKth(int k) {
            int ch0size = (ch[0] != null) ? ch[0].sz : 0;
            int d = k - ch0size - 1;
            if (d < 0) return 0; // 左儿子
            if (d > 0) return 1; // 右儿子
            return -1;
        }

        void maintain() {
            sz = 1 + (ch[0] != null ? ch[0].sz : 0) + (ch[1] != null ? ch[1].sz : 0);
            sum = key ^ (ch[0] != null ? ch[0].sum : 0) ^ (ch[1] != null ? ch[1].sum : 0);
        }

        void apply() {
            flipTodo = !flipTodo;
        }

        void pushDown() {
            if (!flipTodo) return;
            if (ch[0] != null) ch[0].apply();
            if (ch[1] != null) ch[1].apply();
            // o.ch[0], o.ch[1] = o.ch[1], o.ch[0]
            Node temp = ch[0];
            ch[0] = ch[1];
            ch[1] = temp;
            flipTodo = false;
        }
    }

    // 构建一棵中序遍历为 a 的 splay 树
    // 比如，给你一个序列和一些修改操作，每次取出一段子区间，cut 掉然后 append 到末尾，输出完成所有操作后的最终序列：
    //     我们可以 buildSplay(1,n)，每次操作调用两次 split 来 cut 区间，得到三棵子树 a b c
    //     append 之后应该是 a c b，那么我们可以 a.merge(c.merge(b)) 来完成这一操作
    //     注意 merge 后可能就不满足搜索树的性质了，但是没有关系，中序遍历的结果仍然是正确的，我们只要保证这一点成立，就能正确得到完成所有操作后的最终序列
    private Node buildSplay(int[] a, int l, int r) {
        if (l > r) return null;
        int m = (l + r) >>> 1;
        Node o = new Node(a[m]);
        o.ch[0] = buildSplay(a, l, m - 1);
        o.ch[1] = buildSplay(a, m + 1, r);
        o.maintain();
        return o;
    }

    // 旋转，并维护子树大小
    // d=0：左旋，返回 o 的右儿子
    // d=1：右旋，返回 o 的左儿子
    private Node rotate(Node o, int d) {
        Node x = o.ch[d ^ 1];
        o.ch[d ^ 1] = x.ch[d];
        x.ch[d] = o;
        o.maintain();
        x.maintain();
        return x;
    }

    // 将子树 o（中序遍历）的第 k 个节点伸展到 o，并返回该节点
    // 1 <= k <= o.size()
    private Node splay(Node o, int k) {
        if (o == null) return null;
        o.pushDown();
        int d = o.cmpKth(k);
        if (d < 0) return o;
        int ch0size = (o.ch[0] != null) ? o.ch[0].sz : 0;
        k -= d * (ch0size + 1);
        Node c = o.ch[d];
        if (c == null) return o;
        c.pushDown();
        int d2 = c.cmpKth(k);
        if (d2 >= 0) {
            int cch0size = (c.ch[0] != null) ? c.ch[0].sz : 0;
            c.ch[d2] = splay(c.ch[d2], k - d2 * (cch0size + 1));
            if (d2 == d) o = rotate(o, d ^ 1);
            else o.ch[d] = rotate(c, d);
        }
        return rotate(o, d ^ 1);
    }

    // 分裂子树 o，把 o（中序遍历）的前 k 个节点放在 lo 子树，其余放在 ro 子树
    // 返回的 lo 节点为 o（中序遍历）的第 k 个节点
    // 1 <= k <= o.size()
    // 特别地，k = o.size() 时 ro 为 nil
    private Node[] split(Node lo, int k) {
        if (k > lo.sz) return new Node[]{lo, null};
        lo = splay(lo, k);
        Node ro = lo.ch[1];
        lo.ch[1] = null;
        lo.maintain();
        return new Node[]{lo, ro};
    }

    // 把子树 ro 合并进子树 o，返回合并前 o（中序遍历）的最后一个节点
    // 相当于把 ro 的中序遍历 append 到 o 的中序遍历之后
    // ro 可以为 nil，但 o 不能为 nil
    private Node merge(Node o, Node ro) {
        if (o == null) return ro;
        // 把最大节点伸展上来，这样会空出一个右儿子用来合并 ro
        o = splay(o, o.sz);
        o.ch[1] = ro;
        o.maintain();
        return o;
    }

    public int[] getResults(int[] nums, int[][] queries) {
        // nums = append([]int{0}, nums...) // 前面插个哨兵，保证 t.split(l) 的返回值 lo 非空
        int[] arr = new int[nums.length + 1];
        arr[0] = 0;
        System.arraycopy(nums, 0, arr, 1, nums.length);

        Node t = buildSplay(arr, 0, arr.length - 1);
        List<Integer> ans = new ArrayList<>();
        for (int[] q : queries) {
            if (q[0] == 1) {
                t = splay(t, q[1] + 2);
                t.sum ^= t.key ^ q[2];
                t.key = q[2];
            } else {
                int l = q[1] + 1, r = q[2] + 1;
                // 先拆开
                Node[] sp = split(t, l);
                Node lo = sp[0], o = sp[1];
                sp = split(o, r - l + 1);
                Node mo = sp[0], ro = sp[1];
                if (q[0] == 2) {
                    ans.add(mo != null ? mo.sum : 0);
                } else if (mo != null) {
                    mo.apply(); // 把中间这段反转
                }
                t = merge(merge(lo, mo), ro); // 再拼回去
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
/*
$3526. 范围异或查询与子数组反转
https://leetcode.cn/problems/range-xor-queries-with-subarray-reversals/description/

给定一个长度为 n 的整数数组 nums 和一个长度为 q 的二维整数数组 queries，其中的每个查询是以下三种类型之一：
1.更新：queries[i] = [1, index, value]
  赋值 nums[index] = value。
2.范围异或查询：queries[i] = [2, left, right]
  计算 子数组 中所有元素的按位异或 nums[left...right]，并记录结果。
3.反转 子数组：queries[i] = [3, left, right]
  原地反转 nums[left...right] 子数组。
按照遇到的顺序返回所有范围异或查询的结果数组。
提示：
1 <= nums.length <= 105
0 <= nums[i] <= 109
1 <= queries.length <= 105
queries[i].length == 3
queries[i][0] ∈ {1, 2, 3}
如果 queries[i][0] == 1:
  0 <= index < nums.length
  0 <= value <= 109
如果 queries[i][0] == 2 或 queries[i][0] == 3：
  0 <= left <= right < nums.length

Splay 模板 https://leetcode.cn/problems/range-xor-queries-with-subarray-reversals/solutions/3658712/splay-mo-ban-by-endlesscheng-5ffa/
时间复杂度 O(n+qlogn)。其中 n 是 nums 的长度，q 是 queries 的长度。
 */