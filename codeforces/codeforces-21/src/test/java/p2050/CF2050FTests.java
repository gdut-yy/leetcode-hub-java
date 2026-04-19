package p2050;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2050FTests extends AbstractOjTests {
    public CF2050FTests() {
        super("/p2050/F/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2050F.main(null);
        super.doAssertion(OUTPUT1);
    }
}
