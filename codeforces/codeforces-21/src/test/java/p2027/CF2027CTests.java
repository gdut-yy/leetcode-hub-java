package p2027;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2027CTests extends AbstractOjTests {
    public CF2027CTests() {
        super("/p2027/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2027C.main(null);
        super.doAssertion(OUTPUT1);
    }
}