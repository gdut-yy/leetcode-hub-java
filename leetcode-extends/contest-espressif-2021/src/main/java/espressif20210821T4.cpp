class Solution {
public:
    int minSupplyTimes(int num, int initWater, vector<vector<int>>& supplyStations) {

    }
};
/*
自行车拉力赛的选手从起点出发，计划前往距离起点num公里处的终点。
自行车上配有一个用于给轮胎降温用的容量无限的水箱，在出发时水箱中有initWater升水，并且选手每骑行一公里就需要消耗一升水用于给轮胎降温。
在比赛路线途中设有若干个补给站，以[与起点的距离,水量]的格式记录于二维数组 supplyStations中。当选手抵达补给站时，可选择是否对水箱进行补水，若选择补水，则会将该补水站当前水量全部补入水箱中。
请返回选手抵达终点至少需要的补水次数。若无法抵达终点，则返回 -1。
注意：
若选手抵达补给站时水箱剩余水量为 0，可在此补水；
若选手抵达终点时水箱剩余水量为 0，视作抵达目的地。
示例 1：
输入：num =10, initWater = 11, supplyStations = [[5,1]]
输出：0
解释：无需加水就可直接到达终点。
示例 2：
输入：num = 572, initWater = 200, supplyStations = [[200,156]]
输出：-1
解释：即使选择在第一个补给站加水也无法抵达终点。
示例 3：
输入：num = 200, initWater = 11, supplyStations = [[5,5],[6,100],[10,189],[11,30]]
输出：1
解释：以下是一种可行的方案：
出发时水箱中水量为 11 升；
骑行来到距起点 5 公里处的补给站，不选择加水，此时水箱中的水量为 6 升；
骑行来到距起点 6 公里处的补给站，不选择加水，此时水箱中的水量为 5 升；
骑行来到距起点 10 公里处的补给站，选择加水，此时水箱中的水量为 190 升；
骑行来到距起点 11 公里处的补给站，不选择加水，此时水箱中的水量为 189 升；
到达终点，此时水箱中的水量为 0 升。
提示：
1 <= num, initWater, supplyStations[i][1] <= 10^9
0 <= supplyStations.length <= 500
0 < supplyStations[0][0] < supplyStations[1][0] < ... < supplyStations[supplyStations.length-1][0] < num
 */