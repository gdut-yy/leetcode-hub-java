import java.util.List;

public class Solution3433 {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        // 按照时间戳从小到大排序，时间戳相同的，离线事件排在前面
        events.sort((o1, o2) -> {
            int t1 = Integer.parseInt(o1.get(1));
            int t2 = Integer.parseInt(o2.get(1));
            if (t1 == t2) {
                int priority1 = getPriority(o1.get(0));
                int priority2 = getPriority(o2.get(0));
                return Integer.compare(priority1, priority2);
            }
            return Integer.compare(t1, t2);
        });

        int[] ans = new int[numberOfUsers];
        int[] onlineT = new int[numberOfUsers];
        for (List<String> e : events) {
            String msgType = e.get(0);
            int curT = Integer.parseInt(e.get(1));
            String mentions_string = e.get(2);
            if ("OFFLINE".equals(msgType)) {
                onlineT[Integer.parseInt(mentions_string)] = curT + 60;
                continue;
            }
            if ("ALL".equals(mentions_string)) {
                for (int i = 0; i < numberOfUsers; i++) {
                    ans[i]++;
                }
            } else if ("HERE".equals(mentions_string)) {
                for (int i = 0; i < numberOfUsers; i++) {
                    if (onlineT[i] <= curT) { // 在线
                        ans[i]++;
                    }
                }
            } else {
                for (String s : mentions_string.split(" ")) {
                    int i = Integer.parseInt(s.substring(2));
                    ans[i]++;
                }
            }
        }
        return ans;
    }

    private int getPriority(String msgType) {
        return "OFFLINE".equals(msgType) ? 0 : 1;
    }
}
/*
3433. 统计用户被提及情况
https://leetcode.cn/problems/count-mentions-per-user/description/

第 434 场周赛 T2。

给你一个整数 numberOfUsers 表示用户总数，另有一个大小为 n x 3 的数组 events 。
每个 events[i] 都属于下述两种类型之一：
1.消息事件（Message Event）：["MESSAGE", "timestampi", "mentions_stringi"]
  - 事件表示在 timestampi 时，一组用户被消息提及。
  - mentions_stringi 字符串包含下述标识符之一：
    - id<number>：其中 <number> 是一个区间 [0,numberOfUsers - 1] 内的整数。可以用单个空格分隔 多个 id ，并且 id 可能重复。此外，这种形式可以提及离线用户。
    - ALL：提及 所有 用户。
    - HERE：提及所有 在线 用户。
2.离线事件（Offline Event）：["OFFLINE", "timestampi", "idi"]
  - 事件表示用户 idi 在 timestampi 时变为离线状态 60 个单位时间。用户会在 timestampi + 60 时自动再次上线。
返回数组 mentions ，其中 mentions[i] 表示  id 为  i 的用户在所有 MESSAGE 事件中被提及的次数。
最初所有用户都处于在线状态，并且如果某个用户离线或者重新上线，其对应的状态变更将会在所有相同时间发生的消息事件之前进行处理和同步。
注意 在单条消息中，同一个用户可能会被提及多次。每次提及都需要被 分别 统计。
提示：
1 <= numberOfUsers <= 100
1 <= events.length <= 100
events[i].length == 3
events[i][0] 的值为 MESSAGE 或 OFFLINE 。
1 <= int(events[i][1]) <= 105
在任意 "MESSAGE" 事件中，以 id<number> 形式提及的用户数目介于 1 和 100 之间。
0 <= <number> <= numberOfUsers - 1
题目保证 OFFLINE 引用的用户 id 在事件发生时处于 在线 状态。

模拟。
 */