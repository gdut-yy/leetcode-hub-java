public class Solution832 {
    public int[][] flipAndInvertImage(int[][] image) {
        int imageM = image.length;
        int imageN = image[0].length;
        for (int i = 0; i < imageM; i++) {
            // 水平翻转图像
            for (int j = 0; j < imageN / 2; j++) {
                int tmp = image[i][j];
                image[i][j] = image[i][imageN - 1 - j];
                image[i][imageN - 1 - j] = tmp;
            }
            // 反转图像
            for (int j = 0; j < imageN; j++) {
                if (image[i][j] == 0) {
                    image[i][j] = 1;
                } else {
                    image[i][j] = 0;
                }
            }
        }
        return image;
    }
}
/*
832. 翻转图像
https://leetcode-cn.com/problems/flipping-an-image/

第 84 场周赛 T1。
根据题意进行模拟即可
 */
