package c279;

import base.AbstractOjTests;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Abc279dTests extends AbstractOjTests {
    public Abc279dTests() {
        super("/c279/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        Abc279_d.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        Abc279_d.main(null);
        super.doAssertion(OUTPUT2);
    }

    @Test
    @Disabled
    public void example3() throws IOException {
        super.doSetSystemInOut(INPUT3);
        Abc279_d.main(null);
        super.doAssertion(OUTPUT3);
    }
}