package p1669;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1669DTests extends AbstractOjTests {
    public CF1669DTests() {
        super("/p1669/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1669D.main(null);
        super.doAssertion();
    }
}
