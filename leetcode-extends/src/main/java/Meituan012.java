import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * meituan-012. 小美的书架
 * https://leetcode-cn.com/problems/FvoBGh/
 */
public class Meituan012 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8));
        String[] line0 = reader.readLine().split(" ");
        int M = Integer.parseInt(line0[0]);
        int N = Integer.parseInt(line0[1]);
        int Q = Integer.parseInt(line0[2]);
        String[] qLines = new String[Q];
        for (int i = 0; i < Q; i++) {
            qLines[i] = reader.readLine();
        }
        List<Integer> resList = solution(M, N, qLines);
        for (int res : resList) {
            writer.write(String.valueOf(res));
            writer.write(System.lineSeparator());
        }
        writer.close();
        reader.close();
    }

    private static List<Integer> solution(int M, int N, String[] qLines) {
        List<Integer> resList = new ArrayList<>();
        // 书本编号从 1 到 M
        Bookshelf bookshelf = new Bookshelf(N + 1);
        for (String line : qLines) {
            String[] params = line.split(" ");
            switch (params[0]) {
                case "1":
                    bookshelf.doCase1(Integer.parseInt(params[1]), Integer.parseInt(params[2]));
                    break;
                case "2":
                    bookshelf.doCase2(Integer.parseInt(params[1]));
                    break;
                case "3":
                    bookshelf.doCase3(Integer.parseInt(params[1]));
                    break;
                case "4":
                    resList.add(bookshelf.doCase4(Integer.parseInt(params[1])));
                    break;
                default:
                    bookshelf.doCase5(Integer.parseInt(params[1]));
                    break;
            }
        }
        return resList;
    }

    private static class Bookshelf {
        // 小团手上有的书
        private final Set<Integer> tuanSet;
        // 书架上书的所属行
        private final Map<Integer, Integer> shelfMap;
        // 书架上的行是否被锁
        private final boolean[] shelfLock;

        public Bookshelf(int capacity) {
            tuanSet = new HashSet<>();
            shelfMap = new HashMap<>();
            shelfLock = new boolean[capacity];
        }

        /**
         * 将书 x 放入书架第 y 行，只有 不在团手上 + 尚未放入书架或者放入书架行未被锁 + 新的书架行没锁 才合法。
         *
         * @param x 书本的编号
         * @param y 书架的行编号
         */
        public void doCase1(int x, int y) {
            if (!tuanSet.contains(x) && (!shelfMap.containsKey(x) || !shelfLock[shelfMap.get(x)]) && !shelfLock[y]) {
                shelfMap.put(x, y);
            }
        }

        /**
         * 锁上书架 y，不论之前是否上锁，统统锁上
         *
         * @param y 书架的行编号
         */
        public void doCase2(int y) {
            shelfLock[y] = true;
        }

        /**
         * 解锁书架 y，不论之前是否上锁，统统解锁
         *
         * @param y 书架的行编号
         */
        public void doCase3(int y) {
            shelfLock[y] = false;
        }

        /**
         * 外借之后需要将该书从书架上删除 + 小团借走
         *
         * @param x 书本的编号
         * @return 在哪一行，借不到输出一行 -1
         */
        public int doCase4(int x) {
            if (!tuanSet.contains(x) && shelfMap.containsKey(x) && !shelfLock[shelfMap.get(x)]) {
                int res = shelfMap.get(x);
                shelfMap.remove(x);
                tuanSet.add(x);
                return res;
            }
            return -1;
        }

        /**
         * 小团还书
         *
         * @param x 书本的编号
         */
        public void doCase5(int x) {
            tuanSet.remove(x);
        }
    }
}
/*
小美的书架上有很多书。小美是个爱读书的新时代好青年。
小团虽然也喜欢看书，但小团大多数时候都更喜欢来小美家蹭书读。
这就导致小美的书架上很多书都会被小团借走。
小美很烦这一点，就想出了一个招数，小美的书架是一行一行的，他会对一些行加锁，这样小团就借不走了。
现在小团想要借书，请你帮忙看看小团能不能借到书，如果可以借到的话在哪一行书架上有这本书。
为了简单起见，每本书将用一个正整数进行编号，小美的书架一共有 N 行。

格式：
输入：
- 第一行三个正整数 M，N，Q，表示小美书架有 N 行编号 1 到 N ，书本编号从 1 到 M ，接下来有 Q 个操作
- 接下来 Q 行，每行是下列操作中的一种：
  1. x y : x 是书本的编号，y 是书架的行编号，代表小美将编号为 x 的书本放置到 y 行上。若该书本在小团手上则放置无效，
若原来该书在书架上且原行上锁则放置无效，若该书被放置到一个锁了的行上则放置无效。
  2. y : y 是书架的行编号，代表小美将行编号为 y 的书架加锁，对已经上锁的书架行该操作无效。
  3. y : y 是书架的行编号，代表小美将行编号为 y 的书架锁去掉，对无锁的书架行该操作无效。
  4. x : x 是书本的编号，代表小团想借编号为 x 的书本，对该操作若可以借到输出一行正整数在哪一行，借不到输出一行 -1
  5. x : x 是书本的编号，代表小团还回来编号为 x 的书本。若该书本不在小团手上该操作无效。
输出：
- 对于每个操作 4 ，若可以借到输出一行正整数在哪一行，借不到输出一行 -1 。

示例：
输入：
5 5 10
1 1 4
1 2 3
1 3 1
2 1
4 1
5 2
4 3
4 5
3 1
4 2
输出：
4
-1
-1
3

提示：
对于 30% 的数据有 N<=10, M<=10, Q<=20
对于 80% 的数据有 N<=1000, M<=1000, Q<=100000
对于 100% 的数据有 N<=10000, M<=10000, Q<=100000
 */
