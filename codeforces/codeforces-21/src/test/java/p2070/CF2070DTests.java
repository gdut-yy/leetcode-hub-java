package p2070;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2070DTests extends AbstractOjTests {
    public CF2070DTests() {
        super("/p2070/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2070D.main(null);
        super.doAssertion(OUTPUT1);
    }
}
