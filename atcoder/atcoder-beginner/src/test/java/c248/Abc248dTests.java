package c248;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Abc248dTests extends AbstractOjTests {
    public Abc248dTests() {
        super("/c248/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        Abc248_d.main(null);
        super.doAssertion(OUTPUT1);
    }
}