package c423;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Abc423eTests extends AbstractOjTests {
    public Abc423eTests() {
        super("/c423/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        Abc423_e.main(null);
        super.doAssertion(OUTPUT1);
    }
}
