package c218;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Abc218bTests extends AbstractOjTests {
    public Abc218bTests() {
        super("/c218/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        Abc218_b.main(null);
        super.doAssertion(OUTPUT1);
    }
}
