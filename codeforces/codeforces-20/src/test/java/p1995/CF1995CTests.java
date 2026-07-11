package p1995;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1995CTests extends AbstractOjTests {
    public CF1995CTests() {
        super("/p1995/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1995C.main(null);
        super.doAssertion(OUTPUT1);
    }
}
