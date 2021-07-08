# leetcode-hub-java

基于 java11 + junit5 + allure2 的 leetcode 题解

leetcode-n 存放 100(n-1)+1 ~ 100n 的题目

如 leetcode-19 存放 1801 ~ 1900 的题目

## 常用算法模板

### 前缀和

```
nums   3 5 2 -2
preSum 0 3 8 10 8

nums[i..j] 的累加和 = preSum[j + 1] - preSum[i]
```

```java
// 前缀和数组
int len = nums.length;
int[] preSum = new int[len + 1];
preSum[0] = 0;
for (int i = 0; i < len; i++) {
    preSum[i + 1] = preSum[i] + nums[i];
}
```

### 差分数组

```
nums 8  2 6  3 1
diff 8 -6 4 -3 2

diff[i] = nums[i] - nums[i - 1]
```

```java
// nums[i..j] 的元素全部加 3
diff[i] += 3;
diff[j + 1] -= 3;

// 根据差分数组构造结果数组
int[] res = new int[diff.length];
res[0] = diff[0];
for (int i = 1; i < diff.length; i++) {
    res[i] = res[i - 1] + diff[i];
}
```

### 快速幂

```java
public long fastPower(long x, long pow, int mod) {
    long ans = 1;
    while (pow > 0) {
        if (pow % 2 == 1) {
            ans *= x;
            // 取模
            ans %= mod;
        }
        x *= x;
        // 取模
        x %= mod;
        pow /= 2;
    }
    return ans;
}
```