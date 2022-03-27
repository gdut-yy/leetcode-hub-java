import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Solution721Tests {
    private final Solution721 solution721 = new Solution721();

    @Test
    public void example1() {
        List<List<String>> accounts = List.of(
                List.of("John", "johnsmith@mail.com", "john00@mail.com"),
                List.of("John", "johnnybravo@mail.com"),
                List.of("John", "johnsmith@mail.com", "john_newyork@mail.com"),
                List.of("Mary", "mary@mail.com")
        );
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("John", "john00@mail.com", "john_newyork@mail.com", "johnsmith@mail.com"),
                Arrays.asList("John", "johnnybravo@mail.com"),
                Arrays.asList("Mary", "mary@mail.com")
        );
        List<List<String>> actual = solution721.accountsMerge(accounts);
        expected.sort(UtUtils.STRING_LIST_COMPARATOR);
        actual.sort(UtUtils.STRING_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void example2() {
        List<List<String>> accounts = List.of(
                List.of("Gabe", "Gabe0@m.co", "Gabe3@m.co", "Gabe1@m.co"),
                List.of("Kevin", "Kevin3@m.co", "Kevin5@m.co", "Kevin0@m.co"),
                List.of("Ethan", "Ethan5@m.co", "Ethan4@m.co", "Ethan0@m.co"),
                List.of("Hanzo", "Hanzo3@m.co", "Hanzo1@m.co", "Hanzo0@m.co"),
                List.of("Fern", "Fern5@m.co", "Fern1@m.co", "Fern0@m.co")
        );
        List<List<String>> expected = Arrays.asList(
                Arrays.asList("Ethan", "Ethan0@m.co", "Ethan4@m.co", "Ethan5@m.co"),
                Arrays.asList("Gabe", "Gabe0@m.co", "Gabe1@m.co", "Gabe3@m.co"),
                Arrays.asList("Hanzo", "Hanzo0@m.co", "Hanzo1@m.co", "Hanzo3@m.co"),
                Arrays.asList("Kevin", "Kevin0@m.co", "Kevin3@m.co", "Kevin5@m.co"),
                Arrays.asList("Fern", "Fern0@m.co", "Fern1@m.co", "Fern5@m.co")
        );
        List<List<String>> actual = solution721.accountsMerge(accounts);
        expected.sort(UtUtils.STRING_LIST_COMPARATOR);
        actual.sort(UtUtils.STRING_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }
}
