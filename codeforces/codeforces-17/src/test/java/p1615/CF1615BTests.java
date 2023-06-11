package p1615;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1615BTests extends AbstractOjTests {
    public CF1615BTests() {
        super("/p1615/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1615B.main(null);
        super.doAssertion();
    }
}
