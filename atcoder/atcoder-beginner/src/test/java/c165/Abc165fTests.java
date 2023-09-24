package c165;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Abc165fTests extends AbstractOjTests {
    public Abc165fTests() {
        super("/c165/F/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        Abc165_f.main(null);
        super.doAssertion(OUTPUT1);
    }
}