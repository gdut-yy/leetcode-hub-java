public class SfTech220619T5 {
    public boolean isCompliance(int[][] distance, int n) {
        int m = distance.length;

        UnionFind unionFind = new UnionFind(m);
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                if (distance[i][j] <= 2) {
                    unionFind.union(i, j);
                }
            }
        }
        return unionFind.count <= n;
    }

    private static class UnionFind {
        // 记录每个节点的父节点
        int[] parent;
        // 记录每棵树的重量
        int[] rank;
        // (可选) 连通分量
        int count;

        // 0 ~ n-1
        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = i;
            }
            count = n;
        }

        // 返回节点 x 的根节点
        private int find(int x) {
            int ret = x;
            while (ret != parent[ret]) {
                // 路径压缩
                parent[ret] = parent[parent[ret]];
                ret = parent[ret];
            }
            return ret;
        }

        // 将 p 和 q 连通
        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP != rootQ) {
                if (rank[rootP] > rank[rootQ]) {
                    parent[rootQ] = rootP;
                } else if (rank[rootP] < rank[rootQ]) {
                    parent[rootP] = rootQ;
                } else {
                    parent[rootQ] = rootP;
                    // 重量平衡
                    rank[rootP] += 1;
                }
                count--;
            }
        }
    }
}
/*
顺丰05. 慧眼神瞳
https://leetcode.cn/contest/sf-tech/problems/BN8jAm/

【背景】
"慧眼神瞳"平台可以通过分析摄像头监控画面，进行自动化的识别场地形象是否符合标准、工具是否定置定位、火灾预警、防盗预警、异常人员入侵预警等情况。
出于运维考虑，要求场地对摄像头进行分组管理，每组有专门的负责人负责管理。
【问题】
假设平台部署摄像头的距离集合distance，为场地安排n个负责人，其中:
distance[i][j]表示摄像头i和摄像头j之间的距离，如果distance[i][j]<=2米说明它们属于同一组。
请你设计一个算法判断该场地是否可以保证每组摄像头至少有一个负责人管理。
输入: 摄像头部署之间距离集合m*m的二维数组distance[m][m]，人员数量n
输出：是否满足要求的结果:true/false
示例1：
假设存在三个摄像头1,2,3
image.png
输入：distance=[[0,1,3], [1,0,3], [3,3,0]], n = 2
输出：true
解释：
distance：摄像头部署之间距离集合，摄像头id=索引i+1；
distance=[
 [0,1,3], => 摄像头id1(i=0)分别到摄像头id1、2、3（j=0,1,2）的距离：id1->id1: 0米；id1->id2: 1米；id1->id3: 3米
 [1,0,3], => 摄像头id2(i=1)分别到摄像头id1、2、3（j=0,1,2）的距离：id2->id1: 1米；id2->id2: 0米；id2->id3: 3米
 [3,3,0]] => 摄像头id3(i=2)分别到摄像头id1、2、3（j=0,1,2）的距离：id3->id1: 3米；id3->id2: 1米；id3->id3: 3米
n：负责人个数
摄像头1与2的距离为1，摄像头1与3的距离为3，摄像头2与3的距离为3，所以摄像头1和2为一组，摄像头3自己一组，一共有2组摄像头，2<=n，所以能够满足每组至少有一个负责人管理。
示例2：
假设存在三个摄像头1,2,3
image.png
输入：distance=[[0,3,3],[3,0,3],[3,3,0]], n = 2
输出：false
解释：3个摄像头两两相聚3米，大于2米要求，故各为1组，一共3组；但是只有2个负责人，不能满足每组至少有1个负责人管理，所以输出为false
提示：
1 <= m <= 100
0 <= distance[i][j] < 100
0 < n < 100

并查集。
 */