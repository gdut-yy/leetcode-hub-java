import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionP2408Tests {
    @Test
    public void example1() {
        // 创建 3 张表。
        List<String> names = List.of("one", "two", "three");
        List<Integer> columns = List.of(2, 3, 1);
        SolutionP2408.SQL sql = new SolutionP2408.SQL(names, columns);

        // 将 id 为 1 的行添加到表 "two"。返回 True。
        Assertions.assertTrue(sql.ins("two", List.of("first", "second", "third")));

        // 从表 "two" 中 id 为 1 的行
        // 其中第 3 列返回值 "third"。
        Assertions.assertEquals("third", sql.sel("two", 1, 3));

        // 将另外一个 id 为 2 的行添加到表 "two"。返回 True。
        Assertions.assertTrue(sql.ins("two", List.of("fourth", "fifth", "sixth")));

        // 导出表 "two" 的行。
        // 目前表中有两行 id 为 1 和 2 。
        Assertions.assertEquals(List.of("1,first,second,third", "2,fourth,fifth,sixth"), sql.exp("two"));

        // 删除表 "two" 当中的第一行。注意第二行的 id
        // 依然为 2。
        sql.rmv("two", 1);

        // 从表 "two" 中 id 为 2 的行
        // 其中第 2 列返回值 "fifth"。
        Assertions.assertEquals("fifth", sql.sel("two", 2, 2));

        // 导出表 "two" 的行。
        // 目前表中有一行 id 为 2。
        Assertions.assertEquals(List.of("2,fourth,fifth,sixth"), sql.exp("two"));
    }

    @Test
    public void example2() {
        // 创建 3 张表
        List<String> names = List.of("one", "two", "three");
        List<Integer> columns = List.of(2, 3, 1);
        SolutionP2408.SQL sQL = new SolutionP2408.SQL(names, columns);

        // 将 id 为 1 的行添加到表 "two"。返回 True。
        Assertions.assertTrue(sQL.ins("two", List.of("first", "second", "third")));

        // 从表 "two" 中 id 为 1 的行
        // 其中第 3 列返回值 "third"。
        Assertions.assertEquals("third", sQL.sel("two", 1, 3));

        // 删除表 "two" 的第一行。
        sQL.rmv("two", 1);

        // 返回 "<null>" 因为 id 为 1 的单元格
        // 已经从表 "two" 中删除。
        Assertions.assertEquals("<null>", sQL.sel("two", 1, 2));

        // 返回 False 因为列的数量不正确。
        Assertions.assertFalse(sQL.ins("two", List.of("fourth", "fifth")));

        // 将 id 为 2 的行添加到表 "two"。返回 True。
        Assertions.assertTrue(sQL.ins("two", List.of("fourth", "fifth", "sixth")));
    }
}