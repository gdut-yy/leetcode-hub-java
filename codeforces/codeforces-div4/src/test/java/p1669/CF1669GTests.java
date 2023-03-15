package p1669;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1669GTests extends AbstractOjTests {
    public CF1669GTests() {
        super("/p1669/G/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1669G.main(null);
        super.doAssertion();
    }
}
