import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3913 {
    record pair(char ch, int cnt, int pos) {
    }

    public String sortVowels(String S) {
        char[] s = S.toCharArray();
        int n = s.length;
        int[] cnt = new int[26];
        int[] first = new int[26];
        Arrays.fill(first, -1);

        List<Integer> posList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int b = s[i] - 'a';
            cnt[b]++;
            if (first[b] == -1) first[b] = i;
            if (isVowel(s[i])) {
                posList.add(i);
            }
        }

        pair[] pairs = new pair[5];
        pairs[0] = new pair('a', cnt['a' - 'a'], first['a' - 'a']);
        pairs[1] = new pair('e', cnt['e' - 'a'], first['e' - 'a']);
        pairs[2] = new pair('i', cnt['i' - 'a'], first['i' - 'a']);
        pairs[3] = new pair('o', cnt['o' - 'a'], first['o' - 'a']);
        pairs[4] = new pair('u', cnt['u' - 'a'], first['u' - 'a']);
        Arrays.sort(pairs, (o1, o2) -> {
            if (o1.cnt == o2.cnt) return Integer.compare(o1.pos, o2.pos);
            return Integer.compare(o2.cnt, o1.cnt);
        });
        int j = 0;
        for (pair pair : pairs) {
            for (int i = 0; i < pair.cnt; i++) {
                Integer id = posList.get(j++);
                s[id] = pair.ch;
            }
        }
        return new String(s);
    }

    private boolean isVowel(char ch) {
        return "aeiou".indexOf(ch) >= 0;
    }
}
/*
3913. 按频率对元音排序
https://leetcode.cn/problems/sort-vowels-by-frequency/description/

第 499 场周赛 T2。

给你一个由小写英文字母组成的字符串 s。
仅重新排列字符串中的 元音字母，使它们按照出现频率的 非递增 顺序排列。
如果多个元音字母的 出现频率 相同，则按照它们在 s 中 首次出现 的位置排序。
返回修改后的字符串。
元音字母为 'a'、'e'、'i'、'o' 和 'u'。
字母的 出现频率 是指它在字符串中出现的次数。
提示：
1 <= s.length <= 10^5
s 由小写英文字母组成

模拟 + 自定义排序。
时间复杂度 O(n + 5log5)。
 */