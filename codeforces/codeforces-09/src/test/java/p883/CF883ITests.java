package p883;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF883ITests extends AbstractOjTests {
    public CF883ITests() {
        super("/p883/I/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF883I.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        CF883I.main(null);
        super.doAssertion(OUTPUT2);
    }
}