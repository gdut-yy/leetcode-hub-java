package c243;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Abc243gTests extends AbstractOjTests {
    public Abc243gTests() {
        super("/c243/G/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        Abc243_g.main(null);
        super.doAssertion(OUTPUT1);
    }
}