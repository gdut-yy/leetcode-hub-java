package c376;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Abc376eTests extends AbstractOjTests {
    public Abc376eTests() {
        super("/c376/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        Abc376_e.main(null);
        super.doAssertion(OUTPUT1);
    }
}
