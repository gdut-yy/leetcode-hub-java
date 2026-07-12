package c413;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Abc413eTests extends AbstractOjTests {
    public Abc413eTests() {
        super("/c413/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        Abc413_e.main(null);
        super.doAssertion(OUTPUT1);
    }
}
