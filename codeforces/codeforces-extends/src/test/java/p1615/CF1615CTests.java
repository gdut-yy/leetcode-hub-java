package p1615;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1615CTests extends AbstractOjTests {
    public CF1615CTests() {
        super("/p1615/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1615C.main(null);
        super.doAssertion();
    }
}
