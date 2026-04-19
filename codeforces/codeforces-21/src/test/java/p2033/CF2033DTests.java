package p2033;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2033DTests extends AbstractOjTests {
    public CF2033DTests() {
        super("/p2033/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2033D.main(null);
        super.doAssertion(OUTPUT1);
    }
}