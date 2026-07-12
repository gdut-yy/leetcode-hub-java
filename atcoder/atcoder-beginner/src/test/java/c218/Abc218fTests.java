package c218;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Abc218fTests extends AbstractOjTests {
    public Abc218fTests() {
        super("/c218/F/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        Abc218_f.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        Abc218_f.main(null);
        super.doAssertion(OUTPUT2);
    }

    @Test
    public void example3() throws IOException {
        super.doSetSystemInOut(INPUT3);
        Abc218_f.main(null);
        super.doAssertion(OUTPUT3);
    }

    @Test
    public void example4() throws IOException {
        super.doSetSystemInOut(INPUT4);
        Abc218_f.main(null);
        super.doAssertion(OUTPUT4);
    }
}
