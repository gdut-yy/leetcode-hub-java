package c292;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Abc292bTests extends AbstractOjTests {
    public Abc292bTests() {
        super("/c292/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        Abc292_b.main(null);
        super.doAssertion(OUTPUT1);
    }
}