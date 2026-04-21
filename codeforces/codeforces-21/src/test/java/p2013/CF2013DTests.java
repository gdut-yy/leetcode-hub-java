package p2013;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2013DTests extends AbstractOjTests {
    public CF2013DTests() {
        super("/p2013/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2013D.main(null);
        super.doAssertion(OUTPUT1);
    }
}