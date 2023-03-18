package c290;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Abc290dTests extends AbstractOjTests {
    public Abc290dTests() {
        super("/c290/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        Abc290_d.main(null);
        super.doAssertion(OUTPUT1);
    }
}