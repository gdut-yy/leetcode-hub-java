import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Jianxin003 {
    public int[] metroRouteDesignI(int[][] lines, int start, int end) {
        // @see Solution815
        Map<Integer, List<Integer>> stopRoutesMap = buildStopRoutesMap(lines);

        // BFS
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start, List.of(start)));
        boolean found = false;
        List<List<Integer>> resList = new ArrayList<>();
        while (!found && !queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node cur = queue.remove();
                int stop = cur.stop;
                List<Integer> memoList = cur.memoList;
                // 当前车站的线路集合
                List<Integer> routesList = stopRoutesMap.get(stop);
                for (int route : routesList) {
                    int[] stops = lines[route];
                    int idx = getIdx(stops, stop);
                    // 向左走
                    List<Integer> tmpList = new ArrayList<>();
                    for (int j = idx - 1; j >= 0; j--) {
                        tmpList.add(stops[j]);
                        if (stops[j] == end || stopRoutesMap.get(stops[j]).size() > 1) {
                            List<Integer> nextList = new ArrayList<>(memoList);
                            nextList.addAll(tmpList);
                            if (stops[j] == end) {
                                resList.add(nextList);
                                found = true;
                                break;
                            } else {
                                // 添加当前线路的 "换乘站"
                                queue.add(new Node(stops[j], nextList));
                            }
                        }
                    }
                    // 向右走
                    tmpList.clear();
                    for (int j = idx + 1; j < stops.length; j++) {
                        tmpList.add(stops[j]);
                        if (stops[j] == end || stopRoutesMap.get(stops[j]).size() > 1) {
                            List<Integer> nextList = new ArrayList<>(memoList);
                            nextList.addAll(tmpList);
                            if (stops[j] == end) {
                                resList.add(nextList);
                                found = true;
                                break;
                            } else {
                                // 添加当前线路的 "换乘站"
                                queue.add(new Node(stops[j], nextList));
                            }
                        }
                    }
                }
            }
        }

        // 要求路线上无重复的站点
        List<List<Integer>> resList2 = new ArrayList<>();
        for (List<Integer> res : resList) {
            if (res.size() == new HashSet<>(res).size()) {
                resList2.add(res);
            }
        }

        // 返回字典序最小的路线
        resList2.sort((o1, o2) -> {
            int size = Math.min(o1.size(), o2.size());
            for (int i = 0; i < size; i++) {
                if (!o1.get(i).equals(o2.get(i))) {
                    return o1.get(i).compareTo(o2.get(i));
                }
            }
            return o1.size() - o2.size();
        });
        return resList2.get(0).stream().mapToInt(i -> i).toArray();
    }

    private int getIdx(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

    private Map<Integer, List<Integer>> buildStopRoutesMap(int[][] routes) {
        Map<Integer, List<Integer>> stopRoutesMap = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            int[] route = routes[i];
            for (int key : route) {
                List<Integer> list = stopRoutesMap.getOrDefault(key, new ArrayList<>());
                list.add(i);
                stopRoutesMap.put(key, list);
            }
        }
        return stopRoutesMap;
    }

    private static class Node {
        int stop;
        List<Integer> memoList;

        public Node(int stop, List<Integer> memoList) {
            this.stop = stop;
            this.memoList = memoList;
        }
    }
}
/*
建信03. 地铁路线规划
https://leetcode-cn.com/contest/ccbft-2021fall/problems/zQTFs4/

某城市有若干条地铁线路，lines 记录了每条地铁线路依次停靠的站点（每条线路均是双向的）
李林想从站点 start 出发前往 end，请规划一条可行路线使得他可以以最小的换乘次数到达目的站点。
若有多条路线满足要求，请返回字典序最小的路线（要求路线上无重复的站点）。

注意：
输入数据保证存在 start 到 end 的路线
任意路线上的点在该条路线上仅出现一次（即任意一条路线均不是环线）

示例 1：
输入：lines = [[1,2,3,4,5],[2,10,14,15,16],[10,8,12,13],[7,8,4,9,11]], start = 1, end = 7
输出：[1,2,3,4,8,7]

示例 2：
输入：lines = [[1,2,3,4,5,6,7,8,9,10,11],[12,13,2,14,8,15],[16,1,17,10,18]], start = 9, end = 1
输出：[9,8,7,6,5,4,3,2,1]

提示：
1 <= lines.length, lines[i].length <= 100
1 <= lines[i][j], start, end <= 10000
 */