package p1362;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1362CTests extends AbstractOjTests {
    public CF1362CTests() {
        super("/p1362/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1362C.main(null);
        super.doAssertion(OUTPUT1);
    }
}