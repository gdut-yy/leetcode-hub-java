package p622;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF622CTests extends AbstractOjTests {
    public CF622CTests() {
        super("/p622/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF622C.main(null);
        super.doAssertion(OUTPUT1);
    }
}