import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution2115 {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, Set<String>> outGraph = new HashMap<>();
        Map<String, Set<String>> inGraph = new HashMap<>();
        // n == recipes.length == ingredients.length
        int n = recipes.length;
        for (int i = 0; i < n; i++) {
            List<String> froms = ingredients.get(i);
            String to = recipes[i];

            for (String from : froms) {
                Set<String> outSet = outGraph.getOrDefault(from, new HashSet<>());
                outSet.add(to);
                outGraph.put(from, outSet);
            }

            Set<String> inSet = inGraph.getOrDefault(to, new HashSet<>());
            inSet.addAll(froms);
            inGraph.put(to, inSet);
        }

        // 拓扑排序
        // 原材料 进队列
        Queue<String> queue = new LinkedList<>(Arrays.asList(supplies));
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.remove();
                for (String next : outGraph.getOrDefault(cur, new HashSet<>())) {
                    inGraph.get(next).remove(cur);
                    if (inGraph.get(next).size() == 0) {
                        queue.add(next);
                    }
                }
            }
        }

        // 入度为 0 的菜才能做出来
        List<String> resList = new ArrayList<>();
        for (String recipe : recipes) {
            if (inGraph.getOrDefault(recipe, new HashSet<>()).size() == 0) {
                resList.add(recipe);
            }
        }
        return resList;
    }
}
/*
2115. 从给定原材料中找到所有可以做出的菜
https://leetcode.cn/problems/find-all-possible-recipes-from-given-supplies/

第 68 场双周赛 T2。

你有 n 道不同菜的信息。给你一个字符串数组 recipes 和一个二维字符串数组 ingredients 。第 i 道菜的名字为 recipes[i] ，
如果你有它 所有 的原材料 ingredients[i] ，那么你可以 做出 这道菜。一道菜的原材料可能是 另一道 菜，也就是说 ingredients[i] 可能包含 recipes 中另一个字符串。
同时给你一个字符串数组 supplies ，它包含你初始时拥有的所有原材料，每一种原材料你都有无限多。
请你返回你可以做出的所有菜。你可以以 任意顺序 返回它们。
注意两道菜在它们的原材料中可能互相包含。

拓扑排序。入度为 0 的菜才能做出来。
 */