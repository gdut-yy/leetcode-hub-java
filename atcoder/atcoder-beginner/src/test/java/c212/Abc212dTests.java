package c212;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Abc212dTests extends AbstractOjTests {
    public Abc212dTests() {
        super("/c212/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        Abc212_d.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        Abc212_d.main(null);
        super.doAssertion(OUTPUT2);
    }
}
