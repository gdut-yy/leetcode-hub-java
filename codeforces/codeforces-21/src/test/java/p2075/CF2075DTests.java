package p2075;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2075DTests extends AbstractOjTests {
    public CF2075DTests() {
        super("/p2075/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2075D.main(null);
        super.doAssertion(OUTPUT1);
    }
}