public class Cnunionpay220916T3 {
}
/*
银联-3. 风能发电
https://leetcode.cn/contest/cnunionpay2022/problems/wMGN0t/

现有一座风力发电场和容量 storeLimit 的储能站，第 j 条供电指令 supply[j]=[time, minSupply, maxSupply] 表示时刻 time 起（包含该时刻）每一时刻最少供应电能 minSupply 以及最多供应电能 maxSupply，直至后续指令调整。
在时刻 i 发电量为 power[i]，该时刻供电逻辑如下：
- 若发电量在 [minSupply, maxSupply] 范围内，则均供应负载；
- 若发电量大于 maxSupply，则超出部分存入储能站，存储量至多不超过 storeLimit；
- 若发电量小于 minSupply，则由储能站补充缺少电量，最多不超过当前存储量；
 - 注：储能站补充电量，直至剩余存储电量为 0
请返回最后时刻（即时刻 power.length-1）储能站中能源总量。
注意：
输入用例保证供电指令的 time 严格递增且第 0 个指令的 time = 0
储能电站初始存储电量为 0
示例 1：
输入：
storeLimit = 10
power = [1,3,4,3,6]
supply = [[0,2,3]]
输出: 4
解释：
时刻 0，供能 1， 新增储能 0， 总储能 0
时刻 1，供能 3， 新增储能 0， 总储能 0
时刻 2，供能 3， 新增储能 1， 总储能 1
时刻 3，供能 3， 新增储能 0， 总储能 1
时刻 4，供能 3， 新增储能 3， 总储能 4
因此最后时刻，剩余的能源总量为 4
示例 2：
输入：
storeLimit = 6
power = [6,5,2,1,0]
supply = [[0,1,2],[2,3,3]]
输出: 0
解释：
时刻 0，供能 2， 新增储能 4， 总储能 4
时刻 1，供能 2， 新增储能 2， 总储能 6 (由于储能电站达上限，电量 1 丢弃)
时刻 2，供能 3， 新增储能 -1， 总储能 5
时刻 3，供能 3， 新增储能 -2， 总储能 3
时刻 4，供能 3， 新增储能 -3， 总储能 0
因此最后时刻，剩余的能源总量为 0
提示：
1 <= storeLimit <= 10^6
1 <= power.length <= 10^5
0 <= power[i] <= 10^5
1 <= supply.length <= power.length
对于 i < j，满足 supply[i][0] < supply[j][0]
supply[i].length == 3
0 <= supply[i][0] < power.length
0 <= supply[i][1]<= supply[i][2] <= 10^5
 */