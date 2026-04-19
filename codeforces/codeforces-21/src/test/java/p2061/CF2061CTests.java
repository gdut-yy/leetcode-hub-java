package p2061;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2061CTests extends AbstractOjTests {
    public CF2061CTests() {
        super("/p2061/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2061C.main(null);
        super.doAssertion(OUTPUT1);
    }
}
