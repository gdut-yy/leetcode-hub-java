import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution5974Tests {
    private final Solution5974 solution5974 = new Solution5974();

    @Test
    public void example1() {
        String corridor = "SSPPSPS";
        int expected = 3;
        Assertions.assertEquals(expected, solution5974.numberOfWays(corridor));
    }

    @Test
    public void example2() {
        String corridor = "PPSPSP";
        int expected = 1;
        Assertions.assertEquals(expected, solution5974.numberOfWays(corridor));
    }

    @Test
    public void example3() {
        String corridor = "S";
        int expected = 0;
        Assertions.assertEquals(expected, solution5974.numberOfWays(corridor));
    }

    // 补充用例
    @Test
    public void example4() {
        String corridor = "PPPPPPPSPPPSPPPPSPPPSPPPPPSPPPSPPSPPSPPPPPSPSPPPPPSPPSPPPPPSPPSPPSPPPSPPPPSPPPPSPPPPPSPSPPPPSPSPPPSPPPPSPPPPPSPSPPSPPPPSPPSPPSPPSPPPSPPSPSPPSSSS";
        int expected = 18335643;
        Assertions.assertEquals(expected, solution5974.numberOfWays(corridor));
    }
}
