package p1980;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1980CTests extends AbstractOjTests {
    public CF1980CTests() {
        super("/p1980/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1980C.main(null);
        super.doAssertion(OUTPUT1);
    }
}
