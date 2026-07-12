package c375;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Abc375fTests extends AbstractOjTests {
    public Abc375fTests() {
        super("/c375/F/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        Abc375_f.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        Abc375_f.main(null);
        super.doAssertion(OUTPUT2);
    }
}
