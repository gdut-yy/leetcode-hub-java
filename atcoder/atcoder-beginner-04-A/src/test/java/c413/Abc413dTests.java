package c413;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Abc413dTests extends AbstractOjTests {
    public Abc413dTests() {
        super("/c413/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        Abc413_d.main(null);
        super.doAssertion(OUTPUT1);
    }
}
