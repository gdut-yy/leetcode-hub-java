package shopee;

import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Shopee003 {
    static Scanner scanner;
    static PrintWriter out;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        out = new PrintWriter(System.out);
        int t = 1;
        // t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        int warehouse = scanner.nextInt();
        int m = scanner.nextInt();

        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            adjMap.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            adjMap.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        List<Store> stores = new ArrayList<>();
        for (int i = 0; i < warehouse; i++) {
            int remain = scanner.nextInt();
            int fee = scanner.nextInt();
            int pos = scanner.nextInt();
            stores.add(new Store(pos, remain, fee));
        }

        int orderCount = scanner.nextInt();
        Map<Integer, Integer> needs = new HashMap<>();
        for (int i = 0; i < orderCount; i++) {
            int need = scanner.nextInt();
            int pos = scanner.nextInt();
            needs.merge(pos, need, Integer::sum);
        }

        Map<Integer, Map<Integer, Integer>> distAll = new HashMap<>();
        for (Store s : stores) {
            if (!distAll.containsKey(s.pos)) {
                distAll.put(s.pos, bfs(s.pos, adjMap));
            }
        }

        final int START = -1, END = -2, OFFSET = 10000;
        MinCostMaxFlow mcmf = new MinCostMaxFlow(START, END);

        for (Store s : stores) {
            mcmf.addEdge(START, s.pos, s.remain, 0);
        }

        for (Map.Entry<Integer, Integer> e : needs.entrySet()) {
            mcmf.addEdge(e.getKey() + OFFSET, END, e.getValue(), 0);
        }

        for (Store s : stores) {
            Map<Integer, Integer> dist = distAll.get(s.pos);
            for (Map.Entry<Integer, Integer> e : needs.entrySet()) {
                int city = e.getKey();
                Integer d = dist.get(city);
                if (d != null) {
                    mcmf.addEdge(s.pos, city + OFFSET, s.remain, (long) d * s.fee);
                }
            }
        }

        long[] result = mcmf.work();
        out.println(result[1]);
    }

    private static Map<Integer, Integer> bfs(int start, Map<Integer, List<Integer>> adjMap) {
        Map<Integer, Integer> dist = new HashMap<>();
        Deque<Integer> queue = new ArrayDeque<>();
        dist.put(start, 0);
        queue.add(start);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int step = dist.get(cur);
            List<Integer> neighbors = adjMap.get(cur);
            if (neighbors == null) continue;

            for (int next : neighbors) {
                if (!dist.containsKey(next)) {
                    dist.put(next, step + 1);
                    queue.add(next);
                }
            }
        }
        return dist;
    }

    static class Store {
        int pos, remain, fee;

        Store(int pos, int remain, int fee) {
            this.pos = pos;
            this.remain = remain;
            this.fee = fee;
        }
    }

    static class Edge {
        int from, to, cap, flow;
        long cost;

        Edge(int from, int to, int cap, long cost, int flow) {
            this.from = from;
            this.to = to;
            this.cap = cap;
            this.cost = cost;
            this.flow = flow;
        }
    }

    static class MinCostMaxFlow {
        int start, end;
        List<Edge> edges = new ArrayList<>();
        Map<Integer, List<Integer>> reGraph = new HashMap<>();
        Map<Integer, Long> dist;

        static final long INF = Long.MAX_VALUE / 4;
        static final int INF_FLOW = Integer.MAX_VALUE / 2;

        MinCostMaxFlow(int start, int end) {
            this.start = start;
            this.end = end;
        }

        void addEdge(int from, int to, int cap, long cost) {
            edges.add(new Edge(from, to, cap, cost, 0));
            edges.add(new Edge(to, from, 0, -cost, 0));

            int len = edges.size();
            reGraph.computeIfAbsent(from, k -> new ArrayList<>()).add(len - 2);
            reGraph.computeIfAbsent(to, k -> new ArrayList<>()).add(len - 1);
        }

        long[] work() {
            int flow = 0;
            long cost = 0;

            while (true) {
                int delta = spfa();
                if (delta == 0) break;

                flow += delta;
                cost += (long) delta * dist.get(end);
            }

            return new long[]{flow, cost};
        }

        int spfa() {
            dist = new HashMap<>();
            Map<Integer, Boolean> inQueue = new HashMap<>();
            Map<Integer, Integer> pre = new HashMap<>();
            Map<Integer, Integer> inFlow = new HashMap<>();

            dist.put(start, 0L);
            inQueue.put(start, true);
            inFlow.put(start, INF_FLOW);

            Deque<Integer> queue = new ArrayDeque<>();
            queue.add(start);

            while (!queue.isEmpty()) {
                int cur = queue.poll();
                inQueue.put(cur, false);

                List<Integer> edgeIndices = reGraph.get(cur);
                if (edgeIndices == null) continue;

                for (int edgeIndex : edgeIndices) {
                    Edge edge = edges.get(edgeIndex);

                    if (edge.cap - edge.flow > 0) {
                        long nd = dist.get(cur) + edge.cost;

                        if (nd < dist.getOrDefault(edge.to, INF)) {
                            dist.put(edge.to, nd);
                            pre.put(edge.to, edgeIndex);

                            int curFlow = inFlow.getOrDefault(cur, INF_FLOW);
                            inFlow.put(edge.to, Math.min(curFlow, edge.cap - edge.flow));

                            if (!inQueue.getOrDefault(edge.to, false)) {
                                inQueue.put(edge.to, true);
                                queue.add(edge.to);
                            }
                        }
                    }
                }
            }

            int delta = inFlow.getOrDefault(end, 0);
            if (delta > 0) {
                int cur = end;
                while (cur != start) {
                    int preEdgeIndex = pre.get(cur);
                    Edge e = edges.get(preEdgeIndex);

                    e.flow += delta;
                    edges.get(preEdgeIndex ^ 1).flow -= delta;

                    cur = e.from;
                }
            }

            return delta;
        }
    }
}
/*
Shopee-003. Order Delivery
https://leetcode.cn/problems/0pXm7y/

In the parallel universe, where there are 13 months, Shopee has a 13.13 campaign. During this 13.13 campaign, Shopee gives free shipping delivery vouchers to all users who buy item X. Shopee has N warehouses to store the item X, and each warehouse has Wi number of item X. Each warehouse is located in a city and all cities have at most one warehouse. To serve the customers, each warehouse has their own courier delivery. The cost of the delivery in warehouse i is Ci dollar per kilometer. Interestingly, in this parallel universe, the distance between neighboring cities is exactly one kilometer. The cities can be represented as a graph, where a node represents the city and the edge represents the road between cities and all the cities are connected. Warehouse i is located at city Pi.

During the 13.13 campaign, people are very excited to buy this item X because of the free shipping discounts. As a result, there are M orders created, each order contains Ki number of item X, and it needs to be delivered to city Gi. To serve all the customers, multiple warehouses can be used to serve a single order. So, one order can be served by multiple warehouses.

Because of the free shipping discounts, Shopee needs to pay the delivery fee of all the orders. Your task is to help Shopee to minimize the delivery fee in this 13.13 campaign.

Input Format
The first line contains three integers N, D, and E (1 <= N <= 20, 1 <= D <= N, N-1 <= E <= 200) representing the number of cities, warehouses, and roads in this parallel universe. The next E lines contain 2 integers Xi and Yi (1 <= Xi,Yi <= N, Xi != Yi) which indicates that there is a road between city Xi and Yi. The next D line contains 3 integers Wi, Ci, and Pi (1 <= Wi <= 10^9, 1 <= Ci <= 10^6, 1 <= Pi <= N) which represents the number of item X in warehouse i and the delivery fee of warehouse i per kilometer and the location of warehouse i. The next line contains an integer M (1 <= M <= 100000) which represents the number of orders. Each of the next M lines contain two integers Ki and Gi (1 <= Ki <= 10^9, 1 <= Gi <= N, sum of all Ki <= 10^9) which represent the number of item X ordered in order-i and the city of order i.

Output Format
Output a single integer contains the total delivery cost of all orders. It is guaranteed that Shopee can serve all the orders.

Sample Input
8 3 11
1 2
1 3
2 3
3 4
4 5
5 6
5 7
5 8
4 6
3 7
7 8
12 5 1
11 10 6
1 6 7
3
3 4
4 4
7 5

Sample Output
136
 */