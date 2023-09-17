package c290;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Abc290bTests extends AbstractOjTests {
    public Abc290bTests() {
        super("/c290/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        Abc290_b.main(null);
        super.doAssertion(OUTPUT1);
    }
}