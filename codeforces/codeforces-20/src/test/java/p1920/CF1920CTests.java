package p1920;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1920CTests extends AbstractOjTests {
    public CF1920CTests() {
        super("/p1920/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1920C.main(null);
        super.doAssertion(OUTPUT1);
    }
}