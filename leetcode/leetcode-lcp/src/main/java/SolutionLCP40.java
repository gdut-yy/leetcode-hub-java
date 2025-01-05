import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SolutionLCP40 {
    public int maximumScore(int[] cards, int cnt) {
        // 优先队列（大顶堆）奇数偶数分组，降序排列
        PriorityQueue<Integer> oddMaxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> evenMaxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int card : cards) {
            if (card % 2 == 1) {
                oddMaxHeap.add(card);
            } else {
                evenMaxHeap.add(card);
            }
        }
        int cardsLen = cards.length;
        // 奇数偶数个数
        int oddCnt = oddMaxHeap.size();
        int evenCnt = cardsLen - oddCnt;

        // 无解有两种情况
        // 1. cnt 为奇数，cards 中没有一个偶数
        // 2. cnt 等于卡片总数，cards 中奇数个数是奇数
        if ((cnt % 2 == 1 && evenCnt == 0) || (cnt == cardsLen && oddCnt % 2 == 1)) {
            return 0;
        }

        // 有解的场景，也有两种情况
        // 1. cnt 为奇数，偶数对奇数 + 至少一个偶数（必定包含最大的偶数）
        // 2. cnt 为偶数，偶数对奇数 + 偶数对偶数
        // 奇数偶数对
        int oddPairCnt = oddCnt / 2;
        int evenPairCnt = (cnt % 2 == 1) ? (evenCnt - 1) / 2 : evenCnt / 2;
        // 如果 cnt 为奇数，必定包含最大的偶数
        int maxEven = (cnt % 2 == 1) ? evenMaxHeap.remove() : 0;

        // 优先队列（大顶堆）奇数偶数对
        PriorityQueue<Integer> pairMaxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        while (oddPairCnt > 0) {
            pairMaxHeap.add(oddMaxHeap.remove() + oddMaxHeap.remove());
            oddPairCnt--;
        }
        while (evenPairCnt > 0) {
            pairMaxHeap.add(evenMaxHeap.remove() + evenMaxHeap.remove());
            evenPairCnt--;
        }

        // 总对数
        int totalPair = cnt / 2;
        int res = 0;
        while (totalPair > 0) {
            res += pairMaxHeap.remove();
            totalPair--;
        }
        res += maxEven;
        return res;
    }

    public int maximumScore2(int[] cards, int cnt) {
        reverseSort(cards);
        int sum = 0;
        for (int i = 0; i < cnt; i++) {
            sum += cards[i];
        }
        if (sum % 2 == 0) return sum;

        int l_min_odd = Integer.MAX_VALUE, l_min_even = Integer.MAX_VALUE;
        int r_max_odd = -1, r_max_even = -1;
        for (int i = 0; i < cnt; i++) {
            if (cards[i] % 2 == 0) {
                l_min_even = Math.min(l_min_even, cards[i]);
            } else {
                l_min_odd = Math.min(l_min_odd, cards[i]);
            }
        }
        for (int i = cnt; i < cards.length; i++) {
            if (cards[i] % 2 == 0) {
                r_max_even = Math.max(r_max_even, cards[i]);
            } else {
                r_max_odd = Math.max(r_max_odd, cards[i]);
            }
        }

        int ans = 0;
        // 从前 cnt 个数中去掉一个最小的奇数，从后 n−cnt 个数中加进来一个最大的偶数
        if (l_min_odd != Integer.MAX_VALUE && r_max_even != -1) {
            ans = sum - l_min_odd + r_max_even;
        }
        // 从前 cnt 个数中去掉一个最小的偶数，从后 n−cnt 个数中加进来一个最大的奇数
        if (l_min_even != Integer.MAX_VALUE && r_max_odd != -1) {
            ans = Math.max(ans, sum - l_min_even + r_max_odd);
        }
        return ans;
    }

    private void reverseSort(int[] a) {
        Arrays.sort(a);
        for (int l = 0, r = a.length - 1; l < r; l++, r--) {
            int tmp = a[l];
            a[l] = a[r];
            a[r] = tmp;
        }
    }
}
/*
LCP 40. 心算挑战
https://leetcode.cn/problems/uOAnQW/

LCCUP 力扣杯 2021 秋季编程大赛个人赛 T2。

「力扣挑战赛」心算项目的挑战比赛中，要求选手从 N 张卡牌中选出 cnt 张卡牌，若这 cnt 张卡牌数字总和为偶数，则选手成绩「有效」且得分为 cnt 张卡牌数字总和。
给定数组 cards 和 cnt，其中 cards[i] 表示第 i 张卡牌上的数字。 请帮参赛选手计算最大的有效得分。若不存在获取有效得分的卡牌方案，则返回 0。
提示：
1 <= cnt <= cards.length <= 10^5
1 <= cards[i] <= 1000

找数学规律。
时间复杂度 O(nlogn) 即排序时间复杂度
 */