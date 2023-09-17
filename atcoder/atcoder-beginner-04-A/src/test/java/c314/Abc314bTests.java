package c314;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Abc314bTests extends AbstractOjTests {
    public Abc314bTests() {
        super("/c314/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        Abc314_b.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        Abc314_b.main(null);
        super.doAssertion(OUTPUT2);
    }
}
