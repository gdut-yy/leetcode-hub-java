package p2032;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2032CTests extends AbstractOjTests {
    public CF2032CTests() {
        super("/p2032/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2032C.main(null);
        super.doAssertion(OUTPUT1);
    }
}