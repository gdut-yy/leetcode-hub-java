import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class Solution1912 {
    static class MovieRentingSystem {
        Map<ShopMovie, Integer> tPrice; // 存储(shop, movie) -> price的映射
        Map<Integer, TreeSet<MovieEntry>> tValid; // 存储movie -> 有序的(price, shop)集合
        TreeSet<RentEntry> tRent; // 存储已租借的有序(price, shop, movie)集合

        record ShopMovie(int shop, int movie) {
        }

        record MovieEntry(int price, int shop) {
            static Comparator<MovieEntry> comparator = (o1, o2) -> {
                if (o1.price != o2.price) return Integer.compare(o1.price, o2.price);
                return Integer.compare(o1.shop, o2.shop);
            };
        }

        record RentEntry(int price, int shop, int movie) {
            static Comparator<RentEntry> comparator = (o1, o2) -> {
                if (o1.price != o2.price) return Integer.compare(o1.price, o2.price);
                if (o1.shop != o2.shop) return Integer.compare(o1.shop, o2.shop);
                return Integer.compare(o1.movie, o2.movie);
            };
        }

        public MovieRentingSystem(int n, int[][] entries) {
            tPrice = new HashMap<>();
            tValid = new HashMap<>();
            tRent = new TreeSet<>(RentEntry.comparator);
            for (int[] en : entries) {
                int shop = en[0], movie = en[1], price = en[2];
                tPrice.put(new ShopMovie(shop, movie), price);
                tValid.computeIfAbsent(movie, e -> new TreeSet<>(MovieEntry.comparator)).add(new MovieEntry(price, shop));
            }
        }

        public List<Integer> search(int movie) {
            TreeSet<MovieEntry> set = tValid.get(movie);
            if (set == null) return new ArrayList<>();
            return set.stream().limit(5).map(entry -> entry.shop).toList();
        }

        public void rent(int shop, int movie) {
            int price = tPrice.get(new ShopMovie(shop, movie));
            tValid.get(movie).remove(new MovieEntry(price, shop));
            tRent.add(new RentEntry(price, shop, movie));
        }

        public void drop(int shop, int movie) {
            int price = tPrice.get(new ShopMovie(shop, movie));
            tRent.remove(new RentEntry(price, shop, movie));
            tValid.get(movie).add(new MovieEntry(price, shop));
        }

        public List<List<Integer>> report() {
            return tRent.stream().limit(5).map(entry -> Arrays.asList(entry.shop, entry.movie)).toList();
        }
    }
}
/*
1912. 设计电影租借系统
https://leetcode.cn/problems/design-movie-rental-system/description/

你有一个电影租借公司和 n 个电影商店。你想要实现一个电影租借系统，它支持查询、预订和返还电影的操作。同时系统还能生成一份当前被借出电影的报告。
所有电影用二维整数数组 entries 表示，其中 entries[i] = [shopi, moviei, pricei] 表示商店 shopi 有一份电影 moviei 的拷贝，租借价格为 pricei 。每个商店有 至多一份 编号为 moviei 的电影拷贝。
系统需要支持以下操作：
- Search：找到拥有指定电影且 未借出 的商店中 最便宜的 5 个 。商店需要按照 价格 升序排序，如果价格相同，则 shopi 较小 的商店排在前面。如果查询结果少于 5 个商店，则将它们全部返回。如果查询结果没有任何商店，则返回空列表。
- Rent：从指定商店借出指定电影，题目保证指定电影在指定商店 未借出 。
- Drop：在指定商店返还 之前已借出 的指定电影。
- Report：返回 最便宜的 5 部已借出电影 （可能有重复的电影 ID），将结果用二维列表 res 返回，其中 res[j] = [shopj, moviej] 表示第 j 便宜的已借出电影是从商店 shopj 借出的电影 moviej 。res 中的电影需要按 价格 升序排序；如果价格相同，则 shopj 较小 的排在前面；如果仍然相同，则 moviej 较小 的排在前面。如果当前借出的电影小于 5 部，则将它们全部返回。如果当前没有借出电影，则返回一个空的列表。
请你实现 MovieRentingSystem 类：
- MovieRentingSystem(int n, int[][] entries) 将 MovieRentingSystem 对象用 n 个商店和 entries 表示的电影列表初始化。
- List<Integer> search(int movie) 如上所述，返回 未借出 指定 movie 的商店列表。
- void rent(int shop, int movie) 从指定商店 shop 借出指定电影 movie 。
- void drop(int shop, int movie) 在指定商店 shop 返还之前借出的电影 movie 。
- List<List<Integer>> report() 如上所述，返回最便宜的 已借出 电影列表。
注意：测试数据保证 rent 操作中指定商店拥有 未借出 的指定电影，且 drop 操作指定的商店 之前已借出 指定电影。
提示：
1 <= n <= 3 * 10^5
1 <= entries.length <= 10^5
0 <= shopi < n
1 <= moviei, pricei <= 10^4
每个商店 至多 有一份电影 moviei 的拷贝。
search，rent，drop 和 report 的调用 总共 不超过 10^5 次。

哈希表模拟 + 平衡树
 */