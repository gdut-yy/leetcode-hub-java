package p2160;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2160CTests extends AbstractOjTests {
    public CF2160CTests() {
        super("/p2160/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2160C.main(null);
        super.doAssertion(OUTPUT1);
    }
}