package p1795;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1795CTests extends AbstractOjTests {
    public CF1795CTests() {
        super("/p1795/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1795C.main(null);
        super.doAssertion(OUTPUT1);
    }
}