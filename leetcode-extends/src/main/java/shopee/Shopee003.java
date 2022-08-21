package shopee;

public class Shopee003 {
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