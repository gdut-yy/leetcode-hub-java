package c285;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Abc285fTests extends AbstractOjTests {
    public Abc285fTests() {
        super("/c285/F/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        Abc285_f.main(null);
        super.doAssertion(OUTPUT1);
    }
}