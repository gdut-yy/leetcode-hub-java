package p2005;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2005DTests extends AbstractOjTests {
    public CF2005DTests() {
        super("/p2005/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2005D.main(null);
        super.doAssertion(OUTPUT1);
    }
}