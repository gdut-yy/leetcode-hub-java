import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionP2408 {
    static class SQL {
        Map<String, Integer> colNums = new HashMap<>(); // 表名 -> 行数
        Map<String, Integer> nextIds = new HashMap<>(); // 表名 -> 下一个 ID
        Map<String, Map<Integer, List<String>>> datas = new HashMap<>(); // 表名 -> ID -> 记录

        public SQL(List<String> names, List<Integer> columns) {
            int n = names.size();
            for (int i = 0; i < n; i++) {
                String name = names.get(i);
                int column = columns.get(i);
                colNums.put(name, column);
            }
        }

        public boolean ins(String name, List<String> row) {
            if (!colNums.containsKey(name) || colNums.get(name) != row.size()) {
                return false;
            }
            Integer curId = nextIds.merge(name, 1, Integer::sum);
            datas.computeIfAbsent(name, e -> new HashMap<>()).put(curId, row);
            return true;
        }

        public void rmv(String name, int rowId) {
            if (!colNums.containsKey(name)) {
                return;
            }
            datas.getOrDefault(name, new HashMap<>()).remove(rowId);
        }

        public String sel(String name, int rowId, int columnId) {
            if (!colNums.containsKey(name)
                    || colNums.get(name) < columnId
                    || !datas.getOrDefault(name, new HashMap<>()).containsKey(rowId)) {
                return "<null>";
            }
            return datas.get(name).get(rowId).get(columnId - 1);
        }

        public List<String> exp(String name) {
            List<String> res = new ArrayList<>();
            for (Map.Entry<Integer, List<String>> entry : datas.getOrDefault(name, new HashMap<>()).entrySet()) {
                res.add(entry.getKey() + "," + String.join(",", entry.getValue()));
            }
            return res;
        }
    }
}
/*
$2408. 设计 SQL
https://leetcode.cn/problems/design-sql/description/

给定两个字符串数组 names 和 columns，大小都为 n。其中 names[i] 是第 i 个表的名称，columns[i] 是第 i 个表的列数。
您需要实现一个支持以下 操作 的类：
- 在特定的表中 插入 一行。插入的每一行都有一个 id。id 是使用自动递增方法分配的，其中第一个插入行的 id 为 1，同一个表中的后续其他行的 id 为上一个插入行的 id (即使它已被删除) 加 1。
- 从指定表中 删除 一行。注意，删除一行 不会 影响下一个插入行的 id。
- 从任何表中 查询 一个特定的单元格并返回其值。
- 从任何表以 csv 格式 导出 所有行。
实现 SQL 类:
- SQL(String[] names, int[] columns)
  - 创建 n 个表。
- bool ins(String name, String[] row)
  - 将 row 插入表 name 中并返回 true。
  - 如果 row.length 不 匹配列的预期数量，或者 name 不是 一个合法的表，不进行任何插入并返回 false。
- void rmv(String name, int rowId, int columnId)
  - 从表 name 中移除行 rowId。
  - 如果 name 不是 一个合法的表或者没有 id 为 rowId 的行，不进行删除。
- String sel(String name, int rowId, int columnId)
  - 返回表 name 中位于特定的 rowId 和 columnId 的单元格的值。
  - 如果 name 不是 一个合法的表，或者单元格 (rowId, columnId) 不合法，返回 "<null>"。
- String[] exp(String name)
  - 返回表 name 中出现的行。
如果 name 不是 一个合法的表，返回一个空数组。每一行以字符串表示，每个单元格的值（包括 行的 id）以 "," 分隔。
提示:
n == names.length == columns.length
1 <= n <= 10^4
1 <= names[i].length, row[i].length, name.length <= 10
names[i], row[i], name 由小写英文字母组成。
1 <= columns[i] <= 10
1 <= row.length <= 10
所有的 names[i] 都是 不同 的。
最多调用 ins 和 rmv 2000 次。
最多调用 sel 10^4 次。
最多调用 exp 500 次。
进阶：如果表因多次删除而变得稀疏，您会选择哪种方法？为什么？考虑对内存使用和性能的影响。

哈希表模拟
 */