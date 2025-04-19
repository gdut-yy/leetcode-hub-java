import java.util.PriorityQueue;
import java.util.TreeSet;

public class Solution3510 {
    // 两个有序集合 1264ms
    static class V1 {
        record Pair(long s, int i) { // 相邻元素和，左边那个数的下标
        }

        public int minimumPairRemoval(int[] nums) {
            int n = nums.length;
            TreeSet<Pair> pairs = new TreeSet<>((a, b) -> a.s != b.s ? Long.compare(a.s, b.s) : a.i - b.i);
            int dec = 0; // 递减的相邻对的个数
            for (int i = 0; i < n - 1; i++) {
                int x = nums[i];
                int y = nums[i + 1];
                if (x > y) {
                    dec++;
                }
                pairs.add(new Pair(x + y, i));
            }

            // 剩余下标
            TreeSet<Integer> idx = new TreeSet<>();
            for (int i = 0; i < n; i++) {
                idx.add(i);
            }

            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = nums[i];
            }

            int ans = 0;
            while (dec > 0) {
                ans++;

                // 删除相邻元素和最小的一对
                Pair p = pairs.pollFirst();
                long s = p.s;
                int i = p.i;

                // (当前元素，下一个数)
                Integer nxt = idx.higher(i);
                if (a[i] > a[nxt]) { // 旧数据
                    dec--;
                }

                // (前一个数，当前元素)
                Integer pre = idx.lower(i);
                if (pre != null) {
                    if (a[pre] > a[i]) { // 旧数据
                        dec--;
                    }
                    if (a[pre] > s) { // 新数据
                        dec++;
                    }
                    pairs.remove(new Pair(a[pre] + a[i], pre));
                    pairs.add(new Pair(a[pre] + s, pre));
                }

                // (下一个数，下下一个数)
                Integer nxt2 = idx.higher(nxt);
                if (nxt2 != null) {
                    if (a[nxt] > a[nxt2]) { // 旧数据
                        dec--;
                    }
                    if (s > a[nxt2]) { // 新数据（当前元素，下下一个数）
                        dec++;
                    }
                    pairs.remove(new Pair(a[nxt] + a[nxt2], nxt));
                    pairs.add(new Pair(s + a[nxt2], i));
                }

                a[i] = s; // 把 a[nxt] 加到 a[i] 中
                idx.remove(nxt); // 删除 nxt
            }
            return ans;
        }
    }

    // 懒删除堆+数组模拟双向链表 710ms
    static class V2 {
        private record Pair(long s, int i) {
        }

        public int minimumPairRemoval(int[] nums) {
            int n = nums.length;
            // (相邻元素和，左边那个数的下标)
            PriorityQueue<Pair> h = new PriorityQueue<>((a, b) -> a.s != b.s ? Long.compare(a.s, b.s) : a.i - b.i);
            int dec = 0; // 递减的相邻对的个数
            for (int i = 0; i < n - 1; i++) {
                int x = nums[i];
                int y = nums[i + 1];
                if (x > y) {
                    dec++;
                }
                h.offer(new Pair(x + y, i));
            }

            // 每个下标的左右最近的未删除下标
            int[] left = new int[n + 1];
            int[] right = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                left[i] = i - 1;
                right[i] = i + 1;
            }

            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = nums[i];
            }

            int ans = 0;
            while (dec > 0) {
                ans++;

                // 如果堆顶数据与实际数据不符，说明堆顶数据是之前本应删除，但没有删除的数据（懒删除）
                while (right[h.peek().i] >= n || h.peek().s != a[h.peek().i] + a[right[h.peek().i]]) {
                    h.poll();
                }

                // 删除相邻元素和最小的一对
                Pair p = h.poll();
                long s = p.s;
                int i = p.i;

                // (当前元素，下一个数)
                int nxt = right[i];
                if (a[i] > a[nxt]) { // 旧数据
                    dec--;
                }

                // (前一个数，当前元素)
                int pre = left[i];
                if (pre >= 0) {
                    if (a[pre] > a[i]) { // 旧数据
                        dec--;
                    }
                    if (a[pre] > s) { // 新数据
                        dec++;
                    }
                    h.offer(new Pair(a[pre] + s, pre));
                }

                // (下一个数，下下一个数)
                int nxt2 = right[nxt];
                if (nxt2 < n) {
                    if (a[nxt] > a[nxt2]) { // 旧数据
                        dec--;
                    }
                    if (s > a[nxt2]) { // 新数据（当前元素，下下一个数）
                        dec++;
                    }
                    h.add(new Pair(s + a[nxt2], i));
                }

                a[i] = s; // 把 a[nxt] 加到 a[i] 中
                // 删除 nxt
                int l = left[nxt];
                int r = right[nxt];
                right[l] = r; // 模拟双向链表的删除操作
                left[r] = l;
                right[nxt] = n; // 表示删除 nxt
            }
            return ans;
        }
    }
}
/*
3510. 移除最小数对使数组有序 II
https://leetcode.cn/problems/minimum-pair-removal-to-sort-array-ii/description/

第 444 场周赛 T4。

给你一个数组 nums，你可以执行以下操作任意次数：
- 选择 相邻 元素对中 和最小 的一对。如果存在多个这样的对，选择最左边的一个。
- 用它们的和替换这对元素。
返回将数组变为 非递减 所需的 最小操作次数 。
如果一个数组中每个元素都大于或等于它前一个元素（如果存在的话），则称该数组为非递减。
提示：
1 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9

两种方法：两个有序集合 / 懒删除堆+数组模拟双向链表
https://leetcode.cn/problems/minimum-pair-removal-to-sort-array-ii/solutions/3641787/mo-ni-liang-ge-you-xu-ji-he-by-endlessch-gx8s/
rating 2587 (clist.by)
 */