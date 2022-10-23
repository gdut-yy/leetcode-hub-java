public class Autox220828T4 {
}
/*
AutoX-4. 蚂蚁爬行
https://leetcode.cn/contest/autox2023/problems/TcdlJS/

在一张稿纸上画了若干由线条构成的的线段和正圆形。geometry[i] 表示对于第 i 个线条有：
- 若 geometry[i].length 为 4 ，表示为一条线段，[x1, y1, x2, y2] 表示该线段的两个端点坐标分别为 (x1,y1) 和 (x2,y2)。
- 若 geometry[i].length 为 3 ，表示为一个正圆形，[x, y, r] 表示其圆心坐标和半径分别为 (x,y) 和 r
现有一群小蚂蚁在这些线条上爬行，path[i] = [start, end] 表示第 i 只蚂蚁从第 start 个线条前往第 end 个线条。在爬行过程中，对于任意两个线条，只要有接触（公共点），小蚂蚁就能从一个爬到另一个。请判断这些小蚂蚁能否到达各自的目的地。
示例 1：
输入：
geometry = [[2,5,7,3],[1,1,4,2],[4,3,2]]
path = [[0,1],[1,2],[0,2]]
输出：[true,true,true]
解释：如下图所示：
所有的几何对象都是可互通的，所有蚂蚁都可以到达目的地。
示例 2：
输入：
geometry = [[4,1,1],[3,2,1],[1,4,5,4]]
path = [[0,1],[2,0]]
输出：[true,false]
解释：如下图所示:
geometry[0] 和 geometry[1] 相接触，geometry[2] 不与任何几何对象接触，因此蚂蚁 1 无法到达，
提示：
2 <= geometry.length <= 1000
0 <= geometry[i][0],geometry[i][1] <= 10^5
对于线段，0 <= geometry[i][2],geometry[i][3] <= 10^5
对于正圆形，1 <= geometry[i][2] <= 10^5
1 <= path.length <= 1000
0 <= path[i][0], path[i][1] < geometry.length

https://leetcode.cn/circle/discuss/iTuZLj/
 */