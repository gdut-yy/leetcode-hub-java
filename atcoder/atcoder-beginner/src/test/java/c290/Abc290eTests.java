package c290;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Abc290eTests extends AbstractOjTests {
    public Abc290eTests() {
        super("/c290/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        Abc290_e.main(null);
        super.doAssertion(OUTPUT1);
    }
}