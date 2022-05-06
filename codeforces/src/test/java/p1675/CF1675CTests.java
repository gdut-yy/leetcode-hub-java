package p1675;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1675CTests extends AbstractOjTests {
    public CF1675CTests() {
        super("/p1675/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1675C.main(null);
        super.doAssertion();
    }
}
