import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution332Tests {
    private final Solution332 solution332 = new Solution332();

    @Test
    public void example1() {
        List<List<String>> tickets = List.of(List.of("MUC", "LHR"), List.of("JFK", "MUC"), List.of("SFO", "SJC"), List.of("LHR", "SFO"));
        List<String> expected = List.of("JFK", "MUC", "LHR", "SFO", "SJC");
        Assertions.assertEquals(expected, solution332.findItinerary(tickets));
    }

    @Test
    public void example2() {
        List<List<String>> tickets = List.of(List.of("JFK", "SFO"), List.of("JFK", "ATL"), List.of("SFO", "ATL"), List.of("ATL", "JFK"), List.of("ATL", "SFO"));
        List<String> expected = List.of("JFK", "ATL", "JFK", "SFO", "ATL", "SFO");
        Assertions.assertEquals(expected, solution332.findItinerary(tickets));
    }

}
