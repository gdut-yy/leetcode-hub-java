package p2110;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2110CTests extends AbstractOjTests {
    public CF2110CTests() {
        super("/p2110/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2110C.main(null);
        super.doAssertion(OUTPUT1);
    }
}