package p1903;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1903CTests extends AbstractOjTests {
    public CF1903CTests() {
        super("/p1903/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1903C.main(null);
        super.doAssertion(OUTPUT1);
    }
}