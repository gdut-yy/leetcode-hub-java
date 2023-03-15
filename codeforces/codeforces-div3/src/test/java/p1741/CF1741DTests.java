package p1741;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1741DTests extends AbstractOjTests {
    public CF1741DTests() {
        super("/p1741/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1741D.main(null);
        super.doAssertion();
    }
}
