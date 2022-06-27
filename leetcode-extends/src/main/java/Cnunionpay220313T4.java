import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Cnunionpay220313T4 {
    public int coopDevelop(int[][] skills) {
        int n = skills.length;

        // 总数 - 不满足合作开发的成员对数
        long total = (long) n * (n - 1) / 2;

        // 为了保证后面遍历到的 skill 是前面某个 skill 的子集
        Arrays.sort(skills, (o1, o2) -> Integer.compare(o2.length, o1.length));

        Map<String, Integer> cntMap = new HashMap<>();
        for (int[] skill : skills) {
            Arrays.sort(skill);

            total -= cntMap.getOrDefault(arr2String(skill), 0);

            int len = skill.length;
            for (int state = 1; state < (1 << len); state++) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int k = 0; k < len; k++) {
                    // 第 k 位被选中
                    if (((state >> k) & 1) == 1) {
                        stringBuilder.append(skill[k]).append(",");
                    }
                }
                String sub = stringBuilder.toString();
                cntMap.put(sub, cntMap.getOrDefault(sub, 0) + 1);
            }
        }
        return (int) (total % 1000000007);
    }

    private String arr2String(int[] skill) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int sk : skill) {
            stringBuilder.append(sk).append(",");
        }
        return stringBuilder.toString();
    }

    // 时间复杂度 O(n^2) TLE
    public int coopDevelop2(int[][] skills) {
        int len = skills.length;
        long cnt = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (check(skills[i], skills[j])) {
                    cnt++;
                }
            }
        }
        return (int) (cnt % 1000000007);
    }

    private boolean check(int[] skill1, int[] skill2) {
        Set<Integer> hashSet = new HashSet<>();
        for (int i : skill1) {
            hashSet.add(i);
        }
        for (int i : skill2) {
            hashSet.add(i);
        }
        return hashSet.size() > skill1.length && hashSet.size() > skill2.length;
    }
}
/*
银联-04. 合作开发
https://leetcode.cn/contest/cnunionpay-2022spring/problems/lCh58I/

为了不断提高用户使用的体验，开发团队正在对产品进行全方位的开发和优化。
已知开发团队共有若干名成员，skills[i] 表示第 i 名开发人员掌握技能列表。如果两名成员各自拥有至少一门对方未拥有的技能，则这两名成员可以「合作开发」。
请返回当前有多少对开发成员满足「合作开发」的条件。由于答案可能很大，请你返回答案对 10^9 + 7 取余的结果。
注意：
- 对于任意 skills[i] 均升序排列。
提示：
2 <= skills.length <= 10^5
1 <= skills[i].length <= 4
1 <= skills[i][j] <= 1000
skills[i] 中不包含重复元素

总数 - 不满足合作开发的成员对数
参考: 【灵茶山艾府】3/13 中国银联专场竞赛 题解 https://leetcode.cn/circle/discuss/YfxFdF/
 */