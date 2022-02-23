import java.util.PriorityQueue;

public class Solution2182 {
    public String repeatLimitedString(String s, int repeatLimit) {
        // 统计频次
        int[] cntArr = new int[26];
        for (char ch : s.toCharArray()) {
            cntArr[ch - 'a']++;
        }

        // 贪心，按字典序降序
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>((o1, o2) -> Character.compare(o2.ch, o1.ch));
        for (int i = 0; i < 26; i++) {
            if (cntArr[i] > 0) {
                char ch = (char) (i + 'a');
                String str = String.valueOf(ch);
                priorityQueue.add(new Node(ch, str, cntArr[i]));
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!priorityQueue.isEmpty()) {
            Node top1 = priorityQueue.remove();
            if (top1.cnt <= 0) {
                break;
            }
            char lastCh = stringBuilder.length() > 0 ? stringBuilder.charAt(stringBuilder.length() - 1) : '?';
            if (top1.ch != lastCh) {
                int maxLen = Math.min(top1.cnt, repeatLimit);
                top1.cnt -= maxLen;
                stringBuilder.append(top1.str.repeat(maxLen));
                if (top1.cnt > 0) {
                    priorityQueue.add(top1);
                }
            } else {
                Node top2 = priorityQueue.poll();
                if (top2 != null && top2.cnt > 0) {
                    stringBuilder.append(top2.str);
                    top2.cnt--;
                    priorityQueue.add(top1);
                    if (top2.cnt > 0) {
                        priorityQueue.add(top2);
                    }
                } else {
                    break;
                }
            }
        }
        return stringBuilder.toString();
    }

    private static class Node {
        char ch;
        String str;
        int cnt;

        public Node(char ch, String str, int cnt) {
            this.ch = ch;
            this.str = str;
            this.cnt = cnt;
        }
    }
}
/*
2182. 构造限制重复的字符串
https://leetcode-cn.com/problems/construct-string-with-repeat-limit/

第 281 场周赛 T3。

给你一个字符串 s 和一个整数 repeatLimit ，用 s 中的字符构造一个新字符串 repeatLimitedString ，
使任何字母 连续 出现的次数都不超过 repeatLimit 次。你不必使用 s 中的全部字符。
返回 字典序最大的 repeatLimitedString 。
如果在字符串 a 和 b 不同的第一个位置，字符串 a 中的字母在字母表中出现时间比字符串 b 对应的字母晚，则认为字符串 a 比字符串 b 字典序更大 。
如果字符串中前 min(a.length, b.length) 个字符都相同，那么较长的字符串字典序更大。
提示：
1 <= repeatLimit <= s.length <= 10^5
s 由小写英文字母组成

优先队列。比赛时因 int maxLen = Math.min(top1.cnt, repeatLimit); 和 判断使用 toString().endsWith() 判断末位字符导致 3 发 TLE。
相似题目: 1405. 最长快乐字符串
https://leetcode-cn.com/problems/longest-happy-string/
 */