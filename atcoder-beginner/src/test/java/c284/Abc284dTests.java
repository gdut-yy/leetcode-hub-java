package c284;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Abc284dTests extends AbstractOjTests {
    public Abc284dTests() {
        super("/c284/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        Abc284_d.main(null);
        super.doAssertion(OUTPUT1);
    }
}