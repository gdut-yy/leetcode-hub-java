package p1759;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1759ATests extends AbstractOjTests {
    public CF1759ATests() {
        super("/p1759/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1759A.main(null);
        super.doAssertion();
    }
}
