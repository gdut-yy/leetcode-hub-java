package p1582;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1582ATests extends AbstractOjTests {
    public CF1582ATests() {
        super("p1582/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1582A.main(null);
        super.doAssertion();
    }
}
