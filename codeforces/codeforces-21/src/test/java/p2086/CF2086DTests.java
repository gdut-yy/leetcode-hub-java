package p2086;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2086DTests extends AbstractOjTests {
    public CF2086DTests() {
        super("/p2086/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2086D.main(null);
        super.doAssertion(OUTPUT1);
    }
}