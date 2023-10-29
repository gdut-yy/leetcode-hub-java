package c279;

import base.AbstractOjTests;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Abc279fTests extends AbstractOjTests {
    public Abc279fTests() {
        super("/c279/F/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        Abc279_f.main(null);
        super.doAssertion(OUTPUT1);
    }
}