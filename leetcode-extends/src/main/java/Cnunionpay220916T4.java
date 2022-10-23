public class Cnunionpay220916T4 {
}
/*
银联-4. 设计自动售货机
https://leetcode.cn/contest/cnunionpay2022/problems/NyZD2B/

「银联二维码」支付可以提供简便、顺畅的消费服务，通过出示二维码或扫描二维码即可完成支付。
现有一台使用银联二维码进行支付的自动售货机，并对使用 银联 支付的用户提供额外的优惠服务。
同一名顾客每成功购买一次，下次购买便可多享受 1% 的折扣（折后价向上取整），最低折扣为 70%
- 即：第一次购买支付 100% 费用，第二次购买支付 99% 费用， 第三次购买支付 98% 费用，以此类推。
请你设计一个自动售货机，你需要实现一个 VendingMachine 类：
- VendingMachine() —— 初始化一个 VendingMachine 实例
- void addItem(int time, int number, string item, int price, int duration) —— 在 time 时刻向售货机中增加 number 个名称为 item 的商品，价格为 price，保质期为 duration
 - 同种商品可能有不同批次，不同批次的价格和保质期可能不同
- long sell(int time, string customer, string item, int number) —— 在 time 时刻，名称为 customer 的顾客前来购买了 number 个名称为 item 的商品，返回总费用
 - 当且仅当售货机中存在足够数量的未过期商品方可成功购买，并返回支付的总费用，否则一件商品也不会售出，并返回 -1
 - 对于价格不同的同种商品，优先售出价格最低的商品；
 - 如果有价格相同的同种商品，优先出售距离过期时间最近的商品；
注意：
输入保证前一次操作的 time 不大于后一次操作的 time
过期指商品存入的时刻与保质期之和小于当前时刻，也即 addtime + duration < currTime
示例 1：
输入：
["VendingMachine","addItem","sell","sell","sell","sell"]
[[],[0,3,"Apple",10,10],[1,"Tom","Apple",1],[2,"Tom","Apple",3],[3,"Mary","Banana",2],[11,"Jim","Apple",1]]
输出: [null,null,10,-1,-1,-1]
解释：
VendingMachine sys = new VendingMachine();
sys.addItem(0,3,"Apple",10,10); // 时刻 0 ，添加 3 个 Apple，价格为 10，保质期为 10。
sys.sell(1,"Tom","Apple",1); // 时刻 1 ，用户 Tom 购买 1 个 Apple， 支付 10 ：。
sys.sell(2,"Tom","Apple",3); // 时刻 2 ，售货机中 Apple 数量为 2 ，用户 Tom 购买失败，返回 -1。
sys.sell(3,"Mary","Banana",2); // 时刻 3 ，售货机中没有 Banana ，用户 Mary 购买失败，返回 -1。
sys.sell(11,"Jim","Apple",1); // 时刻 11 ，售货机中的 Apple 全部过期，用户 Jim 购买失败，返回 -1。
示例 2：
输入：
["VendingMachine","addItem","addItem","sell","addItem","sell","sell","sell","addItem","sell","sell"]
[[],[0,1,"Apple",4,3],[1,3,"Apple",4,2],[2,"Mary","Apple",2],[2,1,"Banana",2,5],[4,"Jim","Banana",2],[4,"Mary","Banana",1],[4,"Mary","Apple",1],[6,200,"Apple",2,5],[6,"Jim","Apple",100],[7,"Mary","Apple",100]]
输出: [null,null,null,8,null,-1,2,-1,null,200,196]
解释：
VendingMachine sys = new VendingMachine();
sys.addItem(0,1,"Apple",4,3); // 时刻 0 ，添加 1 个 Apple，价格为 4，保质期为 3。
sys.addItem(1,3,"Apple",4,2); // 时刻 1 ，添加 3 个 Apple，价格为 4，保质期为 2。
sys.sell(2,"Mary","Apple",2); // 时刻 2 ，用户 Mary 购买 2 个 Apple，支付 8。
sys.addItem(2,1,"Banana",2,5); // 时刻 2 ，添加 1 个 Banana，价格为 2，保质期为 5。
sys.sell(4,"Jim","Banana",2); // 时刻 4 ，售货机中 Banana 数量为 1 ，用户 Jim 购买失败，返回 -1。
sys.sell(4,"Mary","Banana",1); // 时刻 4 ，用户 Mary 购买 1 个 Banana，享受 1% 的优惠，向上取整后为 2
sys.sell(4,"Mary","Apple",1); // 时刻 4 ，售货机中的 Apple 全部过期，用户 Mary 购买失败，返回 -1。
sys.addItem(6,200,"Apple",2,5); // 时刻 6 ，添加 200 个 Apple，价格为 2，保质期为 5。
sys.sell(6,"Jim","Apple",100); // 时刻 6 ，用户 Jim 购买 100 个 Apple。返回 200
sys.sell(7,"Mary","Apple",100); // 时刻 7 ，用户 Mary 购买 100 个 Apple，可享受 2% 的优惠。返回196
提示：
1 <= item.length,customer.length <= 10，item 和 customer 中只包含英文字母
1 <= duration,price,number <= 10^6
0 <= time <= 10^6
addItem 和 sell 的总调用次数不超过 1000 次
 */