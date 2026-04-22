package p1875;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1875CTests extends AbstractOjTests {
    public CF1875CTests() {
        super("/p1875/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1875C.main(null);
        super.doAssertion(OUTPUT1);
    }
}