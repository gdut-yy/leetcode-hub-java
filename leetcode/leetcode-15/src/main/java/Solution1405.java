import java.util.PriorityQueue;

public class Solution1405 {
    public String longestDiverseString(int a, int b, int c) {
        // 根据数量降序排列
        PriorityQueue<Node> maxHeap = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.cnt, o1.cnt));
        maxHeap.add(new Node("a", a));
        maxHeap.add(new Node("b", b));
        maxHeap.add(new Node("c", c));

        StringBuilder stringBuilder = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            Node top1 = maxHeap.remove();
            if (top1.cnt <= 0) {
                break;
            }
            if (!stringBuilder.toString().endsWith(top1.ch + top1.ch)) {
                stringBuilder.append(top1.ch);
                top1.cnt--;
                maxHeap.add(top1);
            } else {
                Node top2 = maxHeap.remove();
                if (top2.cnt > 0) {
                    stringBuilder.append(top2.ch);
                    top2.cnt--;
                    maxHeap.add(top1);
                    maxHeap.add(top2);
                } else {
                    break;
                }
            }
        }
        return stringBuilder.toString();
    }

    private static class Node {
        String ch;
        int cnt;

        public Node(String ch, int cnt) {
            this.ch = ch;
            this.cnt = cnt;
        }
    }
}
/*
1405. 最长快乐字符串
https://leetcode.cn/problems/longest-happy-string/

如果字符串中不含有任何 'aaa'，'bbb' 或 'ccc' 这样的字符串作为子串，那么该字符串就是一个「快乐字符串」。
给你三个整数 a，b ，c，请你返回 任意一个 满足下列全部条件的字符串 s：
- s 是一个尽可能长的快乐字符串。
- s 中 最多 有a 个字母 'a'、b 个字母 'b'、c 个字母 'c' 。
- s 中只含有 'a'、'b' 、'c' 三种字母。
如果不存在这样的字符串 s ，请返回一个空字符串 ""。
提示：
0 <= a, b, c <= 100
a + b + c > 0

贪心。优先取个数多的字符，如果将要连成 3 个一样的，选择第二多的。
相似题目: $358. K 距离间隔重排字符串
https://leetcode.cn/problems/rearrange-string-k-distance-apart/
621. 任务调度器
https://leetcode.cn/problems/task-scheduler/
 */