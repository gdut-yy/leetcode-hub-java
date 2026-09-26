class Solution {
public:
    double getAdmissionLine(int k, vector<double>& scores) {

    }
};
/*
Q1. 录取分数线
https://leetcode.cn/contest/espressif-2021/problems/QXquF0/description/

给定一个浮点数数组 scores，其中 scores[i] 表示第 i 个考生的高考分数。 现在请你求出某大学的录取分数线，该大学的录取分数线恰好为将所有考生按高考分数由高到低排序后第 k 名考生的高考分数。
注意： scores[i] 恰好为 0.5 的倍数。
示例 1：
输入： k = 5, scores = [150,300,400,500,600,700,550,450,450,500,555.5]
输出：500
解释： 将所有考生按高考分数由高到低排序后第 5 名考生的高考分数为 500。
示例 2：
输入： k = 4, scores = [723,699,510,488.5]
输出：488.5
解释： 将所有考生按高考分数由高到低排序后第 4 名考生的高考分数为 488.5。
提示：
1 <= k <= scores.lengths <= 10^5
0 <= scores[i] <=750
 */