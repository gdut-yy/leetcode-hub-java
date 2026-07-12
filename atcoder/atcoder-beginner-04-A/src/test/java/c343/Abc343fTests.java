package c343;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class Abc343fTests extends AbstractOjTests {
    public Abc343fTests() {
        super("/c343/F/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        Abc343_f.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        Abc343_f.main(null);
        super.doAssertion(OUTPUT2);
    }

    @Test
    public void example3() throws IOException {
        super.doSetSystemInOut(INPUT3);
        Abc343_f.main(null);
        super.doAssertion(OUTPUT3);
    }
}
