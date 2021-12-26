package p1582;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1582CTests extends AbstractOjTests {
    public CF1582CTests() {
        super("p1582/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1582C.main(null);
        super.doAssertion();
    }
}
