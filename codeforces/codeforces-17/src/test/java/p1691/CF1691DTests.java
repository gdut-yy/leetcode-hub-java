package p1691;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1691DTests extends AbstractOjTests {
    public CF1691DTests() {
        super("/p1691/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1691D.main(null);
        super.doAssertion();
    }
}