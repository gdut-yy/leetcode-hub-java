package p954;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF954ITests extends AbstractOjTests {
    public CF954ITests() {
        super("/p954/I/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF954I.main(null);
        super.doAssertion(OUTPUT1);
    }
}