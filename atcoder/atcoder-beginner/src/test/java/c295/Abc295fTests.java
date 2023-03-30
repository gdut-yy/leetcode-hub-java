package c295;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Abc295fTests extends AbstractOjTests {
    public Abc295fTests() {
        super("/c295/F/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        Abc295_f.main(null);
        super.doAssertion(OUTPUT1);
    }
}