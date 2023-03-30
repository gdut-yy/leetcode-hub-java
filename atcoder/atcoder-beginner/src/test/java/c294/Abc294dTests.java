package c294;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Abc294dTests extends AbstractOjTests {
    public Abc294dTests() {
        super("/c294/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        Abc294_d.main(null);
        super.doAssertion(OUTPUT1);
    }
}