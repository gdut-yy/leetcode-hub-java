public class Solution1924 {

}
/*
$1924. 安装栅栏 II
https://leetcode.cn/problems/erect-the-fence-ii/

给你一个二维整数数组 trees，其中 trees[i] = [xi, yi] 表示花园中第 i 棵树的坐标。
你需要用最少的原材料给花园安装一个 圆形 的栅栏，使花园中所有的树都在被 围在栅栏内部（在栅栏边界上的树也算在内）。
正式地说，你需要求出栅栏的圆心坐标 (x,y) 和半径 r，使花园中所有的树都在圆的内部或边界上，并且让半径 r 最小。
请用一个长度为 3 的数组 [x,y,r] 来返回圆心坐标和半径。如果答案与正确答案的误差不超过 10^-5，则该答案将被视为正确答案通过。
提示:
1 <= trees.length <= 3000
trees[i].length == 2
0 <= xi, yi <= 3000

最小圆覆盖 Welzl 算法
```
const eps = 1e-8

type point struct{ x, y float64 }

// 两点距离的平方
func dis2(p, q point) float64 { return (p.x-q.x)*(p.x-q.x) + (p.y-q.y)*(p.y-q.y) }

// 三角形外心
func circumcenter(a, b, c point) point {
	a1, b1, a2, b2 := b.x-a.x, b.y-a.y, c.x-a.x, c.y-a.y
	c1, c2, d := a1*a1+b1*b1, a2*a2+b2*b2, 2*(a1*b2-a2*b1)
	return point{a.x + (c1*b2-c2*b1)/d, a.y + (a1*c2-a2*c1)/d}
}

func outerTrees(trees [][]int) []float64 {
	a := make([]point, len(trees))
	for i, tree := range trees {
		a[i] = point{float64(tree[0]), float64(tree[1])}
	}
    rand.Seed(time.Now().UnixNano())
	rand.Shuffle(len(a), func(i, j int) { a[i], a[j] = a[j], a[i] }) // 随机打乱
	o := a[0] // 圆心
	r2 := 0.  // 半径的平方
	for i, p := range a {
		if dis2(o, p) < r2+eps { // p 在最小圆内部或边上
			continue
		}
		o, r2 = p, 0
		for j, q := range a[:i] {
			if dis2(o, q) < r2+eps { // q 在最小圆内部或边上
				continue
			}
			o = point{(p.x + q.x) / 2, (p.y + q.y) / 2}
			r2 = dis2(o, p)
			for _, x := range a[:j] {
				if dis2(o, x) > r2+eps { // 保证三点不会共线
					o = circumcenter(p, q, x)
					r2 = dis2(o, p)
				}
			}
		}
	}
	return []float64{o.x, o.y, math.Sqrt(r2)}
}

作者：endlesscheng
链接：https://leetcode.cn/problems/erect-the-fence-ii/solution/go-zui-xiao-yuan-fu-gai-welzl-suan-fa-by-v6yz/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```
 */