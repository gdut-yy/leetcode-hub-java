package c381;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Abc381fTests extends AbstractOjTests {
    public Abc381fTests() {
        super("/c381/F/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        Abc381_f.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        Abc381_f.main(null);
        super.doAssertion(OUTPUT2);
    }
}
