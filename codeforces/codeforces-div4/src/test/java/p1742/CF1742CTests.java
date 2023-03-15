package p1742;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1742CTests extends AbstractOjTests {
    public CF1742CTests() {
        super("/p1742/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1742C.main(null);
        super.doAssertion();
    }
}
