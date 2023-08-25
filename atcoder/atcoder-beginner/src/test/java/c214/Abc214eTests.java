package c214;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Abc214eTests extends AbstractOjTests {
    public Abc214eTests() {
        super("/c214/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        Abc214_e.main(null);
        super.doAssertion(OUTPUT1);
    }
}