package p2125;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2125CTests extends AbstractOjTests {
    public CF2125CTests() {
        super("/p2125/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2125C.main(null);
        super.doAssertion(OUTPUT1);
    }
}