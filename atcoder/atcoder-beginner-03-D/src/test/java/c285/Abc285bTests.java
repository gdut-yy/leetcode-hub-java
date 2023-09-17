package c285;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Abc285bTests extends AbstractOjTests {
    public Abc285bTests() {
        super("/c285/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        Abc285_b.main(null);
        super.doAssertion(OUTPUT1);
    }
}