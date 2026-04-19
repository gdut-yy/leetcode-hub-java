package p2126;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2126DTests extends AbstractOjTests {
    public CF2126DTests() {
        super("/p2126/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2126D.main(null);
        super.doAssertion(OUTPUT1);
    }
}