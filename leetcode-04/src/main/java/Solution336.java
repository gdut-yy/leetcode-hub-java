import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution336 {
    // 存储字符串哈希对应的下标，将某个字符串的哈希值和其下标进行映射
    Map<Long, Integer> map = new HashMap<>();
    // 用于去重的map(我变量取为了set，是因为功能来说更像set~)
    Map<Integer, Set<Integer>> set = new HashMap<>();
    // 用于计算哈希定义的质数，质数更容易防止哈希冲突
    long P = 13131;

    public List<List<Integer>> palindromePairs(String[] words) {
        // 将给定的字符串的hash存起来
        for (int i = 0; i < words.length; i++) {
            long hash = 0;
            for (char c : words[i].toCharArray()) {
                hash = hash * P + c;
            }
            map.put(hash, i);
        }


        List<List<Integer>> ans = new ArrayList<>();

        // 逐个遍历每个字符串
        for (int index = 0; index < words.length; index++) {
            String word = words[index];
            // 获得其反转，为什么要反转？前面已经提啦
            StringBuilder tmp = new StringBuilder(word);
            String re_word = tmp.reverse().toString();

            long hash = 0;
            /*这里是为了解决空字符串的出现，因为空字符串hash为0，如果不在这里判断，进入下面那个循环后，hash就不为0了，
                因此永远会忽略空字符串（我认为这段代码极其冗余，各位看看知道干啥了就好，我实在想睡觉不想优化了）*/
            if (map.containsKey(hash)) {
                int pos = map.get(hash);
                if (pos == index) continue;
                if (set.getOrDefault(pos, new HashSet<>()).contains(index)) continue;
                if (check(re_word)) {
                    List<Integer> t = new ArrayList<>();
                    /*注意index和pos的顺序，这点index我定义为当前遍历字符串下标，pos是与匹配的字符串下标，
                        至于为啥要注意顺序，相信大家画画图就能看出来了(s1+s2与s2+s1是不等价的)*/
                    t.add(pos);
                    t.add(index);
                    ans.add(t);
                    Set<Integer> tset = set.getOrDefault(pos, new HashSet<>());
                    tset.add(index);
                    set.put(pos, tset);
                }
            }
            // 开始找re_word的前缀，查询其是否出现过
            for (int i = 0; i < re_word.length(); i++) {
                hash = hash * P + re_word.charAt(i);
                if (map.containsKey(hash)) {
                    int pos = map.get(hash);
                    // 因为有可能出现自己匹配自己，所以这句if将该情况抹杀了
                    if (pos == index) continue;
                    // 对于[pos,index]这样的情况已经出现过啦~~,pass掉
                    if (set.getOrDefault(pos, new HashSet<>()).contains(index)) continue;
                    // 检查剩余部分是否是回文串
                    if (check(re_word.substring(i + 1, re_word.length()))) {
                        List<Integer> t = new ArrayList<>();
                        t.add(pos);
                        t.add(index);
                        ans.add(t);
                        Set<Integer> tset = set.getOrDefault(pos, new HashSet<>());
                        tset.add(index);
                        set.put(pos, tset);
                    }
                }
            }

            /*剩下的都一样了，开始找re_word的后缀，思路一样的。
                这里也是相当冗余，甚至可以和前面的循环合并，相信厉害的各位一定可以的！我就摆烂一会儿*/
            hash = 0;
            if (map.containsKey(hash)) {
                int pos = map.get(hash);
                if (pos == index) continue;
                if (set.getOrDefault(index, new HashSet<>()).contains(pos)) continue;
                if (check(re_word)) {
                    List<Integer> t = new ArrayList<>();
                    t.add(index);
                    t.add(pos);
                    ans.add(t);
                    Set<Integer> tset = set.getOrDefault(index, new HashSet<>());
                    tset.add(pos);
                    set.put(index, tset);
                }
            }
            long step = 1;
            for (int i = re_word.length() - 1; i >= 0; i--) {
                hash = re_word.charAt(i) * step + hash;
                step = step * P;
                if (map.containsKey(hash)) {
                    int pos = map.get(hash);
                    if (pos == index) continue;
                    if (set.getOrDefault(index, new HashSet<>()).contains(pos)) continue;
                    if (check(re_word.substring(0, i))) {
                        List<Integer> t = new ArrayList<>();
                        t.add(index);
                        t.add(pos);
                        ans.add(t);
                        Set<Integer> tset = set.getOrDefault(index, new HashSet<>());
                        tset.add(pos);
                        set.put(index, tset);
                    }
                }
            }
        }
        return ans;
    }

    boolean check(String s) {
        char[] sarr = s.toCharArray();
        int l = 0, r = sarr.length - 1;
        while (l <= r) {
            if (sarr[l] != sarr[r]) return false;
            l++;
            r--;
        }
        return true;
    }
}
/*
336. 回文对
https:// leetcode.cn/problems/palindrome-pairs/

给定一组 互不相同 的单词， 找出所有 不同 的索引对 (i, j)，使得列表中的两个单词， words[i] + words[j] ，可拼接成回文串。
提示：
1 <= words.length <= 5000
0 <= words[i].length <= 300
words[i] 由小写英文字母组成
 */