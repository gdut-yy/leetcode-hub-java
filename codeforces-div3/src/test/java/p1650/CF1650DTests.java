package p1650;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1650DTests extends AbstractOjTests {
    public CF1650DTests() {
        super("/p1650/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1650D.main(null);
        super.doAssertion();
    }
}
